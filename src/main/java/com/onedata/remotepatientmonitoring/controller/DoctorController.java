package com.onedata.remotepatientmonitoring.controller;

import com.onedata.remotepatientmonitoring.dto.doctor.DoctorRequestDTO;
import com.onedata.remotepatientmonitoring.dto.doctor.DoctorResponseDTO;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Doctor;
import com.onedata.remotepatientmonitoring.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<DoctorResponseDTO> findAllDoctors(){
        return doctorService.findAll();
    }

    @GetMapping("id/{id}")
    public DoctorResponseDTO findDoctorsById(@PathVariable("id") Integer id){
        return doctorService.findById(id);
    }

    @PostMapping
    public String createDoctor(@RequestBody @Valid DoctorResponseDTO responseDTO){
        return doctorService.create(responseDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable("id") Integer id){
        return doctorService.delete(id);
    }

    @PutMapping("/{id}")
    public DoctorResponseDTO updateDoctors(@RequestBody @Valid DoctorRequestDTO doctor, @PathVariable("id") Integer id){
        return doctorService.update(doctor,id);
    }
}
