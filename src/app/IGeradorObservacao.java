package app;

import java.util.List;

public interface IGeradorObservacao {
    public String textoFatura(Integer tamanhoLista);

    public String geraObservacao(List lista);

    public String juntaCodigosFatura(List codigos);
} 