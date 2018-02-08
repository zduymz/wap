package edu.mum.wap.dao;

import edu.mum.wap.model.Cinema;
import edu.mum.wap.model.Movie;
import edu.mum.wap.model.Seat;
import edu.mum.wap.model.ShowDate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CinemaDAO {
    private Map<String, Cinema> cinemasDAO = new HashMap<>();
    private MovieDAO movies = new MovieDAO();
    {
        Map<String, Integer[]> _seat1 = new HashMap<>();
        Map<String, Integer[]> _seat2 = new HashMap<>();
        Map<String, Integer[]> _seat3 = new HashMap<>();
        Map<String, Integer[]> _seat4 = new HashMap<>();
        Map<String, Integer[]> _seat5 = new HashMap<>();
        Map<String, Integer[]> _seat6 = new HashMap<>();
        Map<String, Integer[]> _seat7 = new HashMap<>();
        Map<String, Integer[]> _seat8 = new HashMap<>();
        Map<String, Integer[]> _seat9 = new HashMap<>();
        Map<String, Integer[]> _seat10 = new HashMap<>();
        Map<String, Integer[]> _seat11 = new HashMap<>();
        Map<String, Integer[]> _seat12 = new HashMap<>();
        Map<String, Integer[]> _seat13 = new HashMap<>();
        Map<String, Integer[]> _seat14 = new HashMap<>();
        Map<String, Integer[]> _seat15 = new HashMap<>();
        Map<String, Integer[]> _seat16 = new HashMap<>();
        Map<String, Integer[]> _seat17 = new HashMap<>();
        Map<String, Integer[]> _seat18 = new HashMap<>();
        Map<String, Integer[]> _seat19 = new HashMap<>();
        Map<String, Integer[]> _seat20 = new HashMap<>();
        Map<String, Integer[]> _seat21 = new HashMap<>();
        Map<String, Integer[]> _seat22 = new HashMap<>();

        _seat1.put("A", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat1.put("B", new Integer[]{0, 1, 1, 0, 0, 0, 0, 0, 0, 0});
        _seat1.put("C", new Integer[]{0, 1, 0, 1, 0, 0, 0, 0, 0, 0});
        _seat1.put("D", new Integer[]{0, 1, 0, 0, 1, 0, 0, 0, 0, 0});
        _seat1.put("E", new Integer[]{0, 1, 0, 0, 0, 1, 0, 0, 0, 0});
        _seat1.put("F", new Integer[]{0, 1, 0, 0, 0, 0, 1, 0, 0, 0});
        _seat1.put("G", new Integer[]{0, 1, 0, 0, 0, 0, 0, 1, 0, 0});
        _seat1.put("H", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 1, 0});
        _seat1.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 1});
        _seat1.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat2.put("A", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat2.put("B", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat2.put("C", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat2.put("D", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat2.put("E", new Integer[]{0, 1, 0, 1, 0, 0, 0, 0, 0, 0});
        _seat2.put("F", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat2.put("G", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat2.put("H", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat2.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat2.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat3.put("A", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat3.put("B", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat3.put("C", new Integer[]{0, 1, 0, 1, 0, 0, 0, 0, 0, 0});
        _seat3.put("D", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat3.put("E", new Integer[]{0, 1, 0, 0, 0, 0, 1, 0, 0, 0});
        _seat3.put("F", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat3.put("G", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat3.put("H", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat3.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat3.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat4.put("A", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat4.put("B", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat4.put("C", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat4.put("D", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat4.put("E", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat4.put("F", new Integer[]{0, 1, 0, 0, 0, 0, 1, 0, 0, 0});
        _seat4.put("G", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat4.put("H", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat4.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat4.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat5.put("A", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat5.put("B", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat5.put("C", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat5.put("D", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat5.put("E", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat5.put("F", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat5.put("G", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat5.put("H", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat5.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat5.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat6.put("A", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat6.put("B", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat6.put("C", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat6.put("D", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat6.put("E", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat6.put("F", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat6.put("G", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat6.put("H", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat6.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat6.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat7.put("A", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat7.put("B", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat7.put("C", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat7.put("D", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat7.put("E", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat7.put("F", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat7.put("G", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat7.put("H", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat7.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat7.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat8.put("A", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat8.put("B", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat8.put("C", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat8.put("D", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat8.put("E", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat8.put("F", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat8.put("G", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat8.put("H", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat8.put("I", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat8.put("J", new Integer[]{0, 0, 0, 1, 0, 0, 0, 0, 0, 0});

        _seat9.put("A", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat9.put("B", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat9.put("C", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat9.put("D", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat9.put("E", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat9.put("F", new Integer[]{0, 0, 0, 0, 1, 0, 0, 0, 0, 0});
        _seat9.put("G", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat9.put("H", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat9.put("I", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat9.put("J", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat10.put("A", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat10.put("B", new Integer[]{0, 0, 0, 1, 1, 0, 0, 0, 0, 0});
        _seat10.put("C", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat10.put("D", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat10.put("E", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat10.put("F", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat10.put("G", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat10.put("H", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat10.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat10.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat11.put("A", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat11.put("B", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat11.put("C", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat11.put("D", new Integer[]{0, 1, 0, 0, 1, 1, 0, 0, 0, 0});
        _seat11.put("E", new Integer[]{0, 1, 0, 0, 1, 1, 0, 0, 0, 0});
        _seat11.put("F", new Integer[]{0, 1, 0, 0, 0, 1, 0, 0, 0, 0});
        _seat11.put("G", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat11.put("H", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat11.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat11.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat12.put("A", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat12.put("B", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat12.put("C", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat12.put("D", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat12.put("E", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat12.put("F", new Integer[]{0, 1, 1, 1, 1, 0, 0, 0, 0, 0});
        _seat12.put("G", new Integer[]{0, 1, 0, 0, 1, 0, 0, 0, 0, 0});
        _seat12.put("H", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat12.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat12.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat13.put("A", new Integer[]{0, 1, 1, 1, 1, 0, 0, 0, 0, 0});
        _seat13.put("B", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat13.put("C", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat13.put("D", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat13.put("E", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat13.put("F", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat13.put("G", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat13.put("H", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat13.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat13.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat14.put("A", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat14.put("B", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat14.put("C", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat14.put("D", new Integer[]{0, 1, 0, 1, 0, 0, 0, 0, 0, 0});
        _seat14.put("E", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat14.put("F", new Integer[]{0, 1, 0, 0, 1, 1, 0, 0, 0, 0});
        _seat14.put("G", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat14.put("H", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat14.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat14.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat15.put("A", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat15.put("B", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat15.put("C", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat15.put("D", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat15.put("E", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat15.put("F", new Integer[]{0, 0, 0, 1, 1, 1, 0, 0, 0, 0});
        _seat15.put("G", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat15.put("H", new Integer[]{0, 1, 0, 0, 0, 1, 0, 0, 0, 0});
        _seat15.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat15.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat16.put("A", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat16.put("B", new Integer[]{0, 1, 0, 0, 1, 0, 0, 0, 0, 0});
        _seat16.put("C", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat16.put("D", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat16.put("E", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat16.put("F", new Integer[]{0, 1, 0, 0, 0, 1, 0, 0, 0, 0});
        _seat16.put("G", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat16.put("H", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat16.put("I", new Integer[]{0, 1, 0, 1, 1, 0, 0, 1, 0, 0});
        _seat16.put("J", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat17.put("A", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat17.put("B", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat17.put("C", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat17.put("D", new Integer[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 0});
        _seat17.put("E", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat17.put("F", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat17.put("G", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat17.put("H", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat17.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat17.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat18.put("A", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat18.put("B", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat18.put("C", new Integer[]{0, 1, 0, 0, 1, 0, 1, 0, 0, 0});
        _seat18.put("D", new Integer[]{0, 1, 0, 0, 0, 1, 0, 0, 0, 0});
        _seat18.put("E", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat18.put("F", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat18.put("G", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat18.put("H", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat18.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat18.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat19.put("A", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat19.put("B", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat19.put("C", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat19.put("D", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat19.put("E", new Integer[]{0, 1, 0, 0, 0, 1, 0, 0, 0, 0});
        _seat19.put("F", new Integer[]{0, 1, 0, 0, 1, 1, 0, 0, 0, 0});
        _seat19.put("G", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat19.put("H", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat19.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat19.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat20.put("A", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat20.put("B", new Integer[]{0, 1, 0, 1, 0, 0, 0, 0, 0, 0});
        _seat20.put("C", new Integer[]{0, 1, 0, 1, 0, 0, 0, 0, 0, 0});
        _seat20.put("D", new Integer[]{0, 1, 1, 0, 0, 0, 0, 0, 0, 0});
        _seat20.put("E", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat20.put("F", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat20.put("G", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat20.put("H", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat20.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat20.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat21.put("A", new Integer[]{0, 1, 1, 0, 0, 0, 0, 0, 0, 0});
        _seat21.put("B", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat21.put("C", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat21.put("D", new Integer[]{0, 1, 1, 0, 0, 0, 0, 0, 0, 0});
        _seat21.put("E", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat21.put("F", new Integer[]{0, 1, 1, 0, 0, 0, 0, 0, 0, 0});
        _seat21.put("G", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat21.put("H", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat21.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat21.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        _seat22.put("A", new Integer[]{0, 1, 0, 0, 1, 0, 0, 0, 0, 0});
        _seat22.put("B", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat22.put("C", new Integer[]{0, 1, 0, 0, 1, 0, 0, 0, 0, 0});
        _seat22.put("D", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat22.put("E", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat22.put("F", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat22.put("G", new Integer[]{0, 1, 0, 0, 1, 0, 0, 0, 0, 0});
        _seat22.put("H", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat22.put("I", new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        _seat22.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        Seat seat1 = new Seat(_seat1);
        Seat seat2 = new Seat(_seat2);
        Seat seat3 = new Seat(_seat3);
        Seat seat4 = new Seat(_seat4);
        Seat seat5 = new Seat(_seat5);
        Seat seat6 = new Seat(_seat6);
        Seat seat7 = new Seat(_seat7);
        Seat seat8 = new Seat(_seat8);
        Seat seat9 = new Seat(_seat9);
        Seat seat10 = new Seat(_seat10);
        Seat seat11 = new Seat(_seat11);
        Seat seat12 = new Seat(_seat12);
        Seat seat13 = new Seat(_seat13);
        Seat seat14 = new Seat(_seat14);
        Seat seat15 = new Seat(_seat15);
        Seat seat16 = new Seat(_seat16);
        Seat seat17 = new Seat(_seat17);
        Seat seat18 = new Seat(_seat18);
        Seat seat19 = new Seat(_seat19);
        Seat seat20 = new Seat(_seat20);
        Seat seat21 = new Seat(_seat21);
        Seat seat22 = new Seat(_seat22);
        
        Cinema c1 = new Cinema("1", "1215 Theatre Drive, Ottumwa, IA", "CEC - Ottumwa 8 Theatre");
        Cinema c2 = new Cinema("2", "831 Ave G, Fort Madison, IA", "Fox Theater - Fort Madison");
        Cinema c3 = new Cinema("3", "1602 Sycamore St, Iowa City, IA", "Marcus Sycamore Cinema");
        Cinema c4 = new Cinema("4", "550 S Gear Ave, West Burlington, IA", "CEC - Westland Mall 10");

        c1.addSchedule(new ShowDate("2/14/2018", "Wed", "14:30"),
                movies.getMovieById("1"), seat1);
        c1.addSchedule(new ShowDate("2/14/2018", "Wed", "16:30"),
                movies.getMovieById("2"), seat2);
        c1.addSchedule(new ShowDate("2/14/2018", "Wed", "18:30"),
                movies.getMovieById("3"), seat3);
        c1.addSchedule(new ShowDate("2/14/2018", "Wed", "20:30"),
                movies.getMovieById("1"), seat4);
        c1.addSchedule(new ShowDate("2/15/2018", "Thu", "8:00"),
                movies.getMovieById("2"), seat5);
        c1.addSchedule(new ShowDate("2/15/2018", "Thu", "10:00"),
                movies.getMovieById("3"), seat6);
        c1.addSchedule(new ShowDate("2/15/2018", "Thu", "12:00"),
                movies.getMovieById("1"), seat7);
        c1.addSchedule(new ShowDate("2/15/2018", "Thu", "14:00"),
                movies.getMovieById("3"), seat8);
        c1.addSchedule(new ShowDate("2/15/2018", "Thu", "16:00"),
                movies.getMovieById("4"), seat9);
        c1.addSchedule(new ShowDate("2/15/2018", "Thu", "18:00"),
                movies.getMovieById("5"), seat10);
        c1.addSchedule(new ShowDate("2/16/2018", "Fri", "8:00"),
                movies.getMovieById("1"), seat11);
        c1.addSchedule(new ShowDate("2/16/2018", "Fri", "10:00"),
                movies.getMovieById("5"), seat12);

        c2.addSchedule(new ShowDate("2/14/2018", "Wed", "17:30"),
                movies.getMovieById("1"), seat13);
        c2.addSchedule(new ShowDate("2/14/2018", "Wed", "16:30"),
                movies.getMovieById("1"), seat14);
        c3.addSchedule(new ShowDate("2/14/2018", "Wed", "18:30"),
                movies.getMovieById("1"), seat15);
        c4.addSchedule(new ShowDate("2/14/2018", "Wed", "10:30"),
                movies.getMovieById("1"), seat16);
        c2.addSchedule(new ShowDate("2/15/2018", "Wed", "14:30"),
                movies.getMovieById("2"), seat17);
        c2.addSchedule(new ShowDate("2/15/2018", "Wed", "16:30"),
                movies.getMovieById("3"), seat18);
        c3.addSchedule(new ShowDate("2/14/2018", "Wed", "14:30"),
                movies.getMovieById("2"), seat19);
        c4.addSchedule(new ShowDate("2/14/2018", "Wed", "16:30"),
                movies.getMovieById("3"), seat20);
        c4.addSchedule(new ShowDate("2/14/2018", "Wed", "18:30"),
                movies.getMovieById("6"), seat21);
        c4.addSchedule(new ShowDate("2/14/2018", "Wed", "20:30"),
                movies.getMovieById("6"), seat22);
        cinemasDAO.put("1",c1);
        cinemasDAO.put("2",c2);
        cinemasDAO.put("3",c3);
        cinemasDAO.put("4",c4);
    }

    public List<Cinema> getCinemaList(Movie movie) {
        return cinemasDAO.values().stream().filter(cinema -> cinema.hasMovie(movie))
                .collect(Collectors.toList());
    }

    public List<Cinema> getAllCinemas() {
        return cinemasDAO.values().stream().collect(Collectors.toList());
    }

    public Cinema getCinema(String id) {
        return cinemasDAO.get(id);
    }

    public List<ShowDate> getShowDate(String cinemaID, Movie movie) {
        return cinemasDAO.get(cinemaID).getShowDate(movie);
    }

    public Seat getSeat(String cinemaID, String time) {
        return cinemasDAO.get(cinemaID).getSeat(time);
    }

    public boolean updateSeat(String _seat1, String cinemaID, String time) {
        return cinemasDAO.get(cinemaID).getSeat(time).setSeat(_seat1);
    }

    public int getAvailableSeat(String cinemaID, String time) {
        return cinemasDAO.get(cinemaID).getSeat(time).getAvailableSeat();
    }
}
