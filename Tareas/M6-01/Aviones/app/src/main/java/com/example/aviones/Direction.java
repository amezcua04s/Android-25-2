package com.example.aviones;

import java.util.Random;

public enum Direction {
    NORTH, SOUTH, EAST, WEST, COLLISION;

    public static Direction randomDirection() {
        Direction[] values = {NORTH, SOUTH, EAST, WEST};
        return values[new Random().nextInt(values.length)];
    }
}

