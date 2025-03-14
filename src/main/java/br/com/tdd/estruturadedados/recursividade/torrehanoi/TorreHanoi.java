package br.com.tdd.estruturadedados.recursividade.torrehanoi;

import java.util.ArrayList;
import java.util.List;

public class TorreHanoi {

    List<Pin> pins;

    public TorreHanoi() {
        
        this.pins = List.of(new Pin(1), new Pin(2), new Pin(3));

        List<Disc> discs = new ArrayList<>();

        discs.add(new Disc(3, "Disc 3"));
        discs.add(new Disc(2, "Disc 2"));
        discs.add(new Disc(1, "Disc 1"));

        getPinById(1).setDiscs(discs);

    }
    
    public void changeDiscsToPin(Integer i) {

        Pin pinHasDiscs = getPinHasDiscs();

        if (pinHasDiscs == null) {

            System.out.println("Não há discos para mover");

            return;

        } else if (pinHasDiscs.getId() == i) {

            System.out.println("Discos já estão no pino informado");

            return;

        }  else if (getPinById(i) == null) {

            System.out.println("Pino não existe");

            return;

        } else {
            moveToPin(i);
        }

    }

    private void moveToPin(Integer idPinToMove) {

//        1️⃣ Mover um disco por vez.
//        2️⃣ Nunca colocar um disco maior sobre um disco menor.
//        3️⃣ Usar um pino auxiliar para ajudar nos movimentos.

        if (moveHasBeenCompleted(idPinToMove)) {
            return;
        } else {

            Pin pinToMove = getPinById(idPinToMove);

            Disc discToMove = pinToMove.getDiscs().getLast();

            if (pinToMove.getDiscs().isEmpty()) {

                pinToMove.getDiscs().add(discToMove);

                if (moveHasBeenCompleted(idPinToMove)) {
                    return;
                } else {
                    moveToPin(getIdPinHasMenorOrEmptyDiscs());
                }

            } else if (isPlaceble(pinToMove, discToMove)) {
                pinToMove.getDiscs().add(discToMove);
            } else {
                moveToPin(getIdPinHasMenorOrEmptyDiscs());
            }

        }

    }

    private boolean isPlaceble(Pin pin, Disc discToMove) {
        return pin.getDiscs().getLast().getSize() > discToMove.getSize();
    }

    private Boolean moveHasBeenCompleted(Integer destination) {
        return pins.get(destination - 1).getDiscs().size() == 3;
    }

    private Integer getIdPinHasMenorOrEmptyDiscs() {

        return pins.stream()
                .sorted((pin1, pin2) -> {

                    if (pin1.getDiscs().isEmpty()) {
                        return -1;
                    } else if (!pin2.getDiscs().isEmpty()) {
                        return Integer.compare(pin1.getDiscs().getLast().getSize(), pin2.getDiscs().getLast().getSize());
                    } else {
                        return Integer.compare(pin1.getDiscs().size(), pin2.getDiscs().size());
                    }

                })
                .findFirst()
                .get()
                .getId();

    }


    private Pin getPinHasDiscs() {

        return pins.stream()
                .filter(pin -> !pin.getDiscs().isEmpty()).findFirst()
                .get();

    }


    public void printPins() {
        
        for (Pin pin : pins) {
            
            System.out.println("Pino" + pin.getId() + ": ");

            pin.getDiscs().forEach(disc -> {
                System.out.println(disc.getData());
            });
            
        }
        
    }

    private Pin getPinById(Integer i) {
        return pins.stream().filter(pin -> pin.getId().equals(i)).findFirst().orElse(null);
    }


}
