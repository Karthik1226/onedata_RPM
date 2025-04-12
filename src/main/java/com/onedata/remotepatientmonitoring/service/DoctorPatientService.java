package com.onedata.remotepatientmonitoring.service;

import com.onedata.remotepatientmonitoring.models.tables.pojos.Doctor;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Patient;
import com.onedata.remotepatientmonitoring.repo.DoctorPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorPatientService {
    @Autowired
    private DoctorPatientRepo doctorPatientRepo;

    public void assignDoctor(Integer doctorId, Integer patientId){
        doctorPatientRepo.assignDoctorToPatient(doctorId,patientId);
    }
    public void removeDoctor(Integer doctorId,Integer patientId){
        doctorPatientRepo.removeDoctorFromPatient(doctorId,patientId);
    }
    public List<Doctor> getDoctorByPatient(Integer patientId){
        return doctorPatientRepo.getDoctorsByPatientId(patientId);
    }
    public List<Patient> getPatientByDoctor(Integer doctorId){
        return doctorPatientRepo.getPatientsByDoctorId(doctorId);
    }
}
