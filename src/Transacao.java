import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private final String tipo;
    private final double valor;
    private final String dataHora;
    private final String dispositivo;
    private final String localizacao;

    public Transacao(String tipo, double valor, String dispositivo, String localizacao) {
        this.tipo = tipo;
        this.valor = valor;
        this.dispositivo = dispositivo;
        this.localizacao = localizacao;
        this.dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getDataHora() {
        return dataHora;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public String getLocalizacao() {
        return localizacao;
    }
}
