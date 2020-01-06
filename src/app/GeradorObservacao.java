package app;

import java.util.ArrayList;
import java.util.List;

public class GeradorObservacao {

	private final String TEXTO_NOTA_FISCAL_SINGULAR = "Fatura da nota fiscal de simples remessa: ";
	private final String TEXTO_NOTA_FISCAL_PLURAL = "Fatura das notas fiscais de simples remessa: ";

	public String geraObservacao(List lista) {
		if (lista.isEmpty()) {
			return "";
		}
		ArrayList<Integer> listaArrayList = new ArrayList<Integer>(lista);
		ArrayList<String> codigosListaString = converteArrayList(listaArrayList);
		String textoFatura = textoFatura(listaArrayList.size());
		String codigosFatura = juntaCodigosFatura(codigosListaString);
		return textoFatura + codigosFatura;
	}

	protected String textoFatura(Integer tamanhoLista) {
		if (tamanhoLista == 1) {
			return TEXTO_NOTA_FISCAL_SINGULAR;
		} else {
			return TEXTO_NOTA_FISCAL_PLURAL;
		}
	}

	protected String juntaCodigosFatura(ArrayList<String> codigos) {
		ArrayList<String> novoCodigos = new ArrayList<String>();
		for (int i = 0; i < codigos.size(); i++) {
			String codigo = codigos.get(i);
			Boolean penultimoElemento = i == codigos.size() - 2;
			Boolean ultimoElemento = i == codigos.size() - 1;
			if (ultimoElemento) {
				novoCodigos.add(codigo);
			} else if (penultimoElemento) {
				novoCodigos.add(codigo + " e ");
			} else {
				novoCodigos.add(codigo + ", ");
			}
		}
		String novoCodigosTexto = String.join("", novoCodigos);
		return novoCodigosTexto;
	}

	protected ArrayList<String> converteArrayList(ArrayList<Integer> lista) {
		ArrayList<String> arrayListString = new ArrayList<String>();
		for (Integer i : lista) {
			arrayListString.add(String.valueOf(i));
		}
		return arrayListString;
	}
}
