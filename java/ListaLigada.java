public class ListaLigada implements EstruturaDeDados{
    private No inicio;

    
    //     if (inicio != null)
    //         inicio = inicio.getProximo();
    // }

    // public void removeFim (){
    //     if (inicio == null){
    //         return;
    //     }
    //     if (inicio.getProximo() == null){
    //         inicio = null;
    //     }
    //     removeFim(inicio);
    // }

    // public void removeFim (No n){
    //     No proximo = n.getProximo();
    //     if (proximo.getProximo() == null){
    //         n.setProximo(null);
    //         return;
    //     } else{
    //         removeFim(proximo);
    //     }
    // }

    // public void insereInicio (int valor){
    //     if(inicio == null){
    //         inicio = new No(valor);
    //         return;
    //     }
    //     No n = new No(valor);
    //     n.setProximo(inicio);
    //     inicio = n;

    // }

    // public void insereFim (int valor){
    //     if(inicio == null){
    //         inicio = new No(valor);
    //         return;
    //     }
    //     insere(inicio, valor);
    // }

    // public boolean procura (int valor){
    //     if (inicio == null){
    //         return false;
    //     } else {
    //         return procura(inicio, valor);
    //     }
    // }

    // public boolean procura (No n, int valor){
    //     if (n.getValor() == valor){
    //         return true;
    //     } else if (n.getProximo() == null){
    //         return false;
    //     } else {
    //         return procura(n.getProximo(), valor);
    //     }
    // }
    // public void insere (No n, int valor){
    //     if (n.getProximo() == null){
    //         No novo = new No(valor);
    //         n.setProximo(novo);
    //     } else {
    //         insere(n.getProximo(), valor);
    //     }
    // }

    // public void remover(int valor){
    //     if (inicio == null){
    //         return;
    //     }
    //     if (inicio.getValor() == valor){
    //         inicio = inicio.getProximo();
    //         return;
    //     }
    //     remover(inicio, valor);
    // }

    // public void remover(No n, int valor){
    //     No proximo = n.getProximo();
    //     if (proximo == null){
    //         return;
    //     }
    //     if (proximo.getValor() == valor){
    //         n.setProximo(proximo.getProximo());
    //     } else{
    //         remover(proximo, valor);
    //     }
    // }

    // public static void main(String[] args) {
    //     for (int i = 0; i < 100; i++) {
    //         System.out.println(i);
    //         if (i == 50){
    //             break;
    //         }
    //     }
    //     System.out.println("fim");
    // }


    public static void main(String[] args) {
        ListaLigada list = new ListaLigada();
        System.out.println(list.insert(3));
        System.out.println(list.insert(5));
        System.out.println(list.insert(7));
        System.out.println(list.search(7));
        System.out.println(list.search(5));
        System.out.println(list.search(9));
        System.out.println(list.minimum());
        System.out.println(list.maximum());
        System.out.println(list.sucessor(5));
        System.out.println(list.prodessor(3));
    }

    @Override
    public boolean insert(int chave) {
        if (inicio == null)
        {
            inicio = new No(chave);
            inicio.setProximo(null);
            return true;
        } 
        else
        {
            insert0(inicio, chave);
            return true;
        }
    }
    public boolean insert0(No n,int chave){
        if(n.getProximo() == null)
        {
            No no = new No(chave);
            n.setProximo(no);
            return true;
        }
        else
        {
            insert0(n.getProximo(), chave);
        }
        return false;

    }

    @Override
    public boolean delete(int chave) {
        if(inicio.getValor() == chave)
        {
            inicio = inicio.getProximo();
            return true;
        }
        else
        {
             return delete0(inicio, chave);
        }
    }

    public boolean delete0(No delete, int chave) {
        No remover = delete.getProximo();
        if(remover.getValor() == chave){
            delete.setProximo(remover.getProximo());
            return true;
        }
        else 
        {
            return delete0(delete.getProximo(), chave);
        }
    }
    @Override
    public boolean search(int chave) {
        if(inicio == null)
        {
            return false;
        }
        else{
          return search0(inicio, chave);
        }   
    }
    public boolean search0(No n, int chave){
        if(n == null)
        {
            return false;
        }
        if(n.getValor()== chave)
        {
            return true;
        }
        else
        {
            return search0(n.getProximo(), chave);
        }
    }
    @Override
    public int minimum() {
        if(inicio == null){
            return 0;
        }
        else{
            int mini = inicio.getValor();
            if(inicio.getProximo() == null){
                return mini;
            }
            else{
                return minimum0(inicio, mini);
            }
        }
    }
    public int minimum0(No no,int mini)
    {   int num = mini;
        if(no.getProximo() == null){
            return mini;
        }

        if(no.getProximo().getValor() < num)
        {
            num = no.getProximo().getValor();
        }
            return minimum0(no.getProximo(), num); 
    }

    @Override
    public int maximum() {
        if(inicio == null)
        {
            return 0;
        }
        else{
            int max = inicio.getValor();
            if(inicio.getProximo() == null)
            {
                return max;
            }
            else{
                return maximum0(inicio,max);
            }
        }
    }
    public int maximum0(No no , int max){
        {   int num = max;
            if(no.getProximo()== null){
                return num;
            }
            else if(no.getProximo().getValor() > num){ 
                 num = no.getProximo().getValor();
            
            }
                return maximum0(no.getProximo(),num); 
        }
    }
    @Override
    public int sucessor(int chave) {
        if(inicio == null){
            return 0;
        }
        else if(inicio.getValor() == chave)
        {
            return inicio.getProximo().getValor();
        }
        else
        {
            return sucessor0(inicio, chave);
        }
    }
    public int sucessor0(No no, int chave){
        if(no.getProximo() == null)
        {
            return 0;
        }
        else if(no.getValor() == chave)
        {  
            return no.getProximo().getValor();
        }
            return sucessor0(no.getProximo(), chave);
    }

    @Override
    public int prodessor(int chave) {
        if(inicio == null || inicio.getValor() == chave)
        {
            return -1;
        }
        else if(inicio.getProximo().getValor() == chave)
        {
            return inicio.getValor();
        }
        else{
            return prodessor0(inicio, chave);
        }
    }

    public int prodessor0(No no, int chave){
        if(no.getProximo() == null)
        {
            return no.getValor();
        }
        else if(no.getProximo().getValor() == chave)
        {
            return no.getValor();
        }
            return prodessor0(no.getProximo(), chave);
    }
}
