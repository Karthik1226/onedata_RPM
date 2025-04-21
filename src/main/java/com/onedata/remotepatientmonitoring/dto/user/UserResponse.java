package com.onedata.remotepatientmonitoring.dto.user;

import com.onedata.remotepatientmonitoring.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String username;
    private Role role;
}
