package com.jrutz;

import java.util.Observable;

public class EqualityNewsNetwork extends ElectionReporter {


    public EqualityNewsNetwork(Observable observable) {
        super(observable);
        name = "Equality News Network";
        PVReportStrategy = new DemPopVoteStrategy();
        ECReportStrategy = new DemElectoralStrategy();
    }
}
