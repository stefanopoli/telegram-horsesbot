package it.stepol.telegram.generators;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Stefano Poli on 31/05/16.
 */
public class SaraReplyGenerator extends AbstractUserReplyGenerator {

    private static final String[] REPLIES = {
            "Sara occhio... hai un calabrese alle spalle!!!!!!!!",
            "Lamagni o labevi...ahahahah!!!",
            "Sara sei un po' bepposa eh..."
    };

    @Override
    List<Object> getAvailableReplies() {
        return Arrays.asList(REPLIES);
    }
}
