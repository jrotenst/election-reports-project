package com.jrutz;

import java.util.Observable;

public class AlmostTrueNews extends ElectionReporter {

    public AlmostTrueNews(Observable observable) {
        super(observable);
        PVReportStrategy = new DemPopVoteStrategy();
        ECReportStrategy = new HonestElectoralStrategy();
    }
}
