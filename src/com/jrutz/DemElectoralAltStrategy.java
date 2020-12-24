package com.jrutz;

// democrat favoring strategy that takes 2% of all republican votes in every
// state and makes them democrat votes instead (note that this only affects
// the electoral votes if there is a state within this margin)

import java.util.ArrayList;

public class DemElectoralAltStrategy implements IElectionReportingStrategy {

    private ArrayList<State> results;
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
            awardElectorals(s);
        }
        return "Republican: " + repElectorals + "\t\t" + "Democrat: "+ demElectorals;
    }

    private void awardElectorals(State s) {
        if (isRepLeadLessThan2Percent(s)) {
            demElectorals += s.getElectoralVotes();
        }
        else {
            repElectorals += s.getElectoralVotes();
        }
    }

    private boolean isRepLeadLessThan2Percent(State s) {
        double twoPercent = (s.getDemVotes() + s.getRepVotes()) * 0.2;
        return s.getRepVotes() - s.getDemVotes() < twoPercent;
    }

    public void resetVariables() {
        repElectorals = 0;
        demElectorals = 0;
    }
}
