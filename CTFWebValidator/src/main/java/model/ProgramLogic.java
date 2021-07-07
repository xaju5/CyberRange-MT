package model;

import java.util.ArrayList;

public class ProgramLogic {
	
	private final String flag1u, flag1p, flag2, flag3u, flag3p, flag4;
	private final String resul1u = "admin", resul1p = "admin", resul2 = "volume secret key",
			resul3u = "ubuntu", resul3p = "osm4u", resul4 = "k8s secret key";
	private final String username, PATH = "workspace/CTFWebValidator/data.csv";	
	
	private String score;
	private int csvArrayLenght, csvLineLength = 2;
	
	//Initialize with given values
	public ProgramLogic(String username, String flag1u, String flag1p, String flag2, String flag3u, String flag3p, String flag4) {
		this.username = username;
		this.flag1u = flag1u;
		this.flag1p = flag1p;
		this.flag2 = flag2;
		this.flag3u = flag3u;
		this.flag3p = flag3p;
		this.flag4 = flag4;
	}
	
	//If there are not values, initialize with null
	public ProgramLogic() {
		this.username = null;
		this.flag1u = null;
		this.flag1p = null;
		this.flag2 = null;
		this.flag3u = null;
		this.flag3p = null;
		this.flag4 = null;
	}
	
	//Checks how much score does the user gets
	public String checkResults() {
		
		int intscore = 0;
		//Adds one point per correct answer.
		if(flag1u.equals(resul1u))
			intscore++;
		if(flag1p.equals(resul1p))
			intscore++;
		if(flag2.equals(resul2))
			intscore++;
		if(flag3u.equals(resul3u))
			intscore++;
		if(flag3p.equals(resul3p))
			intscore++;
		if(flag4.equals(resul4))
			intscore++;
		
		this.score = Integer.toString(intscore);
		return score;
	}
	
	public void saveCSV() {

		boolean overwrite = true;
		String line = username + "," + score + "\n";
		
        FileWR write = new FileWR(PATH, overwrite);
        write.writeString(line);
        write.closeWriter();
		
	}
	
	public String[][] readCSV() {
		
		FileWR read = new FileWR(PATH);
		String line;
				
		ArrayList<String> csvtext = new ArrayList<String>();
		
		while((line = read.readLine()) != null){
			csvtext.add(line);
		}
		read.closeReader();
		
		this.csvArrayLenght = csvtext.size();
		
		String arraytext [][] = new String [csvArrayLenght][csvLineLength]; 
		
		for(int i=0; i < csvArrayLenght; i++) {
			String temp [] = csvtext.get(i).split(",");
			arraytext[i][0] = temp[0];
			arraytext[i][1] = temp[1];			
		}
		
		return arraytext;
	}
	
	public int getCsvArrayLenght() {
		return this.csvArrayLenght;
	}

}
