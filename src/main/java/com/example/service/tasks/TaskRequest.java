package com.example.service.tasks;

import java.time.LocalDateTime;

public record TaskRequest(String title, String email, LocalDateTime dueDate, boolean notified) {
}
