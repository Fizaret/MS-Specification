package az.ingress.msspecification;

import az.ingress.msspecification.domain.Student;
import az.ingress.msspecification.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class MsSpecificationApplication implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(MsSpecificationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student a1 = Student.builder()
                .id(1L)
                .age(19)
                .firstName("FIZARET")
                .lastName("OSMANOV")
                .studentNumber("AA3293781")
                .jpa(80.01).build();
        studentRepository.save(a1);

    }
}
