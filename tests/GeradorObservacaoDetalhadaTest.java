import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.GeradorObservacao;
import app.GeradorObservacaoDetalhada;

import java.util.HashMap;
import java.util.Locale;

public class GeradorObservacaoDetalhadaTest {
   protected HashMap<Integer, Double> listaCodigosVazia, listaCodigosComValores;
   protected GeradorObservacaoDetalhada geradorObservacaoDetalhada;

   @BeforeEach
   protected void setUp() {
      geradorObservacaoDetalhada = new GeradorObservacaoDetalhada(new GeradorObservacao());
      listaCodigosVazia = new HashMap<Integer, Double>();
      listaCodigosComValores = new HashMap<Integer, Double>();
      listaCodigosComValores.put(1, 32.00);
      listaCodigosComValores.put(2, 21.21);
      listaCodigosComValores.put(3, 1320.03);
   }

   @Test
   public void testeListaVazia() {
      String resultado = geradorObservacaoDetalhada.geraObservacao(listaCodigosVazia);
      assertEquals(resultado, "", 
      "Ao passar uma lista vazia, deve retornar um texto vazio");
   }

   @Test
   public void testeResultadoOutraMoeda() {
      Locale moedaCorrente = new Locale("en", "US");
      geradorObservacaoDetalhada.setLocalMoedaCorrente(moedaCorrente);
      String resultado = geradorObservacaoDetalhada.geraObservacao(listaCodigosComValores);
      assertEquals(resultado, "Fatura das notas fiscais de simples remessa: 1 cujo valor é $32.00, 2 cujo valor é $21.21 e 3 cujo valor é $1,320.03",
      "Ao mudar tipo da moeda corrente, deve retornar os valores dos códigos com a moeda alterada");
   }
}