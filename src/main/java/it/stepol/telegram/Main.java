package it.stepol.telegram;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.logging.BotLogger;
import org.telegram.telegrambots.logging.BotsFileHandler;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

/**
 * Created by Stefano Poli on 30/05/16.
 */
public class Main {

    private static final String LOGTAG = "HORSESBOT";

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static final String TOKEN = "205503687:AAFaVbfjKDX0xeUuq4qKUNGDPFgBCC3BOHU";

    public static void main(String args[]) {
        LOG.info("Creating HorsesSuperBot app");

        BotLogger.setLevel(Level.ALL);
        BotLogger.registerLogger(new ConsoleHandler());
        try {
            BotLogger.registerLogger(new BotsFileHandler());
        } catch (IOException e) {
            BotLogger.severe("MAIN", e);
        }

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new HorsesHandlers());
        } catch (TelegramApiException e) {
            BotLogger.error(LOGTAG, e);
        }
    }
}
