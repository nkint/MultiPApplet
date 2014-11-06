

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;

public class WidgetContainer {
	protected Widget p;
	protected JFrame f;
	private boolean done = false;
	private Class<?> pappletClass;
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;
	private String theName = "";

	public WidgetContainer(Class<?> pappletClass, int x, int y) {
		this.pappletClass = pappletClass;
		this.x = x;
		this.y = y;
		
		_init1();
		done = true;
	}
	
	private synchronized void _init1() {
		getName(); 
		getWidth();
		getHeight();
		getCtor();
		
		w();
		addPappletToFrame();
		
		w();
		p.init();
		
		w();
	}

	private void getCtor() {
		f = new JFrame(theName);
		Constructor<?> ctor;
		try {
			ctor = pappletClass.getConstructor(java.lang.Object.class);
			try {
				p = (Widget) ctor.newInstance(new Object[] {this});
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
				return;
			}
		} catch (NoSuchMethodException | SecurityException e1) {
			e1.printStackTrace();
			System.out.println("The Widget class need a constructor 'Object'");
			return;
		}
	}

	private void getHeight() {
		this.height = 100;
		try {
			height = (int) pappletClass.getField("h").get(null);
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e2) {
			e2.printStackTrace();
			System.out.println("The Widget class need a static field called 'h'");
			return;
		}
	}

	private void getWidth() {
		this. width = 100;
		try {
			width = (int) pappletClass.getField("w").get(null);
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e2) {
			e2.printStackTrace();
			System.out.println("The Widget class need a static field called 'w'");
			return;
		}
	}

	private void getName() {
		this.theName = "";
		try {
			theName = (String) pappletClass.getField("title").get(null);
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e2) {
			e2.printStackTrace();
			System.out.println("The Widget class need a static field called 'title'");
			return;
		}
	}

	private synchronized void w() {
		try {
			wait(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private synchronized void addPappletToFrame() {
		f.add(p);
		f.setTitle(theName);
		f.setSize(width, height);
		f.setLocation(x, y);
		f.setResizable(false);
		f.setVisible(true);
	}
	
	public synchronized boolean isDone() {
		return done;
	}

	public String getTitle() {
		return f.getTitle();
	}

	public void setVisible(boolean b) {
		f.setVisible(b);
		//p.setup() ?? maybe something else like p.update
	}
}
