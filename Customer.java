public class Customer {
  private int orderNumber;
  private String customerName;
  private String customerContactNumber;
  private String customerAddress;
  private String customerLocation;
  private String customerEmail;
    
  public Customer(int orderNumber, String customerName, String customerContactNumber, String customerAddress, 
  String customerLocation, String customerEmail) {
    this.orderNumber = orderNumber;
    this.customerName = customerName;
    this.customerContactNumber = customerContactNumber;
    this.customerAddress = customerAddress;
    this.customerLocation = customerLocation;
    this.customerEmail = customerEmail;
  }
    
  // Getters
  public int getOrderNumber() {
    return orderNumber;
  }

  public String getCustomerName() {
    return customerName;
  }

  public String getCustomerContactNumber() {
    return customerContactNumber;
  }

  public String getCustomerAddress() {
    return customerAddress;
  }

  public String getCustomerLocation() {
    return customerLocation;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  // Setters (optional, if needed)
  public void setOrderNumber(int orderNumber) {
    this.orderNumber = orderNumber;
  } 

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public void setCustomerContactNumber(String customerContactNumber) {
    this.customerContactNumber = customerContactNumber;
  }

  public void setCustomerAddress(String customerAddress) {
    this.customerAddress = customerAddress;
  }

  public void setCustomerLocation(String customerLocation) {
    this.customerLocation = customerLocation;
  }

  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
  }
}
