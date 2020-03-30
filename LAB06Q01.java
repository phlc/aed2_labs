/*
Algoritmos e Estrutura de Dados 2 - Pucminas
Pedro Henrique Lima Carvalho
Mat: 651230
Turno:Tarde
*/

import java.util.Scanner;

class Celula{
	public Celula ant;
	public int elemento;
	public Celula prox;

	public Celula (int x){
		this.ant = null;
		this.elemento = x;
		this.prox = null;
	}
		
	public Celula (){
		this(0);
	}

}

class Lista{
	private Celula primeiro, ultimo;

	public Lista(){
		this.primeiro = new Celula();
		this.ultimo = this.primeiro;
	}

	public void inserirInicio(int x){
		Celula tmp = new Celula(x);
		tmp.ant=primeiro;
		tmp.prox=primeiro.prox;
		primeiro.prox=tmp;
		if(primeiro==ultimo)
			ultimo=tmp;
		else
			tmp.prox.ant=tmp;
		tmp=null;
	}
	
	public void inserirFim(int x){
		ultimo.prox = new Celula(x);
		ultimo.prox.ant=ultimo;
		ultimo=ultimo.prox;
	}

	private int tamanho(){
		int resp = 0;
		for(Celula i=primeiro; i.prox!=null; i=i.prox){
			resp++;
		}
		return resp;

	}

	public void inserirPos(int x, int pos) throws Exception{
		int tamanho = this.tamanho();
		if (pos < 0 || pos > tamanho)
			throw new Exception("Posicao Inexistente");
		else if (pos==0)
			inserirInicio(x);
		else if (pos==tamanho)
			inserirFim(x);
		else{

			Celula i = primeiro;
			for(int j=0; j<pos; j++){
				i=i.prox;
			}

			Celula tmp = new Celula(x);
		
			tmp.ant=i;
			tmp.prox=i.prox;
			i.prox=tmp;
			tmp.prox.ant=tmp;
			tmp=null;
			i=null;
		}
	}


	public int removerInicio() throws Exception{
		if (primeiro == ultimo)
			throw new Exception("Lista Vazia");
		Celula tmp  = primeiro;
		primeiro = primeiro.prox;
		int resp = primeiro.elemento;
		primeiro.ant=null;
		tmp.prox=null;
		tmp=null;
		return resp;
	}

	public int removerFim() throws Exception{
		if (primeiro == ultimo)
			throw new Exception("Lista Vazia");
		int resp = ultimo.elemento;
		ultimo=ultimo.ant;
		ultimo.prox.ant=null;
		ultimo.prox=null;
		return resp;
	}


	public int removerPos(int pos) throws Exception{
		int resp;
		int tamanho=this.tamanho();
		if (pos<0 || pos>tamanho-1)
			throw new Exception("Posicao Inexistente");
		else if (pos==0)
			resp = removerInicio();
		else if (pos==tamanho-1)
			resp = removerFim();
		else{
			Celula i = primeiro.prox;
			for(int j=0; j<pos; j++){
				i=i.prox;
			}
			i.ant.prox=i.prox;
			i.prox.ant=i.ant;
			resp=i.elemento;
			i.prox=i.ant=null;
			i=null;
		}

		return resp;
	}

	public void ordenarInsercao(){
		for (Celula i=primeiro.prox.prox; i!=null; i=i.prox){
			int tmp = i.elemento;
			
			Celula j=i.ant;

			while(j!=primeiro && j.elemento>tmp){
				j.prox.elemento=j.elemento;
				j=j.ant;
			}
			j.prox.elemento=tmp;
		}

	}

	public int mostrar(int pos) throws Exception{
		int resp;
		int tamanho=this.tamanho();
		if (pos<0 || pos>tamanho-1)
			throw new Exception ("Posicao Inexistente");
		Celula i=primeiro.prox;

		for (int j=0; j<pos; j++){
			i=i.prox;
		}
		return i.elemento;
	}
}


public class LAB06Q01{
	public static void main(String[] args) throws Exception{
		Scanner leitor = new Scanner(System.in);
	
		while (leitor.hasNext()){
			int qnt = leitor.nextInt();
			Lista l = new Lista();
			int tel = 0;
			int eco = 0;
			for (int i=0; i<qnt; i++){
				tel = leitor.nextInt();
				l.inserirFim(tel);
			}
			
			l.ordenarInsercao();
				
			for(int i=1; i<qnt; i++){
				String str1="";
				String str2="";
			
				str1=str1+l.mostrar(i-1);
				str2=str2+l.mostrar(i);	
				for (int j=0; j<str1.length()-1 && j<str2.length()-1 
					      && str1.charAt(j)==str2.charAt(j); j++){
					eco++;
				}			
			}
			System.out.println(eco);
		}		
	}
}
