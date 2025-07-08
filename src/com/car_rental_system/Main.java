package com.car_rental_system;

import com.car_rental_system.dao.CarDAO;

import java.sql.SQLException;
import java.util.Scanner;

import com.car_rental_system.model.Client;
import com.car_rental_system.service.AdminService;
import com.car_rental_system.service.ClientService;

public class Main {
    Scanner input = new Scanner(System.in);
    void showOptions() throws SQLException, ClassNotFoundException {
        ClientService clientService = new ClientService();
        AdminService adminService = new AdminService();
        while (true) {
            System.out.println();
            System.out.println("====== Welcome To Animesh Car Rental Service ======");
            System.out.println("__________________________________________________");
            System.out.println("Who Are You: (1 For Admin / 2 for client ) "); // 1 for admin 2 for client
            System.out.println("3 For Exit");
            System.out.println("Enter Your Choice : ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    adminService.adminService();
                    break;

                case 2:
                    clientService.clientService();
                    break;

                case 3:
                    System.out.println("Thank you for using our client service");
                    return;

                default:
                    System.out.println("❌ Invalid Choice. Try again.");
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Main mainMethod = new Main();
        mainMethod.showOptions();
    }
}
