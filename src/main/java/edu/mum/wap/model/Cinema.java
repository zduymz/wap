package edu.mum.wap.model;

import java.util.ArrayList;

public class Cinema {
    private String id;
    private String address;
    private String name;
//    private Integer chairs;
    private ArrayList<ShowDate> showdates;
    private Integer[][] seats = new Integer[10][10];
}
