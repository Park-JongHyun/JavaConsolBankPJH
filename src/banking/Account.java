package banking;

public class Account {
	
	public String num;
	public String name;
	public int save;
	public int money;
	
	
	public Account(String num, String name,int save) {
		this.num = num;
		this.name = name;
		this.save = save;
	}
	
	void showAccInfo() {
		System.out.println("***계좌정보출력***");
		System.out.println("-------------\n");
		System.out.println("계좌번호 : "+ num);
		System.out.println("고객이름 : "+ name);
		System.out.println("잔고 : "+ save);
		System.out.println("-------------\n");
		}
	
	void depositMoney() {
		System.out.println("계좌번호:"+num);
		System.out.println("입금액:"+money);
		System.out.println("잔고:"+save+money);
	}

	void withdrawMoney() {
		
	}
	
	//계좌정보 표현 클래스(부모클래스)
	}


