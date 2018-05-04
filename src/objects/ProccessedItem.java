package objects;

import callableItems.CallableItemDescription;
import callableItems.CallableItemFunction;

public class ProccessedItem extends InteractiveItem {
	private CallableItemFunction func;
	private CallableItemDescription desc = null;

	public ProccessedItem (String name, CallableItemDescription d, CallableItemFunction f) {
		super(name);
		func = f;
		desc = d;
	}

	public ProccessedItem (String name, CallableItemFunction f) {
		super(name);
		func = f;
	}

	public ProccessedItem (String name, String description, CallableItemFunction f) {
		super(name, description);
		func = f;
	}

	public void call (String [] args) {
		func.call(args);
	}

	@Override
	public String getDescription () {
		try {
			return desc.getDescription();
		} catch (Exception e) {
			e.printStackTrace();
			return super.getDescription();
		}
	}
}
