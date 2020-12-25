import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class CourseTest {
	
	private Student s1, s2, s3;
	private Course course;
	
	@BeforeEach
	public void setUp() {
		course = new Course("Java");
		s1 = new Student("Sally Studier");
		s2 = new Student("Pat Procrastinator");
		s3 = new Student("Alan AsksALot");
	}

	
	@Test
	public void addingStudentToEmptyCourseAltersTheCourse() {
		boolean result = course.addStudent(s1);
		List<Student> studentList = new ArrayList<>(course.getStudents());
		
		assertTrue(result);
		assertTrue(studentList.contains(s1));
		assertEquals(1, studentList.size());
	}
	

	@Test 
	public void addingStudentToNonEmptyCourseAltersTheCourse() {
	    course.addStudent(s1);
	    course.addStudent(s2);
        List<Student> originalStudentList = new ArrayList<>(course.getStudents());
        boolean result = course.addStudent(s3);
        List<Student> modifiedStudentList =  new ArrayList<>(course.getStudents());
        
        assertTrue(result);
        assertTrue(modifiedStudentList.contains(s3));
        assertEquals(originalStudentList.size()+1, modifiedStudentList.size());
	}
	

    @Test
    public void addingDuplicateStudentDoesNotChangeTheCourse() {
        course.addStudent(s1);
        course.addStudent(s2);
        List<Student> originalStudentList = new ArrayList<>(course.getStudents());
        boolean result = course.addStudent(s1);
        List<Student> modifiedStudentList = new ArrayList<>(course.getStudents());
        
        assertTrue(modifiedStudentList.contains(s1));
        assertEquals(originalStudentList.size(), modifiedStudentList.size());
        assertFalse(result);
        
    }

	@Test
	public void removingStudentFromEmptyDoesNotChangeTheCourse() {
		boolean result = course.removeStudent(s1);
		List<Student> studentList = new ArrayList<>(course.getStudents());
		
		assertNotNull(studentList);
		assertTrue(studentList.isEmpty());
		assertFalse(result);
	}
	    

	@Test
    public void removingEnrolledStudentAltersTheCourse() {
        course.addStudent(s1);
        course.addStudent(s2);
        List<Student> originalStudentList = new ArrayList<>(course.getStudents());     
	    boolean result = course.removeStudent(s1);
        List<Student> modifiedStudentList = new ArrayList<>(course.getStudents());	    
        
        assertNotNull(modifiedStudentList);
        assertFalse(modifiedStudentList.contains(s1));
        assertTrue(modifiedStudentList.contains(s2));
        assertEquals(originalStudentList.size()-1, modifiedStudentList.size());
        assertFalse(modifiedStudentList.isEmpty());
        assertTrue(result);
    }	
	

    @Test
    public void removingUnenrolledStudentDoesNotChangeTheCourse() {
        course.addStudent(s1);
        course.addStudent(s2);
        List<Student> originalStudentList = new ArrayList<>(course.getStudents());
        boolean result = course.removeStudent(s3);
        List<Student> modifiedStudentList = new ArrayList<>(course.getStudents());

        assertNotNull(modifiedStudentList);
        assertFalse(modifiedStudentList.isEmpty());
        assertFalse(modifiedStudentList.contains(s3));
        assertTrue(modifiedStudentList.contains(s1));
        assertEquals(originalStudentList.size(), modifiedStudentList.size());
        assertFalse(result);
    }

}
