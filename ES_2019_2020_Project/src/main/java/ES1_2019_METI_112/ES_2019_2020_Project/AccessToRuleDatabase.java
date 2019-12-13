package ES1_2019_METI_112.ES_2019_2020_Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.LinkedList;

public class AccessToRuleDatabase {
	
	private String path;
	private LinkedList<String> deleteManager;
	
	/**
	 * Construtor da classe
	 * @param path - path do ficheiro
	 */
	public AccessToRuleDatabase(String path) {
		this.path = path;
		this.deleteManager = new LinkedList<>();
	}
	
	
	/**
	 * Este método serve para adicionar conteúdo à Database
	 * @param textLine - Conteúdo para adicionar à Databse
	 * @param operation - Booleano que quando está a true, cria a Database e 
	 * quando está a falso adiciona conteúdo à database
	 * @throws IOException
	 */
	public void writeToFile(String textLine, boolean operation) throws IOException {
		FileWriter write = new FileWriter(path, operation);
		PrintWriter print_line = new PrintWriter(write);
		print_line.printf("%s" + "%n" , textLine);
		print_line.close();	
	}
		
	
	/**
	 * Este método serve para ler o conteúdo da nossa database
	 * @return Retorna um vetor de Strings
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public String[] readFile() throws IOException {
		String[] vector = new String[getNumberOfLines()];
		BufferedReader br = new BufferedReader(new FileReader(path)); 
		for (int i = 0; i < getNumberOfLines(); i++) {
			vector[i] = br.readLine();
		}
		return vector;
	}
	
	
	/**
	 * Este método retorna o conteúdo específico de uma dada linha da database
	 * @param line - Linha para retorna
	 * @return - Retorna uma linha específica da database
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public String[] getLine(int line) throws IOException {
		String[] vector = new String[getNumberOfLines()];
		BufferedReader br = new BufferedReader(new FileReader(path)); 
		for (int i = 0; i < getNumberOfLines(); i++) {
			if(i==(line-1)) {
				vector[i] = br.readLine();
			}
		}
		return vector;
	}
	
	
	/**
	 * Este método serve para determinar o número de linhas existentes na database
	 * @return Retorna o número de linhas da database
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public int getNumberOfLines() throws IOException {
		File file = new File(path);
		LineNumberReader count = new LineNumberReader(new FileReader(file));
		count.skip(file.length());
		return count.getLineNumber();		
	}
	
	
	/**
	 * Este método serve para apagar uma regra da database
	 * @param rule - Regra a apagar 
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public void deleteRule(String rule) throws IOException {
		String[] vector = new String[getNumberOfLines()];
		BufferedReader br = new BufferedReader(new FileReader(path)); 
		for (int i = 0; i < getNumberOfLines(); i++) {
			vector[i] = br.readLine();
			if(!vector[i].equals(rule)) {
				deleteManager.add(vector[i]);
			}
		}
		updateDatabase();
	}
	
	
	/**
	 * Este método faz update à database 
	 * @throws IOException
	 */
	private void updateDatabase() throws IOException {
		for(String i : deleteManager) {
			if(deleteManager.getFirst().equals(i)) {
				writeToFile(i.toString(), false);
			} else {
				writeToFile(i.toString(), true);
			}
		}
	}
	
}