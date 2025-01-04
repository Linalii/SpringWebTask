package ru.linali.springwebtask.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Data
@Getter
@Setter
public class Task {
    private int id;
    private String name;
    private String content;
    private LocalDate appointmentDate;

    public Task(int id, String name, String content, LocalDate appointmentDate) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.appointmentDate = appointmentDate;
    }
}
