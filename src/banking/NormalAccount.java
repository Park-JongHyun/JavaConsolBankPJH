package banking;

public class NormalAccount extends Account{ 

	public NormalAccount(String num, String name, int save, int interestRate) {
		super(num, name, save,0);
	}

	@Override
	public void depositMoney(int amount) {
		super.depositMoney(amount);
		save = save + (int) ((save*0.02) + amount) ;
		}
	
	
	public static void main(String[] args) {
	
	}
}