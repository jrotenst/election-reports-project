package com.jrutz;

// democrat favoring strategy that assumes that the state with the
// most electoral votes will go to the democrat regardless of polling data

import java.util.ArrayList;

public class DemElectoralStrategy implements IElectionReportingStrategy {

    private ArrayList<State> results;
    private State mostElectorals;
    private int repElectorals;
    private int demElectorals;

    @Override
    public void setResults(ArrayList<State> results) {
        this.results = results;
    }

    @Override
    public String report() {
        resetVariables();
        for (State s : results) {
            if (mostElectorals == null ) {
                mostElectorals = s;
            }
            else {
                if (s.getElectoralVotes() > mostElectorals.getElectoralVotes()) {
                    awardElectoralsFairly(mostElectorals);
                    mostElectorals = s;
                }
                else {
                    awardElectoralsFairly(s);
                }
            }
        }

        // award democrats state with most electorals
        demElectorals += mostElectorals.getElectoralVotes();
        return "Republican: " + repElectorals + "\t\t" + "Democrat: "+ demElectorals;
    }

    private void awardElectoralsFairly(State s) {
        if (repLeads(s) > 0) {
            repElectorals += s.getElectoralVotes();
        }
        else if (repLeads(s) < 0) {
            demElectorals += s.getElectoralVotes();
        }
    }

    private int repLeads(State s) {
        if (s.getRepVotes() > s.getDemVotes()) {
            return 1;
        }
        if (s.getRepVotes() < s.getDemVotes()) {
            return -1;
        }
        return 0;
    }

    public void resetVariables() {
        mostElectorals = null;
        repElectorals = 0;
        demElectorals = 0;
    }

}
