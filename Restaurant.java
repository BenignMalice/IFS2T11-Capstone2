public class Restaurant {
  private String restaurantName;
  private String restaurantLocation;
  private String restaurantContactNumber;
  private int numberMealsOrdered;
  private String mealList;
  private String mealPrices;
  private String specialInstructions;
  private String totalAmount;

  // Constructor to initialize the restaurant details
  public Restaurant(String restaurantName, String restaurantLocation, String restaurantContactNumber,
                      int numberMealsOrdered, String mealList, String mealPrices, String specialInstructions,
                      String totalAmount) {
    this.restaurantName = restaurantName;
    this.restaurantLocation = restaurantLocation;
    this.restaurantContactNumber = restaurantContactNumber;
    this.numberMealsOrdered = numberMealsOrdered;
    this.mealList = mealList;
    this.mealPrices = mealPrices;
    this.specialInstructions = specialInstructions;
    this.totalAmount = totalAmount;
  }

  // Getter methods to retrieve the values of the fields
  public String getRestaurantName() {
    return restaurantName;
  }

  public String getRestaurantLocation() {
    return restaurantLocation;
  }

  public String getRestaurantContactNumber() {
    return restaurantContactNumber;
  }

  public int getNumberMealsOrdered() {
    return numberMealsOrdered;
  }

  public String getMealList() {
    return mealList;
  }

  public String getMealPrices() {
    return mealPrices;
  }

  public String getSpecialInstructions() {
    return specialInstructions;
  }

  public String getTotalAmount() {
    return totalAmount;
  }

  // Setter methods to modify the values of the fields 
  public void setRestaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
  }

  public void setRestaurantLocation(String restaurantLocation) {
    this.restaurantLocation = restaurantLocation;
  }

  public void setRestaurantContactNumber(String restaurantContactNumber) {
    this.restaurantContactNumber = restaurantContactNumber;
  }

  public void setNumberMealsOrdered(int numberMealsOrdered) {
    this.numberMealsOrdered = numberMealsOrdered;
  }

  public void setMealList(String mealList) {
    this.mealList = mealList;
  }

  public void setMealPrices(String mealPrices) {
    this.mealPrices = mealPrices;
  }

  public void setSpecialInstructions(String specialInstructions) {
    this.specialInstructions = specialInstructions;
  }

  public void setTotalAmount(String totalAmount) {
    this.totalAmount = totalAmount;
  }
}
