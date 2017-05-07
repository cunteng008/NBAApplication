package model;

public class Arena {
	
	String name;
	String start_end;
	String location;
	int capacity;
	
	public Arena(String name){
		this.name = name;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStart_end() {
		return start_end;
	}

	public void setStart_end(String start_end) {
		this.start_end = start_end;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
