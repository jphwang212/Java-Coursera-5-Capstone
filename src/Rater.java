
/**
 * Write a description of class Rater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Rater {
    private String myID;
    private ArrayList<Rating> myRatings;
//    private int myHash;

    public Rater(String id) {
        myID = id;
//        myHash = hashCode();
        myRatings = new ArrayList<Rating>();
    }

    public void addRating(String item, double rating) {
        myRatings.add(new Rating(item,rating));
    }

    public boolean hasRating(String item) {
        for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getItem().equals(item)){
                return true;
            }
        }
        
        return false;
    }

    public String getID() {
        return myID;
    }

    public double getRating(String item) {
        for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getItem().equals(item)){
                return myRatings.get(k).getValue();
            }
        }
        
        return -1;
    }

    public int numRatings() {
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
        for(int k=0; k < myRatings.size(); k++){
            list.add(myRatings.get(k).getItem());
        }
        
        return list;
    }

//    public int length() {
//        return myRatings.size();
//    }
//    public int hashCode() {
//        String rater = this.toString();
//        return rater.hashCode();
//    }
//    public boolean equals(Object o) {
//        Rater rater = (Rater) o;
//        if (this.length() != rater.length()) {
//            return false;
//        }
//        for (int i = 0; i < myRatings.size(); i++) {
//            String rating = myRatings.get(i).toString();
//            if (!rating.equals(rater.getID())) {
//                return false;
//            }
//        }
//        return true;
//    }
    public String toString() {
        return myID;
    }
}
