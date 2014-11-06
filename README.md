MultiPApplet
============

A structured trial in opening multiple PApplet safely.

Note
====

The project is done with Eclipse. Eclipse save the projects with absolute path in the project config file so there will be some errors when the project is imported.
Add all .jar files inside the `lib/` folder as build path.

Current error
=============

- Launch MultiPApplet.java file as Java Application. There will be 2 window: the main one (MultiPApplet) and the second one (Widget1, with red-background).
- On the first one, click on Widget2 button and open the green widget (the class Widget2).
- If no exception raised, close everything and do it again.

On approximately 3 runs there will be raised this exception:

```
Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException
    at processing.opengl.PJOGL.syncBackTexture(PJOGL.java:597)
    at processing.opengl.PGraphicsOpenGL.beginPixelsOp(PGraphicsOpenGL.java:1829)
    at processing.opengl.PGraphicsOpenGL.readPixels(PGraphicsOpenGL.java:5438)
    at processing.opengl.PGraphicsOpenGL.saveSurfaceToPixels(PGraphicsOpenGL.java:5428)
    at processing.opengl.PGraphicsOpenGL.endDraw(PGraphicsOpenGL.java:1693)
    at processing.core.PApplet.handleDraw(PApplet.java:2326)
    at processing.opengl.PJOGL$PGLListener.display(PJOGL.java:862)
    at jogamp.opengl.GLDrawableHelper.displayImpl(GLDrawableHelper.java:652)
    at jogamp.opengl.GLDrawableHelper.display(GLDrawableHelper.java:636)
    at javax.media.opengl.awt.GLCanvas$10.run(GLCanvas.java:1284)
    at jogamp.opengl.GLDrawableHelper.invokeGLImpl(GLDrawableHelper.java:1106)
    at jogamp.opengl.GLDrawableHelper.invokeGL(GLDrawableHelper.java:981)
    at javax.media.opengl.awt.GLCanvas$11.run(GLCanvas.java:1295)
    at javax.media.opengl.Threading.invoke(Threading.java:193)
    at javax.media.opengl.awt.GLCanvas.display(GLCanvas.java:541)
    at javax.media.opengl.awt.GLCanvas.paint(GLCanvas.java:595)
    at sun.awt.RepaintArea.paintComponent(RepaintArea.java:264)
    at sun.lwawt.LWRepaintArea.paintComponent(LWRepaintArea.java:59)
    at sun.awt.RepaintArea.paint(RepaintArea.java:240)
    at sun.lwawt.LWComponentPeer.handleJavaPaintEvent(LWComponentPeer.java:1312)
    at sun.lwawt.LWComponentPeer.handleEvent(LWComponentPeer.java:1196)
    at java.awt.Component.dispatchEventImpl(Component.java:4959)
    at java.awt.Component.dispatchEvent(Component.java:4705)
    at java.awt.EventQueue.dispatchEventImpl(EventQueue.java:746)
    at java.awt.EventQueue.access$400(EventQueue.java:97)
    at java.awt.EventQueue$3.run(EventQueue.java:697)
    at java.awt.EventQueue$3.run(EventQueue.java:691)
    at java.security.AccessController.doPrivileged(Native Method)
    at java.security.ProtectionDomain$1.doIntersectionPrivilege(ProtectionDomain.java:75)
    at java.security.ProtectionDomain$1.doIntersectionPrivilege(ProtectionDomain.java:86)
    at java.awt.EventQueue$4.run(EventQueue.java:719)
    at java.awt.EventQueue$4.run(EventQueue.java:717)
    at java.security.AccessController.doPrivileged(Native Method)
    at java.security.ProtectionDomain$1.doIntersectionPrivilege(ProtectionDomain.java:75)
    at java.awt.EventQueue.dispatchEvent(EventQueue.java:716)
    at java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:201)
    at java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:116)
    at java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:105)
    at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
    at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:93)
    at java.awt.EventDispatchThread.run(EventDispatchThread.java:82)
```
