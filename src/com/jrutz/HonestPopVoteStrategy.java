package com.jrutz;

import java.util.ArrayList;

// completely honest strategy that reports the exact results

public class HonestPopVoteStrategy implements IElectionReportingStrategy {

    private ArrayList<State> results;
    private int sumRepVotes;
    private int sumDemVotes;

    @Override
    public void setResults(ArrayList<State> results) {
        this.results = results;
    }

    public String report() {
        for (State s : results) {
            sumRepVotes += s.getRepVotes();
            sumDemVotes += s.getDemVotes();
        }
        return " ".repeat(15) + sumRepVotes + "\t" + sumDemVotes + "\n";
    }
}
