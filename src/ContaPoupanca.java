public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void adicionarJuros(double taxa) {
        double juros = getSaldo() * taxa;
        depositar(juros);
        System.out.println(String.format("Juros de R$ %.2f adicionados.", juros));
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }
}
