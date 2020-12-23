package com.jrutz;

import java.util.ArrayList;

//   republican favoring strategy that assumes one of the
//  states (TX) will go republican regardless of the polling data

public class RepElectoralStrategy implements IElectionReportingStrategy {

    private final String RED_STATE = "TX";
    private ArrayList<State> results;
    private int repElectorals;
    private int demElectorals;

    @Override
    public void setResults(ArrayList<State> results) {
        this.results = results;
    }

    public String report() {
        for (State s : results) {
            if (s.getAbrv() == "TX") {
                repElectorals += s.getElectoralVotes();
            }
            else {
                if (repLeads(s) > 0) {
                    repElectorals += s.getElectoralVotes();
                }
                else if (repLeads(s) < 0) {
                    demElectorals += s.getElectoralVotes();
                }
                else {
                    continue;
                }
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
