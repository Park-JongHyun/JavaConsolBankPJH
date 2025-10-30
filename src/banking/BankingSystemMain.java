package banking;

import java.util.Scanner;

public class BankingSystemMain {

	public static Scanner scan = new Scanner(System.in);
	
	// 메인 메서드. 프로그램을 실행하는 클래스
	public static void showMenu() {	
	System.out.println("-----Menu-----");
	System.out.println("1.계좌개설");
	System.out.println("2.입 금");
	System.out.println("3.출 금");
	System.out.println("4.계좌정보출력");
	System.out.println("5.프로그램종료"); 
	System.out.print("선택:");
	}
	
public static void main(String[] args) {
	AccountManager manager = new AccountManager(50);
	
	while(true) {
		showMenu();
		
		int choice; 
		
		try {
	        choice = MenuSelectException.selectMenu();  
	    } catch (MenuSelectException e) {
	    	
	        continue;
	    }
	
		switch(choice) {
		case menu.Makeaccount:
			System.out.println("***신규계좌개설***");
			System.out.println("-----계좌선택-----");
			System.out.println("1.보통계좌");
			System.out.println("2.신용신뢰계좌");
			System.out.print("선택:");
			int accounttype = scan.nextInt();
			scan.nextLine();
			
			manager.makeaccount(accounttype);
			break;
		case menu.Deposit:
			manager.depositMoney();
			break;
		case menu.Withdraw:
			manager.withdrawMoney();
			break;
		case menu.Info:
			manager.showAccInfo();
			break;
		case menu.End:
			System.out.println("프로그램종료");
			return;
		}
		}
	}
}





















