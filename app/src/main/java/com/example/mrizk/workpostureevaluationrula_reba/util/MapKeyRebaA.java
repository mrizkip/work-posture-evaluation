package com.example.mrizk.workpostureevaluationrula_reba.util;

public class MapKeyRebaA {
    private int trunk;
    private int neck;
    private int legs;

    public MapKeyRebaA() {
    }

    public MapKeyRebaA(int trunk, int neck, int legs) {
        this.trunk = trunk;
        this.neck = neck;
        this.legs = legs;
    }

    public int getTrunk() {
        return trunk;
    }

    public void setTrunk(int trunk) {
        this.trunk = trunk;
    }

    public int getNeck() {
        return neck;
    }

    public void setNeck(int neck) {
        this.neck = neck;
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

        MapKeyRebaA that = (MapKeyRebaA) o;

        if (trunk != that.trunk) return false;
        if (neck != that.neck) return false;
        return legs == that.legs;
    }

    @Override
    public int hashCode() {
        int result = trunk;
        result = 31 * result + neck;
        result = 31 * result + legs;
        return result;
    }
}
