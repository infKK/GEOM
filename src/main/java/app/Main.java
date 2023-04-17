package app;

import io.github.humbleui.jwm.App;
import misc.Vector2d;
import misc.Vector2i;

public class Main {


    public static void main(String[] args) {
        Vector2d v = new Vector2d(1.5, 2.1);

        Vector2i vi = v.intVector();


        App.start(Application::new);
    }

}