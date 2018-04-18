package com.example.mrizk.workpostureevaluationrula_reba.util;

import java.util.HashMap;
import java.util.Map;

public class RebaTableA {
    private final Map<MapKeyRebaA, Integer> mapTableA = new HashMap<>();

    public RebaTableA() {
        // Row 1
        mapTableA.put(new MapKeyRebaA(1,1,1), 1);
        mapTableA.put(new MapKeyRebaA(1,1,2), 2);
        mapTableA.put(new MapKeyRebaA(1,1,3), 3);
        mapTableA.put(new MapKeyRebaA(1,1,4), 4);
        mapTableA.put(new MapKeyRebaA(1,2,1), 1);
        mapTableA.put(new MapKeyRebaA(1,2,2), 2);
        mapTableA.put(new MapKeyRebaA(1,2,3), 3);
        mapTableA.put(new MapKeyRebaA(1,2,4), 4);
        mapTableA.put(new MapKeyRebaA(1,3,1), 3);
        mapTableA.put(new MapKeyRebaA(1,3,2), 3);
        mapTableA.put(new MapKeyRebaA(1,3,3), 5);
        mapTableA.put(new MapKeyRebaA(1,3,4), 6);

        // Row 2
        mapTableA.put(new MapKeyRebaA(2,1,1), 2);
        mapTableA.put(new MapKeyRebaA(2,1,2), 3);
        mapTableA.put(new MapKeyRebaA(2,1,3), 4);
        mapTableA.put(new MapKeyRebaA(2,1,4), 5);
        mapTableA.put(new MapKeyRebaA(2,2,1), 3);
        mapTableA.put(new MapKeyRebaA(2,2,2), 4);
        mapTableA.put(new MapKeyRebaA(2,2,3), 5);
        mapTableA.put(new MapKeyRebaA(2,2,4), 6);
        mapTableA.put(new MapKeyRebaA(2,3,1), 4);
        mapTableA.put(new MapKeyRebaA(2,3,2), 5);
        mapTableA.put(new MapKeyRebaA(2,3,3), 6);
        mapTableA.put(new MapKeyRebaA(2,3,4), 7);

        // Row 3
        mapTableA.put(new MapKeyRebaA(3,1,1), 2);
        mapTableA.put(new MapKeyRebaA(3,1,2), 4);
        mapTableA.put(new MapKeyRebaA(3,1,3), 5);
        mapTableA.put(new MapKeyRebaA(3,1,4), 6);
        mapTableA.put(new MapKeyRebaA(3,2,1), 4);
        mapTableA.put(new MapKeyRebaA(3,2,2), 5);
        mapTableA.put(new MapKeyRebaA(3,2,3), 6);
        mapTableA.put(new MapKeyRebaA(3,2,4), 7);
        mapTableA.put(new MapKeyRebaA(3,3,1), 5);
        mapTableA.put(new MapKeyRebaA(3,3,2), 6);
        mapTableA.put(new MapKeyRebaA(3,3,3), 7);
        mapTableA.put(new MapKeyRebaA(3,3,4), 8);

        // Row 4
        mapTableA.put(new MapKeyRebaA(4,1,1), 3);
        mapTableA.put(new MapKeyRebaA(4,1,2), 5);
        mapTableA.put(new MapKeyRebaA(4,1,3), 6);
        mapTableA.put(new MapKeyRebaA(4,1,4), 7);
        mapTableA.put(new MapKeyRebaA(4,2,1), 5);
        mapTableA.put(new MapKeyRebaA(4,2,2), 6);
        mapTableA.put(new MapKeyRebaA(4,2,3), 7);
        mapTableA.put(new MapKeyRebaA(4,2,4), 8);
        mapTableA.put(new MapKeyRebaA(4,3,1), 6);
        mapTableA.put(new MapKeyRebaA(4,3,2), 7);
        mapTableA.put(new MapKeyRebaA(4,3,3), 8);
        mapTableA.put(new MapKeyRebaA(4,3,4), 9);

        // Row 5
        mapTableA.put(new MapKeyRebaA(5,1,1), 4);
        mapTableA.put(new MapKeyRebaA(5,1,2), 6);
        mapTableA.put(new MapKeyRebaA(5,1,3), 7);
        mapTableA.put(new MapKeyRebaA(5,1,4), 8);
        mapTableA.put(new MapKeyRebaA(5,2,1), 6);
        mapTableA.put(new MapKeyRebaA(5,2,2), 7);
        mapTableA.put(new MapKeyRebaA(5,2,3), 8);
        mapTableA.put(new MapKeyRebaA(5,2,4), 9);
        mapTableA.put(new MapKeyRebaA(5,3,1), 7);
        mapTableA.put(new MapKeyRebaA(5,3,2), 8);
        mapTableA.put(new MapKeyRebaA(5,3,3), 9);
        mapTableA.put(new MapKeyRebaA(5,3,4), 9);
    }

    public Map<MapKeyRebaA, Integer> getMapTableA() {
        return mapTableA;
    }
}
