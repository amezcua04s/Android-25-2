package com.example.aviones;
public class Plane {
    public int row, col;
    public Direction direction;

    public Plane(int row, int col, Direction dir) {
        this.row = row;
        this.col = col;
        this.direction = dir;
    }

    public void move() {
        switch (direction) {
            case NORTH: if (row > 0) row--; break;
            case SOUTH: if (row < 3) row++; break;
            case EAST:  if (col < 3) col++; break;
            case WEST:  if (col > 0) col--; break;
            default: break;
        }
    }

    public int getImageResource() {
        switch (direction) {
            case NORTH: return R.mipmap.north;
            case SOUTH: return R.mipmap.south;
            case EAST:  return R.mipmap.east;
            case WEST:  return R.mipmap.west;
            case COLLISION: return R.mipmap.collision;
            default: return 0;
        }
    }

    public Plane copy() {
        return new Plane(row, col, direction);
    }

}



