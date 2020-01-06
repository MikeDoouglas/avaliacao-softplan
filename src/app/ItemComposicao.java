package app;

public class ItemComposicao {
    private Item item;
    private Double quantidade;

    public ItemComposicao(Item item, Double quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}