import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private String tipo;
    private double valor;
    private String dataHora;
    private String dispositivo;
    private String localizacao;

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
