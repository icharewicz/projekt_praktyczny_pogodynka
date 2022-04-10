import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WeatherApp {

    // https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
    // my API: 02c4df71a1696055615492bab981102c

    static String keyAPIOpenWeather = "02c4df71a1696055615492bab981102c";

    static String getContent(String city) {
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + keyAPIOpenWeather);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            //dodanie linii
            String line;
            while ((line = bufferedReader.readLine()) != null){
                content.append(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Wrong data! " + e.getMessage());
            //e.printStackTrace();
        }
        return content.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter city: ");
        String city = scanner.nextLine();

        String jsonContent = getContent(city);
        System.out.println(jsonContent);

        //sprawdzenie czy nie puste
        if (!jsonContent.isEmpty()){

        //parse - wyodrebnianie danych - tylko temperatura
        JSONObject object = new JSONObject(jsonContent);
        //Math.floor - zaokrąglenie
        String s = String.format("Temperature in %s = %s", city, Math.floor(object.getJSONObject("main").getDouble("temp")-273));
        //System.out.println(object.getJSONObject("main").getDouble("temp")-273);
            System.out.println(s);
        }

        }

    }



