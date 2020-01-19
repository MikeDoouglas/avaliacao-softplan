import app.GeradorObservacao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GeradorObservacaoTest {
   protected ArrayList<Integer> listaUmElemento, listaVazia;
   protected GeradorObservacao geradorObservacao;

   @BeforeEach
   protected void setUp() {
      geradorObservacao = new GeradorObservacao();
      listaUmElemento = new ArrayList<Integer>();
      listaUmElemento.add(1);
      listaVazia = new ArrayList<Integer>();
   }

   @Test
   public void testeUmItemNaLista() {
      String resultado = geradorObservacao.geraObservacao(listaUmElemento);
      assertEquals(resultado, "Fatura da nota fiscal de simples remessa: 1"
      , "Lista com um código deve retornar o texto da fatura com apenas um código.");
   }

   @Test
   public void testeListaVazia() {
      String resultado = geradorObservacao.geraObservacao(listaVazia);
      assertEquals(resultado, "", "Lista vazia deve retornar um texto vazio");
   }
}