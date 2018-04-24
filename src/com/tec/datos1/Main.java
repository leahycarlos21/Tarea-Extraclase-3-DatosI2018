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


        ArbolBinario arbolin2 = new ArbolBinario();
        arbolin2.insertar(5);
        arbolin2.insertar(100);
        arbolin2.insertar(9);
        arbolin2.insertar(20);

        arbolin= arbolin.unirArboles(arbolin, arbolin2);
        System.out.println("ORDEN FINAL");
        arbolin.inOrden(arbolin.raiz);
        arbolin.eliminar(1);

        arbolin.eliminar(7);
        arbolin.inOrden(arbolin.raiz);

        //System.out.println(arbolin.obtenerRaiz());


    }
}
