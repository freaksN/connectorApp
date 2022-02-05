package com.demiconconnectorapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class Location implements Serializable {

    @Embedded
    private Street street;

    private String city;
    private String state;
    private String country;
    private String postcode;

    @Embedded
    private Geo coordinates;

    @Embedded
    private Timezone timezone;

}
