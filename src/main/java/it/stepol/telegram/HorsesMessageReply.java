package it.stepol.telegram;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

/**
 * Created by Stefano Poli on 31/05/16.
 */
public class HorsesMessageReply {

    private Message message;

    public HorsesMessageReply(Message message) {
        this.message = message;
    }

    public static class Builder {
        private Message message;
        public Builder(Message message) {
            this.message = message;
        }
        public HorsesMessageReply build() {
            return new HorsesMessageReply(message);
        }
    }

    public SendMessage random() {
        SendMessage reply = new SendMessage();
        reply.setChatId(String.valueOf(message.getChatId()));
        return reply;
    }
}
