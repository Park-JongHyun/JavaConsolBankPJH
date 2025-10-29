package banking;

public abstract class Account {
	
	public String num;//계좌번호
	public String name;//고객이름
	public int save;//잔고
	
	
	
	public Account(String num, String name,int save) {
		this.num = num;
		this.name = name;
		this.save = save;
		
	}
	
	void showAccInfo() {
		
		System.out.println("-------------");
		System.out.println("계좌번호 > "+ num);
		System.out.println("고객이름 > "+ name);
		System.out.println("잔고 > "+ save);
		}

	void depositMoney(int money) {
		save+=money;
	}

	
	void withdrawMoney(int money) {
		save-=money;
	}
}
//계좌정보 표현 클래스(부모클래스)
