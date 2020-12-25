public class Eviction implements Comparable<Eviction> {
	
	private String id, address, zip, fileDate, neighborhood;
	
	enum EvictionCause {NON_PAYMENT, BREACH, NUISANCE, ILLEGAL_USE, FAILURE_TO_SIGN_RENEWAL,	ACCESS_DENIAL,
		UNAPPROVED_SUBTENANT,	OWNER_MOVE_IN,	DEMOLITION,	CAPITAL_IMPROVEMENT,	SUBSTANTIAL_REHAB,	ELLIS_ACT_WITHDRAWAL,
		CONDO_CONVERSION,	ROOMATE_SAME_UNIT,	OTHER_CAUSE,	LATE_PAYMENTS,	LEAD_REMEDIATION,	DEVELOPMENT,	CONSTRAINTS};
	
	private EvictionCause evictionCause;
	
	public Eviction(String id, String address, String zip, String fileDate, 
			String neighborhood, EvictionCause evictionCause){
		this.id = id;
		this.address = address;
		this.zip = zip;
		this.fileDate = fileDate;
		this.neighborhood = neighborhood;
		this.evictionCause = evictionCause;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getFileDate() {
		return fileDate;
	}

	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public EvictionCause getEvictionCause() {
		return evictionCause;
	}

	public void setEvictionCause(EvictionCause evictionCause) {
		this.evictionCause = evictionCause;
	}

	@Override
	public String toString() {
		return "ID: " + id 
				 + "\tNeighborhood: " + neighborhood
				+ "\t\tCause: " + evictionCause
				+ "\t\tAddress: " + address;
	}
	
	public int compareTo(Eviction otherEviction){
		return Integer.compare(Integer.valueOf(this.id), Integer.valueOf(otherEviction.id));
	}
}
