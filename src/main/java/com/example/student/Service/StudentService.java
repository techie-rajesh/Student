package com.example.student.Service;
import com.example.student.Exception.CustomException;
import com.example.student.Model.Student;
import com.example.student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String add(List<Student> students) {
        studentRepository.saveAll(students);
        return "Stored students details";

    }

    public List<Student> get() {
       return studentRepository.findAll();
    }

    public Student getByName(String name) {
        return studentRepository.getByName(name);
    }

    public Student getById(int id)  {
        return studentRepository.findById(id).get();
    }

    public String updateByName(int id, Student student) {
        Student old= studentRepository.findById(id).get();
        Student newUpdate=student;
        old.setName(newUpdate.getName());
        studentRepository.save(old);
        return "Updated";
    }

    public ResponseEntity<Object> updateByNameRespone(int id, Student student) throws CustomException{
        try {

            Student old = studentRepository.findById(id).get();
            Student newUpdate = student;
            old.setName(newUpdate.getName());
            studentRepository.save(old);
            return ResponseEntity.ok(old);
        }catch (Exception e){
            throw new CustomException(id+" is Invalid data from student details");
        }

    }


    public String remove(int id) {
         studentRepository.deleteById(id);
         return "Deleted";
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
