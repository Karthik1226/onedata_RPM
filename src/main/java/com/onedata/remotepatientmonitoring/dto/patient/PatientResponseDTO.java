package com.onedata.remotepatientmonitoring.dto.patient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientResponseDTO {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
}
