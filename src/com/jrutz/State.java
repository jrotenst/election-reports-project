package com.jrutz;

public class State {

    private String abrv;
    private int demVotes;
    private int repVotes;
    private int electoralVotes;

    public State(String abrv, int demVotes, int repVotes, int electoralVotes) {
        this.abrv = abrv;
        this.demVotes = demVotes;
        this.repVotes = repVotes;
        this.electoralVotes = electoralVotes;
    }

    public String getAbrv() { return abrv; }

    public int getDemVotes() { return demVotes; }

    public int getRepVotes() { return repVotes; }

    public int getElectoralVotes() { return electoralVotes; }

    public void setDemVotes(int demVotes) { this.demVotes = demVotes; }

    public void setRepVotes(int repVotes) { this.repVotes = repVotes; }
}
