package com.fullteaching.backend.entry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.comment.Comment;
import com.fullteaching.backend.user.User;

public class EntryTest {

	public User teacher;
	public User teacher1;
	public Comment comentario;
	public Comment comentario1;
	public Entry e1;
	
	@BeforeEach
    public void setup() {
		teacher = new User("Simone","password", "sisi", "", "");
		teacher1 = new User("Maria","123", "mari", "", "");
    	
    	comentario= new Comment("message", 1619126959, teacher);
        comentario1= new Comment("message", 1849126959, teacher1, comentario);
        
        e1 = new Entry("title Entry", 1619126959, teacher);
	}
	
	@Test
	public void testGetId() {
		assertEquals(0, e1.getId());
	}
	
	@Test
	public void testSetId() {
		e1.setId(2);
		assertEquals(2, e1.getId());
	}
	
	@Test
	public void testGetTitle() {
		assertEquals("title Entry", e1.getTitle());
	}
	
	@Test
	public void testSetTitle() {
		e1.setTitle("Title");
		assertEquals("Title", e1.getTitle());
	}
	
	@Test
	public void testGetDate() {
		assertEquals(1619126959, e1.getDate());
	}
	
	@Test
	public void testSetDate() {
		e1.setDate(1119692259);
		assertEquals(1119692259, e1.getDate());
	}
	
	@Test
	public void testGetComments() {
		List lsComentarios = new ArrayList<Comment>();
		lsComentarios.add(comentario);
		lsComentarios.add(comentario1);
    	e1.setComments(lsComentarios);
    	List comentarios = e1.getComments();
       	assertTrue(lsComentarios.equals(comentarios));
	}
	
	@Test
	public void testSetComments() {
		List lsComentarios = new ArrayList<Comment>();
		lsComentarios.add(comentario);
		lsComentarios.add(comentario1);
    	e1.setComments(lsComentarios);
    	List comentarios = e1.getComments();
       	assertTrue(lsComentarios.equals(comentarios));
	}
	
	@Test
	public void testGetUser() {
		User user = e1.getUser();
		assertEquals("sisi", user.getNickName());
	}
	
	@Test
	public void testSetUser() {
		e1.setUser(teacher1);
		User user = e1.getUser();
		assertEquals("mari", user.getNickName());
	}
	
	@Test
	public void testToString() {
		Assertions.assertEquals("Entry[title: \"title Entry\", author: \"sisi\", date: 1619126959, #comments: 0]", e1.toString(), "S�O DIFERENTES!");
	}
}
