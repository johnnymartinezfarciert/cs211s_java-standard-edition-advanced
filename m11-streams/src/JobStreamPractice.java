import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.*;

public class JobStreamPractice {
    
    public static void main(String[] args) {

        List<Job> jobList = new ArrayList<>();
        fillList(jobList);
        
        //jobList.stream().limit(10).forEach(System.out::println);
        
        //jobList.stream().filter( job -> job.getDepartment().contains("Mayor")).forEach(System.out::println);

        // filtering jobs with compensation > 100000
        // map from Stream<Job> to Stream<String>- from Job to title
        /*
        jobList.stream().filter( job -> job.getTotalCompensation() > 100000) // filter creates a Stream<Job>
                    .map( job ->  job.getJobTitle() ) // map creates a Stream<String> 
                    .peek(jobTitleString -> System.out.println("in between mappings with " + jobTitleString))
                    .map( jobTitle -> { // map also creates another new Stream<String>
                        String formattedTitle = jobTitle.replace(" ", "");
                        if(formattedTitle.length()>8) {
                            formattedTitle = formattedTitle.substring(0,8);
                        }
                        return formattedTitle;
                    })
                    .forEach(System.out::println);
        */
        
        // sort the stream- but the original list (used to create the stream) remains unchanged
        /*
        jobList.stream().sorted().limit(5).forEach(System.out::println);
        for(int i=0; i<5; i++) {
            System.out.println(jobList.get(i));
        }
        */
        
        // look at the top 10 overtime jobs
        /*
        jobList.stream().sorted( (job1, job2) -> Integer.compare(job2.getOvertime(), job1.getOvertime()) )
                    .limit(10)
                    .forEach(System.out::println);
        */
        
        // sum up all the overtime
        // System.out.println("The total overtime being paid is " 
        //        + jobList.stream().mapToInt( Job::getOvertime ).sum()  );
        

        // find the job with the max compensation
        Job maxJob = jobList.stream()
                .max( (job1, job2) -> Integer.compare(job1.getTotalCompensation(), job2.getTotalCompensation()))
                //.get(); // only use if 100% sure the stream is not empty!
                .orElseThrow(NoSuchElementException::new);
        System.out.println("the max paying job is " + maxJob);
        
        // make a list of all jobs with overtime pay
        List<Job> overtimeJobList = jobList.stream()
                .filter(job -> job.getOvertime()>0)
                .collect(Collectors.toList());
        
        // a map of all jobs in the mayor's office- key is id, value is the job
        Map<String, Job> mayorJobMap = jobList.stream()
                .filter(job -> job.getDepartment().contains("Mayor"))
                .collect(Collectors.toMap(
                        Job::getEmpID, // key mapper
                        job -> job // value mapper
                ));
        
        // map of all jobs by department; key- the department, value- list of jobs
        Map<String, List<Job>> jobMapByDept = jobList.stream()
                .collect(Collectors.groupingBy(Job::getDepartment));
        
        // map of the sum of all salaries- key- the department, value- sum of all salaries
        Map<String, Integer> jobSalaryByDept = jobList.stream()
                .collect(Collectors.groupingBy( // this takes two parameters
                        job -> job.getDepartment(), // parameter 1- how to get the key
                        Collectors.summingInt( // parameter 2- how to get the value (which also takes a parameter)
                                job -> job.getSalary() // parameter to the summingInt method- a ToIntFunction object
                                // (which goes from type T to int
                                // could replace with Job::getSalary
                                )
                        
                        ));
        
        // map of the average salaries by department
        Map<String, Double> jobSalaryAverageByDept = jobList.stream()
                .collect(Collectors.groupingBy(
                       Job::getDepartment,
                       Collectors.averagingInt(Job::getSalary)));
        
        // finding the total benefits paid across all jobs
        int totalBenefitPay = jobList.stream()
                .reduce( 0, // identity
                        (total, job) -> total + job.getTotalBenefits(), // accumulator
                        (total1, total2) -> total1 + total2 // combiner
                        );
        totalBenefitPay = jobList.stream()
                .map(job -> job.getTotalBenefits() ) // returns a Stream<Integer>
                .reduce( (n1,n2) -> n1+n2 )
                .get();
        
        totalBenefitPay = jobList.stream()
                .mapToInt(Job::getTotalBenefits).sum();
        
        // find the stats about overtime pay
        IntSummaryStatistics overtimeStats = jobList.stream()
                .collect(Collectors.summarizingInt(job -> job.getOvertime()));
        System.out.println(overtimeStats.getMax());
        System.out.println(overtimeStats.getMin());
        System.out.println(overtimeStats.getAverage());
        
        
        
        
        
    }

    private static int fillList(List<Job> list) {
        int count = 0;
        try (Scanner fileScan = new Scanner(new FileReader(new File("Jobs.csv")))) {
            String line = fileScan.nextLine(); // column headers
            while (fileScan.hasNext()) {
                line = fileScan.nextLine();
                // this structure assumes perfectly formatted input data
                Scanner lineScan = new Scanner(line);
                lineScan.useDelimiter(",");
                String empId = lineScan.next();
                String department = lineScan.next();
                String jobFamily = lineScan.next();
                String job = lineScan.next();
                Integer salaries = lineScan.nextInt();
                Integer overtime = lineScan.nextInt();
                Integer totalBenefits = lineScan.nextInt();
                Integer compensation = lineScan.nextInt();
                Job eb = new Job(empId, department, jobFamily, job, salaries, overtime, totalBenefits, compensation);
                list.add(eb);
                count++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return count;
    }

}
