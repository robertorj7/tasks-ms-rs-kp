package com.example.service.tasks;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;
    private final NotificationClient client;

    public TaskService(TaskRepository repository, NotificationClient client) {
        this.repository = repository;
        this.client = client;
    }

    public void sendNotificationForDueTasks() {
        LocalDateTime deadline = LocalDateTime.now().plusDays(1);
        List<Task> dueTasks =  repository.findDueTasksWithinDeadline(deadline);
        for (Task dueTask : dueTasks) {
            NotificationRequest request = new NotificationRequest(
                    "Sua tarefa: " + dueTask.getTitle() + " está prestes a vencer!",
                    dueTask.getEmail());

            client.sendNotification(request);
            dueTask.setNotified(true);

            repository.save(dueTask);
        }
    }
}
