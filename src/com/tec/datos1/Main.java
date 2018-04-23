package com.tec.datos1;

public class Main {

    public static void main(String[] args) {
        ArbolBinario arbolin = new ArbolBinario();
        arbolin.insertar(2);
        arbolin.agregarNodo(6);
        arbolin.agregarNodo(5);

        arbolin.agregarNodo(7);

        arbolin.agregarNodo(4);

        arbolin.agregarNodo(8);

        arbolin.agregarNodo(3);

        arbolin.inOrden(arbolin.raiz);

        arbolin.eliminar(6);
        arbolin.inOrden(arbolin.raiz);


    }
}
