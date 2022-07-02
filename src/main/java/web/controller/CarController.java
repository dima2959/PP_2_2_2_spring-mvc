package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        CarService carService = new CarServiceImpl();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Honda", 159357, "red"));
        carList.add(new Car("Suzuki", 951753, "yellow"));
        carList.add(new Car("Subaru", 258456, "blue"));
        carList.add(new Car("Subaru", 852654, "white"));
        carList.add(new Car("BMW", 753951, "black"));
        List<Car> returnedCarList = count == null ? carList : carService.getSomeCars(carList, count);
        model.addAttribute("list", returnedCarList);
        return "cars";
    }
}