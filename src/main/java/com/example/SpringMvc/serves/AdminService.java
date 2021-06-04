package com.example.SpringMvc.serves;

import com.example.SpringMvc.Repo.AirLineRepo;
import com.example.SpringMvc.Repo.PlaceRepo;
import com.example.SpringMvc.model.AirLine;
import com.example.SpringMvc.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AdminService {


    private final PlaceRepo placeRepo;
    private final AirLineRepo airLineRepo;

    @Autowired
    public AdminService(PlaceRepo placeRepo, AirLineRepo airLineRepo) {
        this.placeRepo = placeRepo;
        this.airLineRepo = airLineRepo;
    }

    public String login(String username, String password, HttpServletRequest req){
        if(username.length() <= 0 || password.length() <= 0){
            return "redirect:/login?error=1";
        }
        HttpSession session = req.getSession();
        session.setAttribute("admin", username);
        session.setAttribute("password", password);
        return "redirect:/dashboard";
    }

    public ModelAndView getDashboard(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("dashboard");
        HttpSession session = req.getSession();
        if(session.getAttribute("admin") == null){
            return new ModelAndView("redirect:/login?error=1");
        }

        List<Place> placeList = placeRepo.getAllPlaces();
        List<AirLine> airLineList = airLineRepo.getAllAirLines();
        mav.addObject("placeList", placeList);
        mav.addObject("airLineList", airLineList);
        return mav;
    }

    public String addPlace(Place place){
        if(place.getSource().length() <= 0 || place.getDestination().length() <= 0){
            return "redirect:/dashboard/add-place?error=1";
        }
        placeRepo.addPlace(place);
        return "redirect:/dashboard";
    }

    public String addAirLine(AirLine airLine){
        if(airLine.getName().length() <= 0 ){
            return "redirect:/dashboard/add-airline?error=1";
        }
        airLineRepo.addAirLine(airLine);
        return "redirect:/dashboard";
    }
}
