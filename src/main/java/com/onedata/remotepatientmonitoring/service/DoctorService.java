package com.onedata.remotepatientmonitoring.service;

import com.onedata.remotepatientmonitoring.dto.doctor.DoctorRequestDTO;
import com.onedata.remotepatientmonitoring.dto.doctor.DoctorResponseDTO;
import com.onedata.remotepatientmonitoring.exception.ResourceNotFoundException;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Doctor;
import com.onedata.remotepatientmonitoring.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorService {

   @Autowired
   private DoctorRepo doctorRepo;

    public List<DoctorResponseDTO> findAll(){
         return doctorRepo.findAllDoctors()
                 .stream()
                 .map(this::asDoctor)
                 .toList();
    }
    public DoctorResponseDTO findById(Integer id){
         Doctor doctor = doctorRepo.findDoctorsByID(id);
         if(doctor == null){
             throw new ResourceNotFoundException("Doctor With Id " + id + " Is not found");
         }
         return asDoctor(doctor);
    }
    public String create(DoctorResponseDTO responseDTO){
        Doctor doctor1 = new Doctor();
        doctor1.setName(responseDTO.getName());
        doctor1.setSpecialization(responseDTO.getSpecialization());
        doctorRepo.createDoctor(doctor1);

        return "Doctor Added Successfully";
    }
    public String delete(Integer id){
        int rowAffected = doctorRepo.deleteDoctorById(id);

        if(rowAffected == 0){
            throw new ResourceNotFoundException("Doctor with Id" + id + "not found");
        }
        return " Doctor Details deleted succuessfully";

    }
    public DoctorResponseDTO update(DoctorRequestDTO requestDTO, Integer id){
        Doctor updated = doctorRepo.findDoctorsByID(id);

        if(updated == null){
            throw new ResourceNotFoundException("Doctor with Id" + id + "not found");
        }
        updated.setName(requestDTO.getName());
        updated.setSpecialization(requestDTO.getSpecialization());

        return asDoctor(updated);
    }

    private DoctorResponseDTO asDoctor(Doctor doctor){
        DoctorResponseDTO dto = new DoctorResponseDTO();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setSpecialization(doctor.getSpecialization());

        return dto;
    }
}
