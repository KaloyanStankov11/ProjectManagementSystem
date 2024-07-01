package com.example.projectmanagementsystem.service;

import com.example.projectmanagementsystem.model.AppUser;
import com.example.projectmanagementsystem.model.LoggedWork;
import com.example.projectmanagementsystem.model.LoggedWorkRequest;
import com.example.projectmanagementsystem.model.Task;
import com.example.projectmanagementsystem.model.dto.LoggedWorkDTO;
import com.example.projectmanagementsystem.repository.LoggedWorkRepository;
import com.example.projectmanagementsystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoggedWorkService {

    @Autowired
    private LoggedWorkRepository loggedWorkRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskRepository taskRepository;

    public List<LoggedWorkDTO> getUserLoggedWork(){
        AppUser user = userService.getUserByUsername((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return loggedWorkRepository.getLoggedWorkByWorker(user).stream().map(LoggedWork::toLoggedWorkDTO).toList();
    }

    public List<LoggedWorkDTO> getLastWeekLoggedWork(){
        AppUser user = userService.getUserByUsername((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        int day = LocalDate.now().getDayOfWeek().getValue();
        LocalDate startDate = LocalDate.now().minusWeeks(1).minusDays(day);
        LocalDate endDate = LocalDate.now().minusWeeks(1).plusDays(6-day);
        return loggedWorkRepository.getLoggedWorkByWorkerAndDateAfterAndDateBefore(user, startDate, endDate).stream().map(LoggedWork::toLoggedWorkDTO).toList();
    }

    public List<LoggedWorkDTO> getTaskLoggedWork(Task task){
        return loggedWorkRepository.getLoggedWorkByTask(task).stream().map(LoggedWork::toLoggedWorkDTO).toList();
    }

    public List<LoggedWorkDTO> addLoggedWork(LoggedWorkRequest loggedWorkDTO){
        AppUser user = userService.getUserByUsername((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Task task = taskRepository.getReferenceById(loggedWorkDTO.getTask().getId());
        LoggedWork loggedWork = new LoggedWork(
                user,
                task,
                loggedWorkDTO.getLoggedTimeNumber(),
                loggedWorkDTO.getLoggedTimeUnit(),
                loggedWorkDTO.getDate()
        );
        loggedWorkRepository.save(loggedWork);
        return loggedWorkRepository.getLoggedWorkByWorker(user).stream().map(LoggedWork::toLoggedWorkDTO).toList();
    }

    public void deleteLoggedWork(Long id){
        loggedWorkRepository.deleteById(id);
    }
}
