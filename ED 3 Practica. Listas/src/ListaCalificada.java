public class ListaCalificada {

    private NodoListaCalificada inicio;
    private int numElementos;

    public ListaCalificada() {
        inicio = null;
        numElementos = 0;
    }

    public boolean vacia() {
        return inicio == null;
    }

    /**
     * Inserta el alumno en la posición que le corresponde según la clave
     */
    public void insertar(Alumno dato) {
        NodoListaCalificada anterior = null;
        NodoListaCalificada actual = inicio;
        while ((actual != null) && (actual.getClave() < dato.getMatricula())) {
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if ((actual == null) || (actual.getClave() > dato.getMatricula())) {
            // Insertar antes de actual
            NodoListaCalificada nuevo = new NodoListaCalificada(dato, actual);
            if (actual == inicio) {  // insertar al principio de la lista
                inicio = nuevo;
            } else {
                anterior.setSiguiente(nuevo);
            }
            numElementos++;
        } else {
            System.out.println(
                    "Clave duplicada (" + dato.getMatricula() + "): no es posible insertar");
        }
    }

    /**
     * Busca la clave en la lista. Si la encuentra devuelve el alumno asociado a dicha clave,
     * y si no la encuentra devuelve NULL.
     */
    public Alumno getElemento(int clave) {
        NodoListaCalificada actual = inicio;
        while ((actual != null) && (actual.getClave() < clave)) {
            actual = actual.getSiguiente();
        }
        if ((actual == null) || (actual.getClave() > clave)) {
            return null;
        } else {
            return actual.getDato();
        }
    }

    /**
     * Determina si la clave recibida como parámetro existe en la lista.
     */
    public boolean contiene(int clave) {
        return this.getElemento(clave) != null;
    }

    /**
     * Elimina de la lista el alumno con número de matrícula clave,
     * en caso de existir.
     */
    public void borrar(int clave) {
        NodoListaCalificada actual = inicio;
        NodoListaCalificada anterior = null;
        while ((actual != null) && (actual.getClave() < clave)) {
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if ((actual == null) || (actual.getClave() > clave)) {
            System.out.println(
                    "Clave no existe (" + clave + "): elemento no borrado");
        } else {  // Clave encontrada
            if (actual == inicio) {    // eliminar el primero de la lista
                inicio = actual.getSiguiente();
            } else {
                anterior.setSiguiente(actual.getSiguiente());
            }
            numElementos--;
        }
    }

    public int getNumElementos() {
        return numElementos;
    }

    public IteradorListaCalificada getIterador() {
        return new IteradorListaCalificada(inicio);
    }

    public void borrarMenores(int clave) {
        NodoListaCalificada actual = inicio;
        NodoListaCalificada anterior = null;
        while ((actual != null) && (actual.getClave() < clave)) {
            if (actual == inicio) {    // eliminar el primero de la lista
                inicio = actual.getSiguiente();
                numElementos--;
            } else {
                anterior.setSiguiente(actual.getSiguiente());
                numElementos--;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
    }

    public void borrarMayores(int clave) {
        NodoListaCalificada actual = inicio;
        NodoListaCalificada anterior = null;
        int elems = 0;
        if (actual.getClave() > clave) {
            inicio = null;
        } else {
            while ((actual != null) && (actual.getClave() < clave)) {
                elems++;
                anterior = actual;
                actual = actual.getSiguiente();
            }
            anterior.setSiguiente(null);
            this.numElementos = elems;
        }
    }

}