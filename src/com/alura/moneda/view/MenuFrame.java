package com.alura.moneda.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.alura.moneda.conversores.ConversorMoneda;
import com.alura.moneda.conversores.ConversorTemperatura;

public class MenuFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private int respuesta;
	
	public MenuFrame(){
		super("Menu");
        
		do {
			String opcion;
			try {
				opcion = mostrarOpciones();
			} catch (Exception e) {
				break;
			}
	        configurarAcciones(opcion);
	        respuesta = JOptionPane.showConfirmDialog(null, "¿Desea continuar?");
		}while(respuesta!=1 && respuesta!=2);
		JOptionPane.showMessageDialog(null, "Programa terminado");
	}

	private String mostrarOpciones() throws Exception{
		return (JOptionPane.showInputDialog(null,
				"Seleccione una opción de conversión", "Menu",
				JOptionPane.QUESTION_MESSAGE, null,
				new Object[] { "Conversor de Moneda", "Conversor de Temperatura" },
				"Seleccion")).toString();
	}

	private void configurarAcciones(String opcionConversor) {
		switch (opcionConversor) {
		case "Conversor de Moneda":
			ConversorMoneda conversorM = new ConversorMoneda();
			break;
		case "Conversor de Temperatura":
			ConversorTemperatura conversorT = new ConversorTemperatura();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Programa terminado");
			break;
		}
	}
	
}
