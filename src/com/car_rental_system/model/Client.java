package com.car_rental_system.model;

public class Client {

    private String clientName;
    private String carNumber;
    private String clientMobileNo;
    private int bookingDays;
    private String clientGovtId;
    private int price;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getClientMobileNo() {
        return clientMobileNo;
    }

    public void setClientMobileNo(String clientMobileNo) {
        this.clientMobileNo = clientMobileNo;
    }

    public int getBookingDays() {
        return bookingDays;
    }

    public void setBookingDays(int bookingDays) {
        this.bookingDays = bookingDays;
    }

    public String getClientGovtId() {
        return clientGovtId;
    }

    public void setClientGovtId(String clientGovtId) {
        this.clientGovtId = clientGovtId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
