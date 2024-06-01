import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
    private List<Transacao> historico = new ArrayList<>();
    private String dispositivo = "APP";
    private String localizacao = "Pavuna - Rio de Janeiro";

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

    @Override
    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente. Saque não efetuado.");
        } else {
            saldo -= valor;
            historico.add(new Transacao("Saque", valor, dispositivo, localizacao));
            System.out.println(String.format("Saque de R$ %.2f efetuado com sucesso.", valor));
        }
        System.out.println(String.format("Saldo atual: R$ %.2f", saldo));
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        historico.add(new Transacao("Depósito", valor, dispositivo, localizacao));
        System.out.println(String.format("Depósito de R$ %.2f efetuado com sucesso.", valor));
        System.out.println(String.format("Saldo atual: R$ %.2f", saldo));
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente. Transferência não efetuada.");
        } else {
            this.sacar(valor);  // A chamada para sacar já adiciona a transação ao histórico e exibe o saldo
            contaDestino.depositar(valor);  // A chamada para depositar no destino adiciona a transação ao histórico

            // Adicionando registro da transferência no histórico da conta de origem
            historico.add(new Transacao("Transferência Enviada", valor, dispositivo, localizacao));
            System.out.println(String.format("Transferência de R$ %.2f efetuada com sucesso.", valor));
        }
    }

    public List<Transacao> getHistorico() {
        return historico;
    }

    public void imprimirHistorico() {
        System.out.println("=== Histórico de Transações ===");
        for (Transacao t : historico) {
            System.out.println(String.format("%s - R$ %.2f - %s - Dispositivo: %s - Localização: %s",
                    t.getTipo(), t.getValor(), t.getDataHora(), t.getDispositivo(), t.getLocalizacao()));
        }
    }

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
