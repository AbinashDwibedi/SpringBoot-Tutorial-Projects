package com.abinash.restAPI.service.Impl;

import com.abinash.restAPI.dto.AddStudentRequestDto;
import com.abinash.restAPI.dto.StudentDto;
import com.abinash.restAPI.entity.Student;
import com.abinash.restAPI.repository.StudentRepository;
import com.abinash.restAPI.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
//        List<StudentDto> studentDtoList = students.stream().map(student -> new StudentDto(student.getId(),student.getName(),student.getEmail())).toList();
        List<StudentDto> studentDtoList = students.stream().map(student -> modelMapper.map(student,StudentDto.class)).toList();
        return studentDtoList;
    }

    @Override
    public StudentDto getStudentsById(Long id) {
        Student student =  studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("student not found with id"+id));
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
         // check first
        if(!studentRepository.existsById(id)){
            throw  new IllegalArgumentException("student does not exists by id: "+id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student =  studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("student not found with id"+id));
        modelMapper.map(addStudentRequestDto, student);

        studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {

        Student student =  studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("student not found with id"+id));

        updates.forEach((field,value)->{
            switch (field){
                case "name": student.setName((String) value);break;
                case "email": student.setEmail((String) value);break;
                default: throw new IllegalArgumentException("enter a valid data to be stored");
            }
        });
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }


}
