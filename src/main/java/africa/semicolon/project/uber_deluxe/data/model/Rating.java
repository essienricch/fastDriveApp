package africa.semicolon.project.uber_deluxe.data.model;

public enum Rating {

    BALABLU(1),
    BAD(2),
    GOOD(3),
    SATISFACTORY(4),
    EXCELLENT(5);

    private int rating;

    public int getRating(){
        return this.rating;
    }
    Rating(int rating){
        this.rating = rating;
    }

}
