package convertidor_de_monedas;

import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class MainMenuDos{
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "¡Bienvenido!");

        do {
            String[] opciones = { "Conversor de monedas", "Conversor de temperatura", "Salir" };
            String opcionElegida = (String) JOptionPane.showInputDialog(null, "Elige una opción:",
                    "Opciones del convertidor", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcionElegida == null || opcionElegida.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Finalizado.", "Conversor", JOptionPane.INFORMATION_MESSAGE);
                break;
            }

            switch (opcionElegida) {
                case "Conversor de monedas":
                    conversorMonedas();
                    break;
                case "Conversor de temperatura":
                    conversorTemperatura();
                    break;
            }

        } while (true);
    }

    public static void conversorMonedas() {
        String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad en pesos a convertir:");
        if (cantidadStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Conversor de monedas",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            double cantidad = Double.parseDouble(cantidadStr);
            String[] divisas = { "Dólar", "Euro", "Libra Esterlina", "Yen Japonés", "Won surcoreano" };
            String divisaElegida = (String) JOptionPane.showInputDialog(null, "Elige una divisa:", "Conversor de monedas",
                    JOptionPane.QUESTION_MESSAGE, null, divisas, divisas[0]);

            if (divisaElegida != null) {
                double resultado = convertirMoneda(cantidad, divisaElegida);
                String mensaje = "El equivalente de " + cantidad + " pesos en " + divisaElegida + " es: " + String.format("%.2f", resultado);
                JOptionPane.showMessageDialog(null, mensaje, "Conversor de monedas", JOptionPane.INFORMATION_MESSAGE);
                realizarOtraConsulta();
            } else {
                JOptionPane.showMessageDialog(null, "Operación cancelada.", "Conversor de monedas",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad inválida. Ingrese un número.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void conversorTemperatura() {
        String temperaturaStr = JOptionPane.showInputDialog("Ingrese la temperatura a convertir:");
        if (temperaturaStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Conversor de temperatura",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            double temperatura = Double.parseDouble(temperaturaStr);
            String[] opciones = { "Celsius a Fahrenheit", "Fahrenheit a Celsius", "Salir" };
            String opcionElegida = (String) JOptionPane.showInputDialog(null, "Elige una opción:",
                    "Conversor de temperatura", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcionElegida == null || opcionElegida.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.", "Conversor de temperatura",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            double resultado = 0.0;
            if (opcionElegida.equals("Celsius a Fahrenheit")) {
                resultado = celsiusAFahrenheit(temperatura);
            } else if (opcionElegida.equals("Fahrenheit a Celsius")) {
                resultado = fahrenheitACelsius(temperatura);
            }

            String mensaje = "La temperatura equivalente es: " + String.format("%.2f", resultado);
            JOptionPane.showMessageDialog(null, mensaje, "Conversor de temperatura", JOptionPane.INFORMATION_MESSAGE);
            realizarOtraConsulta();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Temperatura inválida. Ingrese un número.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void realizarOtraConsulta() {
        String[] opciones = { "Sí", "No" };
        int opcionElegida = JOptionPane.showOptionDialog(null, "¿Desea realizar otra consulta?", "Continuar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (opcionElegida == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Finalizado.", "Conversor", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    private static double convertirMoneda(double cantidad, String divisaElegida) {
        Map<String, Double> tasasDeCambio = new HashMap<>();
        tasasDeCambio.put("Dólar", 0.050);
        tasasDeCambio.put("Euro", 0.045);
        tasasDeCambio.put("Libra Esterlina", 0.046);
        tasasDeCambio.put("Yen Japonés", 0.12);
        tasasDeCambio.put("Won surcoreano", 0.013);
        double tasa = tasasDeCambio.get(divisaElegida);
        return cantidad * tasa;
    }

    private static double celsiusAFahrenheit(double temperaturaCelsius) {
        return (temperaturaCelsius * 9 / 5) + 32;
    }

    private static double fahrenheitACelsius(double temperaturaFahrenheit) {
        return (temperaturaFahrenheit - 32) * 5 / 9;
    }
}
												

