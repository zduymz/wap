package edu.mum.wap.dao;

import edu.mum.wap.model.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TicketDAO {
    private Map<Integer, Ticket> ticketsDb = new HashMap<>();

    public int addTicket(Ticket ticket) {
        int ret = ticketsDb.size()+1;
        ticket.setId(ret);
        ticketsDb.put(ret,ticket);
        return ret;
    }

    public void deleteTicket(int id) {
        ticketsDb.remove(id);
    }

    public List<Ticket> getTicketByUserId(String userid) {
        return ticketsDb.values().stream()
                .filter(t -> t.getUserId().equals(userid))
                .collect(Collectors.toList());
    }
}
