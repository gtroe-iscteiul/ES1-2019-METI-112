package ES1_2019_METI_112.ES_2019_2020_Project;

public class DefinitionMethod {

	private int LOC;
	private int CYCLO;
	private int ATFD;
	private int LAA;
	
	private boolean is_long_method;
	private boolean feature_envy;
	
	
	public boolean longMethodDefinition() {
		if(LOC > 80 && CYCLO > 10) {
			return true;
		}
		return false;
	}
	
	
}
