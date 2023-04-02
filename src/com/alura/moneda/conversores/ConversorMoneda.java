package com.alura.moneda.conversores;

import javax.swing.JOptionPane;

public class ConversorMoneda {
	public ConversorMoneda(){
		String contenido =  JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir:");
		if(comprobarContenido(contenido)) {
			Double valor = Double.valueOf(contenido);
			String opcionMoneda;
			try {
				opcionMoneda = opcionConvertirMoneda();
				Double moneda1 = elegirMoneda1(opcionMoneda);
				Double moneda2 = elegirMoneda2(opcionMoneda);
				Double valorFinal = valor*moneda2/moneda1;
				String tipo = obtenerTipo(opcionMoneda);
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

	private String opcionConvertirMoneda() throws Exception{
		return (JOptionPane.showInputDialog(null,
				"Elija la moneda a la que deseas convertir tu dinero", "Monedas",
				JOptionPane.PLAIN_MESSAGE, null,
				new Object[] {"De Dólar a Pesos", "De Dólar a Euro",
						"De Dólar a Libras","De Dólar a Yen",
						"De Dólar a Won Coreano","De Pesos a Dólar",
						"De Euro a Dólar", "De Libras a Dólar",
						"De Yen a Dólar","De Won Coreano a Dólar"},
				"Seleccion")).toString();
	}
	
	private Double elegirMoneda1(String opcionMoneda) {
		if(opcionMoneda.startsWith("De Dólar"))return 1.00;
		else if(opcionMoneda.startsWith("De Pesos"))return 4654.63;
		else if(opcionMoneda.startsWith("De Euro"))return 0.92;
		else if(opcionMoneda.startsWith("De Libras"))return 0.81;
		else if(opcionMoneda.startsWith("De Yen"))return 132.78;
		else if(opcionMoneda.startsWith("De Won Coreano"))return 1306.47;
		return -1.00;
	}
	
	private Double elegirMoneda2(String opcionMoneda) {
		if(opcionMoneda.endsWith("Dólar"))return 1.00;
		else if(opcionMoneda.endsWith("Pesos"))return 4654.63;
		else if(opcionMoneda.endsWith("Euro"))return 0.92;
		else if(opcionMoneda.endsWith("Libras"))return 0.81;
		else if(opcionMoneda.endsWith("Yen"))return 132.78;
		else if(opcionMoneda.endsWith("Won Coreano"))return 1306.47;
		return -1.00;
	}
	
	private String obtenerTipo(String opcionMoneda) {
		if(opcionMoneda.endsWith("Dólar"))return "Dólares";
		else if(opcionMoneda.endsWith("Pesos"))return "Pesos";
		else if(opcionMoneda.endsWith("Euro"))return "Euros";
		else if(opcionMoneda.endsWith("Libras"))return "Libras";
		else if(opcionMoneda.endsWith("Yen"))return "Yenes";
		else if(opcionMoneda.endsWith("Won Coreano"))return "Wones Coreanos";
		return "";
	}
	
	private void mostrarValorFnal(Double valorFinal, String tipo) {
		DecimalFormat formato = new DecimalFormat("#.00");
		JOptionPane.showMessageDialog(null, "Tienes " +valorFinal.toString()+" "+tipo);
	}
}
