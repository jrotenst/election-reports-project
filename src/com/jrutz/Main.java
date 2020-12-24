package com.jrutz;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static LinkedList<ElectionReporter> electionReporters = new LinkedList<ElectionReporter>();

    public static void main(String[] args) {

        ArrayList<State> latestStateResults = new ArrayList<State>();
        latestStateResults.add(new State("NY",5241957, 3250075, 29));
        latestStateResults.add(new State("CA", 11110250, 6006429, 55));
        latestStateResults.add(new State("FL", 5297045, 5668731, 29));
        latestStateResults.add(new State("GA", 2473633, 2461854, 16));
        latestStateResults.add(new State("PA", 3459923, 3378263, 20));

        ElectionData electionData = new ElectionData(latestStateResults);

        electionReporters.add(new MAGANews(electionData));
        electionReporters.add(new EqualityNewsNetwork(electionData));
        electionReporters.add(new MilktoastConservativeLive(electionData));
        electionReporters.add(new AlmostTrueNews(electionData));
        electionReporters.add(new HonestAbeNewsNetwork(electionData));

        electionData.resultsChanged();
        displayReports();

        // move 50k votes from dem to rep in each state
        for (State s : latestStateResults) {
            s.setRepVotes(s.getRepVotes() + 50000);
            s.setDemVotes(s.getDemVotes() - 50000);
        }

        electionData.resultsChanged();
        displayReports();

        // move 100k votes from rep to dem in each state
        for (State s : latestStateResults) {
            s.setRepVotes(s.getRepVotes() - 100000);
            s.setDemVotes(s.getDemVotes() + 100000);
        }

        electionData.resultsChanged();
        displayReports();

        // move 1m votes from dem to rep in each state
        for (State s : latestStateResults) {
            s.setRepVotes(s.getRepVotes() + 1100000);
            s.setDemVotes(s.getDemVotes() - 1100000);
        }

        electionData.resultsChanged();
        displayReports();
    }

    public static void displayReports() {
        for (ElectionReporter er : electionReporters) {
            System.out.println(er.reportElection() + "\n");
            er.displayLegalMessage();
            System.out.println();
        }
    }
}
