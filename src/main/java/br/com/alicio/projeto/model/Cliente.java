package br.com.alicio.projeto.model;

public class Cliente {
	
	private int num_cliente;
	private int idCliente;
	private String nm_cliente;
	private String cpf_cliente;
	private int fk_cliente_conta;
	
	public int getFk_cliente_conta() {
		return fk_cliente_conta;
	}
	public void setFk_cliente_conta(int fk_cliente_conta) {
		this.fk_cliente_conta = fk_cliente_conta;
	}
	public int getNum_cliente() {
		return num_cliente;
	}
	public void setNum_cliente(int num_cliente) {
		this.num_cliente = num_cliente;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNm_cliente() {
		return nm_cliente;
	}
	public void setNm_cliente(String nm_cliente) {
		this.nm_cliente = nm_cliente;
	}
	public String getCpf_cliente() {
		return cpf_cliente;
	}
	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}
	
	@Override
	public String toString() {
		return "Cliente [num_cliente=" + num_cliente + ", idCliente=" + idCliente + ", nm_cliente=" + nm_cliente
				+ ", cpf_cliente=" + cpf_cliente + ", fk_cliente_conta=" + fk_cliente_conta + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCliente;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf_cliente == null) {
			if (other.cpf_cliente != null)
				return false;
		} else if (!cpf_cliente.equals(other.cpf_cliente))
			return false;
		if (fk_cliente_conta != other.fk_cliente_conta)
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (nm_cliente == null) {
			if (other.nm_cliente != null)
				return false;
		} else if (!nm_cliente.equals(other.nm_cliente))
			return false;
		if (num_cliente != other.num_cliente)
			return false;
		return true;
	}
}