package com.jaya.controller;

import com.jaya.DAO.BookingDAO;
import com.jaya.DAO.FlightDAO;
import com.jaya.DAO.PassengerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PassengerController {
    @Autowired
    PassengerDAO passengerDAO;

    @Autowired
    BookingDAO bookingDAO;

    @Autowired
    FlightDAO flightDAO;

    @PostMapping("/addPassengerDetails")
    public String addPassengerDetails(@RequestParam("flightId")String flightId, @RequestParam("fname")String fname, @RequestParam("lname")String lname, @RequestParam("mobile")long mobile, @RequestParam("email")String email, Model model) {
        String message = "Details not added";
        boolean c1=false,c2=false;
        c1 = passengerDAO.addPassenger(fname, lname, mobile, email);
        int passengerId = passengerDAO.getIdByEmail(email);
        if(passengerId != 0)
            c2 = bookingDAO.addBooking(flightId, passengerId);
        if(c1 && c2) {
            model.addAttribute("passenger", passengerDAO.getPassengerById(passengerId));
            model.addAttribute("flight", flightDAO.getFlightById(flightId));
            return "BookingDetails";
        }
        model.addAttribute("message", message);
        return "Display";
    }
}
