package callableItems;

public class TestCall implements CallableItemFunction, CallableItemDescription {
	public TestCall () {
		//
	}

	@Override
	public void call (String [] args) {
		System.out.println("Test Success");
	}

	@Override
	public String getDescription () {
		return "test good";
	}
}
