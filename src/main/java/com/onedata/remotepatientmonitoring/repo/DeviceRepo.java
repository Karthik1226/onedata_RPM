package com.onedata.remotepatientmonitoring.repo;

import com.onedata.remotepatientmonitoring.models.tables.pojos.Device;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.onedata.remotepatientmonitoring.models.Tables.DEVICE;

@Repository
public class DeviceRepo {
    @Autowired
    private DSLContext dsl;

    public String assignDeviceToPatient(String serialNumber,Integer patientId){
         dsl.insertInto(DEVICE)
                .set(DEVICE.SERIAL_NUMBER,serialNumber)
                 .set(DEVICE.ASSIGNED_PATIENT_ID,patientId)
                 .execute();

        return "Device Assigned Successfully";
    }
    public List<Device> findAllDevice(){
        return dsl.selectFrom(DEVICE)
                .fetchInto(Device.class);
    }
    public Device findInfoByDeviceId(Integer deviceId){
        return dsl.selectFrom(DEVICE)
                .where(DEVICE.ID.eq(deviceId))
                .fetchOneInto(Device.class);
    }
    public String unAssignDevice(Integer patientId){
        dsl.deleteFrom(DEVICE)
                .where(DEVICE.ASSIGNED_PATIENT_ID.eq(patientId))
                .execute();
        return "Device Unassigned Successfully";
    }
}
