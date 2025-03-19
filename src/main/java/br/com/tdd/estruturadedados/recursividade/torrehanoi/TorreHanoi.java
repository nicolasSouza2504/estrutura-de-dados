package br.com.tdd.estruturadedados.recursividade.torrehanoi;

import java.util.ArrayList;
import java.util.List;

public class TorreHanoi {

    List<Pin> pins;

    private Integer destination;
    private String operation;
    private Integer majorSizeDisk;
    public Integer count = 0;

    public TorreHanoi() {

        this.pins = List.of(new Pin(1), new Pin(2), new Pin(3));

        this.operation = "+";
        this.majorSizeDisk = 3;

        List<Disk> disks = new ArrayList<>();

        disks.add(new Disk(3, "Disk 3"));
        disks.add(new Disk(2, "Disk 2" ));
        disks.add(new Disk(1, "Disk 1"));

        getPinByPosition(1).setDisks(disks);

    }

    public void changeDisksToDestination(Integer pinPosition) {

        setDestination(pinPosition);

        changeDisksToPin(pinPosition);

    }

    public void changeDisksToPin(Integer pinPosition) {

//        1️⃣ Mover um disco por vez.
//        2️⃣ Nunca colocar um disco maior sobre um disco menor.
//        3️⃣ Usar um pino auxiliar para ajudar nos movimentos.

        printPins();

        count ++;

        Pin receiverPin = getPinByPosition(pinPosition);

        Pin senderPin = getValidSender(receiverPin);

        if (canGroupToDestination()) {
            groupToDestination();
        } else if (senderPin != null) {

            senderPin.sendDisk(receiverPin);

            if (pinPosition.equals(pins.size()) || pinPosition == 1) {
                changeOperation(pinPosition.equals(pins.size()) ? "-" : "+");
            }

            changeDisksToPin(this.operation.equalsIgnoreCase( "+") ? pinPosition + 1 : pinPosition - 1);

        } else {

            if (pinPosition.equals(pins.size()) || pinPosition == 1) {
                changeOperation(pinPosition.equals(pins.size()) ? "-" : "+");
            }

            changeDisksToPin(this.operation.equalsIgnoreCase( "+") ? pinPosition + 1 : pinPosition - 1);

        }

    }

    private void groupToDestination() {

        Pin destination = getPinByPosition(getDestination());

        sendDiskToPin(destination, 2);

        sendDiskToPin(destination, 1);

    }

    private void sendDiskToPin(Pin receiverPin, Integer size) {

        Pin senderPin = pins.stream()
                        .filter(pin -> pin.getDisks().getLast().getSize() == size)
                        .findFirst()
                        .orElse(null);

        senderPin.sendDisk(receiverPin);

    }

    private Boolean canGroupToDestination() {

        Pin destination = getPinByPosition(getDestination());

        return !destination.getDisks().isEmpty()
                && destination.getLastDisk().getSize() == majorSizeDisk
                && pins.stream()
                    .filter(pin -> pin.getDisks().size() == 1)
                    .count() == pins.size();

    }

    private void changeOperation(String operation) {
        this.operation = operation;
    }

    private Boolean allDisksMovedToDestination() {
        return getPinByPosition(getDestination()).getDisks().size() == 3;
    }

    private Pin getValidSender(Pin receiverPin) {

        return pins.stream()
            .filter(pin -> !pin.getPosition().equals(receiverPin.getPosition()))
            .filter(senderPin -> !senderPin.getDisks().isEmpty()
                                && (receiverPin.getDisks().isEmpty()
                                || receiverPin.getLastDisk().getSize() > senderPin.getLastDisk().getSize()))
            .findFirst()
            .orElse(null);

    }

    private void setDestination(Integer destination) {
        this.destination = destination;
    }

    private Integer getDestination() {
        return this.destination;
    }

    private List<Disk> getDiskList() {
        return pins.stream().filter(pin -> !pin.getDisks().isEmpty()).findFirst().get().getDisks();
    }

    public void printPins() {

        System.out.println("\n\n Printing Pins\n\n");

        for (Pin pin : pins) {

            System.out.println("\n Pino" + pin.getPosition() + ": \n");

            pin.getDisks().forEach(disk -> {
                System.out.println(disk.getData());
            });

        }

    }

    private Pin getPinByPosition(Integer pinPosition) {
        return pins.stream().filter(pin -> pin.getPosition().equals(pinPosition)).findFirst().orElse(null);
    }

}



