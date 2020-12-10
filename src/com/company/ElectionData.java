package com.company;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ElectionData extends Observable {

    private ArrayList<State> stateResults;

    public ElectionData() { }

    public void resultsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setResults(ArrayList<State> stateResults) {
        this.stateResults = stateResults;
        resultsChanged();
    }

    public ArrayList<State> getStateResults() {
        return stateResults;
    }

}
