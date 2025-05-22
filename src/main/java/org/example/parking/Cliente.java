package org.example.parking;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente {
    private final String dni;
    private final String nombre;
    private final List<Vehiculo> vehiculos;

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            vehiculos.add(vehiculo);
        }
    }
    public Vehiculo buscarVehiculoPorPatente(String patente) {
        if (patente == null || patente.isEmpty()) {
            return null;
        }
        for (Vehiculo vehiculo : vehiculos) {
            if (patente.equalsIgnoreCase(vehiculo.getPatente())) {
                return vehiculo;
            }
        }
        return null;
    }
}