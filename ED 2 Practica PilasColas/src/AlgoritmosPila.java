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
        double resultado = Integer.MAX_VALUE;
        if (asignaturas != null) {
            if(!asignaturas.vacia()){
                Asignatura asignatura = asignaturas.desapilar();
                resultado = notaMinima(asignaturas);
                resultado = Math.min(resultado, asignatura.getCalificacion());
                asignaturas.apilar(asignatura);
            }
        }
        return resultado;
    }

    public void mostrarAprobadas(Pila asignaturas) {
        if (asignaturas != null) {
            Asignatura asignatura;
            if (!asignaturas.vacia()) {
                asignatura = asignaturas.desapilar();
                mostrarAprobadas(asignaturas);
                if (asignatura.getCalificacion() >= 5) {
                    asignatura.mostrar();
                }
                asignaturas.apilar(asignatura);
            }
        }
    }
}