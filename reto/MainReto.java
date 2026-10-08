package reto;

import arboles.modelo.Nodo;
import arboles.negocio.ArbolBinario;
import arboles.app.VistaArbol;

public class MainReto {

    public static void main(String[] args) {
        
        ArbolBinario<String> arbolA = new ArbolBinario<>();
        Nodo<String> ltx = arbolA.crearRaiz("LTX");
        Nodo<String> atf = arbolA.agregarIzquierdo(ltx, "ATF");
        Nodo<String> mch = arbolA.agregarDerecho(ltx, "MCH");
        arbolA.agregarIzquierdo(atf, "TUA");
        arbolA.agregarDerecho(atf, "IBB");
        Nodo<String> snc = arbolA.agregarIzquierdo(mch, "SNC");
        arbolA.agregarIzquierdo(snc, "LGQ");
        arbolA.agregarDerecho(mch, "OCC");

        System.out.println("=== Parte 1: arbol A ===");
        VistaArbol.mostrar(arbolA);

        System.out.println("\n=== Parte 2: consultar el arbol A ===");
        System.out.println("Raiz: " + arbolA.getRaiz().getDato());
        System.out.println("Cantidad de nodos: " + arbolA.contarNodos());
        System.out.println("Cantidad de hojas: " + arbolA.contarHojas());
        System.out.println("Altura: " + arbolA.altura());
        System.out.println("Grado de LTX: " + ltx.grado());
        System.out.println("Grado de SNC: " + snc.grado());

        ArbolBinario<String> arbolB = new ArbolBinario<>();
        Nodo<String> gps = arbolB.crearRaiz("GPS");
        Nodo<String> scy = arbolB.agregarDerecho(gps, "SCY");
        Nodo<String> mrr = arbolB.agregarDerecho(scy, "MRR");
        Nodo<String> ptz = arbolB.agregarDerecho(mrr, "PTZ");
        arbolB.agregarDerecho(ptz, "TPN");

        System.out.println("\n=== Parte 3: arbol B ===");
        VistaArbol.mostrar(arbolB);
        System.out.println("Cantidad de nodos de B: " + arbolB.contarNodos());
        System.out.println("Altura de B: " + arbolB.altura());
        System.out.println("El arbol A es cadena?: " + esCadena(arbolA));
        System.out.println("El arbol B es cadena?: " + esCadena(arbolB));
        System.out.println("El arbol B se parece a una lista: cada nodo, excepto el ultimo, tiene un solo hijo.");
        System.out.println("Buscar un dato exige recorrer la cadena hasta encontrarlo o llegar al final.");
        System.out.println("En el peor caso se visitan los n nodos: coste O(n); en B, hasta 5 nodos.");
        System.out.println("A tampoco es un arbol de busqueda ordenado: su forma no garantiza busquedas O(log n).");

        System.out.println("\n=== Casos limite ===");
        ArbolBinario<String> vacio = new ArbolBinario<>();
        System.out.println("Arbol vacio: " + esCadena(vacio) + " (esperado: false)");
        ArbolBinario<String> unNodo = new ArbolBinario<>();
        unNodo.crearRaiz("UIO");
        System.out.println("Arbol de un solo nodo: " + esCadena(unNodo) + " (esperado: true)");

        try {
            arbolA.agregarIzquierdo(ltx, "XXX");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("El programa continua. Nodos de A: " + arbolA.contarNodos());

        System.out.println("\n=== Extra: camino I, D, I ===");
        Nodo<String> destino = arbolA.getRaiz().getIzquierdo().getDerecho().getIzquierdo();
        if (destino == null) {
            System.out.println("No hay aeropuerto: LTX -> ATF -> IBB; IBB no tiene hijo izquierdo.");
        } else {
            System.out.println("Aeropuerto encontrado: " + destino.getDato());
        }
    }

    static boolean esCadena(ArbolBinario<String> arbol) {
        if (arbol.esVacio()) {
            return false;
        }
        return arbol.altura() == arbol.contarNodos() - 1;
    }
}
