package classes_to_use_as_a_base;

public class tryingFeatureEnvy {
	
	private String easyCondition;
	private String hardCondition;
	
	public tryingFeatureEnvy() {
		this.easyCondition = "if(LOC>4)";
		this.hardCondition = "if(LOC>4&&CYCLO<3||ATFD==2&&LAA!=1)";
	}
	
	public String getEasyCondition() {
		return easyCondition;
	}
	
	public String getHardCondition() {
		return hardCondition;
	}
	
	private String getOperators(String s) {
		String result = "";
		String[] vector = s.split("if()");		
		String[] aux = vector[1].split("()");
		for(int i=0; i<aux.length-1; i++) {
			if(aux[i].equals("&") && aux[i+1].equals("&")) {
				result = result + "and ";
			}
			if(aux[i].equals("|") && aux[i+1].equals("|")) {
				result = result + "or ";
			}
		}
		if(result.equals("")) {
			return null;
		} else {
			return result;
		}
	}
	
	private String getSignals(String s) {
		String result = "";
		String[] vector = s.split("if()");		
		String[] aux = vector[1].split("()");
		for(int i=0; i<aux.length-1; i++) {
			if(aux[i].equals("<")) {
				result = result + "smaller ";
			}
			if(aux[i].equals(">")) {
				result = result + "bigger ";
			}
			if(aux[i].equals("=") && aux[i+1].equals("=")) {
				result = result + "equal ";
			}
			if(aux[i].equals("!") && aux[i+1].equals("=")) {
				result = result + "different ";
			}
		}
		return result;
	}
	
	private String getMetrics(String s) {
		String result = "";
		String[] vector = s.split("if()");		
		String[] aux = vector[1].split("()");
		for(int i=0; i<aux.length-2; i++) {
			if(aux[i].equals("L") && aux[i+1].equals("O") && aux[i+2].equals("C")) {
				result = result + "LOC ";
			}
			if(aux[i].equals("C") && aux[i+1].equals("Y") && aux[i+2].equals("C")) {
				result = result + "CYCLO ";
			}
			if(aux[i].equals("A") && aux[i+1].equals("T") && aux[i+2].equals("F")) {
				result = result + "ATFD ";
			}
			if(aux[i].equals("L") && aux[i+1].equals("A") && aux[i+2].equals("A")) {
				result = result + "LAA ";
			}
		}
		return result;
	}
	
	private String getValues(String s) {
		String result = "";
		String[] vector = s.split("if()");		
		String[] aux = vector[1].split("()");
		
		for(int i=0; i<aux.length; i++) {
			if(aux[i].matches(".*\\d.*")) {
				result = result + aux[i] + " ";
			}
		}
		return result;
	}
	
	private int getOperatorsNumber(String s) {
		String[] operators;
		if(getOperators(s)!=null){
			operators = getOperators(s).split(" ");
			return operators.length;
		} else {
			return 0;
		}
	}
	
	private int getSignalsNumber(String s) {
		String[] signals = getSignals(s).split(" ");
		return signals.length;
	}
	
	private int getMetricsNumber(String s) {
		String[] metrics = getMetrics(s).split(" ");
		return metrics.length;
	}
	
	private int getValuesNumber(String s) {
		String[] values = getValues(s).split(" ");
		return values.length;
	}
	
	
	private void dealWithOperatos(String s) {
		if(getOperatorsNumber(s)==0) {
			System.out.println("1 condição");
		}
		if(getOperatorsNumber(s)==1) {
			System.out.println("2 condições");
		}
		if(getOperatorsNumber(s)==2) {
			System.out.println("3 condições");
		}
		if(getOperatorsNumber(s)==3) {
			System.out.println("4 condições");
		}
	}
	
	public static void main(String[] args) {
		tryingFeatureEnvy fe = new tryingFeatureEnvy();
		
		System.out.println("//////////Easy condition//////////");
		System.out.println("Operators: " + fe.getOperators(fe.getEasyCondition()));
		System.out.println("Signals: " + fe.getSignals(fe.getEasyCondition()));
		System.out.println("Metrics: " + fe.getMetrics(fe.getEasyCondition()));
		System.out.println("Values: " + fe.getValues(fe.getEasyCondition()));
		fe.dealWithOperatos(fe.getEasyCondition());
		
		System.out.println("\n" + "//////////Hard condition//////////");
		System.out.println("Operators: " + fe.getOperators(fe.getHardCondition()));
		System.out.println("Signals: " + fe.getSignals(fe.getHardCondition()));
		System.out.println("Metrics: " + fe.getMetrics(fe.getHardCondition()));
		System.out.println("Values: " + fe.getValues(fe.getHardCondition()));
		fe.dealWithOperatos(fe.getHardCondition());
	}
		
}