package com.onedata.remotepatientmonitoring.service;


import com.onedata.remotepatientmonitoring.exception.ResourceNotFoundException;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Device;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Patient;
import com.onedata.remotepatientmonitoring.repo.DeviceRepo;
import com.onedata.remotepatientmonitoring.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepo deviceRepo;

    @Autowired
    private PatientRepo patientRepo;

    public String getCurrentUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    public String assignDevice(String serialNumber,Integer patientId){
        return deviceRepo.assignDeviceToPatient(serialNumber,patientId);
    }
    public List<Device> getAll(){
        return deviceRepo.findAllDevice();
    }
    public Device getDetailsByDeviceId(Integer deviceId){
        return deviceRepo.findInfoByDeviceId(deviceId);
    }
    public String removeDevice(Integer patientId){
        return deviceRepo.unAssignDevice(patientId);
    }

    public Device getAssignedDevice(Integer patientId) {

        String currentUsername = getCurrentUsername();
        Patient patient = patientRepo.findPatientsByID(patientId);

        if (patient == null) {
            throw new ResourceNotFoundException("Patient not found for current user");
        }
        if(!patient.getName().equals(currentUsername)){
            throw new AccessDeniedException("Access Denied. You are not authorized to view this patient's device details.");
        }

        Device device = deviceRepo.findByPatientId(patient.getId());

        if (device == null) {
            throw new ResourceNotFoundException("No device assigned to this patient");
        }

        return device;
    }
}
