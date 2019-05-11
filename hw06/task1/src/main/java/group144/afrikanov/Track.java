package group144.afrikanov;

public class Track {

    private final String name;
    private final int rating;

    Track(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }
}