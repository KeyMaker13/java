package networksimulation;

public interface EventHandler {

  // return an initial event or null
  public abstract Event initialEvent();

  // process this event, returning a new event or null
  public abstract Event processEvent(Event event);
}
