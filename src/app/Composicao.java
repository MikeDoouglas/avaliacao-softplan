package app;

import java.util.ArrayList;

public class Composicao implements Item {
    private Integer codigo;
    private String descricao;
    private String unidade;
    private ArrayList<ItemComposicao> itemsComposicao;

    public Composicao(Integer codigo, String descricao, String unidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidade = unidade;
        this.itemsComposicao = new ArrayList<ItemComposicao>();
    }

    public Double calculaValorTotal() {
        Double valorTotalComposicao = 0.0;
        for (ItemComposicao item : itemsComposicao) {
            Double valorTotalItem = item.getItem().getValor() * item.getQuantidade();
            valorTotalComposicao += truncateDouble(valorTotalItem); 
        }
        return valorTotalComposicao;
    }

    private Double truncateDouble(Double value) {
        return Math.floor(value * 100) / 100;
    }

    @Override
    public Double getValor() {
        return this.calculaValorTotal();
    }

    public void adicionItemComposicao(ItemComposicao itemComposicao) {
        itemsComposicao.add(itemComposicao);
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public ArrayList<ItemComposicao> getItemsComposicao() {
        return itemsComposicao;
    }

    public void setItemsComposicao(ArrayList<ItemComposicao> itemsComposicao) {
        this.itemsComposicao = itemsComposicao;
    }
}