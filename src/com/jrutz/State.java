package com.jrutz;

public class State {

    private String name;
    private String abrv;
    private int demVotes;
    private int repVotes;
    private int electoralVotes;

    public State(String name, String abrv, int electoralVotes) {
        this.name = name;
        this.abrv = abrv;
        this.electoralVotes = electoralVotes;
    }

    public String getName() { return name; }

    public String getAbrv() { return abrv; }

    public int getDemVotes() { return demVotes; }

    public int getRepVotes() { return repVotes; }

    public int getElectoralVotes() { return electoralVotes; }

    public void setDemVotes(int demVotes) { this.demVotes = demVotes; }

    public void setRepVotes(int repVotes) { this.repVotes = repVotes; }
}
