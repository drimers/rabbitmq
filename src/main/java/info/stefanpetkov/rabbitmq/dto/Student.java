package info.stefanpetkov.rabbitmq.dto;

import lombok.Data;

@Data
public class Student {

    private String facultyNumber;
    private String firstName;
    private String lastName;
    private String speciality;
    private String course;
}
