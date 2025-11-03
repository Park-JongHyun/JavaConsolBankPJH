package banking;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;


public class AccountManager {
	
	
	private HashSet<Account> accountsSet = new HashSet<>();
	public AccountManager() {
	}//컬렉션을 통한 해시셋

	
	public void makeaccount() {
		
		System.out.println("***신규계좌개설***");
		System.out.println("-----계좌선택-----");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		System.out.print("선택:");
		int choice = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		
		
		String inum,iname,grade;
		int isave,interest;
		
		System.out.print("계좌번호:"); inum = BankingSystemMain.scan.nextLine();
		System.out.print("고객이름:"); iname = BankingSystemMain.scan.nextLine();
		System.out.print("잔고:"); isave = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		
		Account newAcc = null;
		
		if(choice ==1) {
			System.out.print("기본이자%(정수형태로입력): ");interest = BankingSystemMain.scan.nextInt();
			BankingSystemMain.scan.nextLine();//버퍼처리
			 newAcc = new NormalAccount(inum, iname, isave, interest);//1번계좌-보통계좌
		}
		else if(choice ==2) {
			System.out.print("기본이자%(정수형태로입력): ");interest = BankingSystemMain.scan.nextInt();
			BankingSystemMain.scan.nextLine();
			System.out.print("신용등급(A,B,C 등급): ");grade = BankingSystemMain.scan.nextLine();
			newAcc = new HighCreditAccount(inum, iname, grade, isave, interest);//2번계좌-신용계좌
		}
		
		if (accountsSet.contains(newAcc)) {
	        System.out.print("중복계좌 발견됨. 덮어쓸까요? (y or n): ");
	        char ch = BankingSystemMain.scan.next().charAt(0);
	        BankingSystemMain.scan.nextLine(); // 버퍼 처리
	        if (ch == 'y' || ch == 'Y') {
	            accountsSet.remove(newAcc); // 기존 계좌 삭제
	            accountsSet.add(newAcc);    // 새 계좌 추가
	            System.out.println("새로운 정보로 갱신되었습니다.");
	        } else {
	            System.out.println("취소되었습니다.");
	        }
	    } else {
	        accountsSet.add(newAcc);//중복계좌처리
		
	        System.out.println("계좌개설이 완료되었습니다.");
	        }
	}

	
	public void depositMoney() {
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		
		boolean isFind = false;
		System.out.print("계좌번호:");
		String searchnum = BankingSystemMain.scan.nextLine();
		for(Account acc : accountsSet) {
			if(acc.num.equals(searchnum)) {
				isFind=true;
				
				try {
				System.out.print("입금액:");
				int money = BankingSystemMain.scan.nextInt();
				BankingSystemMain.scan.nextLine();
				
					if (money<0) {
						System.out.println("음수는 입금이 불가능합니다.");
						return;
					}
					else if (money % 500 != 0) {
						System.out.println("500원 단위로 입금가능함");
						return;
					}//예외
					acc.depositMoney(money);
					System.out.println("입금이 완료되었습니다.\n");
					}
				catch(InputMismatchException e){
					System.out.println("문자는 입력할 수 없습니다.");
					BankingSystemMain.scan.nextLine();
					}//예외
			}
		}
	}
		
	public void withdrawMoney() {
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		
		boolean isFind = false;
		System.out.print("계좌번호:");
		String searchnum = BankingSystemMain.scan.nextLine();
		
		
		for(Account acc : accountsSet) {
			if(acc.num.equals(searchnum)) {
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
					}//예외
					
					else if (acc.save<money) {
						System.out.println("잔고 부족. 금액전체를 출금할까요?(y or n)");
		                char choice = BankingSystemMain.scan.next().charAt(0);
		                if(choice == 'Y' || choice == 'y') {
		                    money = acc.save; 
		                } 
		                else {
		                    System.out.println("출금 취소");
		                    return;
		                }
					}
					acc.withdrawMoney(money);
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
		for(Account acc : accountsSet) {
			acc.showAccInfo();
		}
		System.out.println("-------------");
		System.out.println("전체계좌정보 출력이 완료되었습니다.\n");
	}
	
	
	
	public void deleteaccount(){
		System.out.println("***계좌정보 삭제***");
		System.out.print("삭제할 계좌 번호를 입력하세요\n계좌번호: ");
		String num  = BankingSystemMain.scan.nextLine();
		
		Account dummy = new NormalAccount(num, "", 0, 0);

		
		if (accountsSet.remove(dummy)) {
			System.out.println("계좌가 삭제되었습니다.");
		}
		else {
		System.out.println("일치하는 계좌가 없습니다.");
		}
	}
}
	

