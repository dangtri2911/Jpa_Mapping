package com.example.many.to.many;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(StudentRepository studentRepository,
                                         CourseRepository courseRepository) {
        return args -> {

            Student student = new Student("John Doe", 15, "8th");

            studentRepository.save(student);

            Course course1 = new Course("Machine Learning", "ML", 12, 1500);
            Course course2 = new Course("Database Systems", "DS", 8, 800);
            Course course3 = new Course("Web Basics", "WB", 10, 0);

            courseRepository.saveAll(Arrays.asList(course1, course2, course3));

            student.getCourses().addAll(Arrays.asList(course1, course2, course3));

            studentRepository.save(student);
        };
    }
}