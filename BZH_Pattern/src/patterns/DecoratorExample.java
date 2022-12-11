package patterns;

interface IPrinter {
    IPrinter addText(String txt);
    void print();
}

/**
 * ШАБЛОН ДЕКОРАТОР (англ. Decorator) — структурный шаблон проектирования,
 * предназначенный для динамического подключения дополнительного поведения к
 * объекту. Шаблон Декоратор предоставляет гибкую альтернативу практике создания
 * подклассов с целью расширения функциональности.
 *
 */
class Printer implements IPrinter {

    StringBuilder weather = new StringBuilder();

    public Printer(String txt) {
        weather.append(txt);
    }

    public Printer(Printer parent, String txt) {
        weather.append(parent.weather.toString()).append("; ").append(txt);
    }

    @Override
    public IPrinter addText(String txt) {
        return new Printer(this, txt);
    }

    @Override
    public void print() {
        System.out.println(weather.toString());
    }

}

public class DecoratorExample {

    public static void main(String[] args) {
        new Printer("солнечно").addText("дождливо").addText("облако нависают").addText("град").print();
    }
}
