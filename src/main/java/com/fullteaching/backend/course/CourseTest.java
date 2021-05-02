package com.fullteaching.backend.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.coursedetails.CourseDetails;
import com.fullteaching.backend.forum.Forum;
import com.fullteaching.backend.session.Session;
import com.fullteaching.backend.user.User;

public class CourseTest {

	public Course course;
    public Course course1;
    public Course course2;
    public Course course3;
    
    public User teacher;
    public User teacher1;
    
    public User attender;
    public User attender1;
    
    public CourseDetails cd1;
    
    public Session s1;
    public Session s2;
    
    public Forum f;
    
    @BeforeEach
    public void setup() {
        teacher = new User("Simone","password", "sisi", "", "");
    	teacher1 = new User("Maria","123456", "mariazinha", "", "");
        
    	attender = new User("Camila","1234", "cami", "", "");
        attender1 = new User("Malu","222", "malu", "", "");
        
        
        cd1 = new CourseDetails(course);
        cd1.setId(11);
        
        s1 = new Session("Se��o1","Esta � a se��o 1", 1619126959);
        s2 = new Session("Se��o2","Esta � a se��o 2", 1849126959);        
    
        course = new Course("Qualidade e Teste", "qEt", teacher, cd1);
    	course1 = new Course("Metaheuristica", "meta", teacher1);
    	course2 = new Course("Governancia de TI", "govTI", teacher1);
    	course3 = new Course();
    	//os id's dos cursos nao sao inicializados, assim todos os cursos quando criado tem o id=0
    	course1.setId(1);
    	course2.setId(2);
		course3.setId(3);
		
		f = new Forum();
		
    }

    @Test
    public void testGetTitle() {
        String title = course.getTitle();
        assertEquals("Qualidade e Teste", title);
    }
    
    @Test
    public void testSetTitle() {
    	String title = "Metaheuristica I";
    	course1.setTitle(title);
    	assertEquals("Metaheuristica I", course1.getTitle());
    }
    
    @Test
    public void testGetImage() {
    	String img = course1.getImage();
    	assertEquals("meta", course1.getImage());
	}

	@Test
    public void testSetImage() {
		String img = "gvti";
		course2.setImage(img);
		assertEquals(img, course2.getImage());
	}

	@Test
	public void testGetTeacher() {
		User teacher = course.getTeacher();
		assertEquals(teacher, course.getTeacher());
	}

	@Test
	public void testSetTeacher() {
		User teacher3 = new User("Cintia","1212", "cindy", "", "");
		course2.setTeacher(teacher3);
		assertEquals(teacher3, course2.getTeacher());
	}

	@Test
	public void testGetCourseDetails() {
		CourseDetails cd = course.getCourseDetails();
		assertEquals(cd, course.getCourseDetails());
	}

	@Test
	public void testSetCourseDetails() {
		CourseDetails cd2 = new CourseDetails();
		course.setCourseDetails(cd2);
		assertEquals(cd2, course.getCourseDetails());
	}

	@Test
	public void testGetAttenders() {
		Set<User> lsUsers;
        lsUsers = new HashSet<User>();
        lsUsers.add(attender);
        lsUsers.add(attender1);
        course.setAttenders(lsUsers);
        assertIterableEquals(lsUsers, course.getAttenders());
	}

	@Test
	public void testSetAttenders() {
		Set<User> lsUsers;
        lsUsers = new HashSet<User>();
        lsUsers.add(attender);
        lsUsers.add(attender1);
        course.setAttenders(lsUsers);
        assertIterableEquals(lsUsers, course.getAttenders());
	}

	@Test
	public void testGetSessions() {
		Set<Session> lsSessions;
        lsSessions = new HashSet<Session>();
        lsSessions.add(s1);
        lsSessions.add(s2);
        course.setSessions(lsSessions);
        assertIterableEquals(lsSessions, course.getSessions());
	}

	@Test
	public void testSetSessions() {
		Set<Session> lsSessions;
        lsSessions = new HashSet<Session>();
        lsSessions.add(s1);
        course.setSessions(lsSessions);
        assertIterableEquals(lsSessions, course.getSessions());
	}
	
	@Test
   	public void testToString() { 
		Assertions.assertEquals("Course[title: \"Governancia de TI\", teacher: \"mariazinha\", #attenders: 0, #sessions: 0]", course2.toString(), "SAO DIFERENTES!");
		
	}
	
	@Test
	public void testEqualsIdentic() {
		System.out.println("1");
		boolean str = course2.equals(course2);
		assertTrue(str);
	}
	 
	@Test
	public void testEqualsNull() {
		System.out.println("2");
		boolean str = course3.equals(null);
		assertFalse(str);
	}
	
	@Test
	public void testEqualsDifferentClass() {
		System.out.println("3");
		boolean str = course2.equals(cd1);
		assertFalse(str);
	}
	
	@Test
	public void testEqualsDifferentCourses() {
		System.out.println("4");
		boolean id = course.equals(course1);
		assertEquals(false, id);
	}
}