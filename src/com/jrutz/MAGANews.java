package com.jrutz;

import java.util.Observable;

public class MAGANews extends ElectionReporter {

    public MAGANews(Observable observable) {
        super(observable);
        PVReportStrategy = new RepPopVoteStrategy();
    }
}
