package com.example.student.Repository;

import com.example.student.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query(value = "select * from student_details std where std.name like ? ",nativeQuery = true)
    Student getByName(String name);
}
