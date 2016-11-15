# test
public class Test {
	public static void main(String[] args) {

		Bill b = new CurrentBill();
		b.doReading();
		b.doBill();
		

		b = new WaterBill();
		b.doReading();
		b.doBill();
		
	}
}
