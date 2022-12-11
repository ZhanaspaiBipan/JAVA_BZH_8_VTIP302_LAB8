package patterns;

/*
 * Паттерн "Abstract Factory"
 * Абстрактная фабрика предоставляет интерфейс для создания целых семейств объектов
 * без указания конкретных классов. Объекты каждого семейства должны быть логически связаны между собой. 
 *
 * (!) Фишка в использовании интерфейсов в интерфейсах в структуре классов
 */
interface IWheather {
    public IBadWeather cold();
    public INiceWeather warm();
}

interface IBadWeather {
    public void getCoat();
    }

interface INiceWeather {
    public void wearDress();
}

class BadWeather implements IBadWeather {
    @Override
    public void getCoat() {
        System.out.println(" Плохая погода. Эх... Придется взять с собой пальто.");
    }
    
}

class NiceWeather implements INiceWeather {
    @Override
    public void wearDress() {
        System.out.println("Сегодня вполне хорошая погода. Можно выйти с чем нибудь полегкче.");
    }
}

class Wheather implements IWheather {
    IBadWeather badweather = new BadWeather();
    INiceWeather niceweather = new NiceWeather();

    @Override
    public IBadWeather cold() {
        return badweather;
    }

    @Override
    public INiceWeather warm() {
        return niceweather;
    }
}

/**
 * ПАТТЕРН "АБСТРАКТНАЯ ФАБРИКА" (Abstract Factory)
 *
 */
public class AbstractFactoryExample {

    public static void main(String[] args) {
        IWheather weather = new Wheather();
        weather.cold().getCoat();
        weather.warm().wearDress();
        }
}
