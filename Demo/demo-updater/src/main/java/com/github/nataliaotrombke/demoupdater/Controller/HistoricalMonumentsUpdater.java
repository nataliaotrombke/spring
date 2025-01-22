package com.github.nataliaotrombke.demoupdater.Controller;

import com.github.nataliaotrombke.demodata.databaseModel.HistoricalMonuments;
import com.github.nataliaotrombke.demodata.databaseModel.Towns;
import com.github.nataliaotrombke.demodata.repositories.HistoricalMonumentsRepository;
import com.github.nataliaotrombke.demodata.repositories.TownsRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Service
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
                var wojewodzrwo = nextLine[5];
                var powiat = nextLine[6];
                var gmina = nextLine[7];
                var townName = nextLine[8];
                var streetName = nextLine[9];
                var buildingNumber = nextLine[10];


                if (!townName.equalsIgnoreCase(city)) continue;

                Towns townToUse;
                var foundTown = townsRepository.findFirstByTownsName(townName);
                if (foundTown.isEmpty()) {
                    var townToSave = new Towns();
                    townToSave.setTownsName(townName);
                    townToUse = townsRepository.save(townToSave);
                } else {
                    townToUse = foundTown.get();
                }

                HistoricalMonuments historicalMonumentsToSave;
                var foundHistoricalMonuments = historicalMonumentsRepository.findHistoricalMonumentsByMonumentsName(historicalMonumentsName);
                if (foundHistoricalMonuments.isPresent()) {
                    historicalMonumentsToSave = foundHistoricalMonuments.get();
                } else {
                    historicalMonumentsToSave = new HistoricalMonuments();
                }

                historicalMonumentsToSave.setMonumentsName(historicalMonumentsName);
                historicalMonumentsToSave.setStreetName(streetName);
                historicalMonumentsToSave.setTown(townToUse);
                var createdHistoricalMonuments = historicalMonumentsRepository.save(historicalMonumentsToSave);

                System.out.println("Historical Monuments: " + historicalMonumentsName + " zapisane pod kluczem: " + createdHistoricalMonuments.getMonumentsId());
            break;
            }
        } finally {

            connection.disconnect();
        }
    }

}



