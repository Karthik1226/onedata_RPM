package com.onedata.remotepatientmonitoring.controller;

import com.onedata.remotepatientmonitoring.dto.device.DeviceAssign;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Device;
import com.onedata.remotepatientmonitoring.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping
    public String assignDeviceToPatient(@RequestBody DeviceAssign deviceAssign){
        return deviceService.assignDevice(deviceAssign.getSerialNumber(), deviceAssign.getPatientId());
    }
    @GetMapping
    public List<Device> findAllDoctors(){
        return deviceService.getAll();
    }
    @GetMapping("/{deviceId}")
    public Device getDetails(@PathVariable("deviceId") Integer deviceId){
        return deviceService.getDetailsByDeviceId(deviceId);
    }
    @DeleteMapping("/{patientId}")
    public String unAssignDevice(@PathVariable("patientId") Integer patientId){
        return deviceService.removeDevice(patientId);
    }
}
