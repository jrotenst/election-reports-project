package com.jrutz;

public class DemPopVoteStrategy implements IElectionReportingStrategy {

    // a democrat favoring strategy that simply ignores the state with the most republican votes

    @Override
    public String getReport() {
        return null;
    }
}
