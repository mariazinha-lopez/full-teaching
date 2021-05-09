package com.fullteaching.backend.coursedetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.filegroup.FileGroup;
import com.fullteaching.backend.forum.Forum;
import com.fullteaching.backend.user.User;

public class CourseDetailsTest {
	
		public User teacher;
		public User teacher1;
		public User teacher2;
		
		public Course course;
		public Course course1;
		public Course course2;
		
		public Forum forum;
		public Forum forum1;
		
		public FileGroup fg;
		public FileGroup fg1;
		public FileGroup fg2;
		
		public CourseDetails cd;
		public CourseDetails cd1;
		public CourseDetails cd2;
		
	    @BeforeEach
	    public void setup() {
	        teacher = new User("Simone","password", "sisi", "", "");
	    	teacher1 = new User("Maria","123456", "mariazinha", "", "");
	    	teacher2 = new User("Dolores","123", "dolores", "", "");
	    			
	        course = new Course("Qualidade e Teste", "qEt", teacher, cd);
	    	course1 = new Course("Metaheuristica", "meta", teacher1, cd1);
	    	course2 = new Course("Governancia de TI", "govTI", teacher2, cd2);
	    	//os id's dos cursos nao sao inicializados, assim todos os cursos quando criado tem o id=0
	    	course1.setId(1);
	    	course2.setId(2);
			
	    	forum = new Forum(true);
	    	forum1 = new Forum(false);
	    	
	    	fg = new FileGroup("fileGroup_0");
	    	fg1 = new FileGroup("fileGroup_1");
	    	fg2 = new FileGroup("fileGroup_2");
	    	
	    	cd = new CourseDetails(course);
	    	cd.setId(10);
	    	cd1 = new CourseDetails(course1);
	        cd1.setId(11);
	        cd2 = new CourseDetails(course2);
	        cd2.setId(12);
			
	    }

	    @Test
	    public void testGetId() {
	    	assertEquals(10, cd.getId());
	    }
	    
	    @Test
	    public void testSetId() {
	    	cd.setId(22);
	    	assertEquals(22, cd.getId()); 
	    	
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
	    	cd.setForum(forum);
	    	Forum f = cd.getForum();
	    	assertTrue(f.isActivated());
	    }
	    
	    @Test
	    public void testSetForum() {
	    	cd.setForum(forum1);
	    	Forum f = cd.getForum();
	    	assertFalse(f.isActivated());
	    }
	    
	    @Test
	    public void testGetFiles() {
	    	List listFile = new ArrayList<FileGroup>();
	    	listFile.add(fg);
	    	listFile.add(fg1);
	    	cd.setFiles(listFile);
	    	List cdFiles = cd.getFiles();
	       	assertTrue(listFile.equals(cdFiles));
	    }
	    
	    @Test
	    public void testGetCourse() {
	    	assertEquals(course1, cd1.getCourse());
	    }
	    
	    @Test
	    public void testSetCourse() {
	    	cd2.setCourse(course);
	    	assertEquals(course, cd2.getCourse());
	    }
	    
	   }
