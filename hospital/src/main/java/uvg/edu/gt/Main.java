package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    
    /**
     * Metodo principal donde se lleva a cabo el programa
     * @param args
     */
    public static void main(String[] args) {
        List<Paciente> pacientes = readPacientes("pacientes.txt");

        System.out.println("Using VectorHeap:");
        VectorHeap<Paciente> vectorHeap = new VectorHeap<>(Paciente.prioridadComparator);
        for (Paciente paciente : pacientes) {
            vectorHeap.add(paciente);
        }

        while (!vectorHeap.isEmpty()) {
            System.out.println(vectorHeap.poll());
        }

        System.out.println("Using Java Collection Framework:");
        PriorityQueue<Paciente> javaPriorityQueue = new PriorityQueue<>(Paciente.prioridadComparator);
        for (Paciente paciente : pacientes) {
            javaPriorityQueue.add(paciente);
        }

        while (!javaPriorityQueue.isEmpty()) {
            System.out.println(javaPriorityQueue.poll());
        }
    }

    /**
     * Agarra los elementos de el arachivo
     * @param fileName
     * @return
     */
    private static List<Paciente> readPacientes(String fileName) {
        List<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine())!= null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    pacientes.add(new Paciente(values[0].trim(), values[1].trim(), values[2].trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pacientes;
    }
}