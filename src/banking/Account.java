package banking;

public class Account {
	
	public String num;//계좌번호
	public String name;//고객이름
	public int save;//잔고
	public int amount;//입/출금액
	
	
	public Account(String num, String name,int save,int amount) {
		this.num = num;
		this.name = name;
		this.save = save;
		this.amount = amount;
	}
	
	void showAccInfo() {
		System.out.println("***계좌정보출력***");
		System.out.println("-------------\n");
		System.out.println("계좌번호 : "+ num);
		System.out.println("고객이름 : "+ name);
		System.out.println("잔고 : "+ save);
		System.out.println("-------------\n");
		}
	
	void depositMoney(int amount) {
		save+=amount;
//		System.out.println("계좌번호:"+num);
//		System.out.println("입금액:"+amount);
//		System.out.println("잔고:"+save);
	}

	void withdrawMoney(int amount) {
		save-=amount;
//		System.out.println("계좌번호:"+num);
//		System.out.println("출금액:"+amount);
//		System.out.println("잔고:"+save);
	}

	

	
	
	//계좌정보 표현 클래스(부모클래스)
	}


