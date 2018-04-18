package com.example.mrizk.workpostureevaluationrula_reba.util;

public class MapKeyRebaC {
    private int scoreA;
    private int scoreB;

    public MapKeyRebaC() {
    }

    public MapKeyRebaC(int scoreA, int scoreB) {
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapKeyRebaC that = (MapKeyRebaC) o;

        if (scoreA != that.scoreA) return false;
        return scoreB == that.scoreB;
    }

    @Override
    public int hashCode() {
        int result = scoreA;
        result = 31 * result + scoreB;
        return result;
    }
}
