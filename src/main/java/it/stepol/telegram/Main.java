package it.stepol.telegram;

import io.github.nixtabyte.telegram.jtelebot.server.impl.DefaultCommandDispatcher;
import io.github.nixtabyte.telegram.jtelebot.server.impl.DefaultCommandQueue;
import io.github.nixtabyte.telegram.jtelebot.server.impl.DefaultCommandWatcher;

/**
 * Created by Stefano Poli on 30/05/16.
 */
public class Main {

    public static final String TOKEN = "205503687:AAFaVbfjKDX0xeUuq4qKUNGDPFgBCC3BOHU";

    public static void main(String args[]) {
        DefaultCommandDispatcher commandDispatcher = new DefaultCommandDispatcher(10, 100, new DefaultCommandQueue());
        commandDispatcher.startUp();

        DefaultCommandWatcher commandWatcher = new DefaultCommandWatcher(2000, 100, TOKEN, commandDispatcher, new ValeCommandFactory());
        commandWatcher.startUp();
    }
}
