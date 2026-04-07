public class Time implements Comparable<Time> {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int toSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    @Override
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }

    @Override
    public int compareTo(Time other) {
        return Integer.compare(this.toSeconds(), other.toSeconds());
    }
}
