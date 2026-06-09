package com.abinash.restAPI.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data // It will automatically create getters and setters
public class AddStudentRequestDto {
    @NotBlank(message = "Name Required")
    @Size(min = 3,max = 30, message = "name should be of length 3 to 30 characters")
    private String name;
    @Email
    @NotBlank(message = "Email Required")
    private String email;

}
