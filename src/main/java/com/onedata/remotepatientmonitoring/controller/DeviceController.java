package com.onedata.remotepatientmonitoring.controller;

import com.onedata.remotepatientmonitoring.dto.device.DeviceAssign;
import com.onedata.remotepatientmonitoring.exception.ResourceNotFoundException;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Device;
import com.onedata.remotepatientmonitoring.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping
    public ResponseEntity<String> assignDeviceToPatient(@RequestBody DeviceAssign deviceAssign){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(deviceService.assignDevice(deviceAssign.getSerialNumber(), deviceAssign.getPatientId()));
    }

    @GetMapping
    public ResponseEntity<List<Device>> findAllDevice(){
        return ResponseEntity.ok(deviceService.getAll());
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<Device> getDetails(@PathVariable("deviceId") Integer deviceId){
        Device device = deviceService.getDetailsByDeviceId(deviceId);

        if(device != null){
            return ResponseEntity.ok(device);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<String> unAssignDevice(@PathVariable("patientId") Integer patientId){
        return ResponseEntity.ok(deviceService.removeDevice(patientId));
    }
    @GetMapping("/assigned/{patientId}")
    public ResponseEntity<Device> getAssignedDeviceByPatientId(@PathVariable("patientId") Integer patientId){
        Device device = deviceService.getAssignedDevice(patientId);
        if(device != null){
            return ResponseEntity.ok(device);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
