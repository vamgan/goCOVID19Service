package com.tracker.gocovid19service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetFromAPI {

    public static String bufferToString(BufferedReader br) throws IOException {
        String line = null;
        String message = new String();
        while ((line = br.readLine()) != null) {
            message += line;
        }
        return message;
    }
    public static String getRequestForState(String state) throws IOException {
        URL url = new URL("https://disease.sh/v3/covid-19/states/" + state);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (connection.getInputStream())));
        return GetFromAPI.bufferToString(br);
    }
    public static String getRequestForCountry(String country) throws IOException {
        URL url = new URL("https://disease.sh/v3/covid-19/countries/" + country);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (connection.getInputStream())));

        return GetFromAPI.bufferToString(br);

    }
    public static String getRequestForWorld() throws IOException {
        URL url = new URL("https://disease.sh/v3/covid-19/all");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (connection.getInputStream())));
        return GetFromAPI.bufferToString(br);
    }
}

