package app;

import io.github.humbleui.skija.Canvas;
import io.github.humbleui.skija.Paint;
import misc.CoordinateSystem2d;
import misc.CoordinateSystem2i;
import misc.Vector2d;
import misc.Vector2i;

public class MyCircle {
    Vector2d a1;
    Vector2d b1;

    public MyCircle(Vector2d a1, Vector2d b1) {
        this.a1 = a1;
        this.b1 = b1;
    }


    public void paint(Canvas canvas, CoordinateSystem2i windowCS, CoordinateSystem2d ownCS, Paint p) {
        // центр окружности
        Vector2i center = windowCS.getCoords(a1, ownCS);
        Vector2i b = windowCS.getCoords(b1, ownCS);
        int rad = (int) Math.sqrt((center.x - b.x) * (center.x - b.x) + (center.y - b.y) * (center.y - b.y));

        // радиус вдоль оси x
        int radX = rad;
        int radY = rad;

        // кол-во отсчётов цикла
        int loopCnt = 40;
        // создаём массив координат опорных точек
        float[] points = new float[loopCnt * 4];
        // запускаем цикл
        for (int i = 0; i < loopCnt; i++) {
            // x координата первой точки
            points[i * 4] = (float) (center.x + radX * Math.cos(Math.PI / 20 * i));
            // y координата первой точки
            points[i * 4 + 1] = (float) (center.x + radY * Math.sin(Math.PI / 20 * i));

            // x координата второй точки
            points[i * 4 + 2] = (float) (center.x + radX * Math.cos(Math.PI / 20 * (i + 1)));
            // y координата второй точки
            points[i * 4 + 3] = (float) (center.x + radY * Math.sin(Math.PI / 20 * (i + 1)));
        }
        // рисуем линии
        canvas.drawLines(points, p);

    }
}

