package com.jrutz;

public class RepElectoralStrategy implements IElectionReportingStrategy {

    /*
        states will go republican regardless of the polling data
        republican favoring strategy that assumes one of the
     */

    @Override
    public String getReport() {
        return null;
    }
}
