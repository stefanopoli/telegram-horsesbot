package it.stepol.telegram;

import it.stepol.telegram.generators.RandomPretenceGenerator;
import it.stepol.telegram.generators.SmartReplyGenerator;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendAudio;
import org.telegram.telegrambots.api.methods.send.SendDocument;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
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
                if (message.hasText()) {
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

        HorsesMessageReply horsesMessageReply;
        Object reply = null;
        String lowerCaseMsg = message.getText().toLowerCase();
        if (lowerCaseMsg.contains("esci") || lowerCaseMsg.contains("usciamo") || lowerCaseMsg.contains("uscite") || lowerCaseMsg.contains("organizziamo")) {
            horsesMessageReply = HorsesMessageReply.builder(message, new RandomPretenceGenerator("Non posso, ")).build();
            reply = horsesMessageReply.getReply();
        }
        if(reply == null) {
            horsesMessageReply = HorsesMessageReply.builder(message, new SmartReplyGenerator(message.getFrom(), 50)).build();
            reply = horsesMessageReply.getReply();
        }

        if(reply != null) {
            sendReply(reply);
        }
    }

    private Message sendReply(Object reply) throws TelegramApiException {
        Message sent = null;
        if(reply instanceof SendMessage) {
            sent = sendMessage((SendMessage) reply);
        } else if(reply instanceof SendPhoto) {
            sent = sendPhoto((SendPhoto) reply);
        } else if(reply instanceof SendDocument) {
            sent = sendDocument((SendDocument) reply);
        } else if(reply instanceof SendAudio) {
            sent = sendAudio((SendAudio) reply);
        }
        return sent;
    }
}
