package banking;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MenuSelectException extends Exception {

    public MenuSelectException() {
        super("메뉴 입력 예외 발생됨");
    }


    public static int selectMenu() throws MenuSelectException {
        Scanner scan = BankingSystemMain.scan; 
        
        String line ;
        int choice;

        line = scan.nextLine();
        try {
        	choice = Integer.parseInt(line);
            
        } catch (NumberFormatException e) {
        	System.out.println("메뉴 입력 예외 발생됨");
        	System.out.println("메뉴는 1~5사이의 정수를 입력하세요");
            throw new MenuSelectException();
        }

        
        if (choice < 1 || choice > 5) {
        	System.out.println("메뉴 입력 예외 발생됨");
        	System.out.println("메뉴는 1~5사이의 정수를 입력하세요");
            throw new MenuSelectException();
        }

        return choice;
    }//메뉴 예외처리
}
