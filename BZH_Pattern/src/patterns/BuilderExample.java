package patterns;

/*
Если класс содержит большое количество конструкторов, то возникает проблема
- трудно запомнить порядок параметров при вызове класса. 
В таких случаях рекомендуется использовать шаблон Builder.

(!) Хитрость в использовании вложенного статического класса с доступом к классу-родителю
 */
class Weather {

    private String month;
    private String fallout;
    private int degrees;

    public static class Builder {

        private Weather weather;

        public Builder() {
            weather = new Weather();
        }

        public Builder withMonth(String month) {
            weather.month = month;
            return this;
        }

        public Builder withFallout(String fallout) {
            weather.fallout = fallout;
            return this;
        }

        public Builder withDegrees(int degrees) {
            weather.degrees = degrees;
            return this;
        }

        public Weather build() {
            return weather;
        }
    }

    @Override
    public String toString() {
        return "Погода{" + "месяц" + " " + month + ", осадки" + " " + fallout + ", градусы" + " " + degrees + '}';
    }

}

public class BuilderExample {

    public static void main(String[] args) {
        Weather weather = new Weather.Builder()
                .withMonth("Март")
                .withFallout("Дождь")
                .withDegrees(10)
                .build();
        System.out.println(weather);
    }
}
