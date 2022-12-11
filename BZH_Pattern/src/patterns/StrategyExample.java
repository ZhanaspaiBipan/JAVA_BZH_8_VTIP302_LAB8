package patterns;

/*
 * ПАТТЕРН "СТРАТЕГИЯ" (Strategy)
 * Этот паттерн проектирования известен также под названием Policy. 
 * Суть его состоит в том, чтобы создать несколько моделей поведения (стратегий) для одного объекта
 * и вынести их в отдельные классы. 
 *
 * (!) Хитрость паттерна подсовывать в параметры вместо конкретного класса совместимого интерфейса класса
 */
interface IWeather {

    void fallout(boolean turn);
}

class Weather3 implements IWeather {

    @Override
    public void fallout(boolean turn) {
        System.out.println("Сегодня дождь " + turn);
    }

}

class Weather4 implements IWeather {

    @Override
    public void fallout(boolean turn) {
        System.out.println("Сегодня снег " + turn);
    }
}

class Today {

    private IWeather weather;

    public Today(IWeather weather) {
        this.weather = weather;
    }

    public void setWeather(IWeather weather) {
        this.weather = weather;
    }

    public void turnFallout(boolean turn) {
        weather.fallout(turn);
    }
}

/**
 * ПАТТЕРН "СТРАТЕГИЯ"
 *
 */
public class StrategyExample {

    public static void main(String[] args) {
        Today today = new Today(new Weather3());
        today.turnFallout(true);
        today.turnFallout(false);
        today.setWeather(new Weather4());
        today.turnFallout(true);
        today.turnFallout(false);
    }
}
