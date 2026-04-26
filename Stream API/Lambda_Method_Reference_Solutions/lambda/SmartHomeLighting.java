import java.util.function.Consumer;

public class SmartHomeLighting {
    public static void main(String[] args) {

        Consumer<String> motionTrigger = (room) ->
                System.out.println("Motion detected! Turning ON lights in " + room);

        Consumer<String> nightMode = (room) ->
                System.out.println("Night mode: Dim lights in " + room);

        Consumer<String> voiceCommand = (room) ->
                System.out.println("Voice command: Lights ON in " + room);

        motionTrigger.accept("Living Room");
        nightMode.accept("Bedroom");
        voiceCommand.accept("Kitchen");
    }
}
