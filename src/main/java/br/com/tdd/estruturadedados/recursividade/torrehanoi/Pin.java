package br.com.tdd.estruturadedados.recursividade.torrehanoi;

import java.util.ArrayList;
import java.util.List;

public class Pin {

    private Integer position;
    private List<Disk> disks = new ArrayList<>();

    public Pin(Integer position) {
        this.position = position;
    }

    public List<Disk> getDisks() {
        return disks;
    }

    public Integer getPosition() {
        return this.position;
    }


    public void setDisks(List<Disk> disks) {

        disks.forEach(disk -> {
            disk.setPin(this);
        });

        this.disks = disks;

    }

    public void addDisk(Disk disk) {

        this.disks.add(disk);

        disk.setPin(this);

    }

    public void removeDisk(Disk disk) {
        this.disks.remove(disk);
    }

    public Disk getLastDisk() {
        return disks.getLast();
    }

    public void sendDisk(Pin receiverPin) {

        Disk lastDisk = getLastDisk();

        this.removeDisk(lastDisk);

        receiverPin.addDisk(lastDisk);

    }

}
