import java.util.Objects;

public class Job implements Comparable <Job> {
    
  private String empID;
  private String department;
  private String jobFamily;
  private String jobTitle;
  private int overtime;
  private int salary;
  private int totalBenefits;
  private int totalCompensation;


  public Job(String empID, String department, String jobFamily, String job) {
    this.empID = empID;
    this.department = department;
    this.jobFamily = jobFamily;
    this.jobTitle = job;
  }

  public Job(String empID, String department, String familyJob,
                           String job, int salary, int overtime,
                           int totalBenefits, int totalCompensation) {
    this.empID = empID;
    this.department = department;
    this.jobFamily = familyJob;
    this.jobTitle = job;
    this.salary = salary;
    this.overtime = overtime;
    this.totalBenefits = totalBenefits;
    this.totalCompensation = totalCompensation;
  }

  public String getEmpID() {
    return empID;
  }

  public void setEmpID(String empID) {
    this.empID = empID;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getJobFamily() {
    return jobFamily;
  }

  public void setJobFamily(String v) {
    this.jobFamily = jobFamily;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public int getOvertime() {
    return overtime;
  }

  public void setOvertime(int overtime) {
    this.overtime = overtime;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public int getTotalBenefits() {
    return totalBenefits;
  }

  public void setTotalBenefits(int totalBenefits) {
    this.totalBenefits = totalBenefits;
  }

  public int getTotalCompensation() {
    return totalCompensation;
  }

  public void setTotalCompensation(int totalCompensation) {
    this.totalCompensation = totalCompensation;
  }

  @Override
  public String toString() {
    return "ID: " + empID 
            +"\t\tDepartment: " + department 
            + "\t\tTitle: " + jobTitle 
            + "\t\tOvertime: " + overtime
            + "\t\tTotalComp: "+totalCompensation;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Job) {
        Job otherJob = (Job) obj;
        return empID.equalsIgnoreCase(otherJob.empID);
    } else {
        return false;
    }
  }


  @Override
  public int hashCode() {
    return Objects.hash(empID);
  }

  /*
  @Override
  public int compareTo(Job otherJob) {
    if(totalCompensation == otherJob.totalCompensation){
      if(salary==otherJob.salary){
        return empID.compareTo(otherJob.empID);
      }else{
        return Integer.compare(salary, otherJob.salary);
      }
    }else{
      return Integer.compare(totalCompensation,otherJob.totalCompensation);
    }
  }
  */
  @Override
  public int compareTo(Job otherJob) {
      return empID.compareTo(otherJob.empID);
  }
}
