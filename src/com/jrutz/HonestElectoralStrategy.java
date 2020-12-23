package com.jrutz;

import java.util.ArrayList;

public class HonestElectoralStrategy implements IElectionReportingStrategy {

    private ArrayList<State> results;
    private int repElectorals;
    private int demElectorals;

    @Override
    public void setResults(ArrayList<State> results) {
        this.results = results;
    }

    public String report() {
        for (State s : results) {
            if (repLeads(s) > 0) {
                repElectorals += s.getElectoralVotes();
            }
            else if (repLeads(s) < 0 ) {
                demElectorals += s.getElectoralVotes();
            }
            else {
                continue;
            }
        }
        return " ".repeat(15) + repElectorals + "\t" + demElectorals + "\n";
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
}
