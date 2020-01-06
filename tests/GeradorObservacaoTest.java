import app.GeradorObservacao;
import junit.framework.*;

import java.util.ArrayList;

public class GeradorObservacaoTest extends TestCase {
   protected ArrayList<Integer> listaUmElemento, listaVazia;
   protected GeradorObservacao geradorObservacao;

   protected void setUp() {
      geradorObservacao = new GeradorObservacao();
      listaUmElemento = new ArrayList<Integer>();
      listaUmElemento.add(1);
      listaVazia = new ArrayList<Integer>();
   }

   public void testeUmItemNaLista() {
      String resultadoEsperado = "Fatura da nota fiscal de simples remessa: 1";
      String resultado = geradorObservacao.geraObservacao(listaUmElemento);
      assertTrue(resultado.equals(resultadoEsperado));
   }

   public void testeListaVazia() {
      String resultadoEsperado = "";
      String resultado = geradorObservacao.geraObservacao(listaVazia);
      assertTrue(resultado.equals(resultadoEsperado));
   }
}