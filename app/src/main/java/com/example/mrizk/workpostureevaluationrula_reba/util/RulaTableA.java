package com.example.mrizk.workpostureevaluationrula_reba.util;

import java.util.HashMap;
import java.util.Map;

public class RulaTableA {

    private final Map<MapKeyRulaA, Integer> mapTableA = new HashMap<>();

    public RulaTableA() {
        // Row 1
        mapTableA.put(new MapKeyRulaA(1, 1, 1, 1), 1);
        mapTableA.put(new MapKeyRulaA(1, 1, 1, 2), 2);
        mapTableA.put(new MapKeyRulaA(1, 1, 2, 1), 2);
        mapTableA.put(new MapKeyRulaA(1, 1, 2, 2), 2);
        mapTableA.put(new MapKeyRulaA(1, 1, 3, 1), 2);
        mapTableA.put(new MapKeyRulaA(1, 1, 3, 2), 3);
        mapTableA.put(new MapKeyRulaA(1, 1, 4, 1), 3);
        mapTableA.put(new MapKeyRulaA(1, 1, 4, 2), 3);

        // Row 2
        mapTableA.put(new MapKeyRulaA(1, 2, 1, 1), 2);
        mapTableA.put(new MapKeyRulaA(1, 2, 1, 2), 2);
        mapTableA.put(new MapKeyRulaA(1, 2, 2, 1), 2);
        mapTableA.put(new MapKeyRulaA(1, 2, 2, 2), 2);
        mapTableA.put(new MapKeyRulaA(1, 2, 3, 1), 3);
        mapTableA.put(new MapKeyRulaA(1, 2, 3, 2), 3);
        mapTableA.put(new MapKeyRulaA(1, 2, 4, 1), 3);
        mapTableA.put(new MapKeyRulaA(1, 2, 4, 2), 3);

        // Row 3
        mapTableA.put(new MapKeyRulaA(1, 3, 1, 1), 2);
        mapTableA.put(new MapKeyRulaA(1, 3, 1, 2), 3);
        mapTableA.put(new MapKeyRulaA(1, 3, 2, 1), 3);
        mapTableA.put(new MapKeyRulaA(1, 3, 2, 2), 3);
        mapTableA.put(new MapKeyRulaA(1, 3, 3, 1), 3);
        mapTableA.put(new MapKeyRulaA(1, 3, 3, 2), 3);
        mapTableA.put(new MapKeyRulaA(1, 3, 4, 1), 4);
        mapTableA.put(new MapKeyRulaA(1, 3, 4, 2), 4);

        // Row 4
        mapTableA.put(new MapKeyRulaA(2, 1, 1, 1), 2);
        mapTableA.put(new MapKeyRulaA(2, 1, 1, 2), 3);
        mapTableA.put(new MapKeyRulaA(2, 1, 2, 1), 3);
        mapTableA.put(new MapKeyRulaA(2, 1, 2, 2), 3);
        mapTableA.put(new MapKeyRulaA(2, 1, 3, 1), 3);
        mapTableA.put(new MapKeyRulaA(2, 1, 3, 2), 4);
        mapTableA.put(new MapKeyRulaA(2, 1, 4, 1), 4);
        mapTableA.put(new MapKeyRulaA(2, 1, 4, 2), 4);

        // Row 5
        mapTableA.put(new MapKeyRulaA(2, 2, 1, 1), 3);
        mapTableA.put(new MapKeyRulaA(2, 2, 1, 2), 3);
        mapTableA.put(new MapKeyRulaA(2, 2, 2, 1), 3);
        mapTableA.put(new MapKeyRulaA(2, 2, 2, 2), 3);
        mapTableA.put(new MapKeyRulaA(2, 2, 3, 1), 3);
        mapTableA.put(new MapKeyRulaA(2, 2, 3, 2), 4);
        mapTableA.put(new MapKeyRulaA(2, 2, 4, 1), 4);
        mapTableA.put(new MapKeyRulaA(2, 2, 4, 2), 4);

        // Row 6
        mapTableA.put(new MapKeyRulaA(2, 3, 1, 1), 3);
        mapTableA.put(new MapKeyRulaA(2, 3, 1, 2), 4);
        mapTableA.put(new MapKeyRulaA(2, 3, 2, 1), 4);
        mapTableA.put(new MapKeyRulaA(2, 3, 2, 2), 4);
        mapTableA.put(new MapKeyRulaA(2, 3, 3, 1), 4);
        mapTableA.put(new MapKeyRulaA(2, 3, 3, 2), 4);
        mapTableA.put(new MapKeyRulaA(2, 3, 4, 1), 5);
        mapTableA.put(new MapKeyRulaA(2, 3, 4, 2), 5);

        // Row 7
        mapTableA.put(new MapKeyRulaA(3, 1, 1, 1), 3);
        mapTableA.put(new MapKeyRulaA(3, 1, 1, 2), 3);
        mapTableA.put(new MapKeyRulaA(3, 1, 2, 1), 4);
        mapTableA.put(new MapKeyRulaA(3, 1, 2, 2), 4);
        mapTableA.put(new MapKeyRulaA(3, 1, 3, 1), 4);
        mapTableA.put(new MapKeyRulaA(3, 1, 3, 2), 4);
        mapTableA.put(new MapKeyRulaA(3, 1, 4, 1), 5);
        mapTableA.put(new MapKeyRulaA(3, 1, 4, 2), 5);

        // Row 8
        mapTableA.put(new MapKeyRulaA(3, 2, 1, 1), 3);
        mapTableA.put(new MapKeyRulaA(3, 2, 1, 2), 4);
        mapTableA.put(new MapKeyRulaA(3, 2, 2, 1), 4);
        mapTableA.put(new MapKeyRulaA(3, 2, 2, 2), 4);
        mapTableA.put(new MapKeyRulaA(3, 2, 3, 1), 4);
        mapTableA.put(new MapKeyRulaA(3, 2, 3, 2), 4);
        mapTableA.put(new MapKeyRulaA(3, 2, 4, 1), 5);
        mapTableA.put(new MapKeyRulaA(3, 2, 4, 2), 5);

        // Row 9
        mapTableA.put(new MapKeyRulaA(3, 3, 1, 1), 4);
        mapTableA.put(new MapKeyRulaA(3, 3, 1, 2), 4);
        mapTableA.put(new MapKeyRulaA(3, 3, 2, 1), 4);
        mapTableA.put(new MapKeyRulaA(3, 3, 2, 2), 4);
        mapTableA.put(new MapKeyRulaA(3, 3, 3, 1), 4);
        mapTableA.put(new MapKeyRulaA(3, 3, 3, 2), 5);
        mapTableA.put(new MapKeyRulaA(3, 3, 4, 1), 5);
        mapTableA.put(new MapKeyRulaA(3, 3, 4, 2), 5);

        // Row 10
        mapTableA.put(new MapKeyRulaA(4, 1, 1, 1), 4);
        mapTableA.put(new MapKeyRulaA(4, 1, 1, 2), 4);
        mapTableA.put(new MapKeyRulaA(4, 1, 2, 1), 4);
        mapTableA.put(new MapKeyRulaA(4, 1, 2, 2), 4);
        mapTableA.put(new MapKeyRulaA(4, 1, 3, 1), 4);
        mapTableA.put(new MapKeyRulaA(4, 1, 3, 2), 5);
        mapTableA.put(new MapKeyRulaA(4, 1, 4, 1), 5);
        mapTableA.put(new MapKeyRulaA(4, 1, 4, 2), 5);

        // Row 11
        mapTableA.put(new MapKeyRulaA(4, 2, 1, 1), 4);
        mapTableA.put(new MapKeyRulaA(4, 2, 1, 2), 4);
        mapTableA.put(new MapKeyRulaA(4, 2, 2, 1), 4);
        mapTableA.put(new MapKeyRulaA(4, 2, 2, 2), 4);
        mapTableA.put(new MapKeyRulaA(4, 2, 3, 1), 4);
        mapTableA.put(new MapKeyRulaA(4, 2, 3, 2), 5);
        mapTableA.put(new MapKeyRulaA(4, 2, 4, 1), 5);
        mapTableA.put(new MapKeyRulaA(4, 2, 4, 2), 5);

        // Row 12
        mapTableA.put(new MapKeyRulaA(4, 3, 1, 1), 4);
        mapTableA.put(new MapKeyRulaA(4, 3, 1, 2), 4);
        mapTableA.put(new MapKeyRulaA(4, 3, 2, 1), 4);
        mapTableA.put(new MapKeyRulaA(4, 3, 2, 2), 5);
        mapTableA.put(new MapKeyRulaA(4, 3, 3, 1), 5);
        mapTableA.put(new MapKeyRulaA(4, 3, 3, 2), 5);
        mapTableA.put(new MapKeyRulaA(4, 3, 4, 1), 6);
        mapTableA.put(new MapKeyRulaA(4, 3, 4, 2), 6);

        // Row 13
        mapTableA.put(new MapKeyRulaA(5, 1, 1, 1), 5);
        mapTableA.put(new MapKeyRulaA(5, 1, 1, 2), 5);
        mapTableA.put(new MapKeyRulaA(5, 1, 2, 1), 5);
        mapTableA.put(new MapKeyRulaA(5, 1, 2, 2), 5);
        mapTableA.put(new MapKeyRulaA(5, 1, 3, 1), 5);
        mapTableA.put(new MapKeyRulaA(5, 1, 3, 2), 6);
        mapTableA.put(new MapKeyRulaA(5, 1, 4, 1), 6);
        mapTableA.put(new MapKeyRulaA(5, 1, 4, 2), 7);

        // Row 14
        mapTableA.put(new MapKeyRulaA(5, 2, 1, 1), 5);
        mapTableA.put(new MapKeyRulaA(5, 2, 1, 2), 6);
        mapTableA.put(new MapKeyRulaA(5, 2, 2, 1), 6);
        mapTableA.put(new MapKeyRulaA(5, 2, 2, 2), 6);
        mapTableA.put(new MapKeyRulaA(5, 2, 3, 1), 6);
        mapTableA.put(new MapKeyRulaA(5, 2, 3, 2), 7);
        mapTableA.put(new MapKeyRulaA(5, 2, 4, 1), 7);
        mapTableA.put(new MapKeyRulaA(5, 2, 4, 2), 7);

        // Row 15
        mapTableA.put(new MapKeyRulaA(5, 3, 1, 1), 6);
        mapTableA.put(new MapKeyRulaA(5, 3, 1, 2), 6);
        mapTableA.put(new MapKeyRulaA(5, 3, 2, 1), 6);
        mapTableA.put(new MapKeyRulaA(5, 3, 2, 2), 7);
        mapTableA.put(new MapKeyRulaA(5, 3, 3, 1), 7);
        mapTableA.put(new MapKeyRulaA(5, 3, 3, 2), 7);
        mapTableA.put(new MapKeyRulaA(5, 3, 4, 1), 7);
        mapTableA.put(new MapKeyRulaA(5, 3, 4, 2), 8);

        // Row 16
        mapTableA.put(new MapKeyRulaA(6, 1, 1, 1), 7);
        mapTableA.put(new MapKeyRulaA(6, 1, 1, 2), 7);
        mapTableA.put(new MapKeyRulaA(6, 1, 2, 1), 7);
        mapTableA.put(new MapKeyRulaA(6, 1, 2, 2), 7);
        mapTableA.put(new MapKeyRulaA(6, 1, 3, 1), 7);
        mapTableA.put(new MapKeyRulaA(6, 1, 3, 2), 8);
        mapTableA.put(new MapKeyRulaA(6, 1, 4, 1), 8);
        mapTableA.put(new MapKeyRulaA(6, 1, 4, 2), 9);

        // Row 17
        mapTableA.put(new MapKeyRulaA(6, 2, 1, 1), 8);
        mapTableA.put(new MapKeyRulaA(6, 2, 1, 2), 8);
        mapTableA.put(new MapKeyRulaA(6, 2, 2, 1), 8);
        mapTableA.put(new MapKeyRulaA(6, 2, 2, 2), 8);
        mapTableA.put(new MapKeyRulaA(6, 2, 3, 1), 8);
        mapTableA.put(new MapKeyRulaA(6, 2, 3, 2), 9);
        mapTableA.put(new MapKeyRulaA(6, 2, 4, 1), 9);
        mapTableA.put(new MapKeyRulaA(6, 2, 4, 2), 9);

        // Row 18
        mapTableA.put(new MapKeyRulaA(6, 3, 1, 1), 9);
        mapTableA.put(new MapKeyRulaA(6, 3, 1, 2), 9);
        mapTableA.put(new MapKeyRulaA(6, 3, 2, 1), 9);
        mapTableA.put(new MapKeyRulaA(6, 3, 2, 2), 9);
        mapTableA.put(new MapKeyRulaA(6, 3, 3, 1), 9);
        mapTableA.put(new MapKeyRulaA(6, 3, 3, 2), 9);
        mapTableA.put(new MapKeyRulaA(6, 3, 4, 1), 9);
        mapTableA.put(new MapKeyRulaA(6, 3, 4, 2), 9);

    }

    public Map<MapKeyRulaA, Integer> getMapTableA() {
        return mapTableA;
    }
}
