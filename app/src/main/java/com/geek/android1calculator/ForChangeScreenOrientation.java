package com.geek.android1calculator;

import java.io.Serializable;

public class ForChangeScreenOrientation implements Serializable {

    private CharSequence formulaText;

    public void setFormulaText(CharSequence formulaText) {
        this.formulaText = formulaText;
    }

    public CharSequence getFormulaText() {
        return formulaText;
    }
}
