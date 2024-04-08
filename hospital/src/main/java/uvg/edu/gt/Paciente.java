package uvg.edu.gt;

import java.util.Comparator;

public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private String prioridad;

    public Paciente(String nombre, String sintoma, String prioridad) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public String getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Paciente other) {
        return this.prioridad.compareTo(other.prioridad);
    }

    public static Comparator<Paciente> prioridadComparator = new Comparator<Paciente>() {
        @Override
        public int compare(Paciente p1, Paciente p2) {
            return p1.prioridad.compareTo(p2.prioridad);
        }
    };
}
