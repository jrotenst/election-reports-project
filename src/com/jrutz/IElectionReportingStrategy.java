package com.jrutz;

import java.util.ArrayList;

public interface IElectionReportingStrategy {
    String getReport(ArrayList<State> electionResults);
}
