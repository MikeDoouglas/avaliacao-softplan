import app.Composicao;
import app.Insumo;
import app.ItemComposicao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

public class ComposicaoTest {
    private Composicao composicao;

    @BeforeEach
    protected void setUp() {
        Double valorInsumo = 10.0;
        Double quantidadeInsumo = 2.0;
        Insumo insumo = new Insumo(123, "tipo 01", "descrição insumo", "unidade insumo", valorInsumo);
        ItemComposicao itemComposicao = new ItemComposicao(insumo, quantidadeInsumo);
        composicao = new Composicao(1000, "descrição composição", "unidade");
        composicao.adicionItemComposicao(itemComposicao);
    }

    @Test
    public void testeCalculaValorTotal() {
        assertEquals(composicao.calculaValorTotal(), 20.0,
                "Composição possui 1 insumo no valor de 10.0. O valor total da composição deve ser 20.0");
    }
}