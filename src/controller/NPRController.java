package controller;

import br.gui.pilhaint.Pilha;

public class NPRController {

	public void insereValor(Pilha p, int valor) {
		p.push(valor);
	}

	public int npr(Pilha p, String op) {
		int resultado = 0;

		try {
			if (!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")) {
				System.err.println("Operação inválida: " + op);
				return 0;
			}

			if (p.size() < 2) {
				System.err.println("Valores insuficientes na pilha para operação: " + op);
				return 0;
			}

			int valorDireita = p.pop();
			int valorEsquerda = p.pop();

			switch (op) {
			case "+": resultado = valorEsquerda + valorDireita; break;
			case "-": resultado = valorEsquerda - valorDireita; break;
			case "*": resultado = valorEsquerda * valorDireita; break;
			case "/":
				if (valorDireita == 0) {
					System.err.println("Erro: divisão por zero");
					p.push(valorEsquerda);
					p.push(valorDireita);
					return 0;
				}
				resultado = valorEsquerda / valorDireita;
				break;
			}

			p.push(resultado);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		}

		return resultado;
	}

}
