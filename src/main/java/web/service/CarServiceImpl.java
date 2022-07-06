package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {

    List<Car> carsList = new ArrayList<>();
    {
        carsList.add(new Car("Honda", 159357, "red"));
        carsList.add(new Car("Suzuki", 951753, "yellow"));
        carsList.add(new Car("Subaru", 258456, "blue"));
        carsList.add(new Car("Mitsubishi", 852654, "white"));
        carsList.add(new Car("BMW", 753951, "black"));
    }

    @Override
    public List<Car> getListCars(Integer count) {
        if (count != null) {
            return carsList.stream().limit(count).collect(Collectors.toList());
        }
        return carsList;
    }
}
