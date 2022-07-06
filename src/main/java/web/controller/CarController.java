package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarServiceImpl carServiceImpl;

    @GetMapping
    public String listCars(@RequestParam(value = "count", required = false) Integer count, Model car) {
        car.addAttribute("cars", carServiceImpl.getListCars(count));
        return "cars";
    }
}
