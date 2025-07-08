package com.car_rental_system;

import com.car_rental_system.dao.ClientDAO;
import com.car_rental_system.model.Client;

import java.sql.SQLException;
import java.util.Scanner;

// client class for booking car
public class ClientBooking implements UserType {
    Scanner input = new Scanner(System.in);
    Client client = new Client();

    // method override from interface
    @Override
    public void register() throws SQLException, ClassNotFoundException {
        ClientDAO dao = new ClientDAO();
        System.out.println("Enter Your Full Name: ");
        client.setClientName(input.nextLine());

        System.out.println("Enter Car Number You Want To Book: ");
        client.setCarNumber(input.nextLine());

        System.out.println("Enter Your Mobile NO: ");
        client.setClientMobileNo(input.nextLine());

        System.out.println("Enter Booking Days: ");
        client.setBookingDays(input.nextInt());
        input.nextLine();

        System.out.println("Enter Your Govt. Id: ");
        client.setClientGovtId(input.nextLine());

        dao.addClient(client);
    }
}
