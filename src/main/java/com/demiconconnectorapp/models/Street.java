package com.demiconconnectorapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class Street implements Serializable {

    private Integer number;
    @JsonProperty("name")
    private String streetName;
}
