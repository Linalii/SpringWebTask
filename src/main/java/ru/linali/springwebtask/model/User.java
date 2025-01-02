package ru.linali.springwebtask.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

public class User {
    private String firstName;
    private String lastName;
    private String number;
    private LocalDateTime currentTime;

    public User(String firstName, String lastName, String number, LocalDateTime currentTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", number='" + number + '\'' +
                ", currentTime=" + currentTime +
                '}';
    }
}
