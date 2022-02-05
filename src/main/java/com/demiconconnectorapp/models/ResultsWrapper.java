package com.demiconconnectorapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsWrapper implements Serializable {

    List<RandomUser> results;
}
