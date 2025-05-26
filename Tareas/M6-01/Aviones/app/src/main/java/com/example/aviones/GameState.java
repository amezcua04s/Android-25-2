package com.example.aviones;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    public List<Plane> planes;

    public GameState(List<Plane> planes) {
        this.planes = new ArrayList<>();
        for (Plane p : planes) {
            this.planes.add(p.copy());
        }
    }
}
