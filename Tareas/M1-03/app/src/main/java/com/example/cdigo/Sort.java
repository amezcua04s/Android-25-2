package com.example.cdigo;

public class Sort {

    public Sort() {
    }

    public static void quickSort(int[] arreglo, int ePrimero, int eUltimo){

        if(ePrimero >= eUltimo){
            return;
        }

        int ePivote = arreglo[eUltimo];

        int pIzquierda = partir(arreglo, ePrimero, eUltimo, ePivote);

        quickSort(arreglo, ePrimero, pIzquierda-1);
        quickSort(arreglo, pIzquierda+1, eUltimo);
    }

    private static int partir(int[] arreglo, int ePrimero, int eUltimo, int ePivote) {
        int pIzquierda = ePrimero;
        int pDerecha = eUltimo;

        while(pIzquierda < pDerecha) {
            while(arreglo[pIzquierda] <= ePivote && pIzquierda < pDerecha){
                pIzquierda++;
            }
            while(arreglo[pDerecha] >= ePivote && pIzquierda < pDerecha){
                pDerecha--;
            }
            intercambiar(arreglo, pIzquierda, pDerecha);
        }
        intercambiar(arreglo, pIzquierda, eUltimo);
        return pIzquierda;
    }

    private static void intercambiar(int[] arreglo, int eIndice, int eIndice1){

        int eTemporal = arreglo[eIndice];
        arreglo[eIndice] = arreglo[eIndice1];
        arreglo[eIndice1] = eTemporal;

    }

}
