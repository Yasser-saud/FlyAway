package com.example.SpringMvc.serves;

import com.example.SpringMvc.Repo.UserRepo;
import com.example.SpringMvc.Repo.AirlineRepo;
import com.example.SpringMvc.Repo.FlightRepo;
import com.example.SpringMvc.Repo.PlaceRepo;
import com.example.SpringMvc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AdminService {

    private final PlaceRepo placeRepo;
    private final AirlineRepo airlineRepo;
    private final FlightRepo flightRepo;
    private final UserRepo userRepo;

    @Autowired
    public AdminService(PlaceRepo placeRepo, AirlineRepo airlineRepo, FlightRepo flightRepo, UserRepo userRepo) {
        this.placeRepo = placeRepo;
        this.airlineRepo = airlineRepo;
        this.flightRepo = flightRepo;
        this.userRepo = userRepo;
    }

    public boolean isAdmin(HttpServletRequest req){
        HttpSession session = req.getSession();
        return session.getAttribute("admin") != null;
    }

    public String login(String username, String password, HttpServletRequest req){
        if(username.length() <= 0 || password.length() <= 0){
            return "redirect:/login?error=1";
        }

        User user = userRepo.getByUsername(username);

        if(user == null || user.getRole() != Role.ADMIN){
            return "redirect:/login?error=2";
        }
        else if(!user.getPassword().equals(password)){
            return "redirect:/login?error=3";
        }

        HttpSession session = req.getSession();
        session.setAttribute("admin", user);

        return "redirect:/login";
    }

    public String logout(HttpServletRequest req){
        HttpSession session = req.getSession();
        session.invalidate();
        return "redirect:/login";
    }

    public ModelAndView getDashboard(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("dashboard");
        HttpSession session = req.getSession();

        List<Place> placeList = placeRepo.getAllPlaces();
        List<Airline> airlineList = airlineRepo.getAllAirLines();
        List<Flight> flightList = flightRepo.getAllFlights();

        mav.addObject("placeList", placeList);
        mav.addObject("airlineList", airlineList);
        mav.addObject("flightList", flightList);

        return mav;
    }

    public String addPlace(Place place){
        if(place.getSource().length() <= 0 || place.getDestination().length() <= 0){
            return "redirect:/dashboard/add-place?error=1";
        }
        placeRepo.addPlace(place);
        return "redirect:/dashboard";
    }

    public String addAirLine(Airline airLine){
        if(airLine.getName().length() <= 0 ){
            return "redirect:/dashboard/add-airline?error=1";
        }
        airlineRepo.addAirLine(airLine);
        return "redirect:/dashboard";
    }

    public ModelAndView getAddFlightForm(){
        ModelAndView mav = new ModelAndView("addFlightForm");
        mav.addObject("placeList", placeRepo.getAllPlaces());
        mav.addObject("airlineList", airlineRepo.getAllAirLines());
        return mav;
    }

    public ModelAndView addNewFlight(int placeId, int airlineId, int price){
        if(price <= 0){
            return new ModelAndView("redirect:/dashboard/add-flight?error=1");
        }

        Place place = placeRepo.getById(placeId);
        Airline airline = airlineRepo.getById(airlineId);

        flightRepo.addFlight(new Flight(
                price, place, airline
        ));

        return new ModelAndView("redirect:/dashboard");
    }

    public String changePassword(String password, HttpServletRequest req) {
        if(password.length() <= 0){
            return "redirect:/admin/reset?error=1";
        }
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("admin");
        userRepo.updatePassword(user.getId(), password);

        return "redirect:/dashboard";
    }
}
