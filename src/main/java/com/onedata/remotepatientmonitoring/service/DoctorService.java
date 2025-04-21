package com.onedata.remotepatientmonitoring.service;

import com.onedata.remotepatientmonitoring.dto.doctor.DoctorRequestDTO;
import com.onedata.remotepatientmonitoring.dto.doctor.DoctorResponseDTO;
import com.onedata.remotepatientmonitoring.exception.ResourceNotFoundException;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Doctor;
import com.onedata.remotepatientmonitoring.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorService {

   @Autowired
   private DoctorRepo doctorRepo;

    public String getCurrentUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    public List<DoctorResponseDTO> findAll(){
         return doctorRepo.findAllDoctors()
                 .stream()
                 .map(this::asDoctor)
                 .toList();
    }

    public DoctorResponseDTO findById(Integer id){
        String username = getCurrentUsername();

         Doctor doctor = doctorRepo.findDoctorsByID(id);
         if(doctor == null){
             throw new ResourceNotFoundException("Doctor With Id " + id + " Is not found");
         }
        if(!doctor.getName().equals(username))
            throw new AccessDeniedException("Access Denied. You are not authorized to view this doctor's details.");
         return asDoctor(doctor);
    }
    public String create(DoctorRequestDTO requestDTO){
        Doctor doctor1 = new Doctor();
        doctor1.setName(requestDTO.getName());
        doctor1.setSpecialization(requestDTO.getSpecialization());
        doctorRepo.createDoctor(doctor1);

        return "Doctor Added Successfully";
    }
    public String delete(Integer id){
        int rowAffected = doctorRepo.deleteDoctorById(id);

        if(rowAffected == 0){
            throw new ResourceNotFoundException("Doctor with Id" + id + "not found");
        }
        return " Doctor Details deleted successfully";

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
