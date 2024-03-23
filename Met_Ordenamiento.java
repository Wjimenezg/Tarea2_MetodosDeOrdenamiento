package met_ordenamiento;

import java.util.*;
public class Met_Ordenamiento {
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        Opc_Ordenamientos opcOrd=new Opc_Ordenamientos();
        boolean salir=false;
        int opcion=0;
        String dato="";
        System.out.println("Ingrese el dato que desea ordenar, separelos con un espacio");
        dato=entrada.nextLine();
        
        try{
        while(!salir){
            System.out.println("Ingrese el metodo de orden en el que se desea resolver");
            System.out.println("1. Selection Short");
            System.out.println("2. Buble Short");
            System.out.println("3. Insertion Short");
            System.out.println("4. Merge Short");
            System.out.println("5.Quick Short");
            System.out.println("6. Heap Short");
            System.out.println("7. Counting short");
            System.out.println("8. Radix Short");
            System.out.println("9. Bucket Short");
            System.out.println("10. Salir");
            opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    int[] array = Arrays.stream(dato.split(" ")).mapToInt(Integer::parseInt).toArray();
                    opcOrd.Select_Short(array);
                    System.out.println("Arreglo ordenado: " + Arrays.toString(array));
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 2:
                    int[] arrayBubble = Arrays.stream(dato.split(" ")).mapToInt(Integer::parseInt).toArray();
                    opcOrd.Buble_Short(arrayBubble);
                    System.out.println("Arreglo ordenado con el Metodo Bubble Short: " + Arrays.toString(arrayBubble));
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 3:
                    int[] arrayInsertion = Arrays.stream(dato.split(" ")).mapToInt(Integer::parseInt).toArray();
                    opcOrd.Insert_Short(arrayInsertion);
                    System.out.println("Arreglo ordenado con el Metodo Insertion Short: " + Arrays.toString(arrayInsertion));
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 4:
                    int[] arrayMerge = Arrays.stream(dato.split(" ")).mapToInt(Integer::parseInt).toArray();
                    opcOrd.Merge_Short(arrayMerge);
                    System.out.println("Arreglo ordenado con el Metodo Merge Short: " + Arrays.toString(arrayMerge));
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 5:
                    int[] arrayQuick = Arrays.stream(dato.split(" ")).mapToInt(Integer::parseInt).toArray();
                    opcOrd.Quick_Short(arrayQuick, 0, arrayQuick.length - 1); // Llamada al método Quick_Short
                    System.out.println("Arreglo ordenado con Quick Sort: " + Arrays.toString(arrayQuick));
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 6:
                    int[] arrayHeap = Arrays.stream(dato.split(" ")).mapToInt(Integer::parseInt).toArray();
                    opcOrd.Heap_Sort(arrayHeap);
                    System.out.println("Arreglo ordenado con Heap Sort: " + Arrays.toString(arrayHeap));
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 7:
                    int[] arrayCounting = Arrays.stream(dato.split(" ")).mapToInt(Integer::parseInt).toArray();
                    opcOrd.Counting_Short(arrayCounting);
                    System.out.println("Arreglo ordenado con Counting Sort: " + Arrays.toString(arrayCounting));
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 8:
                    int[] arrayRadix = Arrays.stream(dato.split(" ")).mapToInt(Integer::parseInt).toArray();
                    opcOrd.Radix_Short(arrayRadix);
                    System.out.println("Arreglo ordenado con Radix Sort: " + Arrays.toString(arrayRadix));
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 9:
                    int[] arrayBucket = Arrays.stream(dato.split(" ")).mapToInt(Integer::parseInt).toArray();
                    opcOrd.Bucket_Short(arrayBucket);
                    System.out.println("Arreglo ordenado con Bucket Sort: " + Arrays.toString(arrayBucket));
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 10:
                    salir=true;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
            
            }
        }
        }catch(InputMismatchException e){
            System.out.println("la opcion ingresada no es valida");
        }finally{
            entrada.close();
        }
    }
    
}
