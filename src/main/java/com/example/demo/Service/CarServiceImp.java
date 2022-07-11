package com.example.demo.Service;

import com.example.demo.Model.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CarServiceImp implements CarService {

    @Value("${maxCar}")
    private int maxCar;

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

    public List<Car> logicListCar(String count) {
        List<Car> list;
        if (count == null || Integer.parseInt(count) > maxCar) {
            list = getCar(maxCar);
        } else {
            list = getCar(Integer.parseInt(count));
        }

        return list;
    }

    public List<Car> getCar(int count) {
        return listCar().stream().limit(count).collect(Collectors.toList());
    }

}
