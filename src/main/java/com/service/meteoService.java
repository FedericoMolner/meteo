package com.service;

import com.dto.meteoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class meteoService {

    public meteoDTO getMeteo(double lat, double lon) {
        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + lat +
                "&longitude=" + lon + "&current_weather=true";

        RestTemplate restTemplate = new RestTemplate();
        OpenMeteoResponse response = restTemplate.getForObject(url, OpenMeteoResponse.class);

        meteoDTO dto = new meteoDTO();
        dto.setTemperatura(response.current_weather.temperature);
        dto.setCondizione("Condizione non disponibile"); // Puoi personalizzare
        return dto;
    }

    static class OpenMeteoResponse {
        public CurrentWeather current_weather;

        static class CurrentWeather {
            public double temperature;
        }
    }
}
