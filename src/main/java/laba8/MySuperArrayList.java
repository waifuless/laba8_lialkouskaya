package laba8;

import java.util.ArrayList;
import java.util.Collection;

public class MySuperArrayList extends ArrayList<String> {

    private final int maxSize;

    public MySuperArrayList(){
        this.maxSize = Integer.MAX_VALUE;
    }

    public MySuperArrayList(int maxSize){
        this.maxSize = maxSize;
    }

    public MySuperArrayList(MySuperArrayList list) {
        super(list);
        this.maxSize = list.maxSize;
    }

    int compareInnerObjects(int firstId, int secondId){
        return get(firstId).compareTo(get(secondId));
    }

    @Override
    public boolean add(String s) {
        boolean result = super.add(s);
        if(result && size()>maxSize){
            remove(0);
        }
        return result;
    }

    @Override
    public void add(int index, String element) {
        super.add(index, element);
        if(size()>maxSize){
            remove(0);
        }
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        for (String s : c) {
            add(s);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        int i = 0;
        for (String s : c) {
            add(i+index, s);
            i++;
        }
        return true;
    }
}
