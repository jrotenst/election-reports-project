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
        resetVariables();
        int repMax = results.get(0).getRepVotes();
        for (State s : results) {
            sumRepVotes += s.getRepVotes();
            sumDemVotes += s.getDemVotes();
            if (s.getRepVotes() > repMax) {
                repMax = s.getRepVotes();
            }
        }
        sumRepVotes -= repMax;  // subtract the votes from the state with max
        return "Republican: " + sumRepVotes + "\t\t" + "Democrat: "+ sumDemVotes;
    }

    public void resetVariables() {
        sumRepVotes = 0;
        sumDemVotes = 0;
    }
}
