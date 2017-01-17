package networksimulation;

public class Event
    implements Comparable {
  public static final int STOP = 0;
  public static final int MSG_ARRIVAL = 1; // message arrived at router
  public static final int MSG_ROUTE = 2; // message assigned to outgoing line
  public static final int MSG_SENT = 3; // message sent by outgoing line

  private int who; // Who did it
  private int what; // What they did
  private double when; // When they did it
  private int whom; // Whom is it for

  public Event(int who, int what, double when, int whom) {
    this.who = who;
    this.what = what;
    this.when = when;
    this.whom = whom;
  }

  public int getWho() {
    return who;
  }

  public int getWhat() {
    return what;
  }

  public double getWhen() {
    return when;
  }

  public int getWhom() {
    return whom;
  }

  public int compareTo(Object obj) {
    Event e = (Event) obj;
    double timeDifference = when - e.when;
    if (timeDifference < 0) {
      return -1;
    }
    else if (timeDifference > 0) {
      return 1;
    }
    // if equal times, make STOP last
    if (what == STOP && e.what != STOP)
      return 1;
    else if (what != STOP && e.what == STOP)
      return -1;
    return 0;
  }

  public String toString() {
    return getClass().getName() + "[Who:" + who + ", What:" + what
        + ", When:" + when + ", Whom:" + whom + "]";
  }
}
