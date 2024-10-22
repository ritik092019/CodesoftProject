package codesoft;


    import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.JSONObject;

    public class currencyConverter {


        private static final String API_KEY = "YOUR_API_KEY";
        private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            System.out.print("Enter base currency (e.g., USD): ");
            String baseCurrency = scanner.nextLine().toUpperCase();
            System.out.print("Enter target currency (e.g., EUR): ");
            String targetCurrency = scanner.nextLine().toUpperCase();


            System.out.print("Enter amount to convert: ");
            double amount = scanner.nextDouble();


            double exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);


            if (exchangeRate != -1) {
                double convertedAmount = amount * exchangeRate;


                System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
            } else {
                System.out.println("Error fetching exchange rate. Please try again.");
            }

            scanner.close();
        }


        public static double fetchExchangeRate(String baseCurrency, String targetCurrency) {
            try {

                String apiUrl = API_URL + baseCurrency + "/" + targetCurrency;


                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(apiUrl))
                        .build();


                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


                JSONObject jsonResponse = new JSONObject(response.body());


                if (jsonResponse.getString("result").equals("success")) {

                    return jsonResponse.getDouble("conversion_rate");
                } else {
                    System.out.println("Error: " + jsonResponse.getString("error-type"));
                }
            } catch (Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
            }

            return -1;
        }
    }


