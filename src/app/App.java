package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        executaExercicio01();
        executaExercicio02();
    }

    public static void executaExercicio01() {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista.add(11);
        lista.add(2);
        lista.add(33);
        lista.add(4563);
        GeradorObservacao gerador = new GeradorObservacao();
        String observacao = gerador.geraObservacao(lista);
        System.out.println(observacao);

        HashMap<Integer, Double> codigosComValores = new HashMap<Integer, Double>();
        codigosComValores.put(1, 35.94);
        codigosComValores.put(7, 21.00);
        codigosComValores.put(19, 1500.40);
        GeradorObservacaoDetalhada geradorObservacaoDetalhada = new GeradorObservacaoDetalhada();
        geradorObservacaoDetalhada.setTextoTemplate("%d cujo valor é %s");
        geradorObservacaoDetalhada.setLocalMoedaCorrente(new Locale("pt", "BR"));
        String observacaoDetalhada = geradorObservacaoDetalhada.geraObservacao(codigosComValores);
        System.out.println(observacaoDetalhada);
    }

    public static void executaExercicio02() throws Exception {
        ExtratorJson extrator = new ExtratorJson();
        extrator.run();
        String resultado = "";
        HashMap<Integer, Composicao> composicoes = extrator.composicoes;
        for (Map.Entry<Integer, Composicao> item : composicoes.entrySet()) {
            Integer codigoComposicao = item.getKey();
            Composicao composicao = item.getValue();
            resultado += codigoComposicao.toString() + " ";
            resultado += composicao.getDescricao() + " ";
            resultado += composicao.calculaValorTotal() + " \n";
        }
        System.out.println(resultado);
    }
}