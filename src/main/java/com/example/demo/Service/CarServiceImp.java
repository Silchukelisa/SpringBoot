package com.example.demo.Service;

import com.example.demo.Model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarServiceImp implements CarService {

    public List<Car> listCar() {
        List<Car> listCars = new ArrayList<>();

        listCars.add(new Car("BMW", 123, "black"));
        listCars.add(new Car("Москвич", 654, "red"));
        listCars.add(new Car("Tesla", 777, "white"));
        listCars.add(new Car("Porsche", 666, "white"));
        listCars.add(new Car("BMW", 846, "white"));
        listCars.add(new Car("Rolls-Royce", 119, "black"));
        listCars.add(new Car("Toyota", 697, "black"));
        listCars.add(new Car("Tesla", 757, "white"));
        listCars.add(new Car("Volkswagen", 798, "red"));
        listCars.add(new Car("BMW", 846, "white"));
        return listCars;
    }

    public List<Car> logicListCar(int count, String maxCar) {
        List<Car> list;
        if (count > Integer.parseInt(maxCar)) {
            list = getCar(Integer.parseInt(maxCar));
        } else {
            list = getCar(count);
        }

        return list;
    }

    public List<Car> getCar(int count) {
        Stream<Car> stream = listCar().stream();
        return stream.limit(count).collect(Collectors.toList());
    }
}
