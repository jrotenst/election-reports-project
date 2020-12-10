package com.company;

public class HonestPopVoteStrategy implements IPopularVoteReportingStrategy {

    // completely honest strategy that reports the exact results

    @Override
    public String getReport() {
        return null;
    }
}
