package com.fullteaching.backend.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
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
    public CourseDetails cd2;
    
    public Session s1;
    public Session s2;
    
    public Forum f;
    
    @BeforeEach
    public void setup() {
    	teacher = mock(User.class);
        teacher1 = mock(User.class); 
        
        attender = mock(User.class);
        attender1 = mock(User.class);
        
        cd1 = mock(CourseDetails.class);
        cd2 = mock(CourseDetails.class);
        
        s1 = mock(Session.class);
        s2 = mock(Session.class);
        
        course = new Course("Qualidade e Teste", "qEt", teacher, cd1);
    	course1 = new Course("Metaheuristica", "meta", teacher1);
    	course2 = new Course("Governancia de TI", "govTI", teacher1);
    	course3 = new Course();
    	//os id's dos cursos nao sao inicializados, assim todos os cursos quando criado tem o id=0
    	course1.setId(1);
    	course2.setId(2);
		course3.setId(3);
		
		f = mock(Forum.class);
		
    }
    
    @Test
	public void testGetId() {
		assertEquals(0, course.getId());
	}
	
	@Test
	public void testSetId() {
		course.setId(2);
		assertEquals(2, course.getId());
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
		assertEquals(teacher, course.getTeacher());
	}

	@Test
	public void testSetTeacher() {
		course2.setTeacher(teacher);
		assertEquals(teacher, course2.getTeacher());
	}

	@Test
	public void testGetCourseDetails() {
		assertEquals(cd1, course.getCourseDetails());
	}

	@Test
	public void testSetCourseDetails() {
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
        Set<User> courseAttenders = course.getAttenders();
       	assertTrue(lsUsers.equals(courseAttenders));
        //assertIterableEquals(lsUsers, course.getAttenders());
	}

	@Test
	public void testSetAttenders() {
		Set<User> lsUsers;
        lsUsers = new HashSet<User>();
        lsUsers.add(attender);
        lsUsers.add(attender1);
        course.setAttenders(lsUsers);
        Set<User> courseAttenders = course.getAttenders();
       	assertTrue(lsUsers.equals(courseAttenders));
        //assertIterableEquals(lsUsers, course.getAttenders());
	}

	@Test
	public void testGetSessions() {
		Set<Session> lsSessions;
        lsSessions = new HashSet<Session>();
        lsSessions.add(s1);
        lsSessions.add(s2);
        course.setSessions(lsSessions);
        Set<Session> courseSessions = course.getSessions();
       	assertTrue(lsSessions.equals(courseSessions));
        //assertIterableEquals(lsSessions, course.getSessions());
	}

	@Test
	public void testSetSessions() {
		Set<Session> lsSessions;
        lsSessions = new HashSet<Session>();
        lsSessions.add(s1);
        course.setSessions(lsSessions);
        Set<Session> courseSessions = course.getSessions();
       	assertTrue(lsSessions.equals(courseSessions));
        //assertIterableEquals(lsSessions, course.getSessions());
	}
	
	@Test
   	public void testToString() { 
		Assertions.assertEquals("Course[title: \"Governancia de TI\", teacher: \"null\", #attenders: 0, #sessions: 0]", course2.toString(), "SAO DIFERENTES!");
		
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