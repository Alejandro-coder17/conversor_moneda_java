package com.alura.moneda.conversores;

import javax.swing.JOptionPane;

public class ConversorTemperatura {
	public ConversorTemperatura() {
		String contenido =  JOptionPane.showInputDialog("Ingresa el valor de temperatura que deseas convertir:");
		if(comprobarContenido(contenido)) {
			Double valor = Double.valueOf(contenido);
			String opcionTemperatura;
			try {
				opcionTemperatura = opcionConvertirTemperatura();
				Double temperatura1 = elegirTemperatura1(opcionTemperatura);
				Double temperatura2 = elegirTemperatura2(opcionTemperatura);
				Double valorFinal = valor*temperatura2/temperatura1;
				String tipo = obtenerTipo(opcionTemperatura);
				mostrarValorFnal(valorFinal, tipo);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "El valor no es valido");
			}
		}else {
			JOptionPane.showMessageDialog(null, "El valor no es valido");
		}
	}
	
	private boolean comprobarContenido(String contenido) {
		try {
			Double.valueOf(contenido);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	private String opcionConvertirTemperatura() throws Exception{
		return (JOptionPane.showInputDialog(null,
				"Elija la moneda a la que deseas convertir tu dinero", "Monedas",
				JOptionPane.PLAIN_MESSAGE, null,
				new Object[] {"De Celcius a Farenheit", "De Celcius a Kelvin",
						"De Farenheit a Celcius", "De Farenheit a Kelvin",
						"De Kelvin a Celcius","De Kelvin a Farenheit"},
				"Seleccion")).toString();
	}
	
	private Double elegirTemperatura1(String opcionMoneda) {
		if(opcionMoneda.startsWith("De Celcius"))return 1.00;
		else if(opcionMoneda.startsWith("De Farenheit"))return 4654.63;
		else if(opcionMoneda.startsWith("De Kelvin"))return 0.92;
		return -1.00;
	}
	
	private Double elegirTemperatura2(String opcionMoneda) {
		if(opcionMoneda.endsWith("Celcius"))return 1.00;
		else if(opcionMoneda.endsWith("Farenheit"))return 4654.63;
		else if(opcionMoneda.endsWith("Kelvin"))return 0.92;
		return -1.00;
	}
	
	private String obtenerTipo(String opcionMoneda) {
		if(opcionMoneda.endsWith("Celcius"))return "Celcius";
		else if(opcionMoneda.endsWith("Farenheit"))return "Farenheit";
		else if(opcionMoneda.endsWith("Kelvin"))return "Kelvin";
		return "";
	}
	
	private void mostrarValorFnal(Double valorFinal, String tipo) {
		JOptionPane.showMessageDialog(null, "La conversión es " +valorFinal.toString()+"° "+tipo);
	}
}
