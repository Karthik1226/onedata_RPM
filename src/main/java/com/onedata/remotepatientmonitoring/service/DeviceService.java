package com.onedata.remotepatientmonitoring.service;


import com.onedata.remotepatientmonitoring.models.tables.pojos.Device;
import com.onedata.remotepatientmonitoring.repo.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepo deviceRepo;

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
}
