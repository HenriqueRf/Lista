import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class ListaSimples {
  No inicio;
  int tamanho;

  public void inserir(String info) {
    No no = new No();
    no.info = info;
    no.prox = inicio;
    inicio = no;
    tamanho++;
  }

  public String toString() {
    String str = "(" + tamanho + ") ";
    No local = inicio;
    while(local != null){
      str += local.info+ " ";
      local = local.prox;
    }
    return str;
    }
  
public String remove(){
    if(inicio == null){
        return null;
    }
        String info = inicio.info;
        inicio = inicio.prox;
        tamanho--;
        return info;
    
}

public void inserirFim(String info){
  No no = new No();
  no.info = info;
  if(inicio == null){
    no.prox = null;
    inicio=no;
  }else{
    No local = inicio;
    while(local.prox!=null){
      local = local.prox;
    }local.prox=no;
  }tamanho++;
}
public String removeFim(){
  if(inicio==null){
    return null;
  }No local = inicio;
  while(local.prox!= null){
    No aux = local;
    local=local.prox;
    if(local.prox==null){
      aux.prox=null;
      tamanho--;
      return local.info;
    }
  }inicio= null;
  tamanho--;
  return local.info;
}

public void inserirIndice(int indice, String info){
  if(indice <=0){
    inserir(info);
  }else if(indice >= tamanho){
    inserirFim(info);
  }else{
    No local = inicio;
    for(int i = 0;i<indice-1;i++){
      local = local.prox;
    }No no = new No();
    no.info=info;
    local.prox=no;
    tamanho++;
  }
}

public String retirarIndice(int indice){
  if(indice<0|| indice >= tamanho || inicio == null){
    return null;
  }else if(indice == 0){
    return remove();
  }else if(indice == tamanho-1){
    return removeFim();
  }No local = inicio;
  for(int i = 0;i<indice-1;i++){
    local=local.prox;
  }String info = local.prox.info;
  local.prox=local.prox.prox;
  tamanho--;
  return info;
}


}


class Main {
  public static void main(String[] args) {
    ListaSimples a = new ListaSimples();

   
    a.inserir("12");
   
    a.inserir("23");
   
    a.inserir("123");
    System.out.println(a);

  }
}