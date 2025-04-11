package com.onedata.remotepatientmonitoring.service;

import com.onedata.remotepatientmonitoring.models.tables.pojos.Doctor;
import com.onedata.remotepatientmonitoring.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
   @Autowired
   private DoctorRepo doctorRepo;

    public List<Doctor> findAll(){
        return doctorRepo.findAllDoctors();
    }
    public Doctor findById(Integer id){
        return doctorRepo.findDoctorsByID(id);
    }
    public Doctor create(Doctor doctor){
        return doctorRepo.createDoctor(doctor);
    }
    public void delete(Integer id){
        doctorRepo.deleteDoctorById(id);
    }
    public Doctor update(Doctor doctor, Integer id){
        return doctorRepo.updateDoctor(doctor,id);
    }
}
