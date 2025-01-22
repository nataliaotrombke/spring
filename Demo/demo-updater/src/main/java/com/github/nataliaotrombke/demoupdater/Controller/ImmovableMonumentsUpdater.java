package com.github.nataliaotrombke.demoupdater.Controller;


import com.github.nataliaotrombke.demodata.databaseModel.ImmovableMonuments;
import com.github.nataliaotrombke.demodata.databaseModel.Towns;
import com.github.nataliaotrombke.demodata.databaseModel.Voivodeships;
import com.github.nataliaotrombke.demodata.repositories.ImmovableMonumentsRepository;
import com.github.nataliaotrombke.demodata.repositories.TownsRepository;
import com.github.nataliaotrombke.demodata.repositories.VoivodeshipsRepository;
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
public class ImmovableMonumentsUpdater {
    TownsRepository townsRepository;
    ImmovableMonumentsRepository immovableMonumentsRepository;
    VoivodeshipsRepository voivodeshipsRepository;

    public ImmovableMonumentsUpdater(TownsRepository townsRepository, ImmovableMonumentsRepository immovableMonumentsRepository, VoivodeshipsRepository voivodeshipsRepository) {
        this.townsRepository = townsRepository;
        this.immovableMonumentsRepository = immovableMonumentsRepository;
        this.voivodeshipsRepository = voivodeshipsRepository;
    }

    public void updateByCity(String city) throws IOException, URISyntaxException, CsvValidationException {
        String fileUrl = "https://api.dane.gov.pl/resources/61341,rejestr-zabytkow-nieruchomych-plik-csv/file";

        URL url = new URI(fileUrl).toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            CSVReader csvReader = new CSVReader(reader);

            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                var lp = nextLine[0];
                var formaochrony = nextLine[1];
                var dokladnosci = nextLine[2];
                var monumentsName = nextLine[3];
                var chronologia = nextLine[4];
                var funkcja = nextLine[5];
                var materalbudowy = nextLine[6];
                var architecturalStyle = nextLine[7];
                var wykazdokumentow = nextLine[8];
                var datawpisu = nextLine[9];
                var voivodeshipsName = nextLine[10];
                var powiat = nextLine[11];
                var gmina = nextLine[12];
                var townName = nextLine[13];
                var streetName = nextLine[14];
                var buildingNumber = nextLine[15];

                if (!townName.equalsIgnoreCase(city)) continue;

                Voivodeships voivodeshipsToUse;
                var foundVoivodeship = voivodeshipsRepository.findFirstByVoivodeshipsName(voivodeshipsName);
                if (foundVoivodeship.isEmpty()){
                    var voivodeshipToSave = new Voivodeships();
                    voivodeshipToSave.setVoivodeshipsName(voivodeshipsName);
                    voivodeshipsToUse = voivodeshipsRepository.save(voivodeshipToSave);
                } else {
                    voivodeshipsToUse = foundVoivodeship.get();
                }

                Towns townToUse;
                var foundTown = townsRepository.findFirstByTownsName(townName);
                if (foundTown.isEmpty()) {
                    var townToSave = new Towns();
                    townToSave.setTownsName(townName);
                    townToSave.setVoivodeships(voivodeshipsToUse);
                    townToUse = townsRepository.save(townToSave);
                } else {
                    townToUse = foundTown.get();
                }

                ImmovableMonuments immovableMonumentsToSave;
                var foundImmovableMonuments = immovableMonumentsRepository.findFirstByMonumentsName(monumentsName);
                if (foundImmovableMonuments.isPresent()){
                    immovableMonumentsToSave = foundImmovableMonuments.get();
                } else {
                    immovableMonumentsToSave = new ImmovableMonuments();
                }

                immovableMonumentsToSave.setMonumentsName(monumentsName);
                immovableMonumentsToSave.setStreetName(streetName);
                var createdMonuments = immovableMonumentsRepository.save(immovableMonumentsToSave);

                System.out.println("Zabytki nieruchome: " + monumentsName + " zapisane pod kluczem: " + createdMonuments.getMonumentsId() + "pod kluczem: " + townToUse.getTownsId());
            }
        } finally {
            connection.disconnect();
        }
    }
}
