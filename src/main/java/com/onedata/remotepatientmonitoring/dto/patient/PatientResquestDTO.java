package com.onedata.remotepatientmonitoring.dto.patient;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientResquestDTO {
    @NotBlank(message = "Name is Required")
    @Size(min = 2 , max = 40, message = "Name must be between 2 to 40 characters..")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 0,message = "Age must be non-negative")
    @Max(value = 100,message = "Age must be realist")
    private Integer age;

    @NotNull(message = "Gender is required")
    @Pattern(regexp = "Male|Female", message = "Gender must be Male or Female")
    private String gender;
}
