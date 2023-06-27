package com.example.student.Controller;

import com.example.student.Exception.CustomException;
import com.example.student.Model.Student;
import com.example.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/s1")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/add")
    public String add(@RequestBody List<Student> students){
        return studentService.add(students);
    }
    @GetMapping("/get")
    public List<Student> get(){
        return studentService.get();
    }
    @GetMapping("/getByName")
    public Student getByName(@PathParam("name")String name){
        return studentService.getByName(name);
    }
    @GetMapping("/getById/{id}")
    public Student getById(@PathVariable int id) throws CustomException {
        if(id<=3) {
            return studentService.getById(id);
        }

              else{  throw new CustomException(
                        "NO Student PRESENT WITH ID = " + id);
        }
    }
    @PutMapping("/{id}/update")
    public String updateByName(@PathVariable("id")int id,@RequestBody Student
                                student){
        if(id==1){
            return studentService.updateByName(id,student);
        }else{
            return "Not updated becz id does't match with student";
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateByNameRespone(@PathVariable("id")int id, @RequestBody Student
            student) throws CustomException {
        return studentService.updateByNameRespone(id,student);

    }
    @DeleteMapping("remove")
    public String remove (@PathParam("id") int id){
        return studentService.remove(id);
    }
    @GetMapping("getAll")
    public List<Student> getAll(){
        return studentService.getAll();
    }
}
