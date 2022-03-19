package org.alozano.model;

import java.util.ArrayList;
import java.util.List;

public class ListaCsv {
    private List<Csv> lista = new ArrayList<>();

    public void add(Csv csv) {
        lista.add(csv);
    }
    public List <Csv> get(){
        return lista;
    }
}
