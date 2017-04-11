import java.io.*;
import java.util.*;
import org.json.*;

public class CurrencyCalculator {

  public static void main(String[] args) {
  System.out.println(loadFile());
  }

  public static JSONObject loadFile() {
    JSONObject numbers;

    try {
          numbers = new JSONObject(new FileReader("money.json"));
          FileReader currency = new FileReader("money.json");
          Scanner fileCurrency = new Scanner(currency);
          while(fileCurrency.hasNext()){
            numbers = new JSONObject(fileCurrency.next());
          }
          return numbers;
    }
    catch (FileNotFoundException e) {
        numbers = new JSONObject("....");
        return numbers;
    }


  }

  // public static Integer Calculator {
  //
  //
  //
  // }

}
