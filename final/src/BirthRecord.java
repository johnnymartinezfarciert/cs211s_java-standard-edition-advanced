import java.time.*;

public class BirthRecord {
	public enum Gender {
		MALE("male"), FEMALE("female");

		private String display;
		private Gender(String display) {
			this.display = display;
		}
		@Override
    	public String toString() {
    		return this.display;
    	}
	};

    private String name;
    private LocalDate birthDate;
    private double weight, height;
    private int apgarScore; // a numeric score that summarizes the health of a newborn
    private Gender gender;
    private boolean multiple; // true if baby was born as part of twins, triplets, etc. and false otherwise
    
    public BirthRecord(String name, LocalDate birthday, double weight, double height, int apgarScore, boolean multiple, Gender gender) {
        this.name = name;
        this.birthDate = birthday;
        this.weight = weight;
        this.height = height;
        this.apgarScore = apgarScore;
        this.multiple = multiple;
        this.gender = gender;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }

   
    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getApgarScore() {
    	return apgarScore;
    }

	@Override
	public String toString() {
		return name + " (" + gender + ") born:" + birthDate + " at " + weight + "lbs and " + height + "inches;"
				+ " apgar=" + apgarScore + " multiple=" + multiple;
	}
    
   
}