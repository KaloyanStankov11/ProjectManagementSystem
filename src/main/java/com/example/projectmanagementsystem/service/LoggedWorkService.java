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

    public List<LoggedWorkDTO> getTaskLoggedWork(Task task){
        return loggedWorkRepository.getLoggedWorkByTask(task).stream().map(LoggedWork::toLoggedWorkDTO).toList();
    }

    public void addLoggedWork(LoggedWorkRequest loggedWorkDTO){
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
    }
}
