package util;

import java.util.Arrays;

/**
 * A very simple table that stores a list of long.
 */

/*
 * This version is based on the doubling-halving strategy -- a simple array is
 * used, and when more storage is needed, a larger array is obtained
 * and all existing data is recopied into it.
 * 
 * Amortized cost is O(n)
 *
 * License: MIT
 */
public final class LongVector {

    private static final int MINIMUM_SIZE = 16;
   
    /** Array of longs          */
    protected long[] array;
    /** Number of longs in array          */
    protected int size = 0;

    /**
     * Default constructor. Default block size is 16.
     */
    public LongVector() {
        array = new long[MINIMUM_SIZE];
    }

    /**
     * Copy constructor for LongVector
     * 
     * @param v Existing LongVector to copy
     */
    public LongVector(LongVector v) {
        array = v.array.clone();
        size = v.size;
    }

    /**
     * Get the length of the list.
     *
     * @return length of the list
     */
    public final int size() {
        return size;
    }

    private void ensureCapacity(){
        if (size >= array.length)
            array = Arrays.copyOf(array, 2*size);
    }
    
    private void decreaseCapacity(){
        if (size <= array.length/4 && array.length > MINIMUM_SIZE)
            array = Arrays.copyOf(array, Math.max(size/4, MINIMUM_SIZE));
    }
    
    /**
     * Append a long onto the vector.
     *
     * @param value long to add to the list 
     */
    public final void addElement(long value) {
        size++;
        ensureCapacity();
        array[size] = value;
    }

    /**
     * Append several long values onto the vector.
     *
     * @param values longs to add to the list 
     */
    public final void addElements(long[] values) {
        int offset = size;
        size += values.length;
        ensureCapacity();
        System.arraycopy(values, 0, array, offset, values.length);
    }

    /**
     * Inserts the specified node in this vector at the specified index.
     * Each component in this vector with an index greater or equal to
     * the specified index is shifted downward to have an index one greater
     * than the value it had previously.
     * 
     * This method is designed to insert in between the current values
     * stored. To append a value to the tail of the vector, use addElement.
     * @param value long to insert
     * @param i Index of where to insert 
     */
    public final void insertElementAt(long value, int i) {
        if (i >= size || i < 0)
            throw new ArrayIndexOutOfBoundsException();
        
        size += 1;
        ensureCapacity();
        
        //shift other elements downward.
        System.arraycopy(array, i, array, i+1, size-i);
        
        array[i] = value;
    }

    /**
     * Removes all elements from the array.
     */
    public final void removeAllElements() {
        size = 0;
    }

    /**
     * Removes the first occurrence of the argument from this vector.
     * If the object is found in this vector, each component in the vector
     * with an index greater or equal to the object's index is shifted
     * upward to have an index one smaller than the value it had
     * previously.
     *
     * @param s long to remove from array
     *
     * @return True if the long was removed, false if it was not found
     */
    public final boolean removeElement(long s) {
        int index = indexOf(s);
        if (index != -1)
        {
            removeElementAt(index);
            return true;
        }
        
        return false;
    }

    /**
     * Deletes the component at the specified index. Each component in
     * this vector with an index greater or equal to the specified
     * index is shifted upward to have an index one smaller than
     * the value it had previously.
     *
     * @param i index of where to remove a long
     */
    public final void removeElementAt(int i) {

        if (i >= size || i < 0)
            throw new ArrayIndexOutOfBoundsException();
        
        if (i < size-1 ){
            //shift the end of the array up
            removeRange(i,i+1);
        } else{  //i is last element
            size--;
            decreaseCapacity();
        }
    }
    
    public final void removeRange(int fromIndex, int toIndex){
        if (fromIndex < 0 || fromIndex > size)
            throw new ArrayIndexOutOfBoundsException("fromIndex out of bounds");
        
        if (toIndex < 0 || toIndex > size)
            throw new ArrayIndexOutOfBoundsException("toIndex out of bounds");
        
        if (fromIndex < toIndex)
            throw new IllegalArgumentException("fromIndex must be less than toIndex");
        
        System.arraycopy(array, toIndex, array, fromIndex, size - toIndex);
        size -= toIndex - fromIndex;
        decreaseCapacity();
        
    }

    /**
     * Sets the component at the specified index of this vector to be the
     * specified object. The previous component at that position is discarded.
     *
     * The index must be a value greater than or equal to 0 and less
     * than the current size of the vector.
     *
     * @param value object to set
     * @param index Index of where to set the object
     */
    public final void setElementAt(long value, int index) {
        array[index] = value;
    }

    /**
     * Get the nth element.
     *
     * @param i index of object to get
     *
     * @return object at given index
     */
    public final long elementAt(int i) {
        return array[i];
    }

    /**
     * Tell if the table contains the given long.
     *
     * @param s long to look for
     *
     * @return true if the long is in the list
     */
    public final boolean contains(long s) {
        return indexOf(s) != -1;
    }

    /**
     * Searches for the first occurence of the given argument,
     * beginning the search at index, and testing for equality
     * using the equal sign.
     *
     * @param elem long to look for
     * @param index Index of where to begin search
     * @return the index of the first occurrence of the long
     * argument in this vector at position index or later in the
     * vector; returns -1 if the object is not found.
     */
    public final int indexOf(long elem, int index) {

        for (int i = index; i < size; i++) {
            if (array[i] == elem) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Searches for the first occurence of the given argument,
     * beginning the search at index 0, and testing for equality
     * using the equal sign.
     *
     * @param elem long to look for
     * @return the index of the first occurrence of the long
     * argument in this vector at position index or later in the
     * vector; returns -1 if the object is not found.
     */
    public final int indexOf(long elem) {
        return indexOf(elem,0);
    }

    /**
     * Searches for the last occurence of the given argument,
     * beginning the search at the tail, and testing for equality
     * using the equal sign.
     *
     * @param elem long to look for
     * @return the index of the first occurrence of the object
     * argument in this vector at position index or later in the
     * vector; returns -1 if the object is not found.
     */
    public final int lastIndexOf(long elem) {

        for (int i = (size - 1); i >= 0; i--) {
            if (array[i] == elem) {
                return i;
            }
        }

        return -1;
    }
    
    /**
     * Tests if this vector is empty.
     *
     * @return  <code>true</code> if this vector is empty;
     *          <code>false</code> otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the array.
     *
     * @return Returns a deep copy of the array.
     */
    public long[] array(){
        long[] out = new long[size];
        System.arraycopy(array, 0, out, 0, size);
        return out;
    }

}