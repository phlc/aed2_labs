/*
Ciencia da Computação - Pucminas
AEDs II
Pedro Henrique Lima Carvalho
Matricula: 651230
Lab 07
*/


/*
* Classe No ----------------------------------------------------------
*/
class No{
	
//atributos
	No esq;
	char elemento;
	No dir;

//construtores
	public No(char x, No esq, No dir){
		this.esq=esq;
		this.elemento=x;
		this.dir=dir;
	}

	public No(char x){
		this(x, null, null);
	}

	public No(){
		this('a', null, null);
	}
}

/*
* Classe Arvore -----------------------------------------------------
*/

class Arvore{
	
//atributos
	private No raiz;

//contrutores
	public Arvore(){
		this.raiz=null;
	}

	public Arvore(char x){
		this.raiz= new No(x);
	}


//inserir
	public void inserir(char x) throws Exception{
		this.raiz = inserir(x, this.raiz);
	}	

	private No inserir(char x, No i) throws Exception{
		if (i==null)
			i=new No(x);
		else if(x<i.elemento)
			i.esq=inserir(x, i.esq);
		else if(x>i.elemento)
			i.dir=inserir(x, i.dir);
		else
			throw new Exception("Erro elemento existente");
		return i;
	}


//pesquisar
	public boolean pesquisar(char x){
		return (pesquisar(x, this.raiz));
	}

	private boolean pesquisar(char x, No i){
		boolean resp = false;
		if (i==null)
			resp=false;
		else if (x<i.elemento)
			resp=pesquisar(x, i.esq);
		else if (x>i.elemento)
			resp=pesquisar(x, i.dir);
		else
			resp=true;
		return resp;
	}

//remover
	public void remover (char x) throws Exception{
		this.raiz=remover(x, this.raiz);
	}	
	
	private No remover (char x, No i)throws Exception{
		if (i==null)
			throw new Exception("Elemento nao encontrado");
		else if (x<i.elemento)
			i.esq=remover(x, i.esq);
		else if (x>i.elemento)
			i.dir=remover(x, i.dir);
		else if (i.dir==null)
			i=i.esq;
		else if (i.esq==null)
			i=i.dir;
		else
			i.esq=anterior(i, i.esq);
		return i;
	}
	
	private No anterior(No i, No j){
		if (j.dir!=null)
			j.dir=anterior(i, j.dir);
		else{
			i.elemento=j.elemento;
			j=j.esq;
		}
		return j;
	}

//mostrar
	public void mostrarCentral(){
		mostrarCentral(this.raiz);
		System.out.println("");
	}	
	private void mostrarCentral(No i){
		if(i!=null){
			mostrarCentral(i.esq);
			System.out.print(i.elemento+" ");
			mostrarCentral(i.dir);
		}
	}
	

	public void mostrarPre(){
		mostrarPre(this.raiz);
		System.out.println("");
	}
	private void mostrarPre(No i){
		if(i!=null){
			System.out.print(i.elemento+" ");
			mostrarPre(i.esq);
			mostrarPre(i.dir);
		}
	}


	public void mostrarPos(){
		mostrarPos(this.raiz);
		System.out.println("");
	}
	private void mostrarPos(No i){
		if(i!=null){	
			mostrarPos(i.esq);
			mostrarPos(i.dir);
			System.out.print(i.elemento+" ");
		}
	}
}
/*
* Classe LAB07 ------------------------------------------------------------
*/

public class LAB07Q01{
	
// main
	public static void main(String[] args)throws Exception{
		int n = MyIO.readInt();

		for (int i=0; i<n; i++){
			int nos = MyIO.readInt();
			Arvore arv = new Arvore();
			for (int j=0; i<nos; i++){
				arv.inserir(MyIO.readChar());
			}
			MyIO.readLine();
			arv.mostrarPos();
		}

	}
}

