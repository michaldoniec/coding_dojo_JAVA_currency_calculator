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
    System.out.println(currencies.get(currencyChosen).getClass());
    if (currentCurrency == currencyData.get("base")){
     basevalue = amount;
    }
    else{
      Double x = new Double(currencies.get(currentCurrency));
     basevalue = amount * x;
    }
    Double currency2 = new Double(currencies.get(currencyChosen));

    sum = basevalue * currency2;
    return sum;

  }


}
