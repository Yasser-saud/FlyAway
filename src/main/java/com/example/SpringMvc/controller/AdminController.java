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
        boolean isAdmin = adminService.isAdmin(req);
        if(isAdmin)
            return "redirect:/dashboard";

        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest req){
        return adminService.login(username, password, req);
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req){
        return adminService.logout(req);
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard(HttpServletRequest req){
        boolean isAdmin = adminService.isAdmin(req);
        if(isAdmin){
            return adminService.getDashboard(req);
        }
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/dashboard/add-place")
    public String addPlacePage(HttpServletRequest req){
        boolean isAdmin = adminService.isAdmin(req);
        if(isAdmin)
            return "addPlaceForm";

        return "redirect:/login";
    }

    @PostMapping("/dashboard/add-place")
    public String addPlaceHandler(@RequestParam String source, @RequestParam String destination, HttpServletRequest req){
        return adminService.addPlace(new Place(source, destination));
    }

    @GetMapping("/dashboard/add-airline")
    public String addAirLinePage(HttpServletRequest req){
        boolean isAdmin = adminService.isAdmin(req);
        if(isAdmin)
            return "addAirlineForm";
        return "redirect:/login";
    }

    @PostMapping("/dashboard/add-airline")
    public String addAirLineHandler(@RequestParam String name){
        return adminService.addAirLine(new Airline(name));
    }

    @GetMapping("/dashboard/add-flight")
    public ModelAndView addFlightPage(HttpServletRequest req){
        boolean isAdmin = adminService.isAdmin(req);
        if(isAdmin)
            return adminService.getAddFlightForm();

        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/dashboard/add-flight")
    public ModelAndView addFlightHandler(@RequestParam int placeId, @RequestParam int airlineId, @RequestParam int price){
        return adminService.addNewFlight(placeId, airlineId, price);
    }

    @GetMapping("/admin/reset")
    public String resetPage(HttpServletRequest req){
        boolean isAdmin = adminService.isAdmin(req);
        if(isAdmin)
            return "changePass";

        return "redirect:/login";
    }

    @PostMapping("/admin/reset")
    public String changePass(@RequestParam String password, HttpServletRequest req){
        return adminService.changePassword(password, req);
    }
}
