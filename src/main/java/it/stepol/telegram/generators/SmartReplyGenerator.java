package it.stepol.telegram.generators;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.objects.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * Created by Stefano Poli on 31/05/16.
 */
public class SmartReplyGenerator implements ReplyGeneratorInterface {
    private static final Logger LOG = Logger.getLogger(SmartReplyGenerator.class);

    private User sender;
    private double probability;
    private int max;

    public SmartReplyGenerator(User sender, double probability) {
        this.sender = sender;
        this.probability = probability;
        BigDecimal bdi = new BigDecimal((double)100/probability);
        this.max = bdi.setScale(0, RoundingMode.HALF_UP).intValue();
        LOG.info("Setted sender " + sender);
    }

    private ReplyGeneratorInterface getReplyGenerator() {
        if(new Random().nextInt(max) == 0) {
            if(checkUser("valentina", "barbuscia", "vale")) {
                return new ValeReplyGenerator();
            } else if(checkUser("mattia", "zapparoli", "zappa")) {
                return new ZappaReplyGenerator();
            } else if(checkUser("sara", "lamagni", "sara")) {
                return new SaraReplyGenerator();
            } else if(checkUser("giulia", "olivato", "giulia")) {
                return new GiuliaReplyGenerator();
            } /*else if(checkUser("stefano", "poli", "ste")) {
                return new SaraReplyGenerator();
            }*/
        }

        return null;
    }

    private boolean checkUser(String firstName, String lastName, String username) {
        if(sender.getFirstName() != null && sender.getFirstName().toLowerCase().contains(firstName))
            return true;
        if(sender.getLastName() != null && sender.getLastName().toLowerCase().contains(lastName))
            return true;
        if(sender.getUserName() != null && sender.getUserName().toLowerCase().contains(username))
            return true;
        return false;
    }

    @Override
    public Object generate() {
        ReplyGeneratorInterface replyGenerator = getReplyGenerator();
        if(replyGenerator != null) {
            return replyGenerator.generate();
        }
        return null;
    }
}
