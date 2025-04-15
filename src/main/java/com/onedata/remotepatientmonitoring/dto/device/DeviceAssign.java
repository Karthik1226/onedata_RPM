package com.onedata.remotepatientmonitoring.dto.device;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeviceAssign {
    private String serialNumber;
    private int patientId;
}
