package com.jrutz;

import java.util.ArrayList;
import java.util.SplittableRandom;

public interface IElectionReportingStrategy {
    void setResults(ArrayList<State> results);
    String report();
    void resetVariables();
}
