import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
  public void findDriverWithSmallestLoad() {
    try {
      // Create scanner object to read from the file
      Scanner input = new Scanner(new File("driver-info.txt"));
      int smallestLoad = Integer.MAX_VALUE;
      String smallestLoadDriver = "";
      String restaurantArea = ""; 

      // Check if the file has more lines
      while (input.hasNextLine()) {
        String[] data = input.nextLine().split(",");
        
        // Check if the driver's area matches the restaurant area
        if (data[0].equalsIgnoreCase(restaurantArea)) {
          int load = Integer.parseInt(data[1].trim());
          
          // Check if the current load is smaller than the smallest load found so far
          if (load < smallestLoad) {
            smallestLoad = load;
            smallestLoadDriver = data[2].trim(); // Assuming driver's name is in the 3rd position
          }
        }
      }

       if (smallestLoad == Integer.MAX_VALUE) {
         System.out.println("Sorry! Our drivers are too far away from you to be able to deliver to your location.");
       } else {
           System.out.println("Driver with smallest load: " + smallestLoadDriver + ", Load: " + smallestLoad);
         }

      // Close the file
      input.close();
    } 
    catch (FileNotFoundException e) {
      System.out.println("File not found: " + e.getMessage());
    }
  }
} 
