package tech.wedev.pratice.stream.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Teacher {
    String name;
    Integer age;
    Date birth;

    public Teacher(String name, Integer age, Date birth) {
        this.name = name;
        this.age = age;
        this.birth = birth;
    }
}


