public class Alumno {
    private String nombre;
    private String matricula;
    private double calificacionMedia;
    private int numAsignaturas;
    private Pila asignaturas;

    public Alumno(String nombre, String matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.calificacionMedia = 0;
        this.asignaturas = new Pila();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCalificacionMedia() {
        return calcularMedia(this.asignaturas) / numAsignaturas;
    }

    public int getNumAsignaturas() {
        return numAsignaturas;
    }

    public void anadirAsignatura(Asignatura asignatura) {
        if (asignatura != null) {
            this.asignaturas.apilar(asignatura);
            this.numAsignaturas++;
            this.calificacionMedia = getCalificacionMedia();
        }
    }

    public void mostrarAlumno() {
        System.out.println(nombre + ". Matr: " + matricula + " (" + getCalificacionMedia() + ")");
        asignaturas.mostrar();
    }

    private double calcularMedia(Pila asignaturas) {
        double resultado = 0;
        if (asignaturas != null) {
            Asignatura asignatura;
            if (!asignaturas.vacia()) {
                asignatura = asignaturas.desapilar();
                resultado = asignatura.getCalificacion() + calcularMedia(asignaturas);
                asignaturas.apilar(asignatura);
            }
        }
        return resultado;
    }
}
