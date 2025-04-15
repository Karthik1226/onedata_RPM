package com.onedata.remotepatientmonitoring.controller;

import com.onedata.remotepatientmonitoring.dto.doctorPatient.DoctorPatientRequestDTO;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Doctor;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Patient;
import com.onedata.remotepatientmonitoring.service.DoctorPatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api")
public class DoctorPatientController {
    @Autowired
    private DoctorPatientService doctorPatientService;

    @PostMapping("/assign/doctor")
    public void assignDoctorToPatient(@RequestBody @Valid DoctorPatientRequestDTO requestDTO){
        doctorPatientService.assignDoctor(requestDTO.getDoctorId(),requestDTO.getPatientId());
    }
    @DeleteMapping("/remove/doctor")
    public void removeDoctorFromPatient(@RequestParam("doctorId") Integer doctorId,@RequestParam("patientId") Integer patientId){
        doctorPatientService.removeDoctor(doctorId,patientId);
    }
    @GetMapping("/get/doctor/{patientId}")
    public List<Doctor> getDoctor(@PathVariable("patientId") Integer patientId){
        return doctorPatientService.getDoctorByPatient(patientId);
    }
    @GetMapping("/get/patient/{doctorId}")
    public List<Patient> getPatient(@PathVariable("doctorId") Integer doctorId){
        return doctorPatientService.getPatientByDoctor(doctorId);
    }
}