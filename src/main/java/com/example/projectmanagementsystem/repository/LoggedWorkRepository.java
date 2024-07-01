package com.example.projectmanagementsystem.repository;

import com.example.projectmanagementsystem.model.AppUser;
import com.example.projectmanagementsystem.model.LoggedWork;
import com.example.projectmanagementsystem.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LoggedWorkRepository extends JpaRepository<LoggedWork, Long> {
    List<LoggedWork> getLoggedWorkByWorker(AppUser worker);
    List<LoggedWork> getLoggedWorkByTask(Task task);
    List<LoggedWork> getLoggedWorkByWorkerAndDateAfterAndDateBefore(AppUser user, LocalDate startDate, LocalDate endDate);
}
