/**
* LAB 3 - Questao 1  - Sequencia Espelho
* @author Pedro Henrique Lima Carvalho
* Matricula: 651230
* AED2 - Tarde - Puc Minas
*/
public class LAB03Q01{
	
	/**
	* Metodo main
	*/
	public static void main (String[] args){
		String s = MyIO.readLine();	

		while (!isEnd(s)){
			espelho(s);
			s = MyIO.readLine();
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
	*espelho - mostra a sequencia numerica do intervelo de dois numeros espelhada 
	*@param String
	*/
	public static void espelho (String s){

		String[] nums = s.split(" ", 3);

		int ini = Integer.parseInt(nums[0]);
		int fim = Integer.parseInt(nums[1]);
		espelhar (seq(ini, fim));

	}

	/**
	*sequencia - cria uma sequencia de numeros
	*@param int int 
	*@return String
	*/
	public static String seq (int ini, int fim){
		String numeros = "";
		if (ini <= fim){
			numeros = numeros + ini + seq(ini+1, fim);
		}
		return numeros;
	}
	
	/**
	*espelhar - mostra a sequencia espelhada
	*@param String
	*/
	public static void espelhar (String s){
		espelhar (s, 0);
		MyIO.println("");
	}

	/**
	*espelhar - overload
	*@param String int
	*/
	public static void espelhar (String s, int i){
		if (i < s.length()){
			MyIO.print(s.charAt(i));
			espelhar(s, i+1);
			MyIO.print(s.charAt(i));
		}
	}
}

