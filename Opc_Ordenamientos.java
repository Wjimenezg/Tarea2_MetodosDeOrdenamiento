package met_ordenamiento;

import java.util.*;
public class Opc_Ordenamientos {
    private Scanner scanner;
    
    public Opc_Ordenamientos(){
        this.scanner=new Scanner(System.in);
    }
    
    public void Select_Short(int[] Dato){
        int dato=Dato.length;
        // Itera a través del arreglo
        for(int cont=0;cont<dato-1;cont++){
            // Encuentra el índice del elemento mínimo en el subarreglo no ordenado
            int menor=cont;
            for(int cont2=cont+1; cont2<dato; cont2++){
                if(Dato[cont2]<Dato[menor]){
                    // Actualiza el índice del elemento mínimo
                    menor=cont2;                    
                }
            }
            // Intercambia el elemento mínimo con el primer elemento del subarreglo no ordenado
            int temporal=Dato[menor];
            Dato[menor]=Dato[cont];
            Dato[cont]=temporal;
        }    
}
    
//----------------------------------------------------------------------------------
    
    public void Buble_Short(int[] Dato){
            int dato=Dato.length;
            // Itera a través de todo el arreglo
            for(int cont=0; cont<dato-1; cont++){
                // Itera a través del arreglo nuevamente, comparando pares adyacentes
                for(int cont2=0;cont2<dato-cont-1; cont2++){
                    // Si el elemento actual es mayor que el siguiente, intercambia los elementos
                   if(Dato[cont2]>Dato[cont2+1]){
                       int temporal=Dato[cont2];
                       Dato[cont2]=Dato[cont2+1];
                       Dato[cont2+1]=temporal;
                    }
                }
            }
    }

//----------------------------------------------------------------------------------------    
    public void Insert_Short(int[] Dato){
        int dato=Dato.length;
        // Itera a través del arreglo desde el segundo elemento hasta el último
        for(int cont=1;cont<dato; ++cont){
            // Almacena el valor actual en una variable temporal
            int key=Dato[cont];
            int cont2=cont-1;
            /*Inserta el elemento actual en la posición correcta dentro de la sección ya ordenada del arreglo
            Moviendo elementos mayores que el valor actual hacia adelante*/
            while(cont2>=0&&Dato[cont2]>key){
                Dato[cont2+1]=Dato[cont2];
                cont2=cont2-1;
            }
            // Inserta el valor actual en la posición correcta
            Dato[cont2+1]=key;
        }
    }

//----------------------------------------------------------------------------------------
    public void Merge_Short(int[] Dato) {
        sort(Dato, 0, Dato.length - 1);
    }

    private void sort(int[] Dato, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            // Divide el subarreglo en dos partes y ordena cada parte
            sort(Dato, izquierda, medio);
            sort(Dato, medio + 1, derecha);
            // junta las partes ordenadas del subarreglo
            merge(Dato, izquierda, medio, derecha);
        }
    }

    private void merge(int[] Dato, int izquierda, int medio, int derecha) {
        // Crea subarreglos temporales para almacenar las partes izquierda y derecha
        int[] izquierdaDato = new int[medio - izquierda + 1];
        int[] derechaDato = new int[derecha - medio];
        // Copia los elementos del subarreglo izquierdo y derecho a los subarreglos temporales
        for (int cont = 0; cont < izquierdaDato.length; cont++) {
            izquierdaDato[cont] = Dato[izquierda + cont];
        }

        for (int cont2 = 0; cont2 < derechaDato.length; cont2++) {
            derechaDato[cont2] = Dato[medio + 1 + cont2];
        }
        // junta los subarreglos temporales en el arreglo original en orden ascendente
        int cont = 0, cont2 = 0, cont3 = izquierda;
        while (cont < izquierdaDato.length && cont2 < derechaDato.length) {
            if (izquierdaDato[cont] <= derechaDato[cont2]) {
                Dato[cont3++] = izquierdaDato[cont++];
            } else {
                Dato[cont3++] = derechaDato[cont2++];
            }
        }
        // Copia cualquier elemento restante del subarreglo izquierdo
        while (cont < izquierdaDato.length) {
            Dato[cont3++] = izquierdaDato[cont++];
        }
        // Copia cualquier elemento restante del subarreglo derecho
        while (cont2 < derechaDato.length) {
            Dato[cont3++] = derechaDato[cont2++];
        }
    }
    
//------------------------------------------------------------------------------------
    public void Quick_Short(int[] Dato, int izquierda, int derecha) {
        //// Verifica si hay elementos en el subarreglo
        if (izquierda < derecha) {
            // Encuentra el índice del pivote después de la partición
            int pivotIndex = dividir(Dato, izquierda, derecha);
            // Ordena los elementos antes y después del pivote
            Quick_Short(Dato, izquierda, pivotIndex - 1);
            Quick_Short(Dato, pivotIndex + 1, derecha);
        }
    }

    private int dividir(int[] Dato, int izquierda, int derecha) {
        int pivot = Dato[derecha];
        int cont = izquierda - 1;
         // Itera a través del subarreglo para particionar y ordenar
        for (int cont2 = izquierda; cont2 < derecha; cont2++) {
            // Si el elemento actual es menor o igual que el pivote, lo mueve a la izquierda
            if (Dato[cont2] <= pivot) {
                cont++;
                temporal(Dato, cont, cont2);
            }
        }
        // Mueve el pivote a su posición final
        temporal(Dato, cont + 1, derecha);
        return cont + 1;
    }

    private void temporal(int[] Dato, int cont, int cont2) {
        // Intercambia los elementos en las posiciones especificadas
        int temporal = Dato[cont];
        Dato[cont] = Dato[cont2];
        Dato[cont2] = temporal;
    }
    
