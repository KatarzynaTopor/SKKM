package iterator;

import base.FireStation;

import java.util.*;
import java.util.List;

public class UnitIterator implements iterator.Iterator<FireStation> {
    private List<FireStation> stations;
    private int position = 0;

    public UnitIterator(List<FireStation> stations) {
        this.stations = stations;
    }

    @Override
    public boolean hasNext() {
        return position < stations.size();
    }

    @Override
    public FireStation next() {
        if (!hasNext()) throw new NoSuchElementException("No more stations.");
        return stations.get(position++);
    }
}
