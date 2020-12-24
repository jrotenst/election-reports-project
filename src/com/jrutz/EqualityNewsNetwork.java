package com.jrutz;

import java.util.Observable;

public class EqualityNewsNetwork extends ElectionReporter {


    public EqualityNewsNetwork(Observable observable) {
        super(observable);
        PVReportStrategy = new DemPopVoteStrategy();
        ECReportStrategy = new DemElectoralStrategy();
    }
}
