/*
Algoritmos e Estrutura de Dados 2 - Pucminas
Pedro Henrique Lima Carvalho
Mat: 651230
Turno:Tarde
*/

class Celula{
	public int elemento;
	public Celula prox;

	public Celula (int x){
		this.elemento = x;
		this.prox = null;
	}
		
	public Celula (){
		this(0);
	}

}

class Pilha{
	private Celula topo;

	public Pilha(){
		this.topo=null;
	}

	public void inserir(int x){
		Celula tmp = new Celula(x);
		tmp.prox=this.topo;
		this.topo=tmp;
		tmp=null;
	}

	public int remover() throws Exception{
		if (topo == null)
			throw new Exception("Pilha Vazia");
		int resp = topo.elemento;
		Celula tmp = topo;
		topo=topo.prox;
		tmp.prox=null;
		tmp=null;
		return resp;
	}

	public void mostrar(){
		System.out.print("[ ");
		for (Celula i=this.topo; i!=null; i=i.prox){
			System.out.print(i.elemento + " ");
		}
		System.out.println("]");
	}

	private int somarRec(Celula cel){
		int resp = 0;

		if (cel != null){
			resp=cel.elemento;
			resp += somarRec(cel.prox);
		}

		return resp;
	}

	public int somarRec(){
		return (somarRec(this.topo));
	}

	public int maior() throws Exception{
		if (topo==null)
			throw new Exception ("Pilha Vazia");

		int maior = topo.elemento;

		for (Celula i=topo.prox; i!=null; i=i.prox){
			if (maior < i.elemento)
				maior = i.elemento;
		}
		return maior;
	}

	public int maiorRec() throws Exception{
		if (topo==null)
			throw new Exception ("Pilha Vazia");
		return maiorRec(topo);
	}

	public int maiorRec(Celula cel){
		int resp = cel.elemento;
		if (cel.prox != null){
			int tmp = maiorRec(cel.prox);
			if (tmp > resp)
				resp = tmp;
		}

		return resp;
	}

	public void mostrarRec() {
		System.out.print("[ ");
		if (topo != null)
			mostrarRec(this.topo);
		System.out.println("]");
	}
	
	public void mostrarRec(Celula i){
		System.out.print(i.elemento+" ");
		if(i.prox != null)
			mostrarRec(i.prox);
	}

	public void mostrarRecInv(){
		System.out.print("[ ");
		if (topo != null)
			mostrarRecInv(this.topo);
		System.out.println("]");
	}
	
	public void mostrarRecInv(Celula i){
			if(i.prox != null)
		 		mostrarRecInv(i.prox);
			System.out.print(i.elemento+" ");

	}

	public void mostrarInv(){
		System.out.print("[ ");
		if (topo !=null){
			Celula anterior=topo;
			Celula ultima=topo;
			while (ultima.prox != null){
				anterior = ultima;
				ultima = ultima.prox;
			}

			System.out.print(ultima.elemento+" ");

			while(ultima!=topo){
				ultima=anterior;
				anterior=topo;
				while (ultima!=topo && anterior.prox!=ultima){
					anterior=anterior.prox;
				}
				System.out.print(ultima.elemento+" ");
			}
		}
		System.out.println("]");
	}
}


public class LAB05Q01{
	public static void main(String[] args) throws Exception{
		Pilha stack = new Pilha();

		stack.inserir(3);
		stack.inserir(5);
		stack.inserir(7);
		stack.inserir(8);
		
		stack.mostrar();
		stack.remover();
		stack.mostrar();

		System.out.println("SomarRec: "+stack.somarRec());
		System.out.println("Maior: "+stack.maior());
		System.out.println("MaiorRec: "+stack.maiorRec());
		
		stack.mostrarRec();
		stack.mostrarRecInv();
		stack.mostrarInv();
	}	
}
