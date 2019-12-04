package ES1_2019_METI_112.ES_2019_2020_Project;

public class DefectDetectionThread extends Thread{
	
	private GUI_Defect_Detection GDD;
	private String type;
	private String tool;
	private String metric;
	private boolean stop;
	
	public DefectDetectionThread(GUI_Defect_Detection g, String ty, String t, String m) {
		this.GDD = g;
		this.type = ty;
		this.tool = t;
		this.metric = m;
		this.stop = true;
	}
	
	public void run() {
		if(type.equals("DCI")) {
			getResultsDCI(tool, metric);
		}
		if(type.equals("DII")) {
			getResultsDII(tool, metric);
		}
		if(type.equals("ADCI")) {
			getResultsADCI(tool, metric);
		}
		if(type.equals("ADII")) {
			getResultsADII(tool, metric);
		}
		while(stop==true) {
			//waiting for the end of task
		}
		if(stop==false) {
			GDD.setThreadWorkingDown();
		}
	}
	
	private void getResultsDCI(String tool, String metric) {
		int DCI = 0;
		int lines = GDD.getGOF().getGMC().getFile().getNumberOfLines();
		for(int i=1; i<lines; i++) {
			if(GDD.getGOF().getGMC().getFile().getCellValue(i, tool).equals("true") && 
			  GDD.getGOF().getGMC().getFile().getCellValue(i, metric).equals("true")) {
				DCI++;
			}
		}
		GDD.setDCI(DCI);
		stop = false;
	}
	
	private void getResultsDII(String tool, String metric) {
		int DII = 0;
		int lines = GDD.getGOF().getGMC().getFile().getNumberOfLines();
		for(int i=1; i<lines; i++) {
			if(GDD.getGOF().getGMC().getFile().getCellValue(i, tool).equals("true") && 
			  GDD.getGOF().getGMC().getFile().getCellValue(i, metric).equals("false")) {
				DII++;
			}
		}
		GDD.setDII(DII);
		stop = false;
	}
	
	private void getResultsADCI(String tool, String metric) {
		int ADCI = 0;
		int lines = GDD.getGOF().getGMC().getFile().getNumberOfLines();
		for(int i=1; i<lines; i++) {
			if(GDD.getGOF().getGMC().getFile().getCellValue(i, tool).equals("false") && 
			  GDD.getGOF().getGMC().getFile().getCellValue(i, metric).equals("false")) {
				ADCI++;
			}
		}
		GDD.setADCI(ADCI);
		stop = false;
	}
	
	private void getResultsADII(String tool, String metric) {
		int ADII = 0;
		int lines = GDD.getGOF().getGMC().getFile().getNumberOfLines();
		for(int i=1; i<lines; i++) {
			if(GDD.getGOF().getGMC().getFile().getCellValue(i, tool).equals("false") && 
			  GDD.getGOF().getGMC().getFile().getCellValue(i, metric).equals("true")) {
				ADII++;
			}
		}
		GDD.setADII(ADII);
		stop = false;
	}
	
}