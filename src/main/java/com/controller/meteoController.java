package com.controller;


import com.dto.meteoDTO;
import com.service.meteoService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class meteoController {

    private static final Map<String, double[]> COORDINATE_CITTA = Map.of(
            "roma", new double[]{41.9028, 12.4964},
            "milano", new double[]{45.4642, 9.1900},
            "bologna", new double[]{44.4949, 11.3426},
            "napoli", new double[]{40.8518, 14.2681},
            "torino", new double[]{45.0703, 7.6869}
    );

    @Autowired
    private meteoService service;

    @GetMapping({"/", "/meteo"})
    public String meteoPage() {
        return "meteo";
    }

    @PostMapping("/meteo")
    public String getMeteo(@RequestParam String city, Model model) {
        double[] coords = COORDINATE_CITTA.get(city.toLowerCase());
        if (coords == null) {
            model.addAttribute("errore", "Città non valida");
            return "meteo";
        }

        meteoDTO meteo = service.getMeteo(coords[0], coords[1]);
        model.addAttribute("meteo", meteo);
        model.addAttribute("citta", city);
        return "meteo";
    }
}