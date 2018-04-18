package com.example.mrizk.workpostureevaluationrula_reba.util;

public class MapKeyRebaB {
    private int upperArm;
    private int lowerArm;
    private int wrist;

    public MapKeyRebaB() {
    }

    public MapKeyRebaB(int upperArm, int lowerArm, int wrist) {
        this.upperArm = upperArm;
        this.lowerArm = lowerArm;
        this.wrist = wrist;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapKeyRebaB that = (MapKeyRebaB) o;

        if (upperArm != that.upperArm) return false;
        if (lowerArm != that.lowerArm) return false;
        return wrist == that.wrist;
    }

    @Override
    public int hashCode() {
        int result = upperArm;
        result = 31 * result + lowerArm;
        result = 31 * result + wrist;
        return result;
    }
}
