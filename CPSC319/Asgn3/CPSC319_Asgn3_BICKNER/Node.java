
public class Node {
    public String element;
    public String rawdata;
    public String studentnum;
    public String studentlastname;
    public String homedep;
    public String program;
    public String year;
    public char command;
    public Node next;
    public Node right;
    public Node left;

    public Node(){
        this.next = null;
        this.right = null;
        this.left = null;
    }

    public Node(String e, Node n) {
        rawdata = e;
        element = e.substring(1);
        studentnum = e.substring(1,7);
        studentlastname = e.substring(8,32);
        homedep = e.substring(33,36);
        program = e.substring(37,40);
        year = e.substring(41,42);
        command = e.charAt(0);
        next = n;
    }

    public Node (String e) {
        rawdata = e;
        element = e.substring(1);
        studentnum = e.substring(1,7);
        studentlastname = e.substring(8,32);
        homedep = e.substring(33,36);
        program = e.substring(37,40);
        year = e.substring(41,42);
        command = e.charAt(0);
        next = null;
        right = null;
        left = null;
    }
    public String toString(){
        return " " + studentlastname + studentnum +"           "+ homedep +"               "+ program +"       "+ year + "\n";
    }
}