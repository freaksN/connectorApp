package com.demiconconnectorapp.services.impl;

import com.demiconconnectorapp.models.ResultsWrapper;
import com.demiconconnectorapp.services.RandomUserWebClientService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class RandomUserWebClientServiceImpl implements RandomUserWebClientService {

    /**
     * Connects and retrieve the json data from the API
     *
     * @param url
     * @return the json data from the api
     */
    public List<ResultsWrapper> getRandomUserFromApi(String url) {
        WebClient webClient = WebClient.create();

        return webClient.get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(ResultsWrapper.class)
                .log()
                .collectList()
                .block();

    }

}