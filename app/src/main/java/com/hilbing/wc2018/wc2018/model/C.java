
package com.hilbing.wc2018.wc2018.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class C {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("winner")
    @Expose
    private Object winner;
    @SerializedName("runnerup")
    @Expose
    private Object runnerup;
    @SerializedName("matches")
    @Expose
    private List<MatchC> matches = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getWinner() {
        return winner;
    }

    public void setWinner(Object winner) {
        this.winner = winner;
    }

    public Object getRunnerup() {
        return runnerup;
    }

    public void setRunnerup(Object runnerup) {
        this.runnerup = runnerup;
    }

    public List<MatchC> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchC> matches) {
        this.matches = matches;
    }

}
