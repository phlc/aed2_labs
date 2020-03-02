 class LAB01Q02 {
   public static int isMaiuscula (char c){
      if (c >= 'A' && c <= 'Z')
	return 1;
      else
	return 0;
   }

   public static boolean isFim(String s){
      return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static int quantasMaiusculas(String s, int ref){
      if (ref < s.length()){
      	return (isMaiuscula(s.charAt(ref))+quantasMaiusculas(s, ++ref));
      } else {
	return 0;
      }  
   }

   public static void mostrarContagemLetrasMaiusculas (String[] entrada, int ref, int length){

      if (ref < length){
	MyIO.println(quantasMaiusculas(entrada[ref], 0));
	mostrarContagemLetrasMaiusculas (entrada, ++ref, length);         
      }
   }

   public static void main (String[] args){
      String[] entrada = new String[1000];
      int numEntrada = 0;

      //Leitura da entrada padrao
      do {
         entrada[numEntrada] = MyIO.readLine();
      } while (isFim(entrada[numEntrada++]) == false);
      numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
      
      //chamar mostraContagemLetrasMaiusculas que conta e printa recusivamente as letras maiusculas
      mostrarContagemLetrasMaiusculas(entrada, 0, numEntrada);
   }
}
