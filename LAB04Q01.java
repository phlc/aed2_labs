/**
* LAB 4 - Questao 1  - Sequencia Espelho
* @author Pedro Henrique Lima Carvalho
* Matricula: 651230
* AED2 - Tarde - Puc Minas
*/
public class LAB04Q01{
	
	/**
	* Metodo main
	*/
	public static void main (String[] args){
		String s = MyIO.readLine();	

		while (!isEnd(s)){
			parenteses(s);
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
	*parenteses - verifica se os parenteses de uma string estao corretos 
	*@param String
	*/
	public static void parenteses (String s){
		
		int c = 0; //controle

		for (int i=0; i<s.length()&&c>=0; i++){
			if(s.charAt(i)=='(')
				c++;
			if(s.charAt(i)==')')
				c--;
		}	
		
		if (c!=0)
			MyIO.println("incorreto");
		else
			MyIO.println("correto");
	}
}

