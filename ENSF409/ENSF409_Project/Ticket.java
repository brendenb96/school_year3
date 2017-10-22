

public class Ticket{

    private Flight flight;
    private String firstName;
    private String lastName;
    private int ticketNum;

    public Ticket(Flight f, String fname, String lname, int tNum){
        this.flight = f;
        this.firstName = fname;
        this.lastName = lname;
        this.ticketNum = tNum;
    }

    public Flight getFlight(){
        return flight;
    }
    public String getfirstName(){
        return firstName;
    }
    public String getlastName(){
        return lastName;
    }
    public String getwholeName(){
        return firstName + " " + lastName;
    }


}