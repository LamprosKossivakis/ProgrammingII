package com.company;

import com.company.Positive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;

//this is the simple testing method, I don't link it with the database, because I don't have the tables there yet =)  
public class TestPositive {

	//I have a problem with the Date here, i dont know in which format it works
	    Positive positive = new Positive("Sarah",2012-07-10);

	    @Test
	    public void testContructor() {

	        Assert.assertEquals("failure - wrong name", "Sarah", positive.getName());
	        Assert.assertEquals("failure - wrong Date of Birth", 2012-07-10, positive.getDateOfBirth());
	    }

	    @Test
	    public void testToString() {

	        String expected = "Positive patient's  name = " + positive.getName() + " ,Date of birth " + positive.getDateOfBirth() + " and id [" + positive.getID() +" ]"; 
	        Assert.assertEquals("failure - wrong to String", expected, positive.toString());
	    }

	    @After
	    public void tearDown() {
	        /* Not really needed */
	        positive = null;
	    }
	}
