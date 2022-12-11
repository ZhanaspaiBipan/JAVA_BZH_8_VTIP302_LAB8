package patterns;

/*
 * Паттерн Singleton (Одиночка)
 * Паттерны проектирования - это описание некоторых проблем, возникающих во время объектно-ориентированного 
 * проектирования, а также способов их решения (как практических, так и теоретических). 
 * Иными словами - это примеры правильных подходов к реению типичных задач проектирования.
 * Одним из самых распространенных паттернов является MyFather (Одиночка). 
 * 
 * (!) Фишка паттерна не дать возможности создать несколько экземпляров класса
 */

final class Weather2 {

    private static Weather2 instance = null;
    private String fallout; // полезное поле синглтона (имя отца)

    private Weather2() { // Запрет на вызов конструктора извне (private-конструктор)
    }

    public String getFallout() { // Полезный метод класса
        return fallout;
    }

    public void setFallout(String name) { // Полезный метод класса, срабатывает один раз
        if (this.fallout == null) {
            this.fallout = name;
        }
    }

    // Метод доступа к классу с первичной инициализацией
    public static synchronized Weather2 getInstance() {
        if (instance == null) {
            instance = new Weather2();
        }
        return instance;
    }
}

public class SingletonExample {

    public static void main(String[] args) {
        //MyFather singleton = new MyFather(); // Так нельзя изза защиты синглтона
        Weather2.getInstance().setFallout("дождь");
        Weather2.getInstance().setFallout("снег");
        System.out.println(Weather2.getInstance().getFallout());
    }

}
