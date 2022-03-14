import java.util.Iterator;
import java.util.LinkedList;

public class AlumnoBib {

    private String nombre;
    private int matricula;
    private LinkedList<Evaluacion> expediente;

    public AlumnoBib(String nombre, int matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
        expediente = new LinkedList<>();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void nuevaEvaluacion(Evaluacion evaluacion) {
        expediente.add(evaluacion);
    }

    public boolean estaAprobado(String nombreAsig) {
        boolean aprobado = false;
        Iterator<Evaluacion> it = expediente.iterator();
        while (it.hasNext() && !aprobado) {
            Evaluacion evaluacion = it.next();
            if (evaluacion.getNombreAsignatura().equals(nombreAsig) &&
                    evaluacion.getNota() >= 5.0) {
                aprobado = true;
            }
        }
        return aprobado;
    }

    public ListaOrdinal asignaturasAprobadas() {
        Evaluacion ev;
        ListaOrdinal aprobadas = new ListaOrdinal();
        Iterator<Evaluacion> it = this.expediente.iterator();
        while (it.hasNext()) {
            ev = it.next();
            if (ev.getNota() >= 5)
                aprobadas.insertar(ev);
        }
        return aprobadas;
    }

    public double mediaAprobadas() {
        double resul = 0;
        ListaOrdinal aprobadas = this.asignaturasAprobadas();
        IteradorListaOrdinal it = aprobadas.getIterador();
        while (it.hasNext()) {
            resul += it.next().getNota();
        }
        resul /= aprobadas.getNumElementos();
        return resul;
    }

    public int getNumAprobadas() {
        ListaOrdinal aprobadas = this.asignaturasAprobadas();
        return aprobadas.getNumElementos();
    }

    public void mostrar() {
        System.out.println(nombre + ". Matricula: " + matricula);
        Iterator<Evaluacion> it = this.expediente.iterator();
        if (this.expediente.size() > 0) {
            while (it.hasNext()) {
                it.next().mostrar();
            }
            System.out.println(this.expediente.size() + " Evaluaciones y " + this.getNumAprobadas() + " asiganturas aprobadas con calificacion media " + this.mediaAprobadas());
        } else System.out.println("No ha realizado ninguna evaluacion.");
        System.out.println("---------------------------------");
    }

}


