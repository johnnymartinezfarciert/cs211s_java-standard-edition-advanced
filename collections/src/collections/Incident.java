package collections;


public class Incident implements Comparable<Incident> {
	private String dateTime;
	private String dayOfWeek, id, catagory, description, resolution, intersection, neighborhood;

	public Incident(String dateTime, String dayOfWeek, String id, String catagory, String description,
			String resolution) {
		this.dateTime = dateTime;
		this.dayOfWeek = dayOfWeek;
		this.id = id;
		this.catagory = catagory;
		this.description = description;
		this.resolution = resolution;
	}

	@Override
	public String toString() {
		return "Incident [dateTime=" + dateTime + ", dayOfWeek=" + dayOfWeek + ", id=" + id + ", catagory=" + catagory
				+ ", description=" + description + ", resolution=" + resolution + ", toString()=" + super.toString() + "]";
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Incident) {
			Incident other = (Incident) obj;
			return id.equals(other.id) && dateTime.equals(other.dateTime) && dayOfWeek.equals(other.dayOfWeek)
					&& catagory.equals(other.catagory) && description.equals(other.description)
					&& resolution.equals(other.resolution);
		} else {
			return false;
		}
	}
	
	// natural ordering is by ID
	@Override 
	public int compareTo(Incident otherIncident) {
		return id.compareTo(otherIncident.id);
	}

}
