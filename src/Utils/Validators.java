package Utils;

public class Validators {
	
	
	/**
	 * This method gets a number and returns a number
	 * @param str
	 * @return number
	 */
	public static Double string2Double(String str) {
		Double num = null;
		try {
			num = Double.parseDouble(str);			//parsing was successful
		}catch (Exception e){
			num = null;
		}
		
		return num; 
	}
}
