package com.demiconconnectorapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfoResponse {

    private String name;
    private String gender;
    private String email;
}
