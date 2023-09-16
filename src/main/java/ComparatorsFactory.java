import ChristmasDecorType.ChristmasDecor;

import java.util.Comparator;

// factory to create simple Comparators and merge to complex
public class ComparatorsFactory {

    private static class DecorNameComparator implements Comparator<ChristmasDecor>{
        @Override
        public int compare(ChristmasDecor o1, ChristmasDecor o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static Comparator<ChristmasDecor> byName(){
        return new DecorNameComparator();
    }

    public static Comparator<ChristmasDecor> byPrice(){
        return (o1, o2) -> Float.compare(o1.getPrice(), o2.getPrice());
    }

    public static Comparator<ChristmasDecor> byLocation(){
        return new Comparator<ChristmasDecor>() {
            @Override
            public int compare(ChristmasDecor o1, ChristmasDecor o2) {
                return o1.getLocation().getLocationName().
                        compareTo(o2.getLocation().getLocationName());
            }
        };
    }

    public static Comparator<ChristmasDecor> byDecorType(){
        return Comparator.comparing(o -> o.getType().getTypeName());
    }
    public static Comparator<ChristmasDecor> byTwoComparators
            (Comparator<ChristmasDecor> a,Comparator<ChristmasDecor> b) {
        return a.thenComparing(b);
    }

}