package com.onedata.remotepatientmonitoring.service;

import com.onedata.remotepatientmonitoring.exception.ResourceNotFoundException;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Doctor;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Patient;
import com.onedata.remotepatientmonitoring.repo.DoctorPatientRepo;
import com.onedata.remotepatientmonitoring.repo.DoctorRepo;
import com.onedata.remotepatientmonitoring.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorPatientService {
    @Autowired
    private DoctorPatientRepo doctorPatientRepo;
    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private PatientRepo patientRepo;

    public String assignDoctor(Integer doctorId, Integer patientId){
        if(doctorRepo.findDoctorsByID(doctorId) == null){
            throw new ResourceNotFoundException("Doctor not found with ID: " + doctorId);
        }
        if(patientRepo.findPatientsByID(patientId) == null){
            throw new ResourceNotFoundException("Patient not found with ID: " + patientId);
        }
        doctorPatientRepo.assignDoctorToPatient(doctorId,patientId);
        return "Doctor assigned to the patient";
    }


    public void removeDoctor(Integer doctorId,Integer patientId){
        doctorPatientRepo.removeDoctorFromPatient(doctorId,patientId);
    }
    public List<Doctor> getDoctorByPatient(Integer patientId){
        List<Doctor> doctors = doctorPatientRepo.getDoctorsByPatientId(patientId);
        if(patientId == null){
            throw new ResourceNotFoundException("Patient With Id "+ patientId + " Is not found");
        }
        return doctors;
    }
    public List<Patient> getPatientByDoctor(Integer doctorId){
        List<Patient> patient = doctorPatientRepo.getPatientsByDoctorId(doctorId);
        if(doctorId == null){
            throw new ResourceNotFoundException("Doctor With Id "+ doctorId + " Is not found");
        }
        return patient;
    }
}
