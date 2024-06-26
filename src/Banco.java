import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private final List<Conta> contas = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
	
	public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public List<Conta> getContas() {
        return contas;
    }
}