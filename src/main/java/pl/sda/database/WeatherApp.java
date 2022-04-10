package pl.sda.database;

import org.json.JSONObject;
import pl.sda.database.weather_entity_classes.Measures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.Date;
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
        System.out.println("Enter the data in format yyyy-MM-dd: ");
        String date = scanner.nextLine();

        //weryfikacja daty
        if (date.isEmpty()){
            LocalDate localDate = LocalDate.now();
            LocalDate localDateDefault = localDate.plusDays(1);
            date = localDateDefault.toString();
        }

        //System.out.println(date);

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

        Measures measures = new Measures();
        MeasuresDAO measuresDAO = new MeasuresDAO();

        JSONObject jsonObject = new JSONObject(jsonContent);
        measures.setTemperature((int)jsonObject.getJSONObject("main").getDouble("temp")-273);
        measures.setHumidity(jsonObject.getJSONObject("main").getDouble("humidity"));

        measuresDAO.add(measures);

        }

    }



