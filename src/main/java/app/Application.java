package app;

import io.github.humbleui.jwm.App;
import io.github.humbleui.jwm.Event;
import io.github.humbleui.jwm.Platform;
import io.github.humbleui.jwm.Window;

import java.io.File;
import java.util.function.Consumer;

import static io.github.humbleui.jwm.Platform.WINDOWS;

public class Application implements Consumer<Event> {
    // окно приложения
    private final Window window;

    // конструктор приложения
    public Application() {
        // создаём окно
        window = App.makeWindow();
        // задаём обработчиком событий текущий объект
        window.setEventListener(this);
        // делаем окно видимым
        window.setVisible(true);
        window.setTitle("Java 2D");
        // задаём размер окна
        window.setWindowSize(900, 900);
// задаём его положение
        window.setWindowPosition(100, 100);
        // задаём иконку
        switch (Platform.CURRENT) {
            case WINDOWS -> window.setIcon(new File("src/main/resources/windows.ico"));
            case MACOS -> window.setIcon(new File("src/main/resources/macos.icns"));
        }
    }

    // обработчик событий
    @Override
    public void accept(Event event) {

    }
}