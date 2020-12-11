package com.company;

import com.company.Negative;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;

public class TestNegative {
	
	 Negative negative = new Negative("Jack",2001-06-13);

	    @Test
	    public void testContructor() {

	        Assert.assertEquals("failure - wrong name", "Jack", negative.getName());
	        Assert.assertEquals("failure - wrong Date of Birth", 2012-07-10, negative.getDateOfBirth());
	    }

	     @Test
	    public void testToString() {

	        String expected = "Positive patient's  name = " + negative.getName() + " ,Date of birth " + negative.getDateOfBirth() + " and id [" + negative.getID() +" ]"; 
	        Assert.assertEquals("failure - wrong to String", expected, negative.toString());
	    }

	          
	    @After
	    public void tearDown() {
	        /* Not really needed */
	        negative = null;
	    }
	}



