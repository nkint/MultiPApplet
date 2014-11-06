

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import controlP5.ControlP5;


public class MultiPApplet extends PApplet {
	//-------------------------------------------------------- boiler plate
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		PApplet.main(new String[] { "MultiPApplet" });
	}
	
	public MultiPApplet() {
	}

	//-------------------------------------------------------- globals
	
	private ControlP5 cp5;
	private List<WidgetContainer> widgets = new ArrayList<WidgetContainer>();
	private int def = 0;

	//-------------------------------------------------------- widget manager
	
	private synchronized void addWidget(Class<?> class1, int x, int y) {
		String s = getTitle(class1);
		WidgetContainer _w = getWidgetByTitle(s);
		if(_w==null) {
			
			try {
				wait(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			_w = new WidgetContainer(class1, x, y);
			if ( _w.isDone() ) {
				widgets.add(_w);
			}
		}
		_w.setVisible(true);
	}
	
	public WidgetContainer getWidgetByTitle(String s) {
		for(WidgetContainer w : this.widgets) {
			if(w.getTitle()==s) {
				return w;
			}
		}
		return null;
	}
	
	private String getTitle(Class<?> widgetPApplet) {
		String title = "";
		try {
			title = (String) widgetPApplet.getField("title").get(null);
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
			System.out.println("The Widget class need a static field called 'title'");
			System.exit(-1);
		}
		return title;
	}

	//-------------------------------------------------------- gui handler
	public void widget1(boolean n) {
		addWidget(Widget1.class, 0, 0);
	}
	
	public void widget2(boolean n) {
		addWidget(Widget2.class, 0, 0);
	}

	//-------------------------------------------------------- PApplet
	
	public void setup() {
		
		size(150, 300);
		frame.setLocation(0, 0);
		
		cp5 = new ControlP5(this);

		cp5.addButton("widget1").setWidth(130);
		cp5.addButton("widget2").setWidth(130);
		
		addWidget(Widget1.class, 150, 0);
	}

	public void draw() {
		background(def);
	}
}
