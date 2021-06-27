package cn.xdevops.designpatterns.iterator;

import java.util.Iterator;

public class Waitress {
    Menu pancakeHouseMenu;
    Menu dinerMenu;
    Menu cafeMenu;

    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.cafeMenu = cafeMenu;
    }

    public void printMenu() {
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinnerIterator = dinerMenu.createIterator();
        Iterator cafeIterator = cafeMenu.createIterator();

        System.out.println("MENU");
        System.out.println("----");
        System.out.println("BREAKFAST");
        printMenu(pancakeIterator);

        System.out.println();
        System.out.println("LUNCH");
        printMenu(dinnerIterator);

        System.out.println();
        System.out.println("DINNER");
        printMenu(cafeIterator);
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.println(String.format("%s, %.2f -- %s", menuItem.getName(), menuItem.getPrice(), menuItem.getDescription()));
        }
    }
}
