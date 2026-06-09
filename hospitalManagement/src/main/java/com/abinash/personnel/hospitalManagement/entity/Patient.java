package com.abinash.personnel.hospitalManagement.entity;

import com.abinash.personnel.hospitalManagement.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(
        name = "patient_tble", // but here we are defining what should be the table name
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = {"name","birthDate"})
        },
        indexes = {
                @Index(name = "Idx_patient_name_birthdate",columnList = "birthDate")
        }
)
public class Patient { // if its PatientService then in database it will be stored as patient_service.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(
            nullable = false,
            length = 40
    )
    private String name;
    @ToString.Exclude
    private LocalDate birthDate;
    @Column(unique = true)
    private String email;
    private String gender;
    @CreationTimestamp // important
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    // only while creation and update process i want insurance should update otherwise not
    @JoinColumn(
            name = "patient_insurance_id" // owning side
    )
    private Insurance insurance;

    @OneToMany(mappedBy = "patient",cascade = {CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.LAZY)// fetch type will create n+ 1 query problem to solve it make it as lazy and JSON.IGNORE in dto
    // to solve this issue if you want patient with their appointmetns without n+ 1 problem create a custom query
    private List<Appointment> appointments = new ArrayList<>(); // It will not create a column in table its impossible



//    @Override
//    public String toString() {
//        return "Patient{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", birthDate=" + birthDate +
//                ", email='" + email + '\'' +
//                ", gender='" + gender + '\'' +
//                '}';
//    }
}
