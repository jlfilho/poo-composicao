package entidades;

import java.time.LocalDate;

public class ContratoPorHora {
	private LocalDate data;
	private Double valorPorHora;
	private Integer horas;
	
	public ContratoPorHora() {
		
	}

	public ContratoPorHora(LocalDate data, Double valorPorHora, Integer horas) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.horas = horas;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	public Double getValorTotal() {
		return horas * valorPorHora;
	}

	@Override
	public String toString() {
		return "ContratoPorHora [data=" + data + ", valorPorHora=" + valorPorHora + ", horas=" + horas + "]";
	}

}
