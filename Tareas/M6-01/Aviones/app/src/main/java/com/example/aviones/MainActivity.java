package com.example.aviones;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private GridLayout gridLayout;
    private List<Plane> planes;
    private ImageView[][] cells;
    private List<List<Plane>> history = new ArrayList<>();
    private final int GRID_SIZE = 4;
    private final int PLANE_COUNT = 10;

    public Button btn_next, btn_prev, btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = findViewById(R.id.gridLayout);

        // grid
        cells = new ImageView[GRID_SIZE][GRID_SIZE];
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                ImageView cell = new ImageView(this);
                cell.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
                cell.setImageResource(0);
                gridLayout.addView(cell);
                cells[row][col] = cell;
            }
        }

        btn_next = this.findViewById(R.id.btn_next);
        btn_prev = this.findViewById(R.id.btn_prev);
        btn_reset = this.findViewById(R.id.btn_reset);

        btn_next.setOnClickListener(v -> {
            nextTurn();
        });

        btn_prev.setOnClickListener(v -> {
            previousTurn();
        });

        btn_reset.setOnClickListener(v -> {
            resetGame();
        });

        startGame();
    }

    private void startGame() {
        planes = new ArrayList<>();
        Random random = new Random();

        while (planes.size() < PLANE_COUNT) {
            int row = random.nextInt(GRID_SIZE);
            int col = random.nextInt(GRID_SIZE);
            boolean occupied = false;
            for (Plane p : planes)
                if (p.row == row && p.col == col)
                    occupied = true;

            if (!occupied)
                planes.add(new Plane(row, col, Direction.randomDirection()));
        }

        history.clear();
        saveState();
        drawPlanes();
    }

    private void nextTurn() {
        for (Plane p : planes) p.move();
        checkCollisions();
        saveState();
        drawPlanes();
    }

    private void previousTurn() {
        if (history.size() > 1) {
            history.remove(history.size() - 1);
            planes = clonePlanes(history.get(history.size() - 1));
            drawPlanes();
        }
    }

    private void resetGame() {
        startGame();
    }

    private void saveState() {
        List<Plane> snapshot = clonePlanes(planes);
        history.add(snapshot);
    }

    private List<Plane> clonePlanes(List<Plane> source) {
        List<Plane> copy = new ArrayList<>();
        for (Plane p : source)
            copy.add(new Plane(p.row, p.col, p.direction));
        return copy;
    }

    private void drawPlanes() {
        // Limpia grid
        for (int row = 0; row < GRID_SIZE; row++)
            for (int col = 0; col < GRID_SIZE; col++)
                cells[row][col].setImageResource(0);

        // Dibuja aviones
        for (Plane p : planes) {
            if (p.row >= 0 && p.row < GRID_SIZE && p.col >= 0 && p.col < GRID_SIZE)
                cells[p.row][p.col].setImageResource(p.getImageResource());
        }
    }

    private void checkCollisions() {
        Map<String, Integer> posCount = new HashMap<>();
        for (Plane p : planes) {
            String key = p.row + "," + p.col;
            posCount.put(key, posCount.getOrDefault(key, 0) + 1);
        }

        for (Plane p : planes) {
            String key = p.row + "," + p.col;
            if (posCount.get(key) > 1)
                p.direction = Direction.COLLISION;
        }
    }
}
