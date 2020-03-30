/*
Algoritmos e Estrutura de Dados 2 - Pucminas
Pedro Henrique Lima Carvalho
Mat: 651230
Turno:Tarde
*/

import java.util.Scanner;

class Celula{
	public Celula ant;
	public String elemento;
	public Celula prox;

	public Celula (String s){
		this.ant = null;
		this.elemento = s;
		this.prox = null;
	}
		
	public Celula (){
		this("");
	}

}

class Lista{
	private Celula primeiro, ultimo;

	public Lista(){
		this.primeiro = new Celula();
		this.ultimo = this.primeiro;
	}

	public void inserirInicio(String s){
		Celula tmp = new Celula(s);
		tmp.ant=primeiro;
		tmp.prox=primeiro.prox;
		primeiro.prox=tmp;
		if(primeiro==ultimo)
			ultimo=tmp;
		else
			tmp.prox.ant=tmp;
		tmp=null;
	}
	
	public void inserirFim(String s){
		ultimo.prox = new Celula(s);
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

	public void inserirPos(String s, int pos) throws Exception{
		int tamanho = this.tamanho();
		if (pos < 0 || pos > tamanho)
			throw new Exception("Posicao Inexistente");
		else if (pos==0)
			inserirInicio(s);
		else if (pos==tamanho)
			inserirFim(s);
		else{

			Celula i = primeiro;
			for(int j=0; j<pos; j++){
				i=i.prox;
			}

			Celula tmp = new Celula(s);
		
			tmp.ant=i;
			tmp.prox=i.prox;
			i.prox=tmp;
			tmp.prox.ant=tmp;
			tmp=null;
			i=null;
		}
	}


	public String removerInicio() throws Exception{
		if (primeiro == ultimo)
			throw new Exception("Lista Vazia");
		Celula tmp  = primeiro;
		primeiro = primeiro.prox;
		String resp = primeiro.elemento;
		primeiro.ant=null;
		tmp.prox=null;
		tmp=null;
		return resp;
	}

	public String removerFim() throws Exception{
		if (primeiro == ultimo)
			throw new Exception("Lista Vazia");
		String resp = ultimo.elemento;
		ultimo=ultimo.ant;
		ultimo.prox.ant=null;
		ultimo.prox=null;
		return resp;
	}


	public String removerPos(int pos) throws Exception{
		String resp;
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
			String tmp = i.elemento;
			
			Celula j=i.ant;

			while(j!=primeiro && j.elemento.compareTo(tmp)>0){
				j.prox.elemento=j.elemento;
				j=j.ant;
			}
			j.prox.elemento=tmp;
		}

	}

	public int economia() throws Exception{
		int resp = 0;

		for (Celula i=primeiro.prox; i.prox!=null; i=i.prox){
			for(int j=0; j<i.elemento.length(); j++){
				if(i.elemento.charAt(j)==i.prox.elemento.charAt(j))
					resp++;
				else
					j=i.elemento.length();
			}	
		}	
		return resp;
	}
}


public class LAB06Q01{
	public static void main(String[] args) throws Exception{
		Scanner leitor = new Scanner(System.in);
	
		while (leitor.hasNext()){
			int qnt = Integer.parseInt(leitor.nextLine());
			Lista l = new Lista();
			String tel;
			for (int i=0; i<qnt; i++){
				tel = leitor.nextLine();
				l.inserirFim(tel);
			}
			
			l.ordenarInsercao();
			System.out.println(l.economia());
		}
		leitor.close();		
	}
}
