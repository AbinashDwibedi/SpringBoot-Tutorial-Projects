package com.abinash.restAPI.controller;

import com.abinash.restAPI.dto.AddStudentRequestDto;
import com.abinash.restAPI.dto.StudentDto;
import com.abinash.restAPI.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private  final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudents(){
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }
//    @GetMapping("/student/{id}")
//    public StudentDto getStudentById(@PathVariable(id) Long studentId){
//
//    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok().body(studentService.getStudentsById(id));
    }
//        @GetMapping("/student/{id}/{name}")
//        public StudentDto getStudentById(@PathVariable Long id, @PathVariable String name){
//            return
//        }
    @PostMapping()
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(id,addStudentRequestDto));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String,Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id,updates));
    }
}

//
//package com.abinash.restAPI.controller;
//
//import com.abinash.restAPI.dto.AddStudentRequestDto;
//import com.abinash.restAPI.dto.StudentDto;
//import com.abinash.restAPI.service.StudentService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//        import java.util.List;
//
//@RestController
//// By providing both paths, you kill any strict-slash redirect bugs completely
//@RequestMapping({"/students", "/students/"})
//@RequiredArgsConstructor
//public class StudentController {
//
//    private final StudentService studentService;
//
//    @GetMapping
//    public ResponseEntity<List<StudentDto>> getStudents(){
//        return ResponseEntity.ok().body(studentService.getAllStudents());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
//        return ResponseEntity.ok().body(studentService.getStudentsById(id));
//    }
//
//    // Leave this completely bare so it inherits the exact base paths above
//    @PostMapping
//    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
//        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
//    }
//}