package Aplication;

import java.text.DecimalFormat;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Program {

	public static void main(String[] args) {
		int continuar = JOptionPane.YES_OPTION;

		while (continuar == JOptionPane.YES_OPTION) {
			String[] menu = { "Conversor de Moedas", "Conversor de Temperaturas" };

			JComboBox<String> menuComboBox = new JComboBox<>(menu);
			menuComboBox.setSelectedIndex(0);

			JOptionPane.showOptionDialog(null, menuComboBox, "Menu", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, null, menuComboBox.getSelectedItem());

			if (menuComboBox.getSelectedIndex() == 0) {

				continuar = JOptionPane.YES_OPTION;

				while (continuar == JOptionPane.YES_OPTION) {
					String[] opcoes = { "De Reais a Dólar", "De Reais a Euro", "De Reais a Libras Esterlinas",
							"De Reais a Peso argentino", "De Reais a Peso chileno", "De Dólar a Reais",
							"De Euro a Reais", "De Libras Esterlina a Reais", "De Peso argentino a Reais",
							"De Peso chileno a Reais" };

					JComboBox<String> opcoesComboBox = new JComboBox<>(opcoes);
					opcoesComboBox.setSelectedIndex(0);

					Object[] mensagem = { "Selecione a opção de conversão", opcoesComboBox };
					int opcaoEscolhida = JOptionPane.showConfirmDialog(null, mensagem, "Conversor de Moeda",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

					if (opcaoEscolhida == JOptionPane.CANCEL_OPTION) {
						JOptionPane.showMessageDialog(null, "Programa Finalizado.");
						continuar = JOptionPane.NO_OPTION;
						break;
					}

					double valor = 0;

					try {
						valor = Double
								.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor a ser convertido"));
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número.");
						continue;
					}

					double resultado = 0;
					String moeda = "";

					switch (opcoesComboBox.getSelectedIndex()) {
					case 0: // Reais -> Dólar
						moeda = "dolar";
						resultado = valor / 5.21;
						break;
					case 1: // Reais -> Euro
						moeda = "Euro";
						resultado = valor / 5.53;
						break;
					case 2: // Reais -> Libras Esterlinas
						moeda = "Libras Esterlinas";
						resultado = valor / 6.24;
						break;
					case 3: // Reais -> Peso argentino
						moeda = "Peso argentino";
						resultado = valor / 0.026;
						break;
					case 4: // Reais -> Peso chileno
						moeda = " Peso chileno";
						resultado = valor / 0.0064;
						break;
					case 5: // Dólar -> Reais
						moeda = "Reais";
						resultado = valor * 5.21;
						break;
					case 6: // Euro -> Reais
						moeda = "Reais";
						resultado = valor * 5.53;
						break;
					case 7: // Libras Esterlinas -> Reais
						moeda = "Reais";
						resultado = valor * 6.24;
						break;
					case 8: // Peso argentino -> Reais
						moeda = "Reais";
						resultado = valor * 0.026;
						break;
					case 9: // Peso chileno -> Reais
						resultado = valor * 0.0064;
						break;
					}

					DecimalFormat df = new DecimalFormat("0.00"); // formatar com duas casas decimais
					JOptionPane.showMessageDialog(null, "Resultado: $ " + df.format(resultado) + " " + moeda);

					continuar = JOptionPane.showConfirmDialog(null, "Deseja realizar outra conversão?",
							"Conversor de Moeda", JOptionPane.YES_NO_CANCEL_OPTION);

					if (continuar == JOptionPane.CANCEL_OPTION) {
						JOptionPane.showMessageDialog(null, "Programa Finalizado.");
						break;
					}
				}

			} else if (menuComboBox.getSelectedIndex() == 1) {

				continuar = JOptionPane.YES_OPTION;

				while (continuar == JOptionPane.YES_OPTION) {
					String[] opcoes = { "De Celsius para Fahrenheit", "De Celsius para Kelvin",
							"De Fahrenheit para Celsius", "De Fahrenheit para Kelvin", "De Kelvin para Celsius",
							"De Kelvin para Fahrenheit" };

					JComboBox<String> opcoesComboBox = new JComboBox<>(opcoes);
					opcoesComboBox.setSelectedIndex(0);

					Object[] mensagem = { "Selecione a opção de conversão", opcoesComboBox };
					int opcaoEscolhida = JOptionPane.showConfirmDialog(null, mensagem, "Conversor de Temperatura",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

					if (opcaoEscolhida == JOptionPane.CANCEL_OPTION) {
						JOptionPane.showMessageDialog(null, "Programa Finalizado.");
						continuar = JOptionPane.NO_OPTION;
						break;
					}

					double temperatura = 0;

					try {
						temperatura = Double.parseDouble(
								JOptionPane.showInputDialog(null, "Digite a temperatura a ser convertida"));
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número.");
						continue;
					}

					double resultado = 0;
					String escala = "";

					switch (opcoesComboBox.getSelectedIndex()) {
					case 0: // Celsius -> Fahrenheit
						escala = "F";
						resultado = (temperatura * 1.8) + 32;
						break;
					case 1: // Celsius -> Kelvin
						escala = "K";
						resultado = temperatura + 273.15;
						break;
					case 2: // Fahrenheit -> Celsius
						escala = "C";
						resultado = (temperatura - 32) / 1.8;
						break;
					case 3: // Fahrenheit -> Kelvin
						escala = "K";
						resultado = ((temperatura - 32) / 1.8) + 273.15;
						break;
					case 4: // Kelvin -> Celsius
						escala = "C";
						resultado = temperatura - 273.15;
						break;
					case 5: // Kelvin -> Fahrenheit
						escala = "F";
						resultado = ((temperatura - 273.15) * 1.8) + 32;
						break;
					}

					DecimalFormat df = new DecimalFormat("0.00"); // formatar com duas casas decimais
					JOptionPane.showMessageDialog(null, "Resultado: " + df.format(resultado) + "°" + escala);

					continuar = JOptionPane.showConfirmDialog(null, "Deseja realizar outra conversão?",
							"Conversor de Temperatura", JOptionPane.YES_NO_CANCEL_OPTION);

					if (continuar == JOptionPane.CANCEL_OPTION) {
						JOptionPane.showMessageDialog(null, "Programa Finalizado.");
						break;
					}
				}
			}

		}

	}

}
