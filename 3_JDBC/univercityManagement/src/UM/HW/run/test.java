package UM.HW.run;

public class test {

	public static void main(String[] args) {

		String str = "19920213";
		char indexOne = str.charAt(2);
		char indexTwo = str.charAt(3);
		String sdnSet = String.valueOf(indexOne)+String.valueOf(indexTwo)+String.valueOf("00000");
		
		System.out.println(String.valueOf(indexOne));
		System.out.println(String.valueOf(indexTwo));
		System.out.println(sdnSet);
		System.out.println(String.valueOf("00000"));
		
		int sdnInt = Integer.parseInt(sdnSet) + (int)(Math.random()*100000);
		System.out.println(String.valueOf(sdnInt));
	}

}
