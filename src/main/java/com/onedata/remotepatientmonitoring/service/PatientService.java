package com.onedata.remotepatientmonitoring.service;

import com.onedata.remotepatientmonitoring.models.tables.pojos.Patient;
import com.onedata.remotepatientmonitoring.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    public List<Patient> findAll(){
        return patientRepo.findAllPatients();
    }
    public Patient findById(Integer id){
        return patientRepo.findPatientsByID(id);
    }
    public Patient create(Patient patient){
        return patientRepo.createPatients(patient);
    }
    public void delete(Integer id){
        patientRepo.deletePatientById(id);
    }
    public Patient update(Patient patient, Integer id){
        return patientRepo.updatePatients(patient,id);
    }
}
