package web.service;

import web.model.Car;

import java.util.List;

public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getSomeCars(List<Car> list, int count) {
        return count < 5 ? list.stream().limit(count).toList() : list;
    }
}