package com.company;

public class DemPopVoteStrategy implements IPopularVoteReportingStrategy {

    // a democrat favoring strategy that simply ignores the state with the most republican votes

    @Override
    public String getReport() {
        return null;
    }
}
