package com.demiconconnectorapp.services;

import com.demiconconnectorapp.models.RandomUser;
import com.demiconconnectorapp.models.ResultsWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RandomUserWebClientService {

    List<ResultsWrapper> getRandomUserFromApi(String url);
}
