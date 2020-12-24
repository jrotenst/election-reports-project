package com.jrutz;

import java.util.Observable;

public class HonestAbeNewsNetwork extends ElectionReporter {

    public HonestAbeNewsNetwork(Observable observable) {
        super(observable);
        PVReportStrategy = new HonestPopVoteStrategy();
        ECReportStrategy = new HonestElectoralStrategy();
    }
}
