package model;

public class ProgramLogic {
	
	private final String flag1u, flag1p, flag2, flag3u, flag3p, flag4;
	private final String resul1u = "admin", resul1p = "admin", resul2 = "volume secret key",
			resul3u = "ubuntu", resul3p = "osm4u", resul4 = "k8s secret key";
	private final String username;
	
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
		
		int score = 0;
		
		//Adds one point per correct answer.
		if(flag1u.equals(resul1u))
			score++;
		if(flag1p.equals(resul1p))
			score++;
		if(flag2.equals(resul2))
			score++;
		if(flag3u.equals(resul3u))
			score++;
		if(flag3p.equals(resul3p))
			score++;
		if(flag4.equals(resul4))
			score++;
		
		return Integer.toString(score);
	}

}
