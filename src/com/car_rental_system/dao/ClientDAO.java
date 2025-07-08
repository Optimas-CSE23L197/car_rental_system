package com.car_rental_system.dao;

import com.car_rental_system.config.DB;
import com.car_rental_system.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDAO {

    // register form for car booking
    public void addClient(Client client) throws SQLException, ClassNotFoundException {
        DB db = new DB();
        AdminDAO adminDAO = new AdminDAO();
        CarDAO carDAO = new CarDAO();

        if (!carDAO.checkCarAvailability(client.getCarNumber())) {
            System.out.println("❌ Car is not available right now. Please choose another car.");
            return;
        }

        String INSERT_CLIENT_INTO_DATABASE = "INSERT INTO client(client_name,car_number,client_mobileNo,booking_days,client_id,price) values(?,?,?,?,?,?)";
        int price = adminDAO.rent(client.getBookingDays(), client.getCarNumber());
        client.setPrice(price);

        try(Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_INTO_DATABASE);
        ) {

            preparedStatement.setString(1, client.getClientName());
            preparedStatement.setString(2, client.getCarNumber());
            preparedStatement.setString(3, client.getClientMobileNo());
            preparedStatement.setInt(4, client.getBookingDays());
            preparedStatement.setString(5, client.getClientGovtId());
            preparedStatement.setInt(6, client.getPrice());
            int rowInsert = preparedStatement.executeUpdate();


            if (rowInsert > 0) {
                carDAO.setBooking(client.getCarNumber());
                System.out.println("Your Booking Is Successful");
            }
        }
    }
}
