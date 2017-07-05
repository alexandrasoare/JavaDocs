package exercise.exercise4;

import java.util.Iterator;

/**
 * Created by Alexandra.Soare on 7/5/2017.
 */
public class MyIterator implements Iterator {
    MyImplementedList elem;
    int index;

    MyIterator(MyImplementedList m, int index) {
        elem = m;
        this.index = index;
    }

    public boolean hasNext() {
        if(index < elem.size() - 1)
            return true;
        return false;
    }

    public Object next() {
        return elem.get(index++);
    }

    public void remove() {
        elem.remove(index);
        index--;
    }

}
