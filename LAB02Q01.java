/**
* LAB 2 - Questao 1  - Combinador
* @author Pedro Henrique Lima Carvalho
* Matricula: 651230
* AED2 - Tarde - Puc Minas
*/
public class LAB02Q01{
	
	/**
	* Metodo main
	*/
	public static void main (String[] args){
		String um = MyIO.readString();
		String dois;	

		while (!isEnd(um)){
			dois = MyIO.readString();
			MyIO.println(combinador(um, dois));
			um = MyIO.readString();
		}
	}
	

	/**
	* isEnd - Verifica o fim das entradas
	* @param String
	* @return boolean
	*/
	public static boolean isEnd (String s){
		return (s.length()==3 && s.charAt(0)=='F' &&
			s.charAt(1)=='I' && s.charAt(2)=='M');
	}

	/**
	*combinador - combina duas strings letra a letra
	*@param String String
	*@return String
	*/
	public static String combinador (String um, String dois){
		String resp = "";

		for (int i=0; i<um.length() || i<dois.length(); i++){
			
			if (i<um.length())
				resp = resp+um.charAt(i);
			if (i<dois.length())
				resp = resp+dois.charAt(i);
		}

		return resp+'\r';
	}
}

