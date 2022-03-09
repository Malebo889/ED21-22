public class AlgoritmosCola {

    public void mostrarGrupo(Cola grupo) {
        if (grupo != null) {
            Alumno alumno;
            int elems = grupo.getNumElementos();
            System.out.println("El grupo contiene " + grupo.getNumElementos() + " alumnos");
            for (int i = 0; i < elems; i++) {
                alumno = grupo.desencolar();
                System.out.println(i + 1 + ". " + alumno.getNombre());
                grupo.encolar(alumno);
            }
        }
    }

    public Cola alumnosAprobados(Cola grupo) {
        Cola aprobados = new Cola();
        if (grupo != null) {
            Alumno alumno;
            int elems = grupo.getNumElementos();
            for (int i = 0; i < elems; i++) {
                alumno = grupo.desencolar();
                if (alumno.getCalificacionMedia() >= 5)
                    aprobados.encolar(alumno);
                grupo.encolar(alumno);
            }
        }
        return aprobados;
    }

    public double calificaciónMedia(Cola grupo) {
        double resultado = 0;
        if (grupo != null) {
            Alumno alumno;
            int elems = grupo.getNumElementos();
            for (int i = 0; i < elems; i++) {
                alumno = grupo.desencolar();
                resultado += alumno.getCalificacionMedia();
                grupo.encolar(alumno);
            }
            resultado /= elems;
        }
        return resultado;
    }
}