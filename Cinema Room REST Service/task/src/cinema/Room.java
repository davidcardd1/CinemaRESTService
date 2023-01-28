package cinema;

import java.util.ArrayList;

public class Room {
    private int total_rows;
    private int total_columns;
    private ArrayList<Seat> available_seats = new ArrayList<>();

    public Room(int total_rows, int total_columns) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;

        for (int row = 1; row <= this.total_rows; row++) {
            for (int col = 1; col <= this.total_columns; col++) {
                addAvailable_seat(new Seat(row, col));
            }
        }
    }

    public Room(int total_rows, int total_columns, ArrayList<Seat> available_seats) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        this.available_seats = available_seats;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public void setAvailable_seats(ArrayList<Seat> available_seats) {
        this.available_seats = available_seats;
    }

    public void addAvailable_seat(Seat seat) {
        this.available_seats.add(seat);
    }

    public ArrayList<Seat> getAvailable_seats() {
        return available_seats;
    }
}
