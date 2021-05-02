package com.fullteaching.backend.coursedetails;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.session.Session;
import com.fullteaching.backend.user.User;

public class CourseDetailsTest {
	
		public CourseDetails cd;
		public CourseDetails cd1;
		public CourseDetails cd2;
		
		public User teacher;
		public User teacher1;
		public User teacher2;
		
		public Course course;
		public Course course1;
		public Course course2;
		
	    @BeforeEach
	    public void setup() {
	        teacher = new User("Simone","password", "sisi", "", "");
	    	teacher1 = new User("Maria","123456", "mariazinha", "", "");
	    	teacher2 = new User("Dolores","123", "dolores", "", "");
	    			
	        course = new Course("Qualidade e Teste", "qEt", teacher, cd1);
	    	course1 = new Course("Metaheuristica", "meta", teacher1);
	    	course2 = new Course("Governancia de TI", "govTI", teacher2);
	    	//os id's dos cursos nao sao inicializados, assim todos os cursos quando criado tem o id=0
	    	course1.setId(1);
	    	course2.setId(2);
			
	    	cd = new CourseDetails(course);
	    	cd.setId(10);
	    	cd1 = new CourseDetails(course1);
	        cd1.setId(11);
	        cd2 = new CourseDetails(course2);
	        cd2.setId(12);
			
	    }

	    @Test
	    public void testGetInfo() {
	        String info = cd.getInfo();
	        assertEquals("", info);
	    }
	    
	    @Test
	    public void testSetInfo() {
	    	String info = "Course of Metaheuristica";
	    	cd.setInfo(info);
	    	assertEquals("Course of Metaheuristica", cd.getInfo());
	    }
	    
	    @Test
	    public void testGetForum() {
	    	
	    }
	    
	    @Test
	    public void testSetForum() {
	    	
	    }
}
