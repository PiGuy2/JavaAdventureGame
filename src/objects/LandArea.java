package objects;

import java.util.ArrayList;

public class LandArea {
	private ArrayList<Item> itemsInArea = new ArrayList<>();

	public LandArea () {
		itemsInArea.add(new BackgroundItem("", ""));
	}
}
