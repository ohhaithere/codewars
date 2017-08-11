package com.frostmaster.Katas.Bagels;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BagelTest {

    @Test
    public void testBagel() {
        Bagel bagel = BagelSolver.getBagel();

        assertEquals(
                bagel.getValue() == 4,
                Boolean.TRUE
        );
    }

}