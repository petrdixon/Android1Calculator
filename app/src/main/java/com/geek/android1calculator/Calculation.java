package com.geek.android1calculator;

// В этом классе логика подсчета

public class Calculation {
    public Calculation(String inputtedFormula) {
        this.inputtedFormula = inputtedFormula;
    }

    private String inputtedFormula;
    private String tempValueString1 = "";
    private String tempValueString2 = "";
    private String operation;
    private int presentValueAfterCalculation;
    private String[] arrInputtedFormula;

    public int getPresentValueAfterCalculation() {
        return presentValueAfterCalculation;
    }

    public void formulaCalculation(){
        arrInputtedFormula = this.inputtedFormula.split("");
        for(String elem:arrInputtedFormula){
            try {
                Integer.valueOf(elem);
                tempValueString2 = tempValueString2 + elem; // собираю число из цифр

            } catch (NumberFormatException e) {
                if(tempValueString1.equals("")) {
                    tempValueString1 = tempValueString2;
                    tempValueString2 = "";
                } else{
                    if(operation.equals("sum")) presentValueAfterCalculation = Integer.parseInt(tempValueString1) + Integer.parseInt(tempValueString2);
                    if(operation.equals("minus")) presentValueAfterCalculation = Integer.parseInt(tempValueString1) - Integer.parseInt(tempValueString2);
                    if(operation.equals("divide")) presentValueAfterCalculation = Integer.parseInt(tempValueString1) / Integer.parseInt(tempValueString2);
                    if(operation.equals("multiply")) presentValueAfterCalculation = Integer.parseInt(tempValueString1) * Integer.parseInt(tempValueString2);
                    tempValueString1 = "";
                }
                if (String.valueOf(elem).equals("+")) operation = "sum";
                if (String.valueOf(elem).equals("-")) operation = "minus";
                if (String.valueOf(elem).equals("÷")) operation = "divide";
                if (String.valueOf(elem).equals("*")) operation = "multiply";

            }
        }
    }
}

