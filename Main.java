import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Capture details for a new Customer
    System.out.println("Enter details for a new customer:");
    System.out.print("Order Number: ");
    int orderNumber = scanner.nextInt();
    scanner.nextLine(); 
    System.out.print("Customer Name: ");
    String customerName = scanner.nextLine();
    System.out.print("Contact Number: ");
    String customerContactNumber = scanner.nextLine();
    System.out.print("Address: ");
    String customerAddress = scanner.nextLine();
    System.out.print("Location: ");
    String customerLocation = scanner.nextLine();
    System.out.print("Email: ");
    String customerEmail = scanner.nextLine();

    // Create a new Customer object
    Customer customer = new Customer(orderNumber, customerName, customerContactNumber, 
    		customerAddress, customerLocation, customerEmail);

    // Capture details for a new Restaurant
    System.out.println("\nEnter details for a new restaurant:");
    System.out.print("Name: ");
    String restaurantName = scanner.nextLine();
    System.out.print("Location: ");
    String restaurantLocation = scanner.nextLine();
    System.out.print("Contact number: ");
    String restaurantContactNumber = scanner.nextLine();
    System.out.print("# Meals ordered: ");
    int numberMealsOrdered = scanner.nextInt();
    scanner.nextLine(); 
    System.out.print("Meal list: ");
    String mealList = scanner.nextLine();
    System.out.print("Meal Prices: ");
    String mealPrices = scanner.nextLine();
    System.out.print("Special Instructions: ");
    String specialInstructions = scanner.nextLine();
    System.out.print("Total Amount: ");
    String totalAmount = scanner.nextLine();

    // Create a new Restaurant object
    Restaurant restaurant = new Restaurant(restaurantName, restaurantLocation, restaurantContactNumber,
            numberMealsOrdered, mealList, mealPrices, specialInstructions, totalAmount);

    // Display the captured details
    System.out.println("\nCustomer Details:");
    System.out.println("Order Number: " + customer.getOrderNumber());
    System.out.println("Customer Name: " + customer.getCustomerName());
    System.out.println("Contact Number: " + customer.getCustomerContactNumber());
    System.out.println("Address: " + customer.getCustomerAddress());
    System.out.println("Location: " + customer.getCustomerLocation());
    System.out.println("Email: " + customer.getCustomerEmail());

    System.out.println("\nRestaurant Details:");
    System.out.println("Name: " + restaurant.getRestaurantName());
    System.out.println("Location: " + restaurant.getRestaurantLocation());
    System.out.println("Contact Number: " + restaurant.getRestaurantContactNumber());
    System.out.println("Number of Meals Ordered: " + restaurant.getNumberMealsOrdered());
    System.out.println("Meal List: " + restaurant.getMealList());
    System.out.println("Meal Prices: " + restaurant.getMealPrices());
    System.out.println("Special Instructions: " + restaurant.getSpecialInstructions());
    System.out.println("Total Amount: " + restaurant.getTotalAmount());

    // Find driver with the lightest load
    String fileName = "drivers.txt";
    String searchArea = customer.getCustomerLocation();

    File file = new File(fileName);
    try (FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr)) {
      String line;
      int lightestLoad = Integer.MAX_VALUE; 
      String driverWithLightestLoad = null;

      while ((line = br.readLine()) != null) {
         String[] parts = line.split(",");
         if (parts.length == 3) {
           String driverName = parts[0].trim();
           String cityName = parts[1].trim();

           try {
             int loadNumber = Integer.parseInt(parts[2].trim());

             if (cityName.equalsIgnoreCase(searchArea)) {
               if (loadNumber < lightestLoad) {
                 lightestLoad = loadNumber;
                 driverWithLightestLoad = driverName;
               }
            }
           } 
           
           catch (NumberFormatException e) {
             // Handle invalid load number
             System.err.println("Invalid load number: " + parts[2].trim());
           }
         }
      }

        if (driverWithLightestLoad != null) {
          System.out.println("Driver with the lightest load in " + searchArea + ": " + driverWithLightestLoad);
          System.out.println("Load Number: " + lightestLoad);
        } else {
            System.out.println("No drivers found in " + searchArea);
        }

        // Check if the customer location and restaurant location are the same
        if (!customer.getCustomerLocation().equalsIgnoreCase(restaurant.getRestaurantLocation())) {
          System.out.println("\nSorry! Our drivers are too far away from you to be able to deliver to your location.");
          return; // Exit the program
        }

        // Save the driver with the lightest load into a variable
        String driverInAreaWithLightestLoad = driverWithLightestLoad;

        // Create an Invoice object and generate the invoice
        Invoice invoice = new Invoice(customer, restaurant, driverInAreaWithLightestLoad, restaurant.getRestaurantContactNumber());
        invoice.generateInvoice();
        
      scanner.close();
    } 
   
    catch (IOException e) {
      e.printStackTrace();
    }
  
  }
}
