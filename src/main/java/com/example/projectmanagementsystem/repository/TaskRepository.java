package com.example.projectmanagementsystem.repository;

import com.example.projectmanagementsystem.model.AppUser;
import com.example.projectmanagementsystem.model.Project;
import com.example.projectmanagementsystem.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByAssignee(AppUser user);
    List<Task> findAllByProject(Project project);
}
