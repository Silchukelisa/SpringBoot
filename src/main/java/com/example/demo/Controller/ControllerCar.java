package com.example.demo.Controller;

import com.example.demo.Service.CarServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


@Controller
public class ControllerCar {

    FileInputStream fis;
    Properties property = new Properties();

    @GetMapping("/cars")
    public String cars(HttpServletRequest request, Model model) throws IOException {
        fis = new FileInputStream("src/main/resources/application.properties");
        property.load(fis);
        String maxCar = property.getProperty("maxCar");
        CarServiceImp carServiceImp = new CarServiceImp();
        String req = request.getParameter("count");
        int count;
        if (req != null) {
            count = Integer.parseInt(request.getParameter("count"));
        } else {
            count = Integer.parseInt(maxCar);
        }
        model.addAttribute("cars", carServiceImp.logicListCar(count, maxCar));
        return "cars";
    }
}
