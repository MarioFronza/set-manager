package com.mariofronza.setmanager.data;

import java.io.Serializable;

public class Set implements Serializable {

    private boolean isFinal;

    public Set(boolean isFinal) {
        this.isFinal = isFinal;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }
}
