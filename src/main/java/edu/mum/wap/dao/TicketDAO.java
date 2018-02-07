package edu.mum.wap.dao;

import edu.mum.wap.model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketDAO {
    private Map<Integer, Ticket> ticketsDb = new HashMap<>();

    public void addTicket(Ticket ticket) {
        ticketsDb.put(ticketsDb.size()+1,ticket);
    }

    public void deleteTicket(int id) {
        ticketsDb.remove(id);
    }
}
