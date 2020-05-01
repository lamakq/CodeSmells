class Row {
    private final Coordinate[] coordinates;

    private Row(Coordinate[] coordinates) {
        this.coordinates = coordinates;
    }

    public Row(int row) {
        coordinates = new Coordinate[3];
        for (int column = 0; column < 3; column++)
            coordinates[column] = new Coordinate(row, column);
    }

    public Coordinate[] getCoordinates() {
        return coordinates;
    }
}
