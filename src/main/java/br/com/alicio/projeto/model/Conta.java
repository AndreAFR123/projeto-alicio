package br.com.alicio.projeto.model;

public class Conta {
	
	private int idConta;
	private long saldo;
	private long limite;
	private String tp_conta;
	private int num_conta;
	public int getIdConta() {
		return idConta;
	}
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	public long getSaldo() {
		return saldo;
	}
	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}
	public long getLimite() {
		return limite;
	}
	public void setLimite(long limite) {
		this.limite = limite;
	}
	public String getTp_conta() {
		return tp_conta;
	}
	public void setTp_conta(String tp_conta) {
		this.tp_conta = tp_conta;
	}
	public int getNum_conta() {
		return num_conta;
	}
	public void setNum_conta(int num_conta) {
		this.num_conta = num_conta;
	}
	
	
	@Override
	public String toString() {
		return "Conta [idConta=" + idConta + ", saldo=" + saldo + ", limite=" + limite + ", tp_conta=" + tp_conta
				+ ", num_conta=" + num_conta + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idConta;
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
		Conta other = (Conta) obj;
		if (idConta != other.idConta)
			return false;
		if (limite != other.limite)
			return false;
		if (num_conta != other.num_conta)
			return false;
		if (saldo != other.saldo)
			return false;
		if (tp_conta == null) {
			if (other.tp_conta != null)
				return false;
		} else if (!tp_conta.equals(other.tp_conta))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	

}
