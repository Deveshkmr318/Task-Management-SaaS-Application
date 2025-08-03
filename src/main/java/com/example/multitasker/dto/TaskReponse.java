package com.example.multitasker.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskReponse {

    private Long id;

    private String title;

    private String description;

    private boolean completed;

    private LocalDateTime dueDate;

    private Long userId;

}
