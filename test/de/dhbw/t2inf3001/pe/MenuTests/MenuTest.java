package de.dhbw.t2inf3001.pe.MenuTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.dhbw.t2inf3001.pe.Menu.Menu;

public class MenuTest {
    @Test
    public void testMenuTextPrint(){
        Menu.setMenu(new TestMenu());
        assertEquals("TESTMENU", Menu.getMenuString());
    }
}
