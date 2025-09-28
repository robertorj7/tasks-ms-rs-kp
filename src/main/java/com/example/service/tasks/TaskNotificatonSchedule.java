package com.example.service.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskNotificatonSchedule {
    private final TaskService service;

    public TaskNotificatonSchedule(TaskService service) {
        this.service = service;
    }

    @Scheduled(fixedRate = 360000 * 24)
    public void checkAndNotifyTasks() {
        service.sendNotificationForDueTasks();
    }
}
