package com.gelerion.learning.microservices.balancing.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Meta {
    private String name;

    @JsonFormat(pattern = "dd::MM::yyyy")
    private LocalDateTime time;

    public Meta() {
    }

    public Meta(String name) {
        this.name = name;
        this.time = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}