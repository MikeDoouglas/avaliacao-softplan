package app;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class GeradorObservacaoDetalhada {
    private Locale localMoedaCorrente;
    private String textoTemplate;
    private IGeradorObservacao geradorObservacao;

    public GeradorObservacaoDetalhada() {
        this.localMoedaCorrente = new Locale("pt", "BR");
        this.textoTemplate = "%d cujo valor é %s";
    }

    public GeradorObservacaoDetalhada(IGeradorObservacao geradorObservacao) {
        this.geradorObservacao = geradorObservacao;
        this.localMoedaCorrente = new Locale("pt", "BR");
        this.textoTemplate = "%d cujo valor é %s";
    }

    public GeradorObservacaoDetalhada(Locale localMoedaCorrente, String textoTemplate) {
        this.localMoedaCorrente = localMoedaCorrente;
        this.textoTemplate = textoTemplate;
    }

    public String geraObservacao(HashMap<Integer, Double> codigosComValores) {
        if (codigosComValores.isEmpty()) {
            return "";
        }
        String textoFatura = this.geradorObservacao.textoFatura(codigosComValores.size());
        ArrayList<String> textosCodigosComValores = textosCodigosComValores(codigosComValores);
        String codigosFatura = this.geradorObservacao.juntaCodigosFatura(textosCodigosComValores);
        return textoFatura + codigosFatura;
    }

    protected ArrayList<String> textosCodigosComValores(HashMap<Integer, Double> codigosComValores) {
        ArrayList<String> codigos = new ArrayList<String>();
        for (Map.Entry<Integer, Double> item : codigosComValores.entrySet()) {
            Double valor = item.getValue();
            Integer codigo = item.getKey();
            String valorEmMoedaCorrente = doubleParaMoedaCorrente(valor);
            String codigoTexto = String.format(this.textoTemplate, codigo, valorEmMoedaCorrente);
            codigos.add(codigoTexto);
        }
        return codigos;
    }

    private String doubleParaMoedaCorrente(Double valor) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(this.localMoedaCorrente);
        return currencyFormatter.format(valor);
    }

    public Locale getLocalMoedaCorrente() {
        return localMoedaCorrente;
    }

    public void setLocalMoedaCorrente(Locale localMoedaCorrente) {
        this.localMoedaCorrente = localMoedaCorrente;
    }

    public String getTextoTemplate() {
        return textoTemplate;
    }

    public void setTextoTemplate(String textoTemplate) {
        this.textoTemplate = textoTemplate;
    }
}