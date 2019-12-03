package ES1_2019_METI_112.ES_2019_2020_Project;

public class DefectDetectionThread extends Thread{
	
	private GUI_Defect_Detection GDD;
	private String type;
	private String tool;
	private String metric;
	
	public DefectDetectionThread(GUI_Defect_Detection g, String ty, String t, String m) {
		this.GDD = g;
		this.type = ty;
		this.tool = t;
		this.metric = m;
	}
/*	
	public void run() {
		System.out.println(this + " started!");
		GDD.setThreadWorkingUp();
		System.out.println(GDD.getThreadsWorking());
		if(type.equals("DCI")) {
			getResultsDCI(tool, metric);
//			GDD.setDCI(getResultsDCI(tool, metric));
		}
		if(type.equals("DII")) {
			getResultsDII(tool, metric);
//			GDD.setDII(getResultsDII(tool, metric));
		}
		if(type.equals("ADCI")) {
			getResultsADCI(tool, metric);
//			GDD.setADCI(getResultsADCI(tool, metric));
		}
		if(type.equals("ADII")) {
			getResultsADII(tool, metric);
//			GDD.setADII(getResultsADII(tool, metric));
		}
	}
	
//	private int getResultsDCI(String tool, String metric) {
	private void getResultsDCI(String tool, String metric) {
		int DCI = 0;
		int lines = GDD.getGOF().getGMC().getFile().getNumberOfLines();
		for(int i=1; i<lines; i++) {
			if(GDD.getGOF().getGMC().getFile().getCellValue(i, tool).equals("true") && 
			  GDD.getGOF().getGMC().getFile().getCellValue(i, metric).equals("true")) {
				DCI++;
			}
		}
//		return DCI;
		GDD.setDCI(DCI);
		System.out.println(this + " finished!");
		GDD.setThreadWorkingDown();
	}
	
	
//	private int getResultsDII(String tool, String metric) {
	private void getResultsDII(String tool, String metric) {
		int DII = 0;
		int lines = GDD.getGOF().getGMC().getFile().getNumberOfLines();
		for(int i=1; i<lines; i++) {
			if(GDD.getGOF().getGMC().getFile().getCellValue(i, tool).equals("true") && 
			  GDD.getGOF().getGMC().getFile().getCellValue(i, metric).equals("false")) {
				DII++;
			}
		}
//		return DII;
		GDD.setDII(DII);
		System.out.println(this + " finished!");
		GDD.setThreadWorkingDown();
	}
	
//	private int getResultsADCI(String tool, String metric) {
	private void getResultsADCI(String tool, String metric) {
		int ADCI = 0;
		int lines = GDD.getGOF().getGMC().getFile().getNumberOfLines();
		for(int i=1; i<lines; i++) {
			if(GDD.getGOF().getGMC().getFile().getCellValue(i, tool).equals("false") && 
			  GDD.getGOF().getGMC().getFile().getCellValue(i, metric).equals("false")) {
				ADCI++;
			}
		}
//		return ADCI;
		GDD.setADCI(ADCI);
		System.out.println(this + " finished!");
		GDD.setThreadWorkingDown();
	}
	
	
//	private int getResultsADII(String tool, String metric) {
	private void getResultsADII(String tool, String metric) {
		int ADII = 0;
		int lines = GDD.getGOF().getGMC().getFile().getNumberOfLines();
		for(int i=1; i<lines; i++) {
			if(GDD.getGOF().getGMC().getFile().getCellValue(i, tool).equals("false") && 
			  GDD.getGOF().getGMC().getFile().getCellValue(i, metric).equals("true")) {
				ADII++;
			}
		}
//		return ADII;
		GDD.setADII(ADII);
		System.out.println(this + " finished!");
		GDD.setThreadWorkingDown();
	}
*/	
}