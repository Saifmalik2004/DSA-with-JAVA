// Interface Example
interface Playable {
    // Abstract method in interface
    void play();
}

class MP3Player implements Playable {
    // Implementing play method from Playable interface
    @Override
    public void play() {
        System.out.println("Playing music from MP3 Player 🎶");
    }
}

class Smartphone implements Playable {
    // Implementing play method from Playable interface
    @Override
    public void play() {
        System.out.println("Playing music from Smartphone 📱");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        // Interface Demonstration
        System.out.println("\nInterface Example:");
        Playable mp3Player = new MP3Player();
        Playable smartphone = new Smartphone();

        mp3Player.play();  // Output: Playing music from MP3 Player
        smartphone.play(); // Output: Playing music from Smartphone
    }
}
