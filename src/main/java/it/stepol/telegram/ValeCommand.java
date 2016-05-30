package it.stepol.telegram;

import io.github.nixtabyte.telegram.jtelebot.client.RequestHandler;
import io.github.nixtabyte.telegram.jtelebot.exception.JsonParsingException;
import io.github.nixtabyte.telegram.jtelebot.request.TelegramRequest;
import io.github.nixtabyte.telegram.jtelebot.request.factory.TelegramRequestFactory;
import io.github.nixtabyte.telegram.jtelebot.response.json.Message;
import io.github.nixtabyte.telegram.jtelebot.server.impl.AbstractCommand;

/**
 * Created by Stefano Poli on 30/05/16.
 */
public class ValeCommand extends AbstractCommand {

    public ValeCommand(Message message, RequestHandler requestHandler) {
        super(message, requestHandler);
    }

    @Override
    public void execute() {
        try {
            TelegramRequest telegramRequest = TelegramRequestFactory.createSendMessageRequest(message.getChat().getId(), "La vale è un cavallo!", true, message.getId(), null);
        } catch (JsonParsingException e) {
            e.printStackTrace();
        }
    }
}