//----------------------------------------------------------------------------------------------
   public void Heap_Sort(int[] Dato) {
        int dato = Dato.length;
        // Construye un heap máximo
        for (int indice = dato / 2 - 1; indice >= 0; indice--)
            heapify(Dato, dato, indice);
        // Extrae elementos uno por uno
        for (int cont = dato - 1; cont > 0; cont--) {
            int temporal = Dato[0];
            Dato[0] = Dato[cont];
            Dato[cont] = temporal;
            heapify(Dato, cont, 0);
        }
    }

    private void heapify(int[] Dato, int dato, int cont) {
        int tamanio = cont;
        int izquierda = 2 * cont + 1;
        int derecha = 2 * cont + 2;
        // Comprueba si el hijo izquierdo es mayor que el nodo actual
        if (izquierda < dato && Dato[izquierda] > Dato[tamanio])
            tamanio = izquierda;
        // Comprueba si el hijo derecho es mayor que el nodo actual
        if (derecha < dato && Dato[derecha] > Dato[tamanio])
            tamanio = derecha;
        // Si el nodo actual no es el más grande, intercambia con el mayor de sus hijos
        if (tamanio != cont) {
            int intercambio = Dato[cont];
            Dato[cont] = Dato[tamanio];
            Dato[tamanio] = intercambio;
            heapify(Dato, dato, tamanio);
        }
    }
    
//-------------------------------------------------------------------------------
    
    public void Counting_Short(int[] Dato) {
        int dato = Dato.length;
        // Encuentra el valor máximo en el arreglo
        int max = Arrays.stream(Dato).max().getAsInt();
        // Crea un arreglo de conteo con el tamaño del rango máximo
        int[] count = new int[max + 1];
        // Llena el arreglo de conteo con las ocurrencias de cada elemento
        for (int cont = 0; cont < dato; ++cont)
            count[Dato[cont]]++;
        // Actualiza el arreglo de conteo para reflejar las posiciones finales de los elementos
        for (int cont = 1; cont <= max; ++cont)
            count[cont] += count[cont - 1];
        // Construye el arreglo ordenado usando el arreglo de conteo
        int[] constru = new int[dato];
        for (int cont = dato - 1; cont >= 0; cont--) {
            constru[count[Dato[cont]] - 1] = Dato[cont];
            count[Dato[cont]]--;
        }

        // Copia el arreglo ordenado de salida al arreglo original
        for (int cont = 0; cont < dato; ++cont)
            Dato[cont] = constru[cont];
    }
    
//---------------------------------------------------------------------------------------
    
    public void Radix_Short(int[] Dato) {
        // Encuentra el máximo número para conocer la cantidad de dígitos
        int max = Arrays.stream(Dato).max().getAsInt();
        
        // Hace el counting sort para cada dígito
        for (int posicion = 1; max / posicion > 0; posicion *= 10)
            countingSort(Dato, posicion);
    }

    private void countingSort(int[] Dato, int posicion) {
        int dato = Dato.length;
        int[] constru = new int[dato];
        int[] conteo = new int[10];
        Arrays.fill(conteo, 0);
        // Almacena el conteo de ocurrencias de cada dígito
        for (int cont = 0; cont < dato; cont++)
            conteo[(Dato[cont] / posicion) % 10]++;
        // Ajusta el conteo para reflejar las posiciones finales de los elementos
        for (int cont = 1; cont < 10; cont++)
            conteo[cont] += conteo[cont - 1];
        // Construye el arreglo ordenado
        for (int cont = dato - 1; cont >= 0; cont--) {
            constru[conteo[(Dato[cont] / posicion) % 10] - 1] = Dato[cont];
            conteo[(Dato[cont] / posicion) % 10]--;
        }
        // Copia el arreglo ordenado al arreglo original
        for (int cont = 0; cont < dato; cont++)
            Dato[cont] = constru[cont];
    }
    
//-----------------------------------------------------------------------------------
    
        public void Bucket_Short(int[] Dato) {
        int dato = Dato.length;
        int max = Arrays.stream(Dato).max().getAsInt();
        
        // Crea un arreglo de listas para los buckets
        List<Integer>[] buckets = new ArrayList[max + 1];
        for (int cont = 0; cont <= max; cont++) {
            buckets[cont] = new ArrayList<>();
        }

        // Distribuye los elementos en los buckets
        for (int cont = 0; cont < dato; cont++) {
            int bucketIndex = Dato[cont];
            buckets[bucketIndex].add(Dato[cont]);
        }

        // Ordena individualmente cada bucket
        for (int cont = 0; cont <= max; cont++) {
            Collections.sort(buckets[cont]);
        }

        // Concatena los buckets ordenados para obtener el arreglo ordenado
        int indice = 0;
        for (int cont = 0; cont <= max; cont++) {
            for (int num : buckets[cont]) {
                Dato[indice++] = num;
            }
        }
    }
}
