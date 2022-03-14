public class Pruebas {

    public static void main(String[] args) {
        System.out.println("********** PRUEBAS **********");

        System.out.println();

        Evaluacion e1 = new Evaluacion("ED", "Junio 19", 4.5);
        Evaluacion e2 = new Evaluacion("ED", "Julio 19", -1);
        Evaluacion e3 = new Evaluacion("ED", "Junio 20", 7.4);
        Evaluacion e4 = new Evaluacion("Algebra", "Junio 18", 6.4);

        ListaOrdinal ev = new ListaOrdinal();

        ev.insertar(e1);
        ev.insertar(e2);
        ev.insertar(e3);
        ev.insertar(e4);

        IteradorListaOrdinal it = ev.getIterador();

        System.out.println("------------ EVALUACIONES EN LA LISTA -----------");
        while (it.hasNext()) {
            it.next().mostrar();
        }

        System.out.println();

        System.out.println("-------------------------------");
        System.out.println("Convocatorias en ED: " + ev.numConvocatorias("ED"));
        System.out.println("Convocatorias en Algebra: " + ev.numConvocatorias("Algebra"));
        System.out.println("Convocatorias en Fundamentos de Programacion: " + ev.numConvocatorias("Fundamentos de Programacion"));

        Alumno a1 = new Alumno("Felipe Garcia Gomez", 1253);
        Alumno a2 = new Alumno("Alicia Blazquez Martin", 5622);

        System.out.println();

        a1.nuevaEvaluacion(e1);
        a1.nuevaEvaluacion(e2);
        a1.nuevaEvaluacion(e3);
        a1.nuevaEvaluacion(e4);

        System.out.println("----------- Asignaturas aprobadas por Felipe García Gómez ----------");
        it = a1.asignaturasAprobadas().getIterador();
        while (it.hasNext()) {
            it.next().mostrar();
        }

        System.out.println();
        System.out.println("----------- Asignaturas aprobadas por Alicia Blázquez Martín ----------");
        it = a2.asignaturasAprobadas().getIterador();
        while (it.hasNext()) {
            it.next().mostrar();
        }

        System.out.println();
        System.out.println("----------- MOSTRAR LOS ALUMNOS ------------");
        a1.mostrar();
        a2.mostrar();

        System.out.println();

        AlumnoBib ab1 = new AlumnoBib("Eduardo Parra Martín", 8765);
        AlumnoBib ab2 = new AlumnoBib("Sonia Torres Pardo", 2345);

        ab1.nuevaEvaluacion(e1);
        ab1.nuevaEvaluacion(e2);
        ab1.nuevaEvaluacion(e3);
        ab1.nuevaEvaluacion(e4);

        System.out.println("----------- MOSTRAR LOS ALUMNOS BIBLIOTECA------------");
        ab1.mostrar();
        ab2.mostrar();

        System.out.println();

        Alumno a3 = new Alumno("Pedro Jiménez del Pozo", 8510);
        Evaluacion evaluacion = new Evaluacion("Fundamentos de Programación", "Enero 19", 8.8);

        a3.nuevaEvaluacion(evaluacion);

        ListaCalificada lc = new ListaCalificada();

        lc.insertar(a3);
        lc.insertar(a1);
        lc.insertar(a2);

        IteradorListaCalificada itc = lc.getIterador();

        System.out.println("------------ ALUMNOS EN LA LISTA -------------");
        while (itc.hasNext()) {
            itc.next().mostrar();
        }

        System.out.println();
        System.out.println("---------- Borramos las claves menores a 6000------------");
        lc.borrarMenores(6000);
        itc = lc.getIterador();
        while (itc.hasNext()) {
            itc.next().mostrar();
        }

        System.out.println();
        System.out.println("---------- Borramos las claves menores a 9000------------");
        lc.borrarMenores(9000);
        itc = lc.getIterador();
        while (itc.hasNext()) {
            itc.next().mostrar();
        }

        lc.insertar(a1);
        lc.insertar(a2);
        lc.insertar(a3);

        System.out.println();
        System.out.println("----- Metemos todos los alumnos y borramos las claves mayores a 7000 ------");
        lc.borrarMayores(7000);
        itc = lc.getIterador();
        while (itc.hasNext()) {
            itc.next().mostrar();
        }

        System.out.println();
        System.out.println("------------ Borramos las claves mayores a 1000 -----------");
        lc.borrarMayores(1000);
        itc = lc.getIterador();
        while (itc.hasNext()) {
            itc.next().mostrar();
        }

        GrupoAlumnos GX11 = new GrupoAlumnos("GX11");

        GX11.nuevoAlumno(a1);
        GX11.nuevoAlumno(a2);
        GX11.nuevoAlumno(a3);

        System.out.println();
        System.out.println("------------ CREADO EL GRUPO GX11------------");
        System.out.println("El Grupo " + GX11.getNombre() + " tiene " + GX11.getNumAlumnos() + " Alumnos");
        System.out.println("------------ Grupo GX11. Alumno con matrícula 8510 ------------");
        GX11.getAlumno(8510).mostrar();
        System.out.println("porcentaje de aprobados en ED el grupo GX11: " + GX11.porcentajeAprobados("ED"));
    }
}