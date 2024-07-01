package com.example.projectmanagementsystem.service;

import com.example.projectmanagementsystem.model.AppUser;
import com.example.projectmanagementsystem.model.Project;
import com.example.projectmanagementsystem.model.Task;
import com.example.projectmanagementsystem.model.dto.LoggedWorkDTO;
import com.example.projectmanagementsystem.model.dto.TaskDTO;
import com.example.projectmanagementsystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private LoggedWorkService loggedWorkService;

    public List<TaskDTO> getAllTasks(){
        return taskRepository.findAll().stream().map(Task::toTaskDTO).toList();
    }

    public List<TaskDTO> getAllTasksByUser(String username){
        AppUser user = userService.getUserByUsername(username);
        return taskRepository.findAllByAssignee(user).stream().map(Task::toTaskDTO).toList();
    }

    public Long createTask(TaskDTO newTask){
        AppUser creator = userService.getUserByUsername((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if(creator.getUserRole().getRoleName() == "WORKER"){
            return 0L;
        }
        Task task = newTask.toTask();
        task.setCreator(creator);
        AppUser assignee = userService.getUserByUsername(newTask.getAssignee().getUsername());
        task.setAssignee(assignee);
        Project project = projectService.getProjectByName(newTask.getProject());
        task.setProject(project);
        task.setCreationTime(LocalDateTime.now());
        return taskRepository.save(task).getId();
    }

    public void updateTask(TaskDTO updatedTask){
        AppUser creator = userService.getUserByUsername(updatedTask.getCreator());
        if(creator.getUserRole().getRoleName() == "WORKER"){
            return;
        }
        Task task = taskRepository.getReferenceById(updatedTask.getId());
        task.setTaskStatus(updatedTask.getTaskStatus());
        AppUser assignee = userService.getUSerById(updatedTask.getAssignee().getId());
        task.setAssignee(assignee);
        task.setCaption(updatedTask.getCaption());
        task.setDescription(updatedTask.getDescription());
        task.setEstimationTimeNumber(updatedTask.getEstimatedTime().getNumber());
        task.setEstimationTimeUnit(updatedTask.getEstimatedTime().getUnit());
        taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public TaskDTO getTaskById(Long id){
        return taskRepository.getReferenceById(id).toTaskDTO();
    }
    public List<TaskDTO> getProjectTasks(String project){
        Project project1 = projectService.getProjectByName(project);
        return taskRepository.findAllByProject(project1).stream().map(Task::toTaskDTO).toList();
    }

    public String getTaskLoggedWork(Long taskId){
        Task task = taskRepository.getReferenceById(taskId);
        List<LoggedWorkDTO> loggedWorkDTO = loggedWorkService.getTaskLoggedWork(task);
        return transformLoggedWork(loggedWorkDTO);
    }

    private String transformLoggedWork(List<LoggedWorkDTO> loggedWork){
        int days = loggedWork.stream()
                .filter(log -> Objects.equals(log.getLoggedTime().getUnit(), "day"))
                .mapToInt(log -> log.getLoggedTime().getNumber())
                .sum();
        int weeks = loggedWork.stream()
                .filter(log -> Objects.equals(log.getLoggedTime().getUnit(), "week"))
                .mapToInt(log -> log.getLoggedTime().getNumber())
                .sum();
        int months = loggedWork.stream()
                .filter(log -> Objects.equals(log.getLoggedTime().getUnit(), "month"))
                .mapToInt(log -> log.getLoggedTime().getNumber())
                .sum();
        StringBuilder stringBuilder = new StringBuilder();
        if(days >= 7){
            int weeksFromDays = days / 7;
            int remainingDays = days % 7;
            weeks += weeksFromDays;
            days = remainingDays;
        }
        if(weeks >= 4){
            int monthsFromWeeks = weeks / 4;
            int remainingWeeks = weeks % 4;
            months += monthsFromWeeks;
            weeks = remainingWeeks;
        }
        return stringBuilder
                .append("Months: ")
                .append(months)
                .append(", Weeks: ")
                .append(weeks)
                .append(", Days: ")
                .append(days)
                .toString();
    }
}
