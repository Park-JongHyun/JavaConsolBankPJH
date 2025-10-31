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
	
	@Override
	public int hashCode() {
		return this.num.hashCode();}
		
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if (!(obj instanceof Account)) return false;
		Account ac = (Account) obj;
		return this.num != null && this.num.equals(ac.num);
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
	
	void deleteaccount() {
		
	}
}
//계좌정보 표현 클래스(부모클래스)
