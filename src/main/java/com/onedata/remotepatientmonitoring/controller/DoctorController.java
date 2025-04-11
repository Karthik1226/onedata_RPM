package com.onedata.remotepatientmonitoring.controller;

import com.onedata.remotepatientmonitoring.models.tables.pojos.Doctor;
import com.onedata.remotepatientmonitoring.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> findAllDoctors(){
        return doctorService.findAll();
    }
    @GetMapping("id/{id}")
    public Doctor findDoctorsById(@PathVariable("id") Integer id){
        return doctorService.findById(id);
    }
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorService.create(doctor);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteDoctor(@PathVariable("id") Integer id){
        doctorService.delete(id);
    }
    @PutMapping("/{id}")
    public Doctor updateDoctors(@RequestBody Doctor doctor, @PathVariable("id") Integer id){
        return doctorService.update(doctor,id);
    }
}
