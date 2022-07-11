package com.example.demo.Controller;

import com.example.demo.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControllerCar {

    @Autowired
    CarService carService;

    @GetMapping("/cars")
    public String cars(@RequestParam(name = "count", required = false) String count, Model model) {
        model.addAttribute("cars", carService.logicListCar(count));
        return "cars";
    }

}
