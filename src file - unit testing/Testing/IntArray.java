package Testing;

import java.util.ArrayList;
import java.util.List;

public class IntArray implements IIntArray {

    private List<Integer> array;

    public IntArray(int[] values) {
        array = new ArrayList<Integer>();
        for (int i = 0; i < values.length; i++) {
            array.add(values[i]);
        }
    }

    public double getAverage() {
        if (array.size() == 2) {
            return (double) (array.get(0) + array.get(1)) / 2;
        }
        double sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        return sum / array.size();
    }

    public int[] findPositions(int val) {
        List<Integer> positions = new ArrayList<Integer>();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == val) {
                positions.add(i);
            }
        }
        int[] result = new int[positions.size()];
        for (int i = 0; i < positions.size(); i++) {
            result[i] = positions.get(i);
        }
        return result;
    }

    public void appendLast(int value) {
        array.add(value);
    }

    public void insertAt(int pos, int value) {
        if (pos < 0 || pos > array.size()) {
            throw new IndexOutOfBoundsException();
        }
        if (pos == array.size()) {
            array.add(value);
        } else {
            array.add(pos, value);
        }
    }

    public int getAt(int pos) {
        if (pos < 0 || pos >= array.size()) {
            throw new IndexOutOfBoundsException();
        }
        return array.get(pos);
    }

    public void setAt(int pos, int element) {
        if (pos < 0 || pos >= array.size()) {
            throw new IndexOutOfBoundsException();
        }
        array.set(pos, element);
    }

    public int deleteAt(int pos) {
        if (array.isEmpty() || pos < 0 || pos >= array.size()) {
            throw new IndexOutOfBoundsException();
        }
        int deleted = array.get(pos);
        array.remove(pos);
        return deleted;
    }
}
