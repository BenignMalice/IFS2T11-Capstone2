import java.io.FileWriter;
import java.io.IOException;

public class Invoice {
  // Class fields
  private Customer customer;
  private Restaurant restaurant;
  private String driverName;
  private String driverContactNumber;

  //Constructor
  public Invoice(Customer customer, Restaurant restaurant, String driverName, String driverContactNumber) {
    this.customer = customer;
    this.restaurant = restaurant;
    this.driverName = driverName;
    this.driverContactNumber = driverContactNumber;
  }

  //Generates an invoice and writes it to a file
  public void generateInvoice() {
    try (FileWriter writer = new FileWriter("invoice.txt")) {
      writeCustomerDetails(writer);
      writeOrderDetails(writer);
      writeDeliveryDetails(writer);
      writeContactDetails(writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //Writes customer details to the invoice file
  private void writeCustomerDetails(FileWriter writer) throws IOException {
    writer.write("Order number: " + customer.getOrderNumber() + "\n");
    writer.write("Customer: " + customer.getCustomerName() + "\n");
    writer.write("Email: " + customer.getCustomerEmail() + "\n");
    writer.write("Phone number: " + customer.getCustomerContactNumber() + "\n");
    writer.write("Location: " + customer.getCustomerLocation() + "\n\n");
  }

  //Writes order details to the invoice file
  private void writeOrderDetails(FileWriter writer) throws IOException {
    writer.write("You have ordered the following from " + restaurant.getRestaurantName() +
        " in " + restaurant.getRestaurantLocation() + ":\n");
    writer.write(restaurant.getNumberMealsOrdered() + " x " + restaurant.getMealList() +
        " (R" + restaurant.getMealPrices() + ")\n");
    writer.write("Special instructions: " + restaurant.getSpecialInstructions() + "\n");
    writer.write("Total: R" + restaurant.getTotalAmount() + "\n\n");
  }

  // Writes delivery details to the invoice file
  private void writeDeliveryDetails(FileWriter writer) throws IOException {
    writer.write(driverName + " is nearest to the restaurant and they will be delivering your\n");
    writer.write("order to you at:\n");
    writer.write(customer.getCustomerAddress() + "\n");
    writer.write(customer.getCustomerLocation() + "\n\n");
  }

  private void writeContactDetails(FileWriter writer) throws IOException {
    writer.write("If you need to contact the restaurant, their number is " + driverContactNumber + ".\n");
  }
}
