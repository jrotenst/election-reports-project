package com.jrutz;

/*  republican favoring strategy that considers the state where the
democrat has the smallest lead to be "too close to call"
and splits the electoral votes, giving half to the democrat
and half to the republican and, in the event of an odd number,
it gives the extra vote to the republican, of course.
*/

import java.util.ArrayList;

public class RepElectoralAltStrategy implements IElectionReportingStrategy {


    @Override
    public String getReport(ArrayList<State> electionResults) {
        return null;
    }
}
