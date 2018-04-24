package com.tec.datos1;

public class ArbolBinario {
    NodoArbol raiz;

    /**
     * Constructor
     */
    public ArbolBinario() {
        this.raiz = null;
    }

    /**
     * Insertar recursivo
     */
    public void insertar(int dato) {
        this.raiz = this.insertar(dato, this.raiz);
    }

    public NodoArbol insertar(int datos, NodoArbol current) {
        if (current == null)
            return new NodoArbol(datos);
        else if (datos < current.dato)
            current.hijoIzquierda = this.insertar(datos, current.hijoIzquierda);
        else if (datos > current.dato)
            current.hijoDerecha = this.insertar(datos, current.hijoDerecha);
        return current;
    }


    /**
     * Insertar Nodo en el arbol
     */
    public void agregarNodo(int dato) {
        NodoArbol nuevo = new NodoArbol(dato);

        if (raiz == null)
            raiz = nuevo;
        else {
            NodoArbol auxNodo = raiz;
            NodoArbol padre;// Solo si tiene hijos
            while (true) {
                padre = auxNodo;
                if (dato < auxNodo.dato) {//Se va para la izquierda
                    auxNodo = auxNodo.hijoIzquierda;
                    if (auxNodo == null) {//llega al final (null)
                        padre.hijoIzquierda = nuevo;
                        return;//Sirve para finalizar el metodo
                    }

                } else {
                    auxNodo = auxNodo.hijoDerecha;
                    if (auxNodo == null) {
                        padre.hijoDerecha = nuevo;
                        return;
                    }
                }
            }
        }
    }

    /**
     * Eliminar
     */
    public boolean eliminar(int dato) {
        NodoArbol auxNodo = raiz;
        NodoArbol padre = raiz;
        boolean esHijoIzq = true;
        while (auxNodo.dato != dato) {
            padre = auxNodo;
            if (dato < auxNodo.dato) {//Se va a la izquierda
                esHijoIzq = true;
                auxNodo = auxNodo.hijoIzquierda;
            } else {
                esHijoIzq = false;
                auxNodo = auxNodo.hijoDerecha;
            }
            if (auxNodo == null) {
                return false;
            }
        }//End while
        if (auxNodo.hijoIzquierda == null && auxNodo.hijoDerecha == null) {//es una hoja
            if (auxNodo == raiz)
                raiz = null;
            else if (esHijoIzq)
                padre.hijoIzquierda = null;
            else
                padre.hijoDerecha = null;
        } else if (auxNodo.hijoDerecha == null) {
            if (auxNodo == raiz)
                raiz = auxNodo.hijoIzquierda;
            else if (esHijoIzq)
                padre.hijoIzquierda = auxNodo.hijoIzquierda;
            else
                padre.hijoDerecha = auxNodo.hijoIzquierda;
        } else if (auxNodo.hijoIzquierda == null) {
            if (auxNodo == raiz)
                raiz = auxNodo.hijoDerecha;
            else if (esHijoIzq)
                padre.hijoIzquierda = auxNodo.hijoDerecha;
            else
                padre.hijoDerecha = auxNodo.hijoIzquierda;
        } else {
            NodoArbol reemplazo = obtenerNodoReemplazo(auxNodo);
            if (auxNodo == raiz)
                raiz = reemplazo;
            else if (esHijoIzq)
                padre.hijoIzquierda = reemplazo;
            else
                padre.hijoDerecha = reemplazo;
            reemplazo.hijoIzquierda = auxNodo.hijoIzquierda;
        }
        return true;//;sí encontró el dato
    }

    /**
     * Método de devolver el nodo reemplazo
     */
    public NodoArbol obtenerNodoReemplazo(NodoArbol nodoReemp) {
        NodoArbol reempPadre = nodoReemp;
        NodoArbol reemplazo = nodoReemp;
        NodoArbol auxNodo = nodoReemp.hijoDerecha;
        while (auxNodo != null) {
            reempPadre = reemplazo;
            reemplazo = auxNodo;
            auxNodo = auxNodo.hijoIzquierda;
        }
        if (reemplazo != nodoReemp.hijoDerecha) {
            reempPadre.hijoIzquierda = reemplazo.hijoDerecha;
            reemplazo.hijoDerecha = nodoReemp.hijoDerecha;
        }
        System.out.println("El nodo a reemplazo es " + reemplazo.dato);
        return reemplazo;
    }

    /**
     * metodo para recorrer el arbol InOrden
     */
    public void inOrden(NodoArbol arbol) {
        if (arbol != null) {
            inOrden(arbol.hijoIzquierda);
            System.out.print(arbol.dato + "- ");
            inOrden(arbol.hijoDerecha);
        }
    }

    /**
     *Obtiene el dato raiz del arbol
     * @return
     */
    private int  obtenerRaiz(){
        return raiz.dato;

    }

    /**
     *Descompone los arboles y los va insertando en el nuevo arbol
     * @param arbol1
     * @param arbol2
     * @return
     */
    public ArbolBinario unirArboles(ArbolBinario arbol1, ArbolBinario arbol2){
        ArbolBinario nuevoArbol = new ArbolBinario();
        while (arbol1.raiz!=null){
            int dato = arbol1.obtenerRaiz();
            nuevoArbol.insertar(dato);
            arbol1.eliminar(dato);
        }
        while(arbol2.raiz!=null){
            nuevoArbol.insertar(arbol2.obtenerRaiz());
            arbol2.eliminar(arbol2.obtenerRaiz());
        }
        return nuevoArbol;

    }

}
