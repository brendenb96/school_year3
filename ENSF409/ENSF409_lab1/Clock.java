

class Clock{

    private static int day,hour,minute,second;              // Create private variables
    public Clock(int day,int hr,int min,int sec){           // Create Constructors for blank or input
        init(day,hr,min,sec);
    }
    public Clock(){
        init(0,0,0,0);
    }
    private void init(int day,int hr,int min,int sec){      // Used a helper function for Constructor
        this.day = day;
        this.hour = hr;
        this.minute = min;
        this.second = sec;        
    }
    public static void main(String[] args) {
// Create elapsed time with the default values of zeros for day, hour,
// minute and second.
Clock t1 = new Clock(); // Default constructor
// sets hour to 23
t1.setHour(23);
// sets day to 1
t1.setDay(1);
// sets minute to 59
t1.setMinute(59);
// sets day to 16
t1.setSecond(16);
// prints: 1:23:59:16
System.out.println(t1.getDay() + ":" + t1.getHour() +":" + t1.getMinute() + ":" + t1.getSecond());
// increments time t1 by 44 seconds:
t1.increment(44);
// prints: 2:0:0:0
System.out.println(t1.getDay() + ":" + t1.getHour() +":" +t1.getMinute() + ":" + t1.getSecond());
// prints the total elapsed time in seconds: 172,800
System.out.printf("The elapsed time in seconds is: %d \n", t1.calculateTotalSeconds());
// REPEAT SIMILAR TESTS FOR t2
 //Elapsed time is 3 days, 1 hour, 4 mins and 5 secs
Clock t2 = new Clock(3, 1, 4, 5);
System.out.println("Clock t2:");
System.out.println(t2.getDay() + ":" + t2.getHour() +":" + t2.getMinute() + ":" + t2.getSecond());
t2.increment(56);
System.out.println(t2.getDay() + ":" + t2.getHour() +":" + t2.getMinute() + ":" + t2.getSecond());
System.out.printf("The elapsed time for t2 in seconds is: %d \n", t2.calculateTotalSeconds());
}
    public int getDay(){        // Returns the day
        return this.day;
    }
    public int getHour(){       // Returns the hour
        return this.hour;
    }
    public int getMinute(){     // Returns the minute
        return this.minute;
    }
    public int getSecond(){     // Returns the Second
        return this.second;
    }
    public void setDay(int day){     // Sets day
        this.day = day;
    }
    public void setHour(int hr){
        if(hr>23||hr<0) System.err.println("Error in hour entry!");  // Error if hr is out of range
        else{
            this.hour = hr;                         // Set hour
        }
    }
    public void setMinute(int min){
        if(min>60||min<0) System.err.println("Error in minute entry!");  // Error if minute out of range
        else{
            this.minute = min;                      // Set minute
        }
    }
    public void setSecond(int sec){
        if(sec>60||sec<0) System.err.println("Error in seconds entry!");  // Error if seconds is out of range
        else{
            this.second = sec;                      // Set seconds
        }
    }
    public void increment(int sec){           // Increments the clock by sec seconds
        int new_sec = this.second + sec;      // Get total amount of seconds
        if(new_sec>=60){                      // If total seconds greater than 60 increase minute and find remaining time
            this.second = new_sec - 60;
            this.minute++;
        }
        if(this.minute>=60){                  // If total minutes greater than 60 increase hour and find remaining time
            this.minute = this.minute-60;
            this.hour++;
        }
        if(this.hour>=24){                    // If total hours greater than 24 increase day and find remaining time
            this.hour = this.hour-24;
            this.day++;
        }
    }
    public int calculateTotalSeconds(){        // Calculate total amount of seconds in the clock
        return ((this.day*24*60*60)+(this.hour*60*60)+(this.minute*60)+this.second);
    }

}