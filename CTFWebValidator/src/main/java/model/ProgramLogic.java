package model;

import java.util.ArrayList;

public class ProgramLogic {
	
	private final String flag1u, flag1p, flag2, flag3u, flag3p, flag4;
	private final String resul1u = "admin", resul1p = "admin", resul2 = "Has robado un volumen!",
			resul3u = "ubuntu", resul3p = "osm4u", resul4 = "iamahostuser";
	private final String username, path;	
	
	private String scoreLine;
	private int csvArrayLenght, csvLineLength = 6;
	
	//getters and setters
	public int getCsvLineLength() {
		return csvLineLength;
	}

	public void setCsvLineLength(int csvLineLength) {
		this.csvLineLength = csvLineLength;
	}
	
	public int getCsvArrayLenght() {
		return this.csvArrayLenght;
	}

	//Initialize with given values
	public ProgramLogic(String username, String flag1u, String flag1p, String flag2, String flag3u, String flag3p, String flag4) {
		this.username = username;
		this.flag1u = flag1u;
		this.flag1p = flag1p;
		this.flag2 = flag2;
		this.flag3u = flag3u;
		this.flag3p = flag3p;
		this.flag4 = flag4;
		
		String currentUsersHomeDir = System.getProperty("user.home");
		this.path = currentUsersHomeDir + "/data.csv";
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
		
		String currentUsersHomeDir = System.getProperty("user.home");
		this.path = currentUsersHomeDir + "/data.csv";
	}
	
	//Checks how much score does the user gets
	public String checkResults() {
		
		this.scoreLine = "";
		int totalscore = 0;
		
		//Adds one point per correct answer.
		if(flag1u.equals(resul1u) && flag1p.equals(resul1p)) {
			totalscore++;
			scoreLine = scoreLine + ",1";
		} else {
			scoreLine = scoreLine + ",0";
		}
			
		if(flag2.equals(resul2)) {
			totalscore++;
			scoreLine = scoreLine + ",1";
		} else {
			scoreLine = scoreLine + ",0";
		}
			
		if(flag3u.equals(resul3u) && flag3p.equals(resul3p)) {
			totalscore++;
			scoreLine = scoreLine + ",1";
		} else {
			scoreLine = scoreLine + ",0";
		}
		
		if(flag4.equals(resul4)) {
			totalscore++;
			scoreLine = scoreLine + ",1";
		} else {
			scoreLine = scoreLine + ",0";
		}
		
		String strTotalscore = Integer.toString(totalscore);	
		scoreLine = "," + strTotalscore + scoreLine;
		
		return strTotalscore;
	}
	
	public void saveCSV() {

		boolean overwrite = true;
		String line = username + scoreLine + "\n";
		
        FileWR write = new FileWR(path, overwrite);
        write.writeString(line);
        write.closeWriter();
		
	}
	
	public String[][] readCSV() {
		
		FileWR read = new FileWR(path);
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
			for(int j =0; j < csvLineLength; j++) {
				arraytext[i][j]=temp[j];
			}		
		}
		
		return arraytext;
	}
	
	

}
