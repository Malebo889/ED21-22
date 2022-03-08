public class AlgoritmosPila {

    public Asignatura asignaturaNotaMaxima(Pila asignaturas) {
        Asignatura resultado = null;
        if (asignaturas != null) {
            Asignatura asignatura = asignaturas.getCima();
            resultado = asignaturaNotaMaximaAux(asignaturas, asignatura);
        }
        return resultado;
    }

    private Asignatura asignaturaNotaMaximaAux(Pila asignaturas, Asignatura aux) {
        Asignatura asignatura;
        if (!asignaturas.vacia()) {
            asignatura = asignaturas.desapilar();
            asignaturaNotaMaximaAux(asignaturas, aux);
            if (asignatura.getCalificacion() > aux.getCalificacion()) {
                aux.setNombre(asignatura.getNombre());
                aux.setCalificacion(asignatura.getCalificacion());
            }
            asignaturas.apilar(asignatura);
        }
        return aux;
    }

    public double notaMinima(Pila asignaturas) {
        double resultado = 0;
        if (asignaturas != null) {
            Asignatura asignatura = asignaturas.getCima();
            resultado = notaMinimaAux(asignaturas, asignatura);
        }
        return resultado;
    }

    private double notaMinimaAux(Pila asignaturas, Asignatura aux) {
        Asignatura asignatura;
        if (!asignaturas.vacia()) {
            asignatura = asignaturas.desapilar();
            notaMinimaAux(asignaturas, aux);
            if (asignatura.getCalificacion() < aux.getCalificacion())
                aux.setCalificacion(asignatura.getCalificacion());
            asignaturas.apilar(asignatura);
        }
        return aux.getCalificacion();
    }


    public void mostrarAprobadas(Pila asignaturas) {
        //Completar
    }
}