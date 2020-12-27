package shop;

import shop.exception.InvalidParametersException;
import shop.service.customer.menu.CustomersMenu;
import shop.service.product.menu.ProductsMenu;
import shop.service.shop.menu.ShopMenu;
import shop.service.staff.menu.StaffMenu;
import shop.service.user.menu.UserMenu;

import java.io.IOException;
import java.util.Scanner;

import static shop.util.constants.Constants.INVALID_NUMBER;

public class Menu {


    public static void main(String[] args) throws InvalidParametersException, IOException {
        boolean isUser = UserMenu.userMenu();
        if (isUser) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome in General Menu \n");
            System.out.println("Please choose menu type");
            System.out.println("________________________");
            System.out.println("1. Staff Menu");
            System.out.println("2. Product Menu");
            System.out.println("3. Customer Menu");
            System.out.println("4. Shop Menu");
            System.out.println("5. If you want to exit press 0");

            boolean t = true;
            while (t) {
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        StaffMenu.staffMenu();
                        break;

                    case 2:
                        ProductsMenu.productsMenu();
                        break;

                    case 3:
                        CustomersMenu.customerMenu();
                        break;
                    case 4:
                        ShopMenu.shopMenu();
                        break;

                    case 0:
                        System.out.println("You are exiting from Menu");
                        t = false;
                        break;

                    default:
                        System.out.println(INVALID_NUMBER);

                }
            }

        }
    }
}

