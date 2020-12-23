package com.jrutz;

import java.util.ArrayList;

// a democrat favoring strategy that simply ignores the state with the most republican votes

public class DemPopVoteStrategy implements IElectionReportingStrategy {

    private ArrayList<State> results;
    private int sumRepVotes;
    private int sumDemVotes;

    @Override
    public void setResults(ArrayList<State> results) {
        this.results = results;
    }

    @Override
    public String report() {
        int repMax = results.get(0).getRepVotes();
        for (State s : results) {
            sumRepVotes += s.getRepVotes();
            sumDemVotes += s.getDemVotes();
            if (s.getRepVotes() > repMax) {
                repMax = s.getRepVotes();
            }
        }
        sumRepVotes -= repMax;  // subtract the votes from the state with max
        return " ".repeat(15) + sumRepVotes + "\t" + sumDemVotes + "\n";
    }
}
