package com.example.mrizk.workpostureevaluationrula_reba.util;

/**
 * Created by mrizk on 16/03/2018.
 */

public class MapKeyRulaA {

    private int upperArm;
    private int lowerArm;
    private int wrist;
    private int wristTwist;

    public MapKeyRulaA() {
    }

    public MapKeyRulaA(int upperArm, int lowerArm, int wrist, int wristTwist) {
        this.upperArm = upperArm;
        this.lowerArm = lowerArm;
        this.wrist = wrist;
        this.wristTwist = wristTwist;
    }

    public int getUpperArm() {
        return upperArm;
    }

    public void setUpperArm(int upperArm) {
        this.upperArm = upperArm;
    }

    public int getLowerArm() {
        return lowerArm;
    }

    public void setLowerArm(int lowerArm) {
        this.lowerArm = lowerArm;
    }

    public int getWrist() {
        return wrist;
    }

    public void setWrist(int wrist) {
        this.wrist = wrist;
    }

    public int getWristTwist() {
        return wristTwist;
    }

    public void setWristTwist(int wristTwist) {
        this.wristTwist = wristTwist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapKeyRulaA that = (MapKeyRulaA) o;

        if (upperArm != that.upperArm) return false;
        if (lowerArm != that.lowerArm) return false;
        if (wrist != that.wrist) return false;
        return wristTwist == that.wristTwist;
    }

    @Override
    public int hashCode() {
        int result = upperArm;
        result = 31 * result + lowerArm;
        result = 31 * result + wrist;
        result = 31 * result + wristTwist;
        return result;
    }
}
