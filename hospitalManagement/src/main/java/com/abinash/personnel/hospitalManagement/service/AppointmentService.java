package com.abinash.personnel.hospitalManagement.service;

import com.abinash.personnel.hospitalManagement.entity.Appointment;
import com.abinash.personnel.hospitalManagement.entity.Doctor;
import com.abinash.personnel.hospitalManagement.entity.Patient;
import com.abinash.personnel.hospitalManagement.repository.AppointmentRepository;
import com.abinash.personnel.hospitalManagement.repository.DoctorRepository;
import com.abinash.personnel.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        if(appointment.getId()!=null) throw  new IllegalArgumentException("Appointment should not have id");

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

//        appointmentRepository.save(appointment);
        // in this case we are not defining any cascading in the patient and doctor
        // so mostly in many to one we don't give any cascading things so avoid it properly

        // To maintain bidirectional consistancy
        patient.getAppointments().add(appointment);

        return appointmentRepository.save(appointment);

    }
    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor); // we don't need to save it as its already in transactional context
        doctor.getAppointments().add(appointment);
        return appointment;
    }
}
