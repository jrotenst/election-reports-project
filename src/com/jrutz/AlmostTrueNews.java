package com.jrutz;

import java.util.Observable;

public class AlmostTrueNews extends ElectionReporter {

    public AlmostTrueNews(Observable observable) {
        super(observable);
        name = "Almost True News";
        PVReportStrategy = new DemPopVoteStrategy();
        ECReportStrategy = new HonestElectoralStrategy();
    }
}
