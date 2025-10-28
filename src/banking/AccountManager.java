package banking;

import java.util.Scanner;

public class AccountManager {
	
	// 컨트롤 클래스로 프로그램의 전반적인 기능
	private Account[] accounts;
	private int numOfaccount;

	
	
	public AccountManager (int num) {
		accounts = new Account[num]; 
		numOfaccount = 0;
	}
	
	public void makeaccount(int choice) {
		
		String inum,iname;
		int imoney;
		
		System.out.println("***신규계좌개설***");
		System.out.print("계좌번호:"); inum = BankingSystemMain.scan.nextLine();
		System.out.print("고객이름:"); iname = BankingSystemMain.scan.nextLine();
		System.out.print("잔고:"); imoney = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		
		Account acc = new Account(inum, iname, imoney,0);
		accounts[numOfaccount++]=acc;
		
		System.out.println("계좌개설이 완료되었습니다.");
	}
	
	public void depositMoney() {
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		
		boolean isFind = false;
		System.out.print("계좌번호:");
		String searchnum = BankingSystemMain.scan.nextLine();
		for(int i=0; i<numOfaccount; i++) {
			if(searchnum.compareTo(accounts[i].num)==0) {
				isFind=true;
				
				System.out.print("입금액:");
				int money = BankingSystemMain.scan.nextInt();
				accounts[i].depositMoney(money);
				System.out.println("입금이 완료되었습니다");
			}
		}
	}
	
	public void withdrawMoney() {
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		
		boolean isFind = false;
		System.out.print("계좌번호:");
		String searchnum = BankingSystemMain.scan.nextLine();
		
		System.out.print("출금액:");
		int money = BankingSystemMain.scan.nextInt();
		
		for( int i = 0; i<numOfaccount; i++) {
			if(searchnum.compareTo(accounts[i].num)==0) {
				accounts[i].withdrawMoney(money);
				isFind = true;
				
				
			}
		}
		
		System.out.println("출금이 완료되었습니다.");
	}
	
	
	public void showAccInfo() {
		for(int i = 0; i<numOfaccount; i++) {
			accounts[i].showAccInfo();
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
}


