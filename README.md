# Car Rental System

A simple Java-based command-line Car Rental System for managing car rentals, bookings, and administrative tasks.

## Features

- **Admin Portal:**
  - Admin authentication (default: admin/admin)
  - View all cars in the system
  - View all rental records (clients)
  - View the current price chart
  - Add new cars to the fleet

- **Client Portal:**
  - View all available cars
  - Book a car (with client details and booking days)
  - Check price chart

## Getting Started

### Prerequisites

- Java 8 or above
- JDBC-compatible database (code references a database, ensure you have the correct DB and credentials set up)
- (Optional) IDE for Java (IntelliJ IDEA, Eclipse, etc.)

### Project Structure

```
src/
  com/car_rental_system/
    Main.java
    ClientBooking.java
    dao/
      CarDAO.java
      AdminDAO.java
      ClientDAO.java
    model/
      Car.java
      Client.java
    service/
      AdminService.java
      ClientService.java
      CarService.java
```

### Setup & Running

1. **Clone the repository:**
   ```sh
   git clone https://github.com/Optimas-CSE23L197/car_rental_system.git
   cd car_rental_system
   ```

2. **Configure the database:**
   - Make sure your database is running and connection details are set in the DB utility class (not shown here).
   - Create required tables for cars and clients as per the fields in `Car` and `Client` models.

3. **Compile and Run:**
   - From the project root, compile the source code:
     ```sh
     javac -d out src/com/car_rental_system/**/*.java
     ```
   - Run the main program:
     ```sh
     java -cp out com.car_rental_system.Main
     ```

### Usage

- On startup, choose whether you are an **Admin** (1) or **Client** (2).
- **Admin** can log in (`admin`/`admin`), view/add cars, and view client bookings.
- **Client** can view all cars, book a car, or check prices.

## Example

```
====== Welcome To Animesh Car Rental Service ======
Who Are You: (1 For Admin / 2 for client )
3 For Exit
Enter Your Choice :
```

As Admin:

```
========== Welcome Admin Service ==========
========== Login ==========
Enter your admin name:
Enter your admin password:
Login Successful
1. Show All Cars
2. Show All Rentals
3. Check Price Chart
5. Add New Car
7. Exit
```

As Client:

```
====== Our Client Service ======
1. Show All Car
2. Book Car
3. Check Price
4. Exit
Enter your choice:
```

## Technologies Used

- Java (core)
- JDBC (database connectivity)
- Command-line interface (CLI)

## License

not needed just for fun

---

*Feel free to contribute or raise issues!*
