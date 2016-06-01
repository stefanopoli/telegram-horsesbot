package it.stepol.telegram.generators;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Stefano Poli on 31/05/16.
 */
public class ZappaReplyGenerator extends AbstractUserReplyGenerator {

    private static final String[] REPLIES = {
            "Spring breaaaaakkkkkkk!!!!!",
            "TETTEEEEEEEEEEEEEEEEEEEEE!!!!",
            "Zappa andiamo alla break's!!!!!"
    };

    @Override
    List<Object> getAvailableReplies() {
        return Arrays.asList(REPLIES);
    }
}
