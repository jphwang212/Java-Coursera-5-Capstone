import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
import java.lang.reflect.Array;
import java.util.*;
public class FirstRatings {
    public ArrayList<Rater> loadRaters(String filename) {
        HashMap<String, Rater> raterMap = new HashMap<String, Rater>();
        ArrayList<Rater> raterData = new ArrayList<Rater>();
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            if (filename.equals(file.getName())) {
                FileResource fr = new FileResource(file);
                CSVParser parser = fr.getCSVParser();
                for (CSVRecord record : parser) {
                    String raterId = record.get("rater_id");
                    String movieId = record.get("movie_id");
                    double rating = Integer.parseInt(record.get("rating"));
                    Rater rater = new Rater(raterId);
                    if (!raterMap.containsKey(raterId)) {
                        rater.addRating(movieId, rating);
                        raterMap.put(raterId, rater);
                    } else {
                        rater = raterMap.get(raterId);
                        if (!rater.hasRating(movieId)) {
                            rater.addRating(movieId, rating);
                        }
                    }
                }
            }
        }
        for (String raterId : raterMap.keySet()) {
            raterData.add(raterMap.get(raterId));
        }
        return raterData;
    }
    public ArrayList<Movie> loadMovies(String filename) {
        ArrayList<Movie> movieData = new ArrayList<Movie>();
        DirectoryResource dr = new DirectoryResource();
        for (File fr : dr.selectedFiles()) {
            if (filename.equals(fr.getName())) {
                FileResource f = new FileResource(fr);
                CSVParser parser = f.getCSVParser();
                for (CSVRecord record : parser) {
                    String id = record.get("id");
                    String title = record.get("title");
                    String year = record.get("year");
                    String genres = record.get("genre");
                    String director = record.get("director");
                    String country = record.get("country");
                    int minutes = Integer.parseInt(record.get("minutes"));
                    String poster = record.get("poster");
//                    if (genres.contains("Comedy")) {
//                        genreCount++;
//                    }
//                    if (minutes > 150) {
//                        timeCount++;
//                    }
                    Movie currMovie = new Movie(id, title, year, genres, director, country, poster, minutes);
                    movieData.add(currMovie);
                }
            }
        }
        return movieData;
    }

    public void testLoadMovies() {
        ArrayList<Movie> movieData = loadMovies("ratedmoviesfull.csv");
        System.out.println("There are " + movieData.size() + " movies.");
//        for (Movie movie : movieData) {
//            System.out.print(movie + " ");
//        }
    }
    public void testLoadRaters() {
        ArrayList<Rater> raterData = loadRaters("ratings.csv");
        System.out.println("There are " + raterData.size() + " raters.");
        for (Rater rater : raterData) {
            System.out.print(rater.getID() + " ");
        }
    }

    public static void main(String[] args) {
        FirstRatings inst = new FirstRatings();
//        inst.testLoadMovies();
        inst.testLoadRaters();
    }
}
