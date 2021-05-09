package com.fullteaching.backend.comment;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.user.User;


public class CommentTest {

    public Comment comentario;
    public Comment comentario2;
    public User usuario;
    public User usuario2;

    @BeforeEach
    public void setup() {

    	
        usuario = mock(User.class);
        usuario2 = mock(User.class);
        comentario= new Comment("message", 1619126959, usuario);
        comentario2= new Comment("message", 1849126959, usuario2, comentario);
    }

    @Test
    public void testGetMensagem() {
        String msg = comentario.getMessage();
        assertEquals("message", msg);
    }

    @Test
    public void testSetMensagem() {
    	String msg = "new Message";
    	comentario.setMessage(msg);
    	assertEquals("new Message", comentario.getMessage());
    }
    
    @Test
    public void testGetDate() {
    	long date = comentario.getDate();
    	assertEquals(1619126959, date);
    	
    }
    
    @Test 
    public void testSetDate() {
    	long date = 1619131461;
    	comentario.setDate(date);
    	assertEquals(1619131461,comentario.getDate());
    }
    
    @Test
    public void testGetReplies() {
       	List listaComentario = new ArrayList<Comment>();
    	listaComentario.add(comentario);
    	listaComentario.add(comentario2);
    	comentario.setReplies(listaComentario);
    	//Arrays.deepEquals(listaComentario, comentario.getReplies());
    	//assertIterableEquals(listaComentario, comentario.getReplies());
    	List comReplies = comentario.getReplies();
       	assertTrue(listaComentario.equals(comReplies));
    }
    
    @Test
    public void testSetReplies() {
    	List listaComentario = new ArrayList<Comment>();
    	listaComentario.add(comentario);
    	listaComentario.add(comentario2);
    	comentario.setReplies(listaComentario);
    	//Arrays.deepEquals(listaComentario, comentario.getReplies());
    	//assertIterableEquals(listaComentario, comentario.getReplies());
    	List comReplies = comentario.getReplies();
       	assertTrue(listaComentario.equals(comReplies));
    }
    
    @Test
	public void testGetUser() {
    	assertEquals(usuario, comentario.getUser());
	}
	
    @Test
	public void testSetUser() {
    	comentario.setUser(usuario2);
    	assertEquals(usuario2, comentario.getUser());
    }
    
   	@Test 
   	public void testGetCommentParent() { 
   		Assertions.assertEquals(comentario, comentario2.getCommentParent());
   	}
   	
   	@Test
   	public void testSetCommentParent() {
   		Comment resp = new Comment("Resposta da menssagem", 134565359, usuario);
   		comentario2.setCommentParent(resp);
   		Assertions.assertEquals(resp, comentario2.getCommentParent());
   	}
   	
   	@Test
   	public void testToString() { 
   		Assertions.assertEquals("Comment[message: \"message\", author: \"null\", parent: \"message\", #replies: 0date: \"1849126959\"]", comentario2.toString(), "S�O DIFERENTES!");
   	}
   	
}