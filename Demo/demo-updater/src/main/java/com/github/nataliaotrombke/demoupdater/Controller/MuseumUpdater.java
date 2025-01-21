package com.github.nataliaotrombke.demoupdater.Controller;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.*;
import java.util.Arrays;

@Service
public class MuseumUpdater {
    public void updateByCity(String city) throws IOException, URISyntaxException, CsvValidationException {
        String fileUrl = "https://api.dane.gov.pl/resources/63269,wykaz-muzeow/csv/"; // Replace with dynamic URL based on city

        URL url = new URI(fileUrl).toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            CSVReader csvReader = new CSVReader(reader);

            csvReader.readNext(); // ignoruj nagłówki

            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                var lp = nextLine[0];
                var museumName = nextLine[1];
                var zipCode = nextLine[2];
                var town = nextLine[3];
                var gmina = nextLine[4];
                var powiat  = nextLine[5];
                var voivodeship = nextLine[6];
                var ulicaAlejaAplac = nextLine[7];
                var street = nextLine[8];
                var nrDomu = nextLine[9];
                var nrLokalu = nextLine[10];

                if (!town.equalsIgnoreCase(city)) continue;


                System.out.println("Museum: " + museumName);
//                break;
            }
        } finally {
            connection.disconnect();
        }
    }
}
