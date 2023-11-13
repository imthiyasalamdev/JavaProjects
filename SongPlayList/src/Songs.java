public class Songs {
    String title;
    double duration;

    public Songs(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public Songs() {

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Songs{" + "title='" + title + '\'' + ", duration=" + duration + '}';
    }
}
