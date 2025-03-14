package br.com.tdd.estruturadedados.recursividade.torrehanoi;

import java.util.ArrayList;
import java.util.List;

public class Pin {

    private Integer id;
    private List<Disc> discs = new ArrayList<>();

    public Pin(Integer id) {
        this.id = id;
    }

    public List<Disc> getDiscs() {
        return discs;
    }

    public Integer getId() {
        return this.id;
    }


    public void setDiscs(List<Disc> discs) {
        this.discs = discs;
    }

}
