package com.jrutz;

import java.util.Observable;

public class MAGANews extends ElectionReporter {

    public MAGANews(Observable observable) {
        super(observable);
        name = "MAGA News Network";
        PVReportStrategy = new RepPopVoteStrategy();
        ECReportStrategy = new RepElectoralStrategy();
    }
}
