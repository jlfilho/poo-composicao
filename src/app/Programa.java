package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entidades.ContratoPorHora;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		//Trabalhador trabalhador = new Trabalhador();
		
		System.out.print("Entre com o nome do departamento: ");
		String departamento = sc.nextLine();
			
		System.out.println("Entre com os dados do trabalhador: ");
		
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Nível (JUNIOR, SENIOR ou PLENO):  ");
		String nivel = sc.nextLine();
		
		System.out.print("Salário Base: ");
		Double salarioBase = sc.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel),
				salarioBase, new Departamento(departamento));
		
		
		System.out.print("Quantos contratos tem este trabalhador: ");
		int n = sc.nextInt();
		
		for(int i=1; i <= n; i++) {
			sc.nextLine();
			System.out.println("Entre com os dados do contrato #"+i+":");
			
			System.out.print("Data (DD/MM/YYYY): ");
			LocalDate data = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			System.out.print("Valor por Hora: ");
			Double valorHora = sc.nextDouble();
			
			System.out.print("Duração: ");
			Integer duracao = sc.nextInt();
			
			ContratoPorHora contrato = new ContratoPorHora(data, valorHora, duracao);
			trabalhador.adicionarContrato(contrato);
		}
		
		sc.nextLine();
		System.out.println();
		
		
		System.out.print("Entre com o mês e o ano para calcular o rendimento (MM/YYYY): ");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse("30/"+sc.next(), dtf);		
		
		System.out.println("Nome: "+trabalhador.getNome());
		System.out.println("Departamento: "+trabalhador.getDepartamento());
		
		System.out.println("Renda para "
		+ data.format(DateTimeFormatter.ofPattern("MM/yyyy")) 
		+ ": R$" + trabalhador.getRenda(data.getYear(), data.getMonthValue()));
		
		sc.close();

	}

}
