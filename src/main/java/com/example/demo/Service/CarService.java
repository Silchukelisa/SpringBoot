package com.example.demo.Service;

import com.example.demo.Model.Car;

import java.util.List;

public interface CarService {
    List<Car> logicListCar(int count, String maxCar);

    List<Car> listCar();

    List<Car> getCar(int count);
}
