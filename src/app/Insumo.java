package app;

public class Insumo implements Item {
    private Integer codigo;
    private String tipo;
    private String descricao;
    private String unidade;
    private Double valorUnitario;

    public Insumo(Integer codigo, String tipo, String descricao, String unidade, Double valorUnitario) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.unidade = unidade;
        this.valorUnitario = valorUnitario;
    }

    @Override
    public Double getValor() {
        return this.getValorUnitario();
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}