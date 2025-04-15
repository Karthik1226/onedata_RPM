package com.onedata.remotepatientmonitoring.dto.doctor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequestDTO {
    @Size(min = 2,max = 50, message = "Name should be between 2 to 50")
    @NotBlank(message = "Name should be provided")
    private String name;
    @NotBlank(message = "Specialization should be provide")
    private String specialization;
}
