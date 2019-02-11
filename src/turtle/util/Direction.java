package turtle.util;

public enum Direction {
    NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, WEST, NORTH_WEST;

    public Direction rotate(Rotation rotation){
        if(rotation == Rotation.RIGHT){
            return Direction.values()[((this.ordinal() + 1)%8)];
        } else if (rotation == Rotation.LEFT) {
            return Direction.values()[((this.ordinal() - 1)%8)];
        } else {
            throw new RuntimeException("Error: Invalid Rotation");
        }

    }
}