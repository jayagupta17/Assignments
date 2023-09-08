package com.jaya.controller;

import com.jaya.DAO.FlightDAO;
import com.jaya.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

@Controller
public class FlightsController {
    @Autowired
    FlightDAO flightDAO;

    @PostMapping("/showFlights")
    public String validateUser(@RequestParam("source")String source, @RequestParam("destination")String destination, Model model)
    {
        ArrayList<Flight> flights = flightDAO.getFlights(source, destination);
        model.addAttribute("flights", flights);
        return "DisplayFlights";
    }
}
