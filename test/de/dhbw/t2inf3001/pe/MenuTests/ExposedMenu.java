package de.dhbw.t2inf3001.pe.MenuTests;

import de.dhbw.t2inf3001.pe.Menu.IMenu;
import de.dhbw.t2inf3001.pe.Menu.Menu;

public class ExposedMenu extends Menu {
    public static IMenu getMenu() {
        return currentMenu;
    }
}
