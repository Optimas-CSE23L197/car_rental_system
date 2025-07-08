package com.car_rental_system.service;

import com.car_rental_system.dao.AdminDAO;
import com.car_rental_system.dao.CarDAO;
import com.car_rental_system.UserType;
import com.car_rental_system.ClientBooking;

import java.sql.SQLException;
import java.util.Scanner;

public class ClientService {

    public void clientService() throws SQLException, ClassNotFoundException {
        CarDAO carDao = new CarDAO();
        UserType client = new ClientBooking();
        AdminDAO adminDAO = new AdminDAO();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("====== Our Client Service ======");
            System.out.println("_________________________________________________");
            System.out.println("1. Show All Car");
            System.out.println("2. Book Car");
            System.out.println("3. Check Price");
            System.out.println("4. Exit");
            System.out.println("_________________________________________________");
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    carDao.getAllCars();
                    break;

                case 2:
                    // book a car
                    client.register();
                    break;

                case 3:
                    adminDAO.price();
                    break;

                case 4:
                    System.out.println("Thank you for using our client service");
                    return;

                default:
                    System.out.println("❌ Invalid Choice. Try again.");
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ClientService service = new ClientService();
        service.clientService();
    }
}

