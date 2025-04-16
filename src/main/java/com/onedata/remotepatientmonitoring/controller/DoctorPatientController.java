package com.onedata.remotepatientmonitoring.controller;

import com.onedata.remotepatientmonitoring.dto.doctorPatient.DoctorPatientRequestDTO;
import com.onedata.remotepatientmonitoring.exception.ResourceNotFoundException;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Doctor;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Patient;
import com.onedata.remotepatientmonitoring.service.DoctorPatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api")
public class DoctorPatientController {
    @Autowired
    private DoctorPatientService doctorPatientService;

    @PostMapping("/assign/doctor")
    public ResponseEntity<String> assignDoctorToPatient(@RequestBody @Valid DoctorPatientRequestDTO requestDTO){
        String message = doctorPatientService.assignDoctor(requestDTO.getDoctorId(),requestDTO.getPatientId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(message);
    }

    @DeleteMapping("/remove/doctor")
    public ResponseEntity<?> removeDoctorFromPatient(@RequestParam("doctorId") Integer doctorId,@RequestParam("patientId") Integer patientId){
        try {
            doctorPatientService.removeDoctor(doctorId, patientId);
            return ResponseEntity.ok("Doctor successfully removed from patient.");
        }
        catch (ResourceNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/get/doctor/{patientId}")
    public ResponseEntity<List<Doctor>> getDoctor(@PathVariable("patientId") Integer patientId){
        return ResponseEntity.ok(doctorPatientService.getDoctorByPatient(patientId));
    }

    @GetMapping("/get/patient/{doctorId}")
    public ResponseEntity<List<Patient>> getPatient(@PathVariable("doctorId") Integer doctorId){
        return ResponseEntity.ok(doctorPatientService.getPatientByDoctor(doctorId));
    }
}