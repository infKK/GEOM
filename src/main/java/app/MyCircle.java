package app;

import io.github.humbleui.skija.Canvas;
import io.github.humbleui.skija.Paint;
import io.github.humbleui.skija.RRect;
import misc.*;

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
            points[i * 4 + 1] = (float) (center.y + radY * Math.sin(Math.PI / 20 * i));

            // x координата второй точки
            points[i * 4 + 2] = (float) (center.x + radX * Math.cos(Math.PI / 20 * (i + 1)));
            // y координата второй точки
            points[i * 4 + 3] = (float) (center.y + radY * Math.sin(Math.PI / 20 * (i + 1)));
        }
        // рисуем линии
        canvas.drawLines(points, p);


        // сохраняем цвет рисования
        int paintColor = p.getColor();
        // задаём красный цвет
        p.setColor(Misc.getColor(200, 255, 0, 0));
        canvas.drawRRect(RRect.makeXYWH(center.x - 4, center.y - 4, 8, 8, 4), p);
        canvas.drawRRect(RRect.makeXYWH(b.x - 4, b.y - 4, 8, 8, 4), p);
        // восстанавливаем исходный цвет рисования
        p.setColor(paintColor);


    }

    public boolean contains(Vector2d p){
        if ((a1.x- p.x)*(a1.x- p.x) + (a1.y- p.y)*(a1.y- p.y) <= (a1.x- b1.x)*(a1.x- b1.x) + (a1.y- b1.y)*(a1.y- b1.y)){
            return true;
        } else{
            return  false;
        }

    }}

