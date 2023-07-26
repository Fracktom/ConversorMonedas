package convertidor_de_monedas;

public class ConversorTemperatura {
    public double celsiusAFahrenheit(double temperaturaCelsius) {
        return (temperaturaCelsius * 9 / 5) + 32;
    }

    public double fahrenheitACelsius(double temperaturaFahrenheit) {
        return (temperaturaFahrenheit - 32) * 5 / 9;
    }
}
