package com.onedata.remotepatientmonitoring.service;

import com.onedata.remotepatientmonitoring.dto.patient.PatientResponseDTO;
import com.onedata.remotepatientmonitoring.dto.patient.PatientResquestDTO;
import com.onedata.remotepatientmonitoring.exception.ResourceNotFoundException;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Patient;
import com.onedata.remotepatientmonitoring.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    public String getCurrentUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


    public List<PatientResponseDTO> findAll(){
         return patientRepo.findAllPatients()
                 .stream()
                 .map(this::mapToResponseDTO)
                 .toList();
    }
    public PatientResponseDTO findById(Integer id) {
        String username = getCurrentUsername();

        Patient patient = patientRepo.findPatientsByID(id);
        if(patient == null){
            throw new ResourceNotFoundException("Patient with Id " + id + " not found.");
        }
        if(!patient.getName().equals(username))
            throw new AccessDeniedException("Access Denied. You are not authorized to view this patient's details.");
        return mapToResponseDTO(patient);
    }
    public String create(PatientResquestDTO resquestDTO){
        Patient patient = new Patient();
        patient.setName(resquestDTO.getName());
        patient.setAge(resquestDTO.getAge());
        patient.setGender(resquestDTO.getGender());
        patientRepo.createPatients(patient);

        return "Patient added successfully" ;
    }
    public String delete(Integer id){
       int rowAffected = patientRepo.deletePatientById(id);

       if(rowAffected == 0){
           throw new ResourceNotFoundException("Patient with Id" + id + "not found");
       }
       return "Patient Details Deleted Successfully";
    }
    public PatientResponseDTO update(PatientResquestDTO resquestDTO, Integer id) {
        Patient updated = patientRepo.findPatientsByID(id);

        if (updated == null){
            throw new ResourceNotFoundException("Patient with Id" + id + "not found");
        }
        updated.setName(resquestDTO.getName());
        updated.setAge(resquestDTO.getAge());
        updated.setGender(resquestDTO.getGender());

        patientRepo.updatePatients(updated);

        return mapToResponseDTO(updated);
    }


    private PatientResponseDTO mapToResponseDTO(Patient patient){
        PatientResponseDTO dto = new PatientResponseDTO();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setAge(patient.getAge());
        dto.setGender(patient.getGender());
        return dto;
    }
}
