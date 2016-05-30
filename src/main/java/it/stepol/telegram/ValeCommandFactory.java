package it.stepol.telegram;

import io.github.nixtabyte.telegram.jtelebot.client.RequestHandler;
import io.github.nixtabyte.telegram.jtelebot.response.json.Message;
import io.github.nixtabyte.telegram.jtelebot.server.Command;
import io.github.nixtabyte.telegram.jtelebot.server.CommandFactory;
import org.apache.log4j.Logger;

/**
 * Created by Stefano Poli on 30/05/16.
 */
public class ValeCommandFactory implements CommandFactory {

    private static final Logger LOG = Logger.getLogger(ValeCommandFactory.class);

    @Override
    public Command createCommand(Message message, RequestHandler requestHandler) {
        LOG.info("Creating new ValeCommand object - message: " + message.getText());
        return new ValeCommand(message, requestHandler);
    }
}
