package app;

import io.github.humbleui.skija.Canvas;
import io.github.humbleui.skija.Paint;
import io.github.humbleui.skija.RRect;
import misc.*;

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
        Vector2i pointA = windowCS.getCoords(a, ownCS);
        Vector2i pointB = windowCS.getCoords(b, ownCS);
        Vector2i pointP = windowCS.getCoords(c, ownCS);

        // создаём линию
        Line line = new Line(new Vector2d(pointA), new Vector2d(pointB));
        // рассчитываем расстояние от прямой до точки
        double dist = line.getDistance(new Vector2d(pointP));
        // рассчитываем векторы для векторного умножения
        Vector2d AB = Vector2d.subtract(new Vector2d(pointB), new Vector2d(pointA));
        Vector2d AP = Vector2d.subtract(new Vector2d(pointP), new Vector2d(pointA));
        // определяем направление смещения
        double direction = Math.signum(AB.cross(AP));
        // получаем вектор смещения
        Vector2i offset = AB.rotated(Math.PI / 2 * direction).norm().mul(dist).intVector();

        // находим координаты вторых двух вершин прямоугольника
        Vector2i pointC = Vector2i.sum(pointB, offset);
        Vector2i pointD = Vector2i.sum(pointA, offset);

        // рисуем его стороны
        canvas.drawLine(pointA.x, pointA.y, pointB.x, pointB.y, p);
        canvas.drawLine(pointB.x, pointB.y, pointC.x, pointC.y, p);
        canvas.drawLine(pointC.x, pointC.y, pointD.x, pointD.y, p);
        canvas.drawLine(pointD.x, pointD.y, pointA.x, pointA.y, p);

        // сохраняем цвет рисования
        int paintColor = p.getColor();
        // задаём красный цвет
        p.setColor(Misc.getColor(200, 255, 0, 0));
        canvas.drawRRect(RRect.makeXYWH(pointA.x - 4, pointA.y - 4, 8, 8, 4), p);
        canvas.drawRRect(RRect.makeXYWH(pointB.x - 4, pointB.y - 4, 8, 8, 4), p);
        canvas.drawRRect(RRect.makeXYWH(pointP.x - 4, pointP.y - 4, 8, 8, 4), p);
        // восстанавливаем исходный цвет рисования
        p.setColor(paintColor);

    }


    public boolean contains(Vector2d p){
        return true;
    }

}
