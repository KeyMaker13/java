package networksimulation;
import queues.*;

public class SingleIncoming {
  private double currentTime;
  private PriorityQueueADT<Event> eventSet;
  private int numberMessages;
  private int numberEvents;
  private String title;
  public boolean started;
  private boolean stopped;
  private IncomingLine inLine;

  public SingleIncoming(String title, double arrival) {
    currentTime = 0.0;
    eventSet = new LinkedPriorityQueue<Event>();
    numberMessages = 0;
    numberEvents = 0;
    this.title = title;
    started = false;
    stopped = false;
    inLine = new IncomingLine(1, arrival, 2);
  }

  public void addEvent(Event e) {
    eventSet.add(e);
  }

  public int getMessages() {
    return numberMessages;
  }

  public int getEvents() {
    return numberEvents;
  }

  public double getTime() {
    return currentTime;
  }

  public String getTitle() {
    return title;
  }

  public void initializeEvents() {
    addEvent(inLine.getNextArrival());
  }

  public void processEvent(Event e) {
    switch (e.getWhat()) {
      case Event.MSG_ARRIVAL:
        addEvent(inLine.getNextArrival());
        numberMessages++;
        break;
      case Event.STOP:
        setStopped();
        break;
      default:
        System.err.println(e + " {unrecognized event}");
        break;
    }
  }

  public void setStopped() {
    stopped = true;
  }

  public void runSimulation(double stoppingTime) {
    if (!started) {
      initializeEvents();
      started = true;
    }
    addEvent(new Event(0, Event.STOP, stoppingTime, 0));
    stopped = false;
    while (!stopped && !eventSet.isEmpty()) {
      Event e = eventSet.removeMin();
      numberEvents++;
      currentTime = e.getWhen();
      processEvent(e);
    }
  }
}
