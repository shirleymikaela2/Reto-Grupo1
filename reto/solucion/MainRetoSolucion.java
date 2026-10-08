
package reto.solucion;

import arboles.app.VistaArbol;
import arboles.modelo.Nodo;
import arboles.negocio.ArbolBinario;

public class MainRetoSolucion {

    public static ArbolBinario<String> construirArbolA() {
        ArbolBinario<String> arbol = new ArbolBinario<>();
        Nodo<String> ltx = arbol.crearRaiz("LTX");
        Nodo<String> atf = arbol.agregarIzquierdo(ltx, "ATF");
        Nodo<String> mch = arbol.agregarDerecho(ltx, "MCH");
        arbol.agregarIzquierdo(atf, "TUA");
        arbol.agregarDerecho(atf, "IBB");
        Nodo<String> snc = arbol.agregarIzquierdo(mch, "SNC");
        arbol.agregarDerecho(mch, "OCC");
        arbol.agregarIzquierdo(snc, "LGQ");
        return arbol;
    }

    public static ArbolBinario<String> construirArbolB() {
        ArbolBinario<String> arbol = new ArbolBinario<>();
        Nodo<String> gps = arbol.crearRaiz("GPS");
        Nodo<String> scy = arbol.agregarDerecho(gps, "SCY");
        Nodo<String> mrr = arbol.agregarDerecho(scy, "MRR");
        Nodo<String> ptz = arbol.agregarDerecho(mrr, "PTZ");
        arbol.agregarDerecho(ptz, "TPN");
        return arbol;
    }

    public static boolean esCadena(ArbolBinario<String> arbol) {
        if (arbol.esVacio()) {
            return false;
        }
        return arbol.altura() == arbol.contarNodos() - 1;
    }

    public static void main(String[] args) {
        ArbolBinario<String> arbolA = construirArbolA();
        ArbolBinario<String> arbolB = construirArbolB();

        System.out.println("== Parte 1: árbol A ==");
        VistaArbol.mostrar(arbolA);

        System.out.println();
        System.out.println("== Parte 2: consultas del árbol A ==");
        Nodo<String> raiz = arbolA.getRaiz();
        System.out.println("raíz         -> " + raiz.getDato());
        System.out.println("contarNodos  -> " + arbolA.contarNodos());
        System.out.println("contarHojas  -> " + arbolA.contarHojas());
        System.out.println("altura       -> " + arbolA.altura());
        System.out.println("grado de LTX -> " + raiz.grado());
        System.out.println("grado de SNC -> "
                + raiz.getDerecho().getIzquierdo().grado());

        System.out.println();
        System.out.println("== Parte 3: árbol B ==");
        VistaArbol.mostrar(arbolB);
        System.out.println("esCadena(A) -> " + esCadena(arbolA));
        System.out.println("esCadena(B) -> " + esCadena(arbolB));
        System.out.println("altura de B: " + arbolB.altura()
                + ", nodos de B: " + arbolB.contarNodos());
        System.out.println(
                "B se parece a una lista: buscar un código puede costar recorrer todos los nodos.");
    }
}
