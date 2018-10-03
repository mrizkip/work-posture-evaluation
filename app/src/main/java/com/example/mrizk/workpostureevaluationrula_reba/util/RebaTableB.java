package com.example.mrizk.workpostureevaluationrula_reba.util;

import java.util.HashMap;
import java.util.Map;

public class RebaTableB {
    private final Map<MapKeyRebaB, Integer> mapTableB = new HashMap<>();

    public RebaTableB() {
        // Row 1
        mapTableB.put(new MapKeyRebaB(1,1,1), 1);
        mapTableB.put(new MapKeyRebaB(1,1,2), 2);
        mapTableB.put(new MapKeyRebaB(1,1,3), 2);
        mapTableB.put(new MapKeyRebaB(1,2,1), 1);
        mapTableB.put(new MapKeyRebaB(1,2,2), 2);
        mapTableB.put(new MapKeyRebaB(1,2,3), 3);

        // Row 2
        mapTableB.put(new MapKeyRebaB(2,1,1), 1);
        mapTableB.put(new MapKeyRebaB(2,1,2), 2);
        mapTableB.put(new MapKeyRebaB(2,1,3), 3);
        mapTableB.put(new MapKeyRebaB(2,2,1), 2);
        mapTableB.put(new MapKeyRebaB(2,2,2), 3);
        mapTableB.put(new MapKeyRebaB(2,2,3), 4);

        // Row 3
        mapTableB.put(new MapKeyRebaB(3,1,1), 3);
        mapTableB.put(new MapKeyRebaB(3,1,2), 4);
        mapTableB.put(new MapKeyRebaB(3,1,3), 5);
        mapTableB.put(new MapKeyRebaB(3,2,1), 4);
        mapTableB.put(new MapKeyRebaB(3,2,2), 5);
        mapTableB.put(new MapKeyRebaB(3,2,3), 5);

        // Row 4
        mapTableB.put(new MapKeyRebaB(4,1,1), 4);
        mapTableB.put(new MapKeyRebaB(4,1,2), 5);
        mapTableB.put(new MapKeyRebaB(4,1,3), 5);
        mapTableB.put(new MapKeyRebaB(4,2,1), 5);
        mapTableB.put(new MapKeyRebaB(4,2,2), 6);
        mapTableB.put(new MapKeyRebaB(4,2,3), 7);

        // Row 5
        mapTableB.put(new MapKeyRebaB(5,1,1), 6);
        mapTableB.put(new MapKeyRebaB(5,1,2), 7);
        mapTableB.put(new MapKeyRebaB(5,1,3), 8);
        mapTableB.put(new MapKeyRebaB(5,2,1), 7);
        mapTableB.put(new MapKeyRebaB(5,2,2), 8);
        mapTableB.put(new MapKeyRebaB(5,2,3), 8);

        // Row 6
        mapTableB.put(new MapKeyRebaB(6,1,1), 7);
        mapTableB.put(new MapKeyRebaB(6,1,2), 8);
        mapTableB.put(new MapKeyRebaB(6,1,3), 8);
        mapTableB.put(new MapKeyRebaB(6,2,1), 8);
        mapTableB.put(new MapKeyRebaB(6,2,2), 9);
        mapTableB.put(new MapKeyRebaB(6,2,3), 9);
    }

    public Map<MapKeyRebaB, Integer> getMapTableB() {
        return mapTableB;
    }
}
