package com.abinash.restAPI.dto;

import lombok.*;

@Data // It will automatically create getters and setters
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String email;

}
