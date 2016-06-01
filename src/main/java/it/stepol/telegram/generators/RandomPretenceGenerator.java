package it.stepol.telegram.generators;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Stefano Poli on 31/05/16.
 */
public class RandomPretenceGenerator extends AbstractUserReplyGenerator {

    private String prefix;

    private static final String[] REPLIES = {
            "sono in lutto per l’estinzione dei brontosauri",
            "ho girato i pollici troppo velocemente e devo aspettare che rallentino",
            "mia mamma si rifiuta ancora di allacciarmi le scarpe",
            "non piove e mi dispiace lasciare l’ombrello a casa da solo",
            "le previsioni dicono che dopodomani pioverà",
            "ho la faraona nel forno aspetto gli archeologi per cena",
            "sto ancora studiando per gli esami del sangue",
            "preferisco restare a casa per restare qui a farmi crescere i capelli",
            "mi si è addormentato un piede e mi spiace svegliarlo a quest ora"
    };

    public RandomPretenceGenerator() {
        this("");
    }

    public RandomPretenceGenerator(String prefix) {
        this.prefix = prefix;
    }

    @Override
    List<Object> getAvailableReplies() {
        return Arrays.asList(REPLIES);
    }

    @Override
    public String generate() {
        String text = String.valueOf(super.generate());
        return prefix + text;
    }
}
