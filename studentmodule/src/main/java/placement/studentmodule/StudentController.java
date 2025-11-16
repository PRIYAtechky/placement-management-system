package placement.studentmodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("student")  // Ensure the path matches with your frontend request
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        
        Optional<Student> existingStudentOptional = studentRepository.findById(id);

       
        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();
            
            
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setDegree(student.getDegree());
            existingStudent.setGraduationYear(student.getGraduationYear());

           
            studentRepository.save(existingStudent);

          
            return ResponseEntity.ok(existingStudent);
        } else {
            
            return ResponseEntity.notFound().build();
        }
    }


    
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}

