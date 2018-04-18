package com.example.mrizk.workpostureevaluationrula_reba.util;

public class MapKeyRulaC {

    private int wristArm;
    private int neckTrunkLeg;

    public MapKeyRulaC() {
    }

    public MapKeyRulaC(int wristArm, int neckTrunkLeg) {
        this.wristArm = wristArm;
        this.neckTrunkLeg = neckTrunkLeg;
    }

    public int getWristArm() {
        return wristArm;
    }

    public void setWristArm(int wristArm) {
        this.wristArm = wristArm;
    }

    public int getNeckTrunkLeg() {
        return neckTrunkLeg;
    }

    public void setNeckTrunkLeg(int neckTrunkLeg) {
        this.neckTrunkLeg = neckTrunkLeg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapKeyRulaC that = (MapKeyRulaC) o;

        if (wristArm != that.wristArm) return false;
        return neckTrunkLeg == that.neckTrunkLeg;
    }

    @Override
    public int hashCode() {
        int result = wristArm;
        result = 31 * result + neckTrunkLeg;
        return result;
    }
}
