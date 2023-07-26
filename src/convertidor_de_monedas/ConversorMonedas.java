package convertidor_de_monedas;

import java.util.HashMap;
import java.util.Map;

public class ConversorMonedas {
    private Map<String, Double> tasasDeCambio;

    public ConversorMonedas() {
        tasasDeCambio = new HashMap<>();
        tasasDeCambio.put("Dólar", 0.059);
        tasasDeCambio.put("Euro", 0.045);
        tasasDeCambio.put("Libra Esterlina", 0.046);
        tasasDeCambio.put("Yen Japonés", 0.12);
        tasasDeCambio.put("Won surcoreano", 0.013);
    }

    public double convertirMoneda(double cantidad, String divisaElegida) {
        double tasa = tasasDeCambio.get(divisaElegida);
        return cantidad * tasa;
    }
}

