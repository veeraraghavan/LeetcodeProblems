package com.practice.leetcode.arithmetic;

public class SolveTheEquation {

    public String solveEquation(String equation) {
        int leftX = 0;
        int rightX = 0;

        int leftVal = 0;
        int rightVal = 0;

        String[] splits = equation.split("=");

        String leftStr = splits[0];
        String rightStr = splits[1];

        int[] leftEvaluated = evaluateEquation(leftStr);
        int[] rightEvaluated = evaluateEquation(rightStr);

        int intX = leftEvaluated[0] - rightEvaluated[0];
        int intVal = rightEvaluated[1] - leftEvaluated[1];

        if (intX == 0) {
            if (intVal == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + (intVal / intX);
        }
    }

    /**
     *
     * @param leftStr
     * Logic: at a particular index, there could be 4 types of char, 'x', '+', '-', '0'-'9'
     * Also, if the char encountered at current index is 'x' or '0'-'9',
     * we need to know from previous chars, the sign just before this.
     * boolean isPositive = false; takes care of it.
     * leftX stores total of X.
     * leftVal stores total of values.
     * @return
     */
    private int[] evaluateEquation(String leftStr) {
        boolean isPositive = false;

        int leftX = 0;
        int leftVal = 0;

        /**
         * handling first character separately
         */
        int i = 0;
        if (leftStr.charAt(i) == 'x') {
            leftX += 1;
            i++;
        } else if (leftStr.charAt(i) == '+') {
            isPositive = true;
            i++;
        } else if (leftStr.charAt(i) == '-') {
            i++;
        }else if (leftStr.charAt(i) >= '0' &&
                leftStr.charAt(i) <= '9') {
            int coeff = 0;
            String coeffStr = "";
            for (; i < leftStr.length() && (leftStr.charAt(i) >= '0' &&
                    leftStr.charAt(i) <= '9'); i++) {
                coeffStr += String.valueOf(leftStr.charAt(i));
            }

            for (int j=(coeffStr.length() - 1), k = 0; j >= 0; j--, k++) {
                coeff += (coeffStr.charAt(j) - 48) *
                        Double.valueOf(Math.pow(10, k)).intValue();
            }
            if (i < leftStr.length() &&
                    leftStr.charAt(i) == 'x') {
                leftX += coeff;
                i++;
            } else {
                leftVal += coeff;
            }
        }

        for (; i < leftStr.length(); i++) {
            if (leftStr.charAt(i) == 'x') {
                if (isPositive) {
                    leftX += 1;
                } else {
                    leftX -= 1;
                }
            } else if (leftStr.charAt(i) == '+') {
                isPositive = true;
            } else if (leftStr.charAt(i) == '-') {
                isPositive = false;
            } else if (leftStr.charAt(i) >= '0' &&
                    leftStr.charAt(i) <= '9') {
                int coeff = 0;
                String coeffStr = "";
                for (; i < leftStr.length() && (leftStr.charAt(i) >= '0' &&
                        leftStr.charAt(i) <= '9'); i++) {
                    coeffStr += String.valueOf(leftStr.charAt(i));
                }

                for (int j=(coeffStr.length() - 1), k = 0; j >= 0; j--, k++) {
                    coeff += (coeffStr.charAt(j) - 48) *
                            Double.valueOf(Math.pow(10, k)).intValue();
                }

                if (i < leftStr.length() &&
                        leftStr.charAt(i) == 'x') {
                    if (isPositive) {
                        leftX += coeff;
                    } else {
                        leftX -= coeff;
                    }
                } else {
                    if (isPositive) {
                        leftVal += coeff;
                    } else {
                        leftVal -= coeff;
                    }
                    i--;
                }
            }
        }
        return new int[]{leftX, leftVal};
    }

    public static void main(String[] args) {
        SolveTheEquation solveTheEquation = new SolveTheEquation();

        String equation = "x+5-3+x=6+x-2";
        System.out.println(solveTheEquation.solveEquation(equation));

        equation = "x=x";
        System.out.println(solveTheEquation.solveEquation(equation));

        equation = "2x=x";
        System.out.println(solveTheEquation.solveEquation(equation));

        equation = "2x+3x-6x=x+2";
        System.out.println(solveTheEquation.solveEquation(equation));

        equation = "x=x+2";
        System.out.println(solveTheEquation.solveEquation(equation));
    }
}