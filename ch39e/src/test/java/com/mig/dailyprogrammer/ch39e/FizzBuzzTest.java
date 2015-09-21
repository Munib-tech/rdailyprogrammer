package com.mig.dailyprogrammer.ch39e;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mramos on 9/21/2015.
 */
public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void setup(){
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void testCheckFizzBuzzRange() throws Exception {
        assertThat(fizzBuzz.isFizzOrBuzz(3),  is("Fizz"));
        assertThat(fizzBuzz.isFizzOrBuzz(5),  is("Buzz"));
        assertThat(fizzBuzz.isFizzOrBuzz(15), is("FizzBuzz"));
        assertThat(fizzBuzz.isFizzOrBuzz(7),  is("7"));
    }
}