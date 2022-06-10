package com.data.resultprocessor.adminController;

import com.data.resultprocessor.model.Student;
import com.data.resultprocessor.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AdminController {

    @Autowired(required = false)
    ResultsRepository repository;


    @PostMapping("/storeresult")
    public @ResponseBody String storeResult(@RequestBody Student newStudent){

        repository.save(newStudent);
        return "student with name :"+ newStudent.getName() + " has been added to the database";
    }

    @PutMapping("/updateresult")
    public @ResponseBody String updateResult(@RequestParam String name, @RequestBody Student student) {
        Optional<Student> updatedStudent = repository.findById(name);
        if(updatedStudent.isPresent()) {
            student.setName(name);
            repository.save(student);
            return "student details with the name: "+name + " have been updated";
        }
        else{
            return "There are no students with the name: "+ name;
        }
    }

    @DeleteMapping("/deleteresult")
    public String deleteResult(@RequestParam String name){
        Optional<Student> studentOptional = repository.findById(name);
        if(studentOptional.isPresent()) {
            repository.deleteById(name);
            return "deleted the student with name: "+ name;
        }
        else {
            return "There are no students with name: "+ name;
        }
    }


}