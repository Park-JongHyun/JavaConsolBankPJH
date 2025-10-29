package banking;

public class HighCreditAccount extends Account {
	String grade;
	int interest;
	private int extrainterest;

	public HighCreditAccount(
			String num, String name, String grade, int save,int interest) {
		super(num, name, save);
		this.interest = interest;
		this.grade = grade;
		
		grade = grade.toUpperCase();
		
		if (grade.equals("A")) this.extrainterest = 7;
		else if (grade.equals("B"))this.extrainterest = 4;
		else this.extrainterest = 2;
	}

	
	@Override
	public void depositMoney(int money) {
		save = save+(save*interest/100)+(save*extrainterest/100)+money;
	}
	
	@Override
	void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자 > "+ interest +"%");
		System.out.println("신용등급 > "+ grade.toUpperCase());
		
	}
}
