package com.jrutz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

abstract class ElectionReporter implements Observer {

    IElectionReportingStrategy PVReportStrategy;
    IElectionReportingStrategy ECReportStrategy;
    ArrayList<State> electionResults;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy hh:mm:ss a");

    public ElectionReporter(Observable observable) {
        observable.addObserver(this);
    }

    public void update(Observable observable, Object o) {
        if (observable instanceof ElectionData) {
            ElectionData electionData = (ElectionData) observable;
            electionResults = electionData.getStateResults();
        }
    }

    public String reportElection() {
        DisplayLegalMessage();
        return PVReportStrategy.getReport()
                + ECReportStrategy.getReport();
    }

    public void DisplayLegalMessage() {
        System.out.println("\n" + formatter.format(new Date()));
        System.out.println("All reports are purely observational and not legally binding in any way.\n");
    }
}
