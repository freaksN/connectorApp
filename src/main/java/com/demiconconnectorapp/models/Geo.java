package com.demiconconnectorapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class Geo implements Serializable {

    private String latitude;
    private String longitude;
}
