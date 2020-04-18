/*
AEDs 2 - Ciencia da Computacao - Pucminas
Pedro Henrique Lima Carvalho - 651230
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Lista{
	int tam;
	char** elementos;
	int ultimo;

} Lista;

int fatorial(int n){
	int resp=1;
	if(n>1)
		resp = n*(fatorial(n-1));
	return resp;
}

void construtorLista(Lista* p_list, int length){
		p_list->tam = fatorial(length);
		p_list->elementos = (char**) malloc (sizeof(char*) * p_list->tam);
		p_list->ultimo=0;
}

void inserir(Lista* p_list, char* word){
	p_list->elementos[p_list->ultimo]=word;
	p_list->ultimo++;
}


void initString(char* palavra, int length){
	for (int i=0; i<length; i++){
		palavra[i]='\0';
	}
}

void permutacoesRec(Lista* p_list, char* word, char*bag);

void gerarPermutacoes(Lista* p_list, char* palavra){
	char* word = (char*) malloc(sizeof(char)*strlen(palavra)+1);
	initString(word, strlen(palavra)+1);
	char* bag = (char*) malloc(sizeof(char)*strlen(palavra)+1);
	strcpy(bag, palavra);
	permutacoesRec(p_list, word, bag);
}

void permutacoesRec(Lista* p_list, char* word, char* bag){
	int controle = 0;
	for (int i=0; i<strlen(bag); i++){
		if(bag[i]!='*'){
			controle = 1;

			char* new_word = (char*) malloc(sizeof(char)*strlen(bag)+1);
			initString(new_word, strlen(bag)+1);
			strcpy(new_word, word);

			new_word[strlen(word)]=bag[i];

			char* new_bag = (char*) malloc(sizeof(char)*strlen(bag)+1);
			initString(new_bag, strlen(bag)+1);
			strcpy(new_bag, bag);

			new_bag[i]='*';
			permutacoesRec(p_list, new_word, new_bag);
		}
	}	
	if (controle==0)
		inserir(p_list, word);
}

void mostrar(Lista* p_list){
	for (int i=0; i<p_list->ultimo; i++){
		printf("%i: %s\n", i+1, p_list->elementos[i]);
	}
	printf("%s", "\n");
}

void ordenar(Lista* p_list){
	for(int i=1; i<p_list->ultimo; i++){
		int j=i;
		while (j>0 && strcmp(p_list->elementos[j-1], p_list->elementos[j])>0){
			char* buffer = p_list->elementos[j-1];
			p_list->elementos[j-1] = p_list->elementos[j];
			p_list->elementos[j] = buffer;
			j--;
		} 
	}
}


int main(){
	int qnt = 0;
	scanf("%d", &qnt);

	for (int i=0; i<qnt; i++){
		//alocar memoria p/ palavra
		char* palavra = (char*) malloc(sizeof(char) * 11);
		
		//inicializar palavra \0
		initString(palavra, 11);
		
		//ler palavra
		scanf("%s", palavra);

		//criar lista
		Lista* p_list = (Lista*) malloc(sizeof(Lista));
		
		//inicializar lista
		construtorLista(p_list, strlen(palavra));

		//gerar permutacoes
		gerarPermutacoes(p_list, palavra);
		
		//ordenar lista
		ordenar(p_list);
		
		//mostrar
		mostrar(p_list);	
	}
}




