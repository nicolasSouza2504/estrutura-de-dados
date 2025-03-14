package br.com.tdd.estruturadedados.recursividade.torrehanoi;


public class Disk {

    private Integer size;
    private String data;

    private Pin pin;

    public Pin getPin() {
        return pin;
    }

    public void setPin(Pin pin) {
        this.pin = pin;
    }

    public Disk(Integer size, String data) {
        this.size = size;
        this.data = data;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getData() {
        return this.data;
    }
}
