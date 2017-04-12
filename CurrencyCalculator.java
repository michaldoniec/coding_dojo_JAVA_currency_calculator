import java.io.*;
import java.util.*;
import org.json.*;

public class CurrencyCalculator {

  public static void main(String[] args) {

  System.out.println(Calculator(loadFile(),"PHP", 2.0, "PLN"));
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

  public static Double Calculator (JSONObject currencyData, String currencyChosen, Double amount, String currentCurrency) {
    JSONObject currencies = currencyData.getJSONObject("rates");
    Double basevalue;
    Double sum;

    if (currentCurrency == currencyData.getString("base")){
     basevalue = amount;
    }
    else{
     basevalue = amount * currencies.getDouble(currentCurrency);
    }

    sum = basevalue * currencies.getDouble(currencyChosen);
    return sum;

  }


}
