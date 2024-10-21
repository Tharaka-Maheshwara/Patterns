//Structural Patterns
//Facade Pattern
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player on");
    }

    public void play(String movie) {
        System.out.println("Playing " + movie);
    }

    public void off() {
        System.out.println("DVD Player off");
    }
}

class Amplifier {
    public void on() {
        System.out.println("Amplifier on");
    }

    public void setVolume(int level) {
        System.out.println("Setting volume to " + level);
    }

    public void off() {
        System.out.println("Amplifier off");
    }
}

class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Amplifier amplifier;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Amplifier amplifier) {
        this.dvdPlayer = dvdPlayer;
        this.amplifier = amplifier;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        amplifier.on();
        amplifier.setVolume(10);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        dvdPlayer.off();
        amplifier.off();
    }

    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Amplifier amplifier = new Amplifier();
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, amplifier);

        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}
