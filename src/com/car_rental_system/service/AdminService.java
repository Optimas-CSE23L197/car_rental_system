package com.car_rental_system.service;

import com.car_rental_system.dao.AdminDAO;
import com.car_rental_system.dao.CarDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminService {
    Scanner input = new Scanner(System.in);
    AdminDAO adminDAO = new AdminDAO();
    CarDAO carDAO = new CarDAO();

    public void adminService() throws SQLException, ClassNotFoundException {
        CarDAO carDAO = new CarDAO();
        System.out.println("========== Welcome Admin Service ==========");

        System.out.println("========== Login ==========");
        if (checkLogin()) {

            System.out.println("1. Show All Cars");
            System.out.println("2. Show All Rentals");
            System.out.println("3. Check Price Chart");
//            System.out.println("4. Update Price Chart");
            System.out.println("5. Add New Car");
//            System.out.println("6. Delete Car");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    carDAO.getAllCars();
                    break;

                case 2:
                    adminDAO.showAllClient();
                    break;

                case 3:
                    adminDAO.price();
                    break;

                case 5:
                    carDAO.takeCarDetails();
                    break;

                case 7:
                    System.out.println("Have a nice day admin...");
                    return;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    // service class for admin
    //check admin username and password
    public boolean adminLogin() {
        String adminName = "admin";
        String adminPassword = "admin";

        System.out.println("Enter your admin name: ");
        String name = input.nextLine();

        System.out.println("Enter your admin password: ");
        String password = input.nextLine();


        if (!adminName.equals(name) && !adminPassword.equals(password)) {
            return false;
        }
        System.out.println("Login Successful");
        return true;
    }

    // check login
    public boolean checkLogin() {
        return adminLogin();
    }
}
