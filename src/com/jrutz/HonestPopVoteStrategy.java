package com.jrutz;

import java.util.ArrayList;

// completely honest strategy that reports the exact results

public class HonestPopVoteStrategy implements IElectionReportingStrategy {

    @Override
    public String getReport(ArrayList<State> electionResults) {
        return null;
    }
}
