
package com.hilbing.wc2018.wc2018.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Round16 {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("matches")
    @Expose
    private List<MatchRound16> matches = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MatchRound16> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchRound16> matches) {
        this.matches = matches;
    }

}
