package com.demiconconnectorapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class Timezone implements Serializable {

    @Column(name="timezone_offset")
    private String offset;

    private String description;
}
