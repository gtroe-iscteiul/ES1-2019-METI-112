package ES1_2019_METI_112.ES_2019_2020_Project;

public class MethodDefinition {

	private String LOC;
	private String CYCLO;
	private String ATFD;
	private String LAA;
	
	/**
	 * Método construtor da classe
	 * @param loc - LOC (número de linhas do código)
	 * @param cyclo - CYCLO (complexidade ciclomática do método)
	 * @param atfd - ATFD (Acessos do método a métodos de outras classes)
	 * @param laa - LAA (Acessos do método a atributos da própria classe)
	 */
	public MethodDefinition(String loc, String cyclo, String atfd, String laa) {
		this.LOC = loc;
		this.CYCLO = cyclo;
		this.ATFD = atfd;
		this.LAA = laa;
	}
	
	//Getters e setters da classe
	
	public String getLOC () {
		return LOC;
	}
	
	public String getCYCLO () {
		return CYCLO;
	}
	
	public String getATFD () {
		return ATFD;
	}
	
	public String getLAA () {
		return LAA;
	}
	
	public void setLOC (String s) {
		LOC = s;
	}
	
	public void setCYCLO (String s) {
		CYCLO = s;
	}
	
	public void setATFD (String s) {
		ATFD = s;
	}
	
	public void setLAA (String s) {
		LAA = s;
	}	
	
	/**
	 * Este método verifica se o utilizador já inicializou os valores de threshold
	 * 
	 * @return Retorna TRUE se o utilizador tiver preenchido os campos e 
	 * FALSE caso não ainda não o tenha feito
	 */
	public boolean hasBeenInitialized() {
		boolean aux;
		if (LOC.equals("-1") && CYCLO.equals("-1") 
				&& ATFD.equals("-1") && LAA.equals("-1")) {
			aux = false;
		} else {
			aux = true;
		}
		return aux;
	}
	
	/**
	 * Este método serve é invocado no processo de calculo dos defeitos, mediante
	 * o utilizador tenha criado e seleccionado uma regra do tipo feature envy
	 * 
	 * @return Retorna um booleano
	 */
	public boolean featureEnvyDefinition() {
		boolean response;
		if(Double.parseDouble(ATFD) > 4 && Double.parseDouble(LAA) < 0.42){
			response = true;
		} else {
			response = false;
		}
		return response;
	}
	
	/**
	 * Este método serve é invocado no processo de calculo dos defeitos, mediante
	 * o utilizador tenha criado e seleccionado uma regra do tipo long method
	 * 
	 * @param fileLOC - LOC do Ficheiro 
	 * @param fileCYCLO - CYCLO do Ficheiro
	 * @param selectedLOC - LOC definido pelo utilizador na regra criada
	 * @param selectedCYCLO - CYCLO definido pelo utilizador na regra criada
	 * 
	 * @return Retorna um booleano
	 */
	public boolean longMethodDefinition(String fileLOC, String fileCYCLO, 
			double selectedLOC, double selectedCYCLO) {
		boolean response;
		if(Double.parseDouble(fileLOC) > selectedLOC && 
				Double.parseDouble(fileCYCLO) > selectedCYCLO) {
			response = true;
		} else {
			response = false;
		}
		return response;
	}
	
}
