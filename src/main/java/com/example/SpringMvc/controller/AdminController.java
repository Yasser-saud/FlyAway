package com.example.SpringMvc.controller;

import com.example.SpringMvc.model.Airline;
import com.example.SpringMvc.model.Place;
import com.example.SpringMvc.serves.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public String adminPage(HttpServletRequest req){
        HttpSession session = req.getSession();
        if(session.getAttribute("admin") != null){
            return "redirect:/dashboard";
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest req){
        return adminService.login(username, password, req);
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard(HttpServletRequest req){
        return adminService.getDashboard(req);
    }

    @GetMapping("/dashboard/add-place")
    public String addPlacePage(){
        return "addPlaceForm";
    }

    @PostMapping("/dashboard/add-place")
    public String addPlaceHandler(@RequestParam String source, @RequestParam String destination){
        return adminService.addPlace(new Place(source, destination));
    }

    @GetMapping("/dashboard/add-airline")
    public String addAirLinePage(){
        return "addAirlineForm";
    }

    @PostMapping("/dashboard/add-airline")
    public String addAirLineHandler(@RequestParam String name){
        return adminService.addAirLine(new Airline(name));
    }

    @GetMapping("/dashboard/add-flight")
    public ModelAndView addFlightPage(){
        return adminService.getAddFlightForm();
    }

    @PostMapping("/dashboard/add-flight")
    public ModelAndView addFlightHandler(@RequestParam int placeId, @RequestParam int airlineId, @RequestParam int price){
        return adminService.addNewFlight(placeId, airlineId, price);
    }
}
