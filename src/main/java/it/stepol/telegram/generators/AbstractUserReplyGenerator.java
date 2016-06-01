package it.stepol.telegram.generators;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Created by Stefano Poli on 01/06/16.
 */
public abstract class AbstractUserReplyGenerator implements ReplyGeneratorInterface {

    abstract List<Object> getAvailableReplies();

    @Override
    public Object generate() {
        List<Object> replies = getAvailableReplies();
        BigDecimal bdi = new BigDecimal(Math.random() * (replies.size()-1));
        int index = bdi.setScale(0, RoundingMode.HALF_UP).intValue();
        return replies.get(index);
    }
}
