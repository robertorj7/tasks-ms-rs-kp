package com.example.service.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("""
            SELECT t
            FROM Task
            WHERE t.dueDate <= :deadline
            AND t.notified = false
            """)
    List<Task> findDueTasksWithinDeadline(LocalDateTime deadline);
}
