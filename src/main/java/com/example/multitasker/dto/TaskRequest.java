package com.example.multitasker.dto;

import com.example.multitasker.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskRequest {

    private String title;

    private String description;

    private boolean completed;

    private LocalDateTime dueDate;

    private Long userId;

}
