package com.controller;


// TODO: Update the import below to match the actual package and class name of meteoDTO
// Example: import com.example.dto.meteoDTO;
import com.dto.meteoDTO;
import com.service.meteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class meteoController {

    @Autowired
    private meteoService service;

    @GetMapping("/meteo")
    public String meteoPage() {
        return "meteo";
    }

    @PostMapping("/meteo")
    public String getMeteo(@RequestParam double lat, @RequestParam double lon, Model model) {
        meteoDTO meteo = service.getMeteo(lat, lon);
        model.addAttribute("meteo", meteo);
        return "meteo";
    }
}
