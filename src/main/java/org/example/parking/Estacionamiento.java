package org.example.parking;

import java.util.*;

public class Estacionamiento {
    private final int capacidadMaxima = 50;
    private final Map<String, Ticket> vehiculosEstacionados = new HashMap<>();
    private final Map<String, Cliente> clientesRegistrados = new HashMap<>();

    public boolean ingresarVehiculo(String dni, String nombre, Vehiculo vehiculo) {
        if (vehiculosEstacionados.size() >= capacidadMaxima) {
            return false;
        }
        if (vehiculosEstacionados.containsKey(vehiculo.getPatente())) {
            return false;
        }
        Cliente cliente = clientesRegistrados.get(dni);

        if (cliente == null) {
            cliente = new Cliente(dni, nombre);
            clientesRegistrados.put(dni, cliente);
        }

        if (cliente.buscarVehiculoPorPatente(vehiculo.getPatente()) != null) {
            return false;
        }
        cliente.agregarVehiculo(vehiculo);
        Ticket ticket = new Ticket(cliente, vehiculo);
        vehiculosEstacionados.put(vehiculo.getPatente(), ticket);
        return true;
    }

    public Ticket retirarVehiculo(String patente) throws Exception {
        Ticket ticket = vehiculosEstacionados.get(patente);
        if (ticket == null) {
            throw new Exception("Vehiculo no encontrado");
        }
        ticket.marcarSalida();
        vehiculosEstacionados.remove(patente);
        return ticket;
    }

    public List<Ticket> listarVehiculosEstacionados() {
        return new ArrayList<>(vehiculosEstacionados.values());
    }
}
