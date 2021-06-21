package cn.xdevops.designpatterns.iterator;

import java.util.Iterator;

public class Waitress {
    Menu pancakeHouseMenu;
    Menu dinerMenu;

    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu() {
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinnerIterator = dinerMenu.createIterator();
        System.out.println("MENU");
        System.out.println("----");
        System.out.println("BREAKFAST");
        printMenu(pancakeIterator);

        System.out.println();
        System.out.println("LUNCH");
        printMenu(dinnerIterator);
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.println(String.format("%s, %.2f -- %s", menuItem.getName(), menuItem.getPrice(), menuItem.getDescription()));
        }
    }
}
