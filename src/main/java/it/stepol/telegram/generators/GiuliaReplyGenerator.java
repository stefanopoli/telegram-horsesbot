package it.stepol.telegram.generators;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Stefano Poli on 31/05/16.
 */
public class GiuliaReplyGenerator extends AbstractUserReplyGenerator {

    private static final String[] REPLIES = {
            "Giulia una domanda: ma i cinesi sono gialli perchè pisciano controvento?",
            "Cin ciu lì cin ciu là"
    };

    @Override
    List<Object> getAvailableReplies() {
        return Arrays.asList(REPLIES);
    }
}
