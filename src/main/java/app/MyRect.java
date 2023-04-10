package app;

import io.github.humbleui.skija.Canvas;
import io.github.humbleui.skija.Paint;
import misc.CoordinateSystem2d;
import misc.CoordinateSystem2i;
import misc.Vector2d;

public class MyRect {
    Vector2d a;
    Vector2d b;
    Vector2d c;

    public MyRect(Vector2d a, Vector2d b, Vector2d c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }



    public void paint(Canvas canvas, CoordinateSystem2i windowCS, CoordinateSystem2d ownCS, Paint p){

    }
}
