package br.com.tdd.estruturadedados.recursividade.torrehanoi;


public class Disc {

    private Integer size;
    private String id;

    public Disc(Integer size, String id) {
        this.size = size;
        this.id = id;
    }

    public String getData() {
        return id;
    }

    public void setData(String data) {
        this.id = data;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
