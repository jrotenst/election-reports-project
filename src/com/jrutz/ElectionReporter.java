package com.jrutz;

import java.text.SimpleDateFormat;
import java.util.Date;

abstract class ElectionReporter {

    IElectionReportingStrategy PVReportStrategy;
    IElectionReportingStrategy ECReportStrategy;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy hh:mm:ss a");

    String reportPopularVote() {
        return PVReportStrategy.getReport();
    }

    String reportElectoralCollege() {
        return ECReportStrategy.getReport();
    }

    void DisplayLegalMessage() {
        System.out.println("\n" + formatter.format(new Date()));
        System.out.println("All reports are purely observational and not legally binding in any way.\n");
    }
}
