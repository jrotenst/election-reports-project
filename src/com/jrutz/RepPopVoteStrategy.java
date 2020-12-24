package com.jrutz;

import java.util.ArrayList;

//  republican favoring strategy that reports 5% fewer of the democrat votes

public class RepPopVoteStrategy implements IElectionReportingStrategy {

    private ArrayList<State> results;
    private int sumRepVotes;
    private int sumDemVotes;

    @Override
    public void setResults(ArrayList<State> results) {
        this.results = results;
    }

    public String report() {
        resetVariables();
        for (State s : results) {
            sumRepVotes += s.getRepVotes();
            sumDemVotes += s.getDemVotes() - (s.getDemVotes() * 0.5);
        }
        return "Republican: " + sumRepVotes + "\t\t" + "Democrat: "+ sumDemVotes;
    }

    public void resetVariables() {
        sumRepVotes = 0;
        sumDemVotes = 0;
    }
}
