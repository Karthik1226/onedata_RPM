package com.onedata.remotepatientmonitoring.dto.doctorPatient;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorPatientRequestDTO {
    @NotNull(message = "Doctor Id must not be null")
    private Integer doctorId;
    @NotNull(message = "Patient Id must not be null")
    private Integer patientId;
}
