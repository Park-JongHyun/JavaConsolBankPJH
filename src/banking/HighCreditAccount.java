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
		
	}

	
	@Override
	public void depositMoney(int money) {
		save = save+(save*interest/100)+(save*extrainterest/100)+money;
		if (grade.equals("A")) this.extrainterest = addinterest.High;
		else if (grade.equals("B"))this.extrainterest = addinterest.Normal;
		else this.extrainterest = addinterest.Low;
	}
	
	@Override
	void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자 > "+ interest +"%");
		System.out.println("신용등급 > "+ grade.toUpperCase());
		
	}
}
