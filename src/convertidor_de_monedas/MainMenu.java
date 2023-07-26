package convertidor_de_monedas;

import javax.swing.*;

public class MainMenu {
    private static final ConversorMonedas conversorMonedas = new ConversorMonedas();
    private static final ConversorTemperatura conversorTemperatura = new ConversorTemperatura();

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
                    mostrarConversorMonedas();
                    break;
                case "Conversor de temperatura":
                    mostrarConversorTemperatura();
                    break;
            }

        } while (true);
    }

    public static void mostrarConversorMonedas() {
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
            } else {
                JOptionPane.showMessageDialog(null, "Operación cancelada.", "Conversor de monedas",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad inválida. Ingrese un número.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra consulta?", "Conversor de monedas", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Finalizado.", "Conversor de monedas", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public static void mostrarConversorTemperatura() {
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
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Temperatura inválida. Ingrese un número.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra consulta?", "Conversor de temperatura", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Finalizado.", "Conversor de temperatura", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    private static double convertirMoneda(double cantidad, String divisaElegida) {
        double tasa = conversorMonedas.convertirMoneda(cantidad, divisaElegida);
        return tasa;
    }

    private static double celsiusAFahrenheit(double temperaturaCelsius) {
        return conversorTemperatura.celsiusAFahrenheit(temperaturaCelsius);
    }

    private static double fahrenheitACelsius(double temperaturaFahrenheit) {
        return conversorTemperatura.fahrenheitACelsius(temperaturaFahrenheit);
    }
}


