package com.github.nataliaotrombke.demoupdater.Controller;

import com.github.nataliaotrombke.demodata.databaseModel.HistoricalMonuments;
import com.github.nataliaotrombke.demodata.databaseModel.Towns;
import com.github.nataliaotrombke.demodata.repositories.HistoricalMonumentsRepository;
import com.github.nataliaotrombke.demodata.repositories.TownsRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class HistoricalMonumentsUpdater {

    TownsRepository townsRepository;
    HistoricalMonumentsRepository historicalMonumentsRepository;

    public HistoricalMonumentsUpdater(TownsRepository townsRepository, HistoricalMonumentsRepository historyRepository) {
        this.townsRepository = townsRepository;
        this.historicalMonumentsRepository = historyRepository;
    }

    public void updateByCity(String city) throws IOException, URISyntaxException, CsvValidationException {
        String fileUrl = "https://api.dane.gov.pl/resources/61342,pomniki-historii-plik-csv/file";

        URL url = new URI(fileUrl).toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            CSVReader csvReader = new CSVReader(reader);

            csvReader.readNext();

            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                var lp = nextLine[0];
                var historicalMonumentsName = nextLine[1];
                var dokladnosci = nextLine[2];
                var typeOfHistoricalMonument = nextLine[3];
                var dateOfEntry = nextLine[4];



                if (!townName.equalsIgnoreCase(city)) continue;

                Towns townToUse;
                var foundTown = townsRepository.findFirstByTownsName(townName);
                if (foundTown.isEmpty()){
                    var newTown = new Towns();
                    towntoSave.setTownsName(townName);
                    townToUse = foundTown.get();
                } else {
                    townToUse = foundTown.get();
                }

                HistoricalMonuments historicalMonumentsToSave.findFirstByHistoricalMonumentsName(historicalMonumentsName);
                if (foundHistoricalMonuments.isPresent()) {
                    historicalMonumentsToSave = foundHistoricalMonuments.get();
                } else {
                    historicalMonumentsToSave = new HistoricalMonuments();
                }
            }
        }
    }

}



