package app;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ExtratorJson {
    public HashMap<Integer, Insumo> insumos;
    public HashMap<Integer, Composicao> composicoes;

    public void run() throws IOException, ParseException {
        FileReader reader = new FileReader("dados-entrada-servicos-composicoes.json");
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
        insumos = extraiInsumos(jsonArray);
        composicoes = extraiComposicoes(jsonArray);
        atribuiInsumosNasComposicoes(jsonArray);
    }

    public void atribuiInsumosNasComposicoes(JSONArray jsonArray) {
        Iterator<JSONObject> iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonItem = iterator.next();
            Integer codigoItem = ((Long) jsonItem.get("codigoItem")).intValue();
            String tipo = (String) jsonItem.get("tipoItem");
            Double quantidade = stringToDouble((String) jsonItem.get("quantidadeComposicao"));
            ItemComposicao item;
            if (tipo.equals("INSUMO")) {
                Insumo insumo = insumos.get(codigoItem);
                item = new ItemComposicao(insumo, quantidade);
            } else {
                Composicao composicao = composicoes.get(codigoItem);
                item = new ItemComposicao(composicao, quantidade);
            }
            Integer codigoComposicao = ((Long) jsonItem.get("codigoComposicao")).intValue();
            composicoes.get(codigoComposicao).adicionItemComposicao(item);
        }
    }

    public HashMap<Integer, Insumo> extraiInsumos(JSONArray jsonArray) {
        Iterator<JSONObject> iterator = jsonArray.iterator();
        HashMap<Integer, Insumo> insumos = new HashMap<Integer, Insumo>();
        while (iterator.hasNext()) {
            JSONObject jsonItem = iterator.next();
            Integer codigo = ((Long) jsonItem.get("codigoItem")).intValue();
            String tipo = (String) jsonItem.get("tipoItem");
            if (!insumos.containsKey(codigo) && tipo.equals("INSUMO")) {
                String descricao = (String) jsonItem.get("descricaoItemComposicao");
                String unidade = (String) jsonItem.get("unidadeItem");
                Double valor = stringToDouble((String) jsonItem.get("valorUnitario"));
                Insumo insumo = new Insumo(codigo, tipo, descricao, unidade, valor);
                insumos.put(codigo, insumo);
            }
        }
        return insumos;
    }

    public HashMap<Integer, Composicao> extraiComposicoes(JSONArray jsonArray) {
        HashMap<Integer, Composicao> composicoes = new HashMap<Integer, Composicao>();
        Iterator<JSONObject> iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonItem = iterator.next();
            if (!composicoes.containsKey(jsonItem.get("codigoComposicao"))) {
                Integer codigo = ((Long) jsonItem.get("codigoComposicao")).intValue();
                String descricao = (String) jsonItem.get("descricaoComposicao");
                String unidade = (String) jsonItem.get("unidadeItem");
                Composicao composicao = new Composicao(codigo, descricao, unidade);
                composicoes.put(codigo, composicao);
            }
        }
        return composicoes;
    }

    private Double stringToDouble(String valor) {
        if (valor == null || valor.isEmpty()) {
            return 0.0;
        }
        String valorComPonto = valor.replace(",", ".");
        return Double.parseDouble(valorComPonto);
    }
}