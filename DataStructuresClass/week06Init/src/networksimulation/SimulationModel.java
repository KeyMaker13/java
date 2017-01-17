package networksimulation;

import queues.*;
import lib.*;
import java.util.*;

public class SimulationModel {
  private SetADT<EventHandler> handlerSet;
  private PriorityQueueADT<Event> eventSet;
  private double currentTime;
  private int numberEvents;
  private boolean started;
  private boolean stopped;
  private String title;
  private boolean debug;

  public SimulationModel(String title) {
    currentTime = 0.0;
    eventSet = new LinkedPriorityQueue<Event> ();
    handlerSet = new ArraySet<EventHandler> ();
    numberEvents = 0;
    this.title = title;
    started = false;
    stopped = false;
  }

  public final void addEvent(Event e) {
    if (e != null) {
      if (debug) {
        System.out.println("Adding " + e);
      }
      eventSet.add(e);
    }
  }

  public final void addHandler(EventHandler h) {
    handlerSet.add(h);
  }

  public final int getEvents() {
    return numberEvents;
  }

  public final double getTime() {
    return currentTime;
  }

  public final String getTitle() {
    return title;
  }

  public final void setStopped() {
    stopped = true;
  }

  public final void setDebug(boolean debug) {
    this.debug = debug;
  }

  public void initializeEvents() {
    Iterator<EventHandler> scan = handlerSet.iterator();
    while (scan.hasNext()) {
      addEvent(scan.next().initialEvent());
    }
  }

  public void processEvent(Event e) {
    if (debug) {
      System.out.println("Processing " + e);
    }
    if (e.getWhat() == Event.STOP) {
      setStopped();
    } else {
      Iterator<EventHandler> scan = handlerSet.iterator();
      while (scan.hasNext()) {
        addEvent(scan.next().processEvent(e));
      }
    }
  }

  final public void runSimulation(double stoppingTime) {
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

  public String toString() {
    String result = title + ": Time = " + currentTime
        + ", Events = " + numberEvents;
    Iterator<EventHandler> scan = handlerSet.iterator();
    while (scan.hasNext()) {
      result += "\n" + scan.next().toString();
    }
    return result;
  }
}
