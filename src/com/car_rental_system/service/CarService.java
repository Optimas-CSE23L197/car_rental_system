package com.car_rental_system.service;

import com.car_rental_system.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    public String showCar(Car car) {
        if(!car.getIsAvailable()) {
            return "No Car Available";
        }

        // fetch all car details from database
        return "Car Available";
    }

    // check car already exist into the database
    public boolean isCarExist(Car car) {
        // input car number
        if (car.getCarNumber().equals("aaa")) {
            return true;
        }

        return false;
    }

    // check car available
    // it will check database and return can is available or not
    public boolean isCarAvailable(Car car) {
        return car.getIsAvailable();
    }
}