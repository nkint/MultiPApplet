import controlP5.ControlP5;
import peasy.PeasyCam;
import processing.core.PApplet;

public class Widget2 extends Widget {

	//-------------------------------------------------------- boilerplate 

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		PApplet.main(new String[] { "MultiPApplet" });
	}

	public static String title = "widget2";
	public static int w = 700;
	public static int h = 700;
	private PeasyCam cam;
	private ControlP5 cp5;

	public Widget2(Object theParent) {
		super(theParent);
		
		System.out.println("Widget2");
	}

	//-------------------------------------------------------- PApplet

	@Override
	public void setup() {
		size(w, h, P3D);
		smooth();

		this.cam = new PeasyCam(this, 600);
		this.cam.setMaximumDistance(10001);
		this.cam.setMinimumDistance(1);
		this.cam.lookAt(0, 0, 0);

		this.cp5 = new ControlP5(this);
		cp5.setAutoDraw(false);
		cp5.addButton("foo");
	}

	@Override
	public void draw() {
		background(0, 100, 0);
		drawHUD();
		box(100);
	}

	private void drawHUD() {
		cam.beginHUD();
		cp5.draw();
		cam.endHUD();
	}
}
