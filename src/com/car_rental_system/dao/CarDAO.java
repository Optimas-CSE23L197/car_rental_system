package com.car_rental_system.dao;
import com.car_rental_system.config.DB;
import com.car_rental_system.model.Car;
import com.car_rental_system.service.CarService;

import java.sql.*;
import java.util.Scanner;


public class CarDAO {
    DB db = new DB();
    CarService service = new CarService();

    // scanner class
    Scanner input = new Scanner(System.in);

    // take input for add a new car
    public void takeCarDetails() {
        Car car = new Car();

        System.out.println("Enter Car Name: ");
        car.setCarName(input.nextLine());

        System.out.println("Enter Car Model: ");
        car.setCarModel(input.nextLine());

        System.out.println("Enter Car Number: ");
        car.setCarNumber(input.nextLine());

        System.out.println("Is Car Available: ");
        if (input.hasNextBoolean()) {
            car.setIsAvailable(input.nextBoolean());
            input.nextLine(); // consume newline
        } else {
            System.out.println("Invalid availability input. Setting to false by default.");
            car.setIsAvailable(false);
            input.nextLine(); // clean input
        }

        System.out.println("Enter Car Type: ");
        car.setCar_type(input.nextLine());

        addNewCar(car);
    }

    // add a new car into database
    public void addNewCar(Car car) {
        String INSERT_CAR_INTO_DB = "INSERT INTO car(car_name, car_model, car_number, car_available, car_type) VALUES (?,?,?,?,?)";

        try (
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CAR_INTO_DB);
        ) {
            if (car == null) throw new RuntimeException("Fill add car details");

            // check if car already exist in database
            if (!service.isCarExist(car)) {
                preparedStatement.setString(1, car.getCarName());
                preparedStatement.setString(2, car.getCarModel());
                preparedStatement.setString(3, car.getCarNumber());
                preparedStatement.setBoolean(4, car.getIsAvailable());
                preparedStatement.setString(5, car.getCar_type());
                int rowInserted = preparedStatement.executeUpdate();

                if (rowInserted > 0) System.out.println("Car added successfully");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // return all car to user
    public void getAllCars() throws SQLException,ClassNotFoundException {
        String SHOW_ALL_CAR = "SELECT * FROM car";

        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(SHOW_ALL_CAR);
             ResultSet rs = statement.executeQuery();) {

            if (rs == null) throw new RuntimeException("get all cars failed");
            System.out.println("========== All Cars ==========");
            while (rs.next()) {
                String carName = rs.getString("car_name");
                String carModel = rs.getString("car_model");
                String carNumber = rs.getString("car_number");
                boolean isAvailable = rs.getBoolean("car_available");
                String car_type = rs.getString("car_type");

                System.out.println("Car Name: "+ carName + " | " + "Car Model: "+carModel + " | " + "Car Number: "+carNumber + " | " + "Car Available: "+isAvailable +" | Car Type: "+car_type);
            }
        }
    }

    // change car status after booking
    public void setBooking(String car_number) throws SQLException, ClassNotFoundException {
        String CHANGE_CAR_STATUS = "UPDATE car SET car_available = false where car_number = ?";

        try (Connection connection = db.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_CAR_STATUS);
        ) {
            preparedStatement.setString(1, car_number);
            preparedStatement.executeUpdate();
        }
    }

    // check car status
    public boolean checkCarAvailability(String car_number) throws SQLException,ClassNotFoundException {
        String CAR_STATUS = "SELECT car_available FROM car WHERE car_number = ?";

        try (Connection connection = db.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CAR_STATUS);
        ) {
            preparedStatement.setString(1, car_number);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()) {
                return rs.getBoolean("car_available");
            } else {
                System.out.println("❌ No car found with number: " + car_number);
                return false;
            }
        }
    }
}