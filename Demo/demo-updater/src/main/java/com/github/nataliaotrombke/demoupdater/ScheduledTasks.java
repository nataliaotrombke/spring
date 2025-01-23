package com.github.nataliaotrombke.demoupdater;

import com.github.nataliaotrombke.demoupdater.Updater.MuseumUpdater;
import com.opencsv.exceptions.CsvValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private final MuseumUpdater museumUpdater;

    public ScheduledTasks(MuseumUpdater museumUpdater) {
        this.museumUpdater = museumUpdater;
    }

    @Scheduled(fixedRate = 5_000, initialDelay = 5_000)
    public void reportCurrentTime() throws CsvValidationException, IOException, URISyntaxException {
        log.info("Updating museums for reda now {}", dateFormat.format(new Date()));
        museumUpdater.updateByCity("reda");
    }
}
