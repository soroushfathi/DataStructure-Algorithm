package gengeric;

public class CompareGeneric <T extends Comparable>{
    public Integer compare (T first, T last){
        return first.compareTo(last);
    }
}
