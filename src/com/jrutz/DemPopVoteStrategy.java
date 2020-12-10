package com.jrutz;

import java.util.ArrayList;

// a democrat favoring strategy that simply ignores the state with the most republican votes

public class DemPopVoteStrategy implements IElectionReportingStrategy {
    @Override
    public String getReport(ArrayList<State> electionResults) {
        return null;
    }
}
