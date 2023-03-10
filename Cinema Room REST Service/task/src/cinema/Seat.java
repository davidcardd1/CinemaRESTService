package cinema;

public class Seat {
    private int row;
    private int column;
    private int price;


    public int getPrice() {
        return price;
    }



    public Seat() {

    }

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;

        this.price = this.row <= 4 ? 10 : 8;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
