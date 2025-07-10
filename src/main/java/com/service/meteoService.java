package com.service;

import com.dto.meteoDTO;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class meteoService {

    public meteoDTO getMeteo(double lat, double lon) {
        String url = "https://api.open-meteo.com/v1/forecast"
                + "?latitude=" + lat
                + "&longitude=" + lon
                + "&daily=temperature_2m_max"
                + "&timezone=auto";

        RestTemplate restTemplate = new RestTemplate();
        OpenMeteoResponse response = restTemplate.getForObject(url, OpenMeteoResponse.class);

        meteoDTO dto = new meteoDTO();
        dto.setDate(response.daily.time);
        dto.setTemperature(response.daily.temperature_2m_max);

        return dto;
    }

    // Classe per mappare la risposta dell'API
    static class OpenMeteoResponse {
        public Daily daily;

        static class Daily {
            public List<String> time;
            public List<Double> temperature_2m_max;
        }
    }
}