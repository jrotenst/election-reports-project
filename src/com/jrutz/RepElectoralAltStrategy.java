package com.jrutz;

/*  republican favoring strategy that considers the state where the
democrat has the smallest lead to be "too close to call"
and splits the electoral votes, giving half to the democrat
and half to the republican and, in the event of an odd number,
it gives the extra vote to the republican, of course.
*/

import java.util.ArrayList;

public class RepElectoralAltStrategy implements IElectionReportingStrategy {

    private ArrayList<State> results;
    private State smallestDemLead = null;
    private int smallestDemLeadMargin = 0;
    private int repElectorals;
    private int demElectorals;

    @Override
    public void setResults(ArrayList<State> results) {
        this.results = results;
    }

    public String report() {
        resetVariables();

        for (State s : results) {
            if (repLeads(s) < 0) {
                if (smallestDemLead == null) {
                    smallestDemLead = s;
                    smallestDemLeadMargin = s.getDemVotes() - s.getRepVotes();
                }
                else {
                    if (s.getDemVotes() - s.getRepVotes() < smallestDemLeadMargin) {
                        awardElectoralsToParty(smallestDemLead, 'D');        // award dems with electorals for state being replaced
                        smallestDemLead = s;
                        smallestDemLeadMargin = s.getDemVotes() - s.getRepVotes();
                    }
                    else {
                        awardElectoralsToParty(s, 'D');
                    }
                }
            }
            else if (repLeads(s) > 0){
                awardElectoralsToParty(s, 'R');      // if reps lead award them the electorals
            }
        }
        splitSmallestState();
        return "Republican: " + repElectorals + "\t\t" + "Democrat: "+ demElectorals;
    }

    private void splitSmallestState() {
        demElectorals += smallestDemLead.getElectoralVotes() / 2;
        repElectorals += (smallestDemLead.getElectoralVotes() / 2) + (smallestDemLead.getElectoralVotes() % 2);
    }

    private void awardElectoralsToParty(State s, char p) {
        if (p == 'R') {
            repElectorals += s.getElectoralVotes();
        }
        else if (p == 'D') {
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
        repElectorals = 0;
        demElectorals = 0;
        smallestDemLeadMargin = 0;
        smallestDemLead = null;
    }

}
