package com.jrutz;

// democrat favoring strategy that takes 2% of all republican votes in every
// state and makes them democrat votes instead (note that this only affects
// the electoral votes if there is a state within this margin)

import java.util.ArrayList;

public class DemElectoralAltStrategy implements IElectionReportingStrategy {

    @Override
    public String getReport(ArrayList<State> electionResults) {
        return null;
    }
}
