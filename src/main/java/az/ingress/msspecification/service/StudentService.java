package az.ingress.msspecification.service;

import az.ingress.msspecification.domain.SearchCriteria;
import az.ingress.msspecification.domain.Student;
import az.ingress.msspecification.domain.StudentSpecification;
import az.ingress.msspecification.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllBy(){
        return studentRepository.findAll(ageGreaterThan(20));
    }

    public List<Student> getAllByName(){
        return studentRepository.findAll(Specification.where(nameLike("FIZARET")).and(ageGreaterThan(20)));
    }

    public List<Student> jpaGreaterThan91(){
        return studentRepository.findAll(jpaGreaterThan(91.0));
    }

    public List<Student> getAllByCriteria(List<SearchCriteria> dto) {
        StudentSpecification studentSpecification = new StudentSpecification();
        dto.forEach(studentSpecification::add);
        return studentRepository.findAll(studentSpecification);
    }

    private Specification<Student> ageGreaterThan(int age){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get(Student.Fields.age),age));
    }

    private Specification<Student> nameLike(String firstName){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Student.Fields.firstName),firstName));
    }

    private Specification<Student> jpaGreaterThan(double jpa){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get(Student.Fields.jpa),jpa));
    }


}