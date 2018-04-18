package com.example.mrizk.workpostureevaluationrula_reba.util;

public class MapKeyRulaB {

    private int neck;
    private int trunk;
    private int legs;

    public MapKeyRulaB() {
    }

    public MapKeyRulaB(int neck, int trunk, int legs) {
        this.neck = neck;
        this.trunk = trunk;
        this.legs = legs;
    }

    public int getNeck() {
        return neck;
    }

    public void setNeck(int neck) {
        this.neck = neck;
    }

    public int getTrunk() {
        return trunk;
    }

    public void setTrunk(int trunk) {
        this.trunk = trunk;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapKeyRulaB that = (MapKeyRulaB) o;

        if (neck != that.neck) return false;
        if (trunk != that.trunk) return false;
        return legs == that.legs;
    }

    @Override
    public int hashCode() {
        int result = neck;
        result = 31 * result + trunk;
        result = 31 * result + legs;
        return result;
    }
}
