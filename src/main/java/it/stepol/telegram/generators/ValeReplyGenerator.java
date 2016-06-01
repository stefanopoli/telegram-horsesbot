package it.stepol.telegram.generators;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stefano Poli on 31/05/16.
 */
public class ValeReplyGenerator extends AbstractUserReplyGenerator {

    private static final String[] REPLIES = {
            "Ha parlato un cavallo per caso????",
            "Cazzomene, fottesega, fregacazzi!!",
            "Ma basta nitrire!!!!"
    };

    @Override
    List<Object> getAvailableReplies() {
        return Arrays.asList(REPLIES);
    }
}
