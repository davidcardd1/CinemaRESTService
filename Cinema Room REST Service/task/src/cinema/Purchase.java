package cinema;

public class Purchase {
    private String token;
    private Seat ticket;

    public Purchase(Seat ticket, String token) {
        this.ticket = ticket;
        this.token = token;
    }

    public Purchase() {
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
