package com.onedata.remotepatientmonitoring.controller;

import com.onedata.remotepatientmonitoring.models.tables.pojos.Patient;
import com.onedata.remotepatientmonitoring.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> findAllPatients(){
        return patientService.findAll();
    }
    @GetMapping("id/{id}")
    public Patient findPatientsById(@PathVariable("id") Integer id){
        return patientService.findById(id);
    }
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        return patientService.create(patient);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable("id") Integer id){
        patientService.delete(id);
    }
    @PutMapping("/{id}")
    public Patient updatePatients(@RequestBody Patient patient, @PathVariable("id") Integer id){
        return patientService.update(patient,id);
    }
}
