package com.jrutz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

abstract class ElectionReporter implements Observer {

    String name;
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
            PVReportStrategy.setResults(electionResults);
            ECReportStrategy.setResults(electionResults);
        }
    }

    public String reportElection() {
        return  "\n********** " + name + " **********\n"
                + "\nLATEST ELECTION RESULTS:\n"
                + "\nELECTORAL COLLEGE - "
                + ECReportStrategy.report()
                + "\n\nPOPULAR VOTE - "
                + PVReportStrategy.report();
    }

    public void displayLegalMessage() {
        System.out.println(formatter.format(new Date()));
        System.out.println("All reports are purely observational and not legally binding in any way.");
    }
}
