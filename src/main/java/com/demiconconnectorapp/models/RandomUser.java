package com.demiconconnectorapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class RandomUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @JsonIgnore
    private Long id;

    @JsonProperty("name")
    private UserInfo name;

    @JsonProperty("gender")
    private String gender;

    @Embedded
    @JsonProperty("location")
    private Location location;

    @JsonProperty("email")
    private String email;

    @JsonIgnore
    private Date dateModified;




}
