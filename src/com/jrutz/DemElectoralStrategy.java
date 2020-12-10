package com.jrutz;

// democrat favoring strategy that assumes that the state with the
// most electoral votes will go to the democrat regardless of polling data

import java.util.ArrayList;

public class DemElectoralStrategy implements IElectionReportingStrategy {

    @Override
    public String getReport(ArrayList<State> electionResults) {
        return null;
    }
}
