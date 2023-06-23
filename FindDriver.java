import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class FindDriver {

  public static void main(String[] args) {
	// Path to the file containing driver information
	String fileName = "C:\\Users\\darry\\OneDrive\\Desktop\\HyperionDev\\Dropbox\\DB23010005997\\2. Advanced Programming Concepts\\L2T07\\driver-info.txt";
    
	// Retrieve the search area from customer location
	String searchArea = customer.getCustomerLocation(); 

	// Create a File object with the specified file name
	File file = new File(fileName);
    
	// Read the file and find drivers in the search area
    try (FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr)) {
      String line;
      int driverCount = 0;
      int loadCount = 0;

      // Read each line of the file
      while ((line = br.readLine()) != null) {
        String[] parts = line.split(",");
        
        // Ensure the line has three parts: driver name, city name, and load number
        if (parts.length == 3) {
          String driverName = parts[0].trim();
          String cityName = parts[1].trim();
 
          try {
            int loadNumber = Integer.parseInt(parts[2].trim());

            // Check if the city name matches the search area
            if (cityName.equalsIgnoreCase(searchArea)) {
              driverCount++;
              loadCount += loadNumber;
              
              // Print driver details
              System.out.println("Driver: " + driverName);
              System.out.println("City: " + cityName);
              System.out.println("Load Number: " + loadNumber);
              System.out.println("------------------------");
              }
            } 
          catch (NumberFormatException e) {
              // Handle the case when the load number is not a valid integer
            System.err.println("Invalid load number: " + parts[2].trim());
          }
        }
      }
      
      // Print the total number of drivers in the search area
      System.out.println("Total Drivers in " + searchArea + ": " + driverCount);
       
      } catch (IOException e) {
          e.printStackTrace();
      }
   }
}
