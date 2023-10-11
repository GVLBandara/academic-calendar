package com.gota.academiccalendar.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Task(
		@Id
        Integer id,
		@NotBlank
        String title,
        String desc,
        Status status,
        Type taskType,
        LocalDateTime date,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}
