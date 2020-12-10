package com.jrutz;

import java.util.ArrayList;

//   republican favoring strategy that assumes one of the
//  states will go republican regardless of the polling data

public class RepElectoralStrategy implements IElectionReportingStrategy {

    @Override
    public String getReport(ArrayList<State> electionResults) {
        return null;
    }
}
