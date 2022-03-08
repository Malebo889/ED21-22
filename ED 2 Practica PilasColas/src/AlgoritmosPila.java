public class AlgoritmosPila {

    public Asignatura asignaturaNotaMaxima(Pila asignaturas) {
        Asignatura resultado = null;
        if (asignaturas != null) {
            if (!asignaturas.vacia()) {
                if (asignaturas.getNumElementos() == 1) {
                    resultado = asignaturas.getCima();
                } else {
                    Asignatura asignatura = asignaturas.desapilar();
                    resultado = asignaturaNotaMaxima(asignaturas);
                    resultado = asignatura.getCalificacion() > resultado.getCalificacion() ? asignatura : resultado;
                    asignaturas.apilar(asignatura);
                }
            }
        }
        return resultado;
    }

    public double notaMinima(Pila asignaturas) {
        double resultado = 0;
        if (asignaturas != null) {
            if (!asignaturas.vacia()) {
                if (asignaturas.getNumElementos() == 1)
                    resultado = asignaturas.getCima().getCalificacion();
                else {
                    Asignatura asignatura = asignaturas.desapilar();
                    resultado = notaMinima(asignaturas);
                    resultado = Math.min(resultado, asignatura.getCalificacion());
                    asignaturas.apilar(asignatura);
                }
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