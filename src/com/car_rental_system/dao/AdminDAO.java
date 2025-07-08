package com.car_rental_system.dao;

import com.car_rental_system.config.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    DB db = new DB();
    CarDAO carDAO = new CarDAO();

    //get all car
    public void getAdminAllCar() throws SQLException, ClassNotFoundException {
        carDAO.getAllCars();
    }

    // rental service price
    public void price() throws SQLException, ClassNotFoundException {
        String GET_PRICE_FROM_DB = "SELECT * FROM price";

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRICE_FROM_DB);
             ResultSet rs = preparedStatement.executeQuery();)  {

            if (rs == null) throw  new  SQLException();

            System.out.println("================= Our Affordable Price Chart =================");
            while (rs.next()) {
                int day = rs.getInt("day");
                int price = rs.getInt("price_per_day");
                String carType = rs.getString("car_type");
                System.out.println("Day: " + day + " | Price: " + price + " | Car Type: " + carType);
            }
        }
    }

    // show all client
    public void showAllClient() throws SQLException, ClassNotFoundException {
        String GET_ALL_CLIENT_FROM_DB = "SELECT * FROM client";

        try (Connection connection = db.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CLIENT_FROM_DB);
        ResultSet rs = preparedStatement.executeQuery();
        ) {
            if (rs == null) throw new RuntimeException();

            System.out.println("========== All Client Details ==========");
            while (rs.next()) {
                String client_name = rs.getString("client_name");
                String car_number = rs.getString("car_number");
                String client_mobileNo = rs.getString("client_mobileNo");
                int booking_days = rs.getInt("booking_days");
                String client_id = rs.getString("client_id");
                int price =rs.getInt("price");
                System.out.println("Client Name: " + client_name +
                        " | Car Number: " + car_number +
                        " | Mobile No: " + client_mobileNo +
                        " | Booking Days: " + booking_days +
                        " | Govt ID: " + client_id +
                        " | Price: ₹" + price
                );
            }
        }
    }

    // calculate total price
    public int rent(int days, String Car_Number) throws SQLException, ClassNotFoundException {
        int total_price = 0;
        String GET_CAR_PRICE_FROM_DB = "SELECT p.price_per_day FROM price p join car c ON p.car_type = c.car_type WHERE c.car_number = ?";

        try (Connection connection = db.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_CAR_PRICE_FROM_DB);
        ) {
            preparedStatement.setString(1, Car_Number);

            try (ResultSet rs = preparedStatement.executeQuery();) {
                if (rs.next()) {
                    int price = rs.getInt("price_per_day");
                    total_price = price * days;
                    System.out.println("Total Rental Price for " + days + " days: ₹" + total_price);
                } else {
                    System.out.println("❌ Car not found or price info unavailable.");
                }
            }
        }

        return total_price;
    }
}
