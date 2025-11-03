package banking;

public class NormalAccount extends Account{ 
	int interest;
	
	public NormalAccount(String num, String name, int save, int interest) {
		super(num, name, save);
		this.interest = interest;
	}

	@Override//계좌 상속
	public void depositMoney(int money) {
		save += (save*interest/100) ;
		save += money ;
		}
	
	@Override
	void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자 > "+interest+"%");
		
	}
}