package com.onedata.remotepatientmonitoring.controller;

import com.onedata.remotepatientmonitoring.dto.doctor.DoctorRequestDTO;
import com.onedata.remotepatientmonitoring.dto.doctor.DoctorResponseDTO;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Doctor;
import com.onedata.remotepatientmonitoring.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorResponseDTO>> findAllDoctors(){
        return ResponseEntity.ok(doctorService.findAll());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<DoctorResponseDTO> findDoctorsById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(doctorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<String> createDoctor(@RequestBody @Valid DoctorResponseDTO responseDTO){
        String message = doctorService.create(responseDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(message);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id") Integer id){
        return ResponseEntity.ok(doctorService.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> updateDoctors(@RequestBody @Valid DoctorRequestDTO doctor, @PathVariable("id") Integer id){
        return ResponseEntity.ok(doctorService.update(doctor, id));
    }
}
