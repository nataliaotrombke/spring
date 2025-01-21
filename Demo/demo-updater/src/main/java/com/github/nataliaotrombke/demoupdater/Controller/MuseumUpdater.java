package com.github.nataliaotrombke.demoupdater.Controller;

import com.github.nataliaotrombke.demodata.databaseModel.Museums;
import com.github.nataliaotrombke.demodata.databaseModel.Towns;
import com.github.nataliaotrombke.demodata.repositories.MuseumRepository;
import com.github.nataliaotrombke.demodata.repositories.TownsRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class MuseumUpdater {
    TownsRepository townsRepository;
    MuseumRepository museumRepository;

    public MuseumUpdater(TownsRepository townsRepository, MuseumRepository museumRepository) {
        this.townsRepository = townsRepository;
        this.museumRepository = museumRepository;
    }

    public void updateByCity(String city) throws IOException, URISyntaxException, CsvValidationException {
        String fileUrl = "https://api.dane.gov.pl/resources/63269,wykaz-muzeow/csv/";

        URL url = new URI(fileUrl).toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            CSVReader csvReader = new CSVReader(reader);

            csvReader.readNext();

            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                var lp = nextLine[0];
                var museumName = nextLine[1];
                var zipCode = nextLine[2];
                var townName = nextLine[3];
                var gmina = nextLine[4];
                var powiat  = nextLine[5];
                var voivodeship = nextLine[6];
                var ulicaAlejaAplac = nextLine[7];
                var street = nextLine[8];
                var nrDomu = nextLine[9];
                var nrLokalu = nextLine[10];

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

                Museums museumToSave;
                var foundMuseum = museumRepository.findFirstByMuseumsName(museumName);
                if (foundMuseum.isPresent()) {
                    museumToSave = foundMuseum.get();
                } else {
                    museumToSave = new Museums();
                }

                museumToSave.setMuseumsName(museumName);
                museumToSave.setStreetName(street);
                museumToSave.setTown(townToUse);
                var createdMuseum = museumRepository.save(museumToSave);

                System.out.println("Museum: " + museumName + " zapisane pod kluczem: " + createdMuseum.getMuseumsId() + " miasto pod kluczem: " + townToUse.getTownsId());
            }
        } finally {
            connection.disconnect();
        }
    }
}
