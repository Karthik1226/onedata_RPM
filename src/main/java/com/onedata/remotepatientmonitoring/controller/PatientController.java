package com.onedata.remotepatientmonitoring.controller;

import com.onedata.remotepatientmonitoring.dto.patient.PatientResponseDTO;
import com.onedata.remotepatientmonitoring.dto.patient.PatientResquestDTO;
import com.onedata.remotepatientmonitoring.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>>findAllPatients(){
        List<PatientResponseDTO> patients = patientService.findAll();
        return ResponseEntity.ok(patients);

    }
    @GetMapping("id/{id}")
    public ResponseEntity<PatientResponseDTO> findPatientsById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(patientService.findById(id));
    }
    @PostMapping
    public ResponseEntity<String> createPatient(@RequestBody @Valid PatientResquestDTO patient){
        String createId = patientService.create(patient);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createId);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") Integer id){
        return ResponseEntity.ok(patientService.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatients(@RequestBody @Valid PatientResquestDTO patient, @PathVariable("id") Integer id){
        PatientResponseDTO updatedDTO =patientService.update(patient,id);
        return ResponseEntity.ok(updatedDTO);
    }
}
