package az.ingress.msspecification.controller;



import az.ingress.msspecification.domain.SearchCriteria;
import az.ingress.msspecification.domain.Student;
import az.ingress.msspecification.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/students")
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final ModelMapper modelMapper;

    @GetMapping("/list")
    public List<Student> getListByCriteria(@RequestBody List<SearchCriteria> dto){
        return studentService.getAllByCriteria(dto);
    }




}