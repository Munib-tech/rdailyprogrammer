package com.mig.dailyprogrammer.ch228e;

import com.mig.dailyprogrammer.ch228e.LettersInAlphabeticalOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by mramos on 9/21/2015.
 */
public class LettersInAlphabeticalOrderTest {

    private LettersInAlphabeticalOrder order;

    @Before
    public void setup(){
        order = new LettersInAlphabeticalOrder();
    }

    @Test
    public void testIsOrdered() throws Exception {
        assertThat(order.isOrdered("abcDEF"),  is(true));
    }

    @Test
    public void testIsOrderedReverse() throws Exception {
        assertThat(order.isOrdered("FEDcba", Comparator.<String>reverseOrder()),  is(true));
    }

    @Test
    public void testCheckWordsOrderWithFormat() throws Exception {
        assertThat(order.checkWordsOrderWithFormat("abc"),  is("IN ORDER"));
        assertThat(order.checkWordsOrderWithFormat("cba"),  is("REVERSE ORDER"));
        assertThat(order.checkWordsOrderWithFormat("xya"),  is("NOT IN ORDER"));
    }
}