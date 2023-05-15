import app.MyCircle;
import app.MyRect;
import app.Task;
import misc.CoordinateSystem2d;
import misc.Vector2d;

import java.util.ArrayList;

public class Test {

    @org.junit.Test
    public void test1() {
        MyCircle myCircle = new MyCircle(new Vector2d(0, 0), new Vector2d(1, 1));
        assert myCircle.contains(new Vector2d(0.5, 0.5));
        assert !myCircle.contains(new Vector2d(1.5, 1.5));
    }

    @org.junit.Test
    public void test2() {
        MyCircle myCircle = new MyCircle(new Vector2d(0, 0), new Vector2d(2, 2));
        assert myCircle.contains(new Vector2d(0.5, 0.5));
        assert !myCircle.contains(new Vector2d(2.5, 1.5));
    }
    @org.junit.Test
    public void test3() {
        MyCircle myCircle = new MyCircle(new Vector2d(1, 0), new Vector2d(4, 3));
        assert myCircle.contains(new Vector2d(0, 0.5));
        assert !myCircle.contains(new Vector2d(5, 5));
    }
    @org.junit.Test
    public void test4() {
        MyRect myRect = new MyRect(new Vector2d(0, 0), new Vector2d(2, 0), new Vector2d(1, 3));
        assert myRect.contains(new Vector2d(1, 2));
        assert !myRect.contains(new Vector2d(2.5, 4));
    }
    @org.junit.Test
    public void test5() {
        MyRect myRect = new MyRect(new Vector2d(0, 0), new Vector2d(3, 0), new Vector2d(1, 3));
        assert myRect.contains(new Vector2d(1, 2));
        assert !myRect.contains(new Vector2d(7, 1.3));
    }
    @org.junit.Test
    public void test6() {
        MyRect myRect = new MyRect(new Vector2d(0, 0), new Vector2d(7, 0), new Vector2d(1, 3));
        assert myRect.contains(new Vector2d(1, 2));
        assert !myRect.contains(new Vector2d(8.6, 4));
    }


    public void test7() {
        ArrayList<MyCircle> circles = new ArrayList<>();
        circles.add(new MyCircle(new Vector2d(0, 0), new Vector2d(1, 1)));
        circles.add(new MyCircle(new Vector2d(0.5, 0.5), new Vector2d(1, 1)));
        ArrayList<MyRect> rects = new ArrayList<>();
        rects.add(new MyRect(new Vector2d(0, 0), new Vector2d(1, 1), new Vector2d(-1, 1)));
        rects.add(new MyRect(new Vector2d(0.5, 0.5), new Vector2d(1, 1), new Vector2d(2, 0)));
        Task task = new Task(new CoordinateSystem2d(0, 0, 10, 10), rects, circles);
        task.solve();

        MyRect myRect = task.resR;
        MyCircle myCircle = task.resC;
        assert myRect.a.x == 0.1;

        // ожидаем координаты вершины a [0.1, 0.2]
        assert Math.abs(myRect.a.x - 0.1) < 0.001 && Math.abs(myRect.a.y - 0.2) < 0.001;

    }
}
