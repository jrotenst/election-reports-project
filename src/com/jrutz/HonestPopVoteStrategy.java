package com.jrutz;

public class HonestPopVoteStrategy implements IElectionReportingStrategy {

    // completely honest strategy that reports the exact results

    @Override
    public String getReport() {
        return null;
    }
}
