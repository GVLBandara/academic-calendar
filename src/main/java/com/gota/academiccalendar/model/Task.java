package com.gota.academiccalendar.model;

import java.time.LocalDateTime;

public record Task(
        Integer id,
        String name,
        String desc,
        Status status,
        Type taskType,
        LocalDateTime date,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}
