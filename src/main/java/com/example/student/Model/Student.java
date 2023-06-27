package com.example.student.Model;

import lombok.*;

import javax.persistence.*;
// This is an Entity Class

@Entity
@Table(name = "student_details")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name="marks")
    private int marks;
}
