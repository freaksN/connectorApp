package com.demiconconnectorapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo implements Serializable {


    @Column(name = "user_firstName")
    private String first;

    @Column(name = "user_lastName")
    private String last;
}
