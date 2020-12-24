package com.jrutz;

import java.util.Observable;

public class MilktoastConservativeLive extends ElectionReporter {

    public MilktoastConservativeLive(Observable observable) {
        super(observable);
        name = "Milktoast Conservative Live";
        PVReportStrategy = new DemPopVoteStrategy();
        ECReportStrategy = new RepElectoralAltStrategy();
    }
}
