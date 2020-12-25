
public enum Status {

		ACTIVE("AC"),
		INACTIVE_TEMP("InTemp"),
		INACTIVE_PERM("InPerm");
		
		private String abbreviation;
		
		private Status(String abbreviation) {
			this.abbreviation = abbreviation;
		}
		public String getAbbreviation() { return abbreviation; }

}
