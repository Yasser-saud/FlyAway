package com.example.SpringMvc.serves;

import com.example.SpringMvc.Repo.FlightRepo;
import com.example.SpringMvc.model.Flight;
import com.example.SpringMvc.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CustomerService {

    private final FlightRepo flightRepo;

    @Autowired
    public CustomerService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }

    public ModelAndView searchResult(HttpServletRequest req){
        HttpSession session = req.getSession();
        ModelAndView mav = new ModelAndView("searchPage");
        String source = req.getParameter("source");
        String destination = req.getParameter("destination");
        String date = req.getParameter("date");
        String passengers = req.getParameter("passengers");
        List<Flight> result = flightRepo.findFlight(source, destination);
        session.setAttribute("pass", passengers);
        session.setAttribute("date", date);
        mav.addObject("result", result);

        return mav;
    }

    public ModelAndView register(@RequestParam String username, @RequestParam String password){
        if(username.length() <= 0 || password.length() <= 0){
            return new ModelAndView("redirect:/register?error=1");
        }
        System.out.println(id+" "+pass);
    }
}
