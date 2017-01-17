import java.io.*;

class  RepairPerson {
	RepairPerson(Name name, Location location) {
		this.name = name;
		this.location = location;
	}
	Name getName() { 
		return name; 
	}
	void moveTo(Location location) { 
		this.location = location; 
	}
	public static RepairPerson read(BufferedReader br) throws Exception {
		Name name = Name.read(br);
		if (name == null)
			return null;
		Location location = Location.read(br);
		if (location == null)
			return null;
		return new RepairPerson(name,location);
	}
	   int getDistanceFrom(Location location) {
		   return location.distanceFrom(this.location);
	   }
	
	private Name name;
	private Location location;
}
