import app.GeradorObservacaoDetalhada;
import junit.framework.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class GeradorObservacaoDetalhadaTest extends TestCase {
   protected ArrayList<Integer> listaCodigosSemValores;
   protected HashMap<Integer, Double> listaCodigosVazia, listaCodigosComValores;
   protected GeradorObservacaoDetalhada geradorObservacaoDetalhada;

   protected void setUp() {
      geradorObservacaoDetalhada = new GeradorObservacaoDetalhada();
      listaCodigosSemValores = new ArrayList<Integer>();
      listaCodigosSemValores.add(1);
      listaCodigosVazia = new HashMap<Integer, Double>();
      listaCodigosComValores = new HashMap<Integer, Double>();
      listaCodigosComValores.put(1, 32.00);
      listaCodigosComValores.put(2, 21.21);
      listaCodigosComValores.put(3, 1320.03);
   }

   public void testeListaSemDetalhes() {
      String resultadoEsperado = "Fatura da nota fiscal de simples remessa: 1";
      String resultado = geradorObservacaoDetalhada.geraObservacao(listaCodigosSemValores);
      assertTrue(resultado.equals(resultadoEsperado));
   }

   public void testeListaVazia() {
      String resultadoEsperado = "";
      String resultado = geradorObservacaoDetalhada.geraObservacao(listaCodigosVazia);
      assertTrue(resultado.equals(resultadoEsperado));
   }

   public void testeResultadoOutraMoeda() {
      String resultadoEsperado = "Fatura das notas fiscais de simples remessa: 1 cujo valor é $32.00, 2 cujo valor é $21.21 e 3 cujo valor é $1,320.03";
      Locale moedaCorrente = new Locale("en", "US");
      geradorObservacaoDetalhada.setLocalMoedaCorrente(moedaCorrente);
      String resultado = geradorObservacaoDetalhada.geraObservacao(listaCodigosComValores);
      assertEquals(resultado, resultadoEsperado);
   }
}