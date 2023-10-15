package com.br.projetoWebJava0.modelo;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoModelo;

	@NotNull
	@Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
	private String nomeCliente;

	@NotEmpty(message = "O endereço deve ser informado")
	@Size(min = 3, message = "O endereço deve ter no mínimo 3 caracteres")
	private String enderecoCliente;

	@NotEmpty(message = "A placa deve ser informado")
	@Size(min = 3, message = "A placa deve ter no mínimo 3 caracteres")
	private String placa;

	@NotEmpty(message = "O nome do modelo deve ser informado")
	@Size(min = 3, message = "O nome do modelo deve ter no mínimo 3 caracteres")
	private String nomeModelo;

	@NotEmpty(message = "A marca deve ser informada")
	@Size(min = 3, message = "A marca deve ter no mínimo 3 caracteres")
	private String codigoMarca;

	@NotEmpty(message = "O valor do aluguel deve ser informado")
	@Size(min = 3, message = "O valor do aluguel deve ter no mínimo 3 caracteres")
	private String valorAluguel;

	public Long getCodigoModelo() {
		return this.codigoModelo;
	}

	public void setCodigoModelo(Long codigoModelo) {
		this.codigoModelo = codigoModelo;
	}

	public String getNomeCliente() {
		return this.nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEnderecoCliente() {
		return this.enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getNomeModelo() {
		return this.nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	public String getCodigoMarca() {
		return this.codigoMarca;
	}

	public void setCodigoMarca(String codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

	public String getValorAluguel() {
		return this.valorAluguel;
	}

	public void setValorAluguel(String valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
