package ES1_2019_METI_112.ES_2019_2020_Project;

public class MethodDefinition {

	private String LOC;
	private String CYCLO;
	private String ATFD;
	private String LAA;
	
	public MethodDefinition(String loc, String cyclo, String atfd, String laa) {
		this.LOC = loc;
		this.CYCLO = cyclo;
		this.ATFD = atfd;
		this.LAA = laa;
	}
	
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
	
	public boolean longMethodDefinition() {
		boolean response;
		if(Integer.parseInt(LOC) > 80 && Integer.parseInt(CYCLO) > 10) {
			response = true;
		} else {
			response = false;
		}
		return response;
	}
	
	public boolean featureEnvyDefinition() {
		boolean response;
		if(LOC.equals("4") && CYCLO.equals("0.42")) {
			response = true;
		} else {
			response = false;
		}
		return response;
	}
	
}
