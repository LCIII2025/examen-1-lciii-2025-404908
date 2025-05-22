package org.example.parking;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {

    }

    @Test
    public void testCalcularPrecio() throws Exception {
        Cliente cliente = new Cliente("234432", "norma rodriguez");
        Vehiculo vehiculo = new Vehiculo("aaa111aaa", "ford fiesta", Vehiculo.Tipo.AUTO);
        cliente.agregarVehiculo(vehiculo);
        Ticket ticket = new Ticket(cliente, vehiculo);

        ticket.setHoraSalida(ticket.getHoraEntrada().plusHours(2).plusMinutes(30));
        long duracion = ticket.calcularMinutos();
        double precio = ticket.calcularPrecio();


    }
}