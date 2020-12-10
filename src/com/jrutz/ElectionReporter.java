package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

abstract class ElectionReporter {

    IPopularVoteReportingStrategy PVReportStrategy;
    IElectoralCollegeReportingStrategy ECReportStrategy;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy hh:mm:ss a");

    void DisplayLegalMessage() {
        System.out.println("\n" + formatter.format(new Date()));
        System.out.println("All reports are purely observational and not legally binding in any way.\n");
    }
}
