import java.sql.Date;
import java.util.ArrayList;

import sun.security.krb5.internal.Ticket;

public class Flight{

    private int flightNum;
    private int durationhrs;
    private int numSeats;
    private int bookedSeats;
    private int remainingSeats;
    private double price;
    private Date date;
    private Time time;
    private String source;
    private String destination;
    private ArrayList<Ticket> passengers;

    public Flight(int fflightNum, int ddurationhrs, int nnumSeats, double pprice, Date ddate, Time ttime, String ssource, String ddestination){
        this.flightNum = fflightNum;
        this.durationhrs = ddurationhrs;
        this.numSeats = nnumSeats;
        this.price = pprice;
        this.date = ddate;
        this.time = ttime;
        this.source = ssource;
        this.destination = ddestination;
        bookedSeats = 0;
        remainingSeats = nnumSeats;
        passengers = new ArrayList<Ticket>();
    }

    public boolean isFull(){
        if(remainingSeats == 0)return true;
        else return false;
    }
    public boolean isEmpty(){
        if(bookedSeats == 0)return true;
        else return false;
    }
    public Ticket findPassenger(int ticketNum){
        if(ticketNum<bookedSeats)return passengers.get(ticketNum);
        else return null;
    }
    public boolean addPassenger(Ticket ticket){
        if(isFull())return false;
        else {
            passengers.add(ticket);
            bookedSeats++;
            remainingSeats--;
            return true;
        }
    }
    public boolean deletePassenger(Ticket ticket){
        if(isEmpty())return false;
        else {
            passengers.add(ticket);
            bookedSeats--;
            remainingSeats++;
            return true;
        }
    }


}