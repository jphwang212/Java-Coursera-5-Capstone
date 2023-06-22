import java.util.ArrayList;

public class ThirdRatings {
    private ArrayList<Rater> myRaters;

    public ThirdRatings() {
        this("ratings_short.csv");
    }
    public ThirdRatings(String ratingsfile) {
        FirstRatings first = new FirstRatings();
        myRaters = first.loadRaters(ratingsfile);
    }

    public int getRaterSize() {
        return myRaters.size();
    }

    private double getAverageByID(String id, int minimalRaters) {
        ArrayList<Double> movieRatings = new ArrayList<Double>();
        double sum = 0.0;
        for (Rater rater : myRaters) {
            if (rater.hasRating(id)) {
                double rating = rater.getRating(id);
                movieRatings.add(rating);
                sum += rating;
            }
        }
        if (movieRatings.size() < minimalRaters) {
            return 0.0;
        }
        return sum / movieRatings.size();
    }

    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        ArrayList<Rating> averages = new ArrayList<Rating>();

        for (String id : movies) {
            double avgRating = getAverageByID(id, minimalRaters);
            if (avgRating > 0.0) {
                Rating rating = new Rating(id, avgRating);
                averages.add(rating);
            }
        }
        return averages;
    }

    public static void main(String[] args) {
        ThirdRatings inst = new ThirdRatings("ratings_short.csv");
        MovieDatabase.initialize("ratedmovies_short.csv");
        ArrayList<Rating> ratings = inst.getAverageRatings(1);
        System.out.println(ratings.size() + " ratings.");
        for (Rating rating : ratings) {
            System.out.println(rating.toString());
        }
    }
}
