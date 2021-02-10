package domain;


public class TicketOffer implements Comparable<TicketOffer> {
    private int id;
    private int cost;
    private String from;
    private String to;
    private int time;

    public TicketOffer(int id, int cost, String from, String to, int time) {
        this.id = id;
        this.cost = cost;
        this.from = from;
        this.to = to;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(TicketOffer o) {
        return Integer.compare(this.cost, o.cost);
    }
}
