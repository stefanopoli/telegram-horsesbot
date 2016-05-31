package it.stepol.telegram;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.logging.BotLogger;

/**
 * Created by Stefano Poli on 31/05/16.
 */
public class HorsesHandlers extends TelegramLongPollingBot {

    private static final String LOGTAG = "HORSESHANDLERS";
    private static final String TOKEN = "205503687:AAFaVbfjKDX0xeUuq4qKUNGDPFgBCC3BOHU";
    private static final String BOTUSERNAME = "HorsesBot";

    private static final Logger LOG = Logger.getLogger(HorsesHandlers.class);

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage()) {
                Message message = update.getMessage();
                if (message.hasText() || message.hasLocation()) {
                    handleIncomingMessage(message);
                }
            }
        } catch (Exception e) {
            BotLogger.error(LOGTAG, e);
        }
    }

    @Override
    public String getBotUsername() {
        return BOTUSERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    private void handleIncomingMessage(Message message) throws TelegramApiException {
        LOG.info("MESSAGE: " + message.getChatId() + " - " + message.getCaption() + " - " + message.getText());

        String response = "TEST";
        String lowerCaseMsg = message.getText().toLowerCase();
        if(lowerCaseMsg.contains("vale") || lowerCaseMsg.contains("valentina") || lowerCaseMsg.contains("bina") || lowerCaseMsg.contains("barbuscia")) {
            response = "Vuoi davvero chattare con un cavallo???";
        }

        SendMessage sendMessage = getSimpleMessage(message);
        sendMessage.setText(response);
        sendMessage(sendMessage);
    }

    private SendMessage getSimpleMessage(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setReplayToMessageId(message.getMessageId());
        return sendMessage;
    }
}
