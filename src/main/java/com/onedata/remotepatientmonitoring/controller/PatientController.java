package com.onedata.remotepatientmonitoring.controller;

import com.onedata.remotepatientmonitoring.dto.patient.PatientResponseDTO;
import com.onedata.remotepatientmonitoring.dto.patient.PatientResquestDTO;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Patient;
import com.onedata.remotepatientmonitoring.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<PatientResponseDTO> findAllPatients(){
        return patientService.findAll();
    }
    @GetMapping("id/{id}")
    public PatientResponseDTO findPatientsById(@PathVariable("id") Integer id){
        return patientService.findById(id);
    }
    @PostMapping
    public String createPatient(@RequestBody @Valid PatientResquestDTO patient){
        return patientService.create(patient);
    }
    @DeleteMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") Integer id){
        return patientService.delete(id);
    }
    @PutMapping("/{id}")
    public PatientResponseDTO updatePatients(@RequestBody @Valid PatientResquestDTO patient, @PathVariable("id") Integer id){
        return patientService.update(patient,id);
    }
}
