public class GrupoAlumnos {

    private String nombre;
    private ListaCalificada listaAlumnos;

    public GrupoAlumnos(String nombre) {
        this.nombre = nombre;
        listaAlumnos = new ListaCalificada();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void nuevoAlumno(Alumno alumno) {
        if (alumno != null) {
            this.listaAlumnos.insertar(alumno);
        }
    }

    public int getNumAlumnos() {
        return this.listaAlumnos.getNumElementos();
    }

    public Alumno getAlumno(int matricula) {
        return listaAlumnos.getElemento(matricula);
    }

    public double porcentajeAprobados(String nombreAsignatura) {
        double resul = 0;

        IteradorListaCalificada itc = this.listaAlumnos.getIterador();
        while (itc.hasNext()) {
            if (itc.next().estaAprobado(nombreAsignatura)) {
                resul++;
            }
        }

        return (resul / listaAlumnos.getNumElementos()) * 100;
    }
}