package data_service.CodeSmells;

public class QualityIndicators {

	
	/**
	 * Avalia a análise de código feita pelas ferramentas em termos de Long Method (iPlasma, PMD e a nossa ferramenta) e Feature Envy (apenas a nossa ferramenta).
	 * <p>
	 * Cria um array de inteiros e guarda lá a informação dos indicadores de qualidade pela ordem: 
	 * iPlasma (Long Method) -> PMD (Long Method) -> NossaFerramenta (Long Method) -> NossaFerramenta (Feature Envy).
	 * <p>
	 * Para cada método analisado pelas ferramentas, é recolhido o Indicador de Qualidade de cada ferramenta e de cada CodeSmell (no caso apenas da nossa ferramenta) 
	 * associado a esse mesmo método, até todos os métodos analisados terem sido tidos em conta.
	 * 
	 * @param scarray Array de objetos SourceCode, cada um corresponde a um método e a toda a informação quanto ao mesmo.
	 * @return Array criado pelo método com as informações dos Indicadores de Qualidade quanto a cada Ferramenta.
	 */
	public int[] analyseQI(SourceCode[] scarray){
		int[] qiarray = new int[16];
		for(int i = 0; i<scarray.length; i++){
			qiarray = qiiPlasma(qiarray, scarray[i]);
			qiarray = qiPMD(qiarray, scarray[i]);
			qiarray = qiTh_LM(qiarray, scarray[i]);
			qiarray = qiTh_FE(qiarray, scarray[i]);
		}
		return qiarray;
	}
	
	/**
	 * Avalia a análise do código feita pela ferramenta iPlasma quanto ao Long Method com Indicadores de Qualidade.
	 * <p>
	 * Se a análise do iPlasma deste método se tratar de um DCI, o método incrementa o primeiro índice 
	 * do array de inteiros, DII incrementa o segundo índice, ADCI o terceiro e ADII o quarto.
	 * 
	 * @param qi Array de inteiros onde vai ser guardada a informação dos Indicadores de Qualidade da ferramenta iPlasma quanto ao Long Method.
	 * @param sc Objeto SourceCode, correspondente a um método e a toda a informação quanto ao mesmo.
	 * @return Array de inteiros recebido como parâmetro (qi), acrescentado com o Indicador de Qualidade do iPlasma (Long Method) quanto ao parâmetro sc recebido.
	 */
	private int[] qiiPlasma(int[] qi, SourceCode sc){
		if(sc.getiPlasma() == true && sc.getIs_long_method() == true){
			qi[0]++;
		}
		if(sc.getiPlasma() == true && sc.getIs_long_method() == false){
			qi[1]++;
		}
		if(sc.getiPlasma() == false && sc.getIs_long_method() == false){
			qi[2]++;
		}
		if(sc.getiPlasma() == false && sc.getIs_long_method() == true){
			qi[3]++;
		}
		return qi;
	}
	
	/**
	 * Avalia a análise do código feita pela ferramenta PMD quanto ao Long Method com Indicadores de Qualidade.
	 * <p>
	 * Se a análise do PMD deste método se tratar de um DCI, o método incrementa o quinto índice 
	 * do array de inteiros, DII incrementa o sexto índice, ADCI o sétimo e ADII o oitavo.
	 * 
	 * @param qi Array de inteiros onde vai ser guardada a informação dos Indicadores de Qualidade da ferramenta PMD quanto ao Long Method.
	 * @param sc Objeto SourceCode, correspondente a um método e a toda a informação quanto ao mesmo.
	 * @return Array de inteiros recebido como parâmetro (qi), acrescentado com o Indicador de Qualidade do PMD (Long Method) quanto ao parâmetro sc recebido.
	 */
	private int[] qiPMD(int[] qi, SourceCode sc){
		if(sc.getPMD() == true && sc.getIs_long_method() == true){
			qi[4]++;
		}
		if(sc.getPMD() == true && sc.getIs_long_method() == false){
			qi[5]++;
		}
		if(sc.getPMD() == false && sc.getIs_long_method() == false){
			qi[6]++;
		}
		if(sc.getPMD() == false && sc.getIs_long_method() == true){
			qi[7]++;
		}
		return qi;
	}
	
	/**
	 * Avalia a análise do código feita pela nossa ferramenta quanto ao Long Method com Indicadores de Qualidade.
	 * <p>
	 * Se a análise da nossa ferramenta deste método se tratar de um DCI, o método incrementa o nono índice 
	 * do array de inteiros, DII incrementa o décimo índice, ADCI o décimo primeiro e ADII o décimo segundo.
	 * 
	 * @param qi Array de inteiros onde vai ser guardada a informação dos Indicadores de Qualidade da nossa ferramenta quanto ao Long Method.
	 * @param sc Objeto SourceCode, correspondente a um método e a toda a informação quanto ao mesmo.
	 * @return Array de inteiros recebido como parâmetro (qi), acrescentado com o Indicador de Qualidade da nossa ferramenta (Long Method) quanto ao parâmetro sc recebido.
	 */
	private int[] qiTh_LM(int[] qi, SourceCode sc){
//		if(sc.getTh_LM() == true && sc.getIs_long_method() == true){
//			qi[8]++;
//		}
//		if(sc.getTh_LM() == true && sc.getIs_long_method() == false){
//			qi[9]++;
//		}
//		if(sc.getTh_LM() == false && sc.getIs_long_method() == false){
//			qi[10]++;
//		}
//		if(sc.getTh_LM() == false && sc.getIs_long_method() == true){
//			qi[11]++;
//		}
		return qi;
	}
	
	/**
	 * Avalia a análise do código feita pela nossa ferramenta quanto ao Feature Envy com Indicadores de Qualidade.
	 * <p>
	 * Se a análise da nossa ferramenta deste método se tratar de um DCI, o método incrementa o décimo terceiro índice 
	 * do array de inteiros, DII incrementa o décimo quarto índice, ADCI o décimo quinto e ADII o décimo sexto.
	 * 
	 * @param qi Array de inteiros onde vai ser guardada a informação dos Indicadores de Qualidade da nossa ferramenta quanto ao Feature Envy.
	 * @param sc Objeto SourceCode, correspondente a um método e a toda a informação quanto ao mesmo.
	 * @return Array de inteiros recebido como parâmetro (qi), acrescentado com o Indicador de Qualidade da nossa ferramenta (Feature Envy) quanto ao parâmetro sc recebido.
	 */
	private int[] qiTh_FE(int[] qi, SourceCode sc){
//		if(sc.getTh_FE() == true && sc.getIs_featue_envy() == true){
//			qi[12]++;
//		}
//		if(sc.getTh_FE() == true && sc.getIs_featue_envy() == false){
//			qi[13]++;
//		}
//		if(sc.getTh_FE() == false && sc.getIs_featue_envy() == false){
//			qi[14]++;
//		}
//		if(sc.getTh_FE() == false && sc.getIs_featue_envy() == true){
//			qi[15]++;
//		}
		return qi;
	}
	
}