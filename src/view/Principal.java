package view;

import controller.NPRController;
import javax.swing.JOptionPane;
import br.gui.pilhaint.*;

public class Principal {

	public static void main(String[] args) {
		NPRController controller = new NPRController();
		Pilha pilha = new Pilha();
		
		while (true) {
			String entrada = JOptionPane
					.showInputDialog("Digite um número ou uma operação (+,-,*,/)\n" + "Digite 'sair' para encerrar.");

			if (entrada == null || entrada.equalsIgnoreCase("sair") || entrada.equals("")) {
                break;
            }
			
			try {
				int valor = Integer.parseInt(entrada);
				controller.insereValor(pilha, valor);
			} catch (NumberFormatException e) {
				int resultado = controller.npr(pilha, entrada);
				JOptionPane.showMessageDialog(null, "Resultado parcial: " + resultado);
			}

		}

		JOptionPane.showMessageDialog(null, "Programa encerrado!");

	}

}
