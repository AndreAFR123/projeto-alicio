package br.com.alicio.projeto.model;

public class Conta {
	
	private int numeroConta;
	private long saldo;
	private long limite;
	private String contaCorrente;
	private String contaPoupança;
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
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
	public String getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	public String getContaPoupança() {
		return contaPoupança;
	}
	public void setContaPoupança(String contaPoupança) {
		this.contaPoupança = contaPoupança;
	}
	@Override
	public String toString() {
		return "Conta [numeroConta=" + numeroConta + ", saldo=" + saldo + ", limite=" + limite + ", contaCorrente="
				+ contaCorrente + ", contaPoupança=" + contaPoupança + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroConta;
		
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
		if (contaCorrente == null) {
			if (other.contaCorrente != null)
				return false;
		} else if (!contaCorrente.equals(other.contaCorrente))
			return false;
		if (contaPoupança == null) {
			if (other.contaPoupança != null)
				return false;
		} else if (!contaPoupança.equals(other.contaPoupança))
			return false;
		if (limite != other.limite)
			return false;
		if (numeroConta != other.numeroConta)
			return false;
		if (saldo != other.saldo)
			return false;
		return true;
	}
	
	

}
