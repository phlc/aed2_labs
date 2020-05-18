/*
Ciencia da Computação - Pucminas
AEDs II
Pedro Henrique Lima Carvalho
Matricula: 651230
Lab 07
*/


/*
* Classe LAB07 ------------------------------------------------------------
*/

public class LAB07Q01{
	

	public static void printPos(String pre, String inf){
		if (inf.length()>0){
			String[] part = inf.split(""+pre.charAt(0));
			for (int i=0; i<part.length; i++){
				int j = 1;
				while (j<pre.length() && !part[i].contains(""+pre.charAt(j))){
					j++;
				}
				printPos(pre.substring(j), part[i]);
				
			}
			System.out.print(pre.charAt(0));
		
		} 
	}

// main
	public static void main(String[] args)throws Exception{
		int n = MyIO.readInt();

		for (int i=0; i<n; i++){
			int nos = MyIO.readInt();
			String pre = MyIO.readString();
			String inf = MyIO.readString();

			printPos(pre, inf);
			System.out.println("");

		}

	}
}

