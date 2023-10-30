package lego.v1;

import java.util.Comparator;

public class LegoSetComparator
        implements Comparator<LegoSet> {

    @Override
    public int compare(LegoSet o1, LegoSet o2) {
        return o1.getTheme().compareTo(o2.getTheme());
    }
}
