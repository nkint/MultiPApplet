

import processing.core.PApplet;

public abstract class Widget extends PApplet {
	private static final long serialVersionUID = 1L;
	protected Object parent;

	@SuppressWarnings("unused")
	private Widget() {
	}

	public Widget(Object theParent) {
		parent = theParent;
	}
	
}
