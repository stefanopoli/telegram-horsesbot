package it.stepol.telegram;

import it.stepol.telegram.generators.ReplyGeneratorInterface;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

/**
 * Created by Stefano Poli on 31/05/16.
 */
public class HorsesMessageReply {

    private Message message;
    private ReplyGeneratorInterface replyGenerator;

    public HorsesMessageReply(Message message, ReplyGeneratorInterface replyGenerator) {
        this.message = message;
        this.replyGenerator = replyGenerator;
    }

    public static Builder builder(Message message, ReplyGeneratorInterface replyGenerator) {
        return new Builder(message, replyGenerator);
    }

    public static class Builder {
        private Message message;
        private ReplyGeneratorInterface replyGenerator;
        public Builder(Message message, ReplyGeneratorInterface replyGenerator) {
            this.message = message;
            this.replyGenerator = replyGenerator;
        }
        public HorsesMessageReply build() {
            return new HorsesMessageReply(message, replyGenerator);
        }
    }

    public Object getReply() {
        Object replyObj = replyGenerator.generate();

        if(replyObj != null) {
            if(replyObj instanceof String) {
                SendMessage reply = new SendMessage();
                reply.setChatId(String.valueOf(message.getChatId()));
                reply.setText(String.valueOf(replyObj));
                return reply;
            }
            if(replyObj instanceof String) {
                SendMessage reply = new SendMessage();
                reply.setChatId(String.valueOf(message.getChatId()));
                reply.setText(String.valueOf(replyObj));
                return reply;
            }

        }
        return null;
    }
}
