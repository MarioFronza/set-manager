package com.mariofronza.setmanager.data;

import java.io.Serializable;

public class Team implements Serializable {

    private String name;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
