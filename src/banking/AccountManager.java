package banking;

import java.util.InputMismatchException;
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
		
		String inum,iname,grade;
		int isave,interest;
		
		System.out.println("***신규계좌개설***");
		System.out.print("계좌번호:"); inum = BankingSystemMain.scan.nextLine();
		System.out.print("고객이름:"); iname = BankingSystemMain.scan.nextLine();
		System.out.print("잔고:"); isave = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		
		if(choice ==1) {
			System.out.print("기본이자%(정수형태로입력): ");interest = BankingSystemMain.scan.nextInt();
			BankingSystemMain.scan.nextLine();//버퍼처리
			NormalAccount nlacnt = new NormalAccount(inum,iname,isave,interest);
			accounts[numOfaccount++]=nlacnt;
		}
		else if(choice ==2) {
			System.out.print("기본이자%(정수형태로입력): ");interest = BankingSystemMain.scan.nextInt();
			BankingSystemMain.scan.nextLine();
			System.out.print("신용등급(A,B,C 등급): ");grade = BankingSystemMain.scan.nextLine();
			
			HighCreditAccount hcacnt = new HighCreditAccount(inum, iname, grade, isave, interest);
			accounts[numOfaccount++]= hcacnt;
		}
		
		System.out.println("계좌개설이 완료되었습니다.\n");
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
				
				try {
				System.out.print("입금액:");
				int money = BankingSystemMain.scan.nextInt();
				
					if (money<0) {
						System.out.println("음수는 입금이 불가능합니다.");
						return;
					}
					else if (money % 500 != 0) {
						System.out.println("500원 단위로 입금가능함");
						return;
					}
					accounts[i].depositMoney(money);
					System.out.println("입금이 완료되었습니다.\n");
					}
				catch(InputMismatchException e){
					System.out.println("문자는 입력할 수 없습니다.");
					BankingSystemMain.scan.nextLine();
					}
			}
		}
	}
		
	public void withdrawMoney() {
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		
		boolean isFind = false;
		System.out.print("계좌번호:");
		String searchnum = BankingSystemMain.scan.nextLine();
		
		
		for( int i = 0; i<numOfaccount; i++) {
			if(searchnum.compareTo(accounts[i].num)==0) {
				try {
					System.out.print("출금액:");
					int money = BankingSystemMain.scan.nextInt();
					if(money<0) {
						System.out.println("음수는 출금이 불가능합니다.");
						return;
					}
					else if (money % 1000 != 0) {
						System.out.println("1000단위로 출금 가능합니다");
						return;
					}
					
					else if (accounts[i].save<money) {
						System.out.println("잔고 부족. 금액전체를 출금할까요?(y or n)");
		                char choice = BankingSystemMain.scan.next().charAt(0);
		                if(choice == 'Y' || choice == 'y') {
		                    money = accounts[i].save; 
		                } 
		                else {
		                    System.out.println("출금 취소");
		                    return;
		                }
					}
					accounts[i].withdrawMoney(money);
					isFind = true;
				}
				catch(InputMismatchException e){
					System.out.println("문자는 입력할 수 없습니다.");
					BankingSystemMain.scan.nextLine();
				}
			}
		}
		
		System.out.println("출금이 완료되었습니다.\n");
	}
	
	
	public void showAccInfo() {
		System.out.println("***계좌정보출력***");
		for(int i = 0; i<numOfaccount; i++) {
			accounts[i].showAccInfo();
		}
		System.out.println("-------------");
		System.out.println("전체계좌정보 출력이 완료되었습니다.\n");
	}
}


