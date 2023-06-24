import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerWithFilters {
    public void printAverageRatings() {
        ThirdRatings third = new ThirdRatings();
        MovieDatabase.initialize("ratedmovies_short.csv");
        int ratingsLength = third.getRaterSize();
        System.out.println("There are " + MovieDatabase.size() + " movies.");
        System.out.println("There are " + ratingsLength + " ratings.");
        // Print movies with enough ratings
        ArrayList<Rating> ratings = third.getAverageRatings(1);
        Collections.sort(ratings);
        System.out.println(ratings.size() + " movies with >= 1 ratings.");
        for (Rating rating : ratings) {
            String title = MovieDatabase.getTitle(rating.getItem());
            System.out.println(rating.getValue() + " " + title);
        }
    }
    public void printAverageRatingsByYear() {
        ThirdRatings third = new ThirdRatings();
        MovieDatabase.initialize("ratedmovies_short.csv");
        YearAfterFilter yearFilter = new YearAfterFilter(2000);
        ArrayList<Rating> filtered = third.getAverageRatingsByFilter(1, yearFilter);
        System.out.println("Found " + filtered.size() + " movies.");
        for (Rating rating : filtered) {
            String title = MovieDatabase.getTitle(rating.getItem());
            System.out.println(rating.getValue() + " " + title);
        }
    }

    public void printAverageRatingsByGenre() {
        ThirdRatings third = new ThirdRatings();
        MovieDatabase.initialize("ratedmovies_short.csv");
        GenreFilter genreFilter = new GenreFilter("Crime");
        ArrayList<Rating> filtered = third.getAverageRatingsByFilter(1, genreFilter);
        System.out.println("Found " + filtered.size() + " movies.");
        for (Rating rating : filtered) {
            String title = MovieDatabase.getTitle(rating.getItem());
            System.out.println(rating.getValue() + " " + title);
        }
    }

    public void printAverageRatingsByMinutes() {
        ThirdRatings third = new ThirdRatings();
        MovieDatabase.initialize("ratedmovies_short.csv");
        MinutesFilter minFilter = new MinutesFilter(100, 170);
        ArrayList<Rating> filtered = third.getAverageRatingsByFilter(1, minFilter);
        System.out.println("Found " + filtered.size() + " movies.");
        for (Rating rating : filtered) {
            String title = MovieDatabase.getTitle(rating.getItem());
            System.out.println(rating.getValue() + " " + title);
        }
    }
    public static void main(String[] args) {
        MovieRunnerWithFilters inst = new MovieRunnerWithFilters();
//        inst.printAverageRatings();
//        inst.printAverageRatingsByYear();
//        inst.printAverageRatingsByGenre();
        inst.printAverageRatingsByMinutes();
    }
}
