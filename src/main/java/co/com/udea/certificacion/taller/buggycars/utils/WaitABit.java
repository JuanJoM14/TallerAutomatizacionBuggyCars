package co.com.udea.certificacion.taller.buggycars.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WaitABit implements Interaction {
    private final long millis;
    public WaitABit(long millis){ this.millis = millis; }
    @Override
    public <T extends Actor> void performAs(T actor) {
        try { Thread.sleep(millis); } catch (InterruptedException ignored) {}
    }
    public static WaitABit forMillis(long millis) {
        return instrumented(WaitABit.class, millis);
    }
}