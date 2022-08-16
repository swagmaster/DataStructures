

import java.util.Arrays;

/* 
 * Adam Atienza
 * 
 * ArrayList class follows the same concept of an array but uses objects as its data type.
 * 
 */
public class ArrayList {

	private Object[] listOfObjects = new Object[1];
    private int numElements = 0;
    
    /* 
     * Inserts the object at the given index.
     */
    public void insert(Object other, int index) {
    	//check the conditions of the index 
        if(index > numElements+1)
            throw new RuntimeException("Index out of bounds.");

        if (listOfObjects.length == numElements)
            expand(); //expands the ArrayList of the length is equal to the number of elements in the array
        if(listOfObjects[index] == null) {
            listOfObjects[index] = other;
            numElements++;
        } else {
            shift(index, 'r'); //shifts the array to the right from that inserted index
            listOfObjects[index] = other;
            numElements++;
        }
    }
    
    /*
     * Removes the object from the given index.
     */
    public Object remove(int index) {
        if ((numElements - 1) == 0) {
            numElements--;
            return listOfObjects[index];
        }
        Object retVal = listOfObjects[index];
        shift(index, 'l'); //shifts the array to the left from that removed index
        numElements--;
        return retVal;
    }

    /*
     * Return the size of the ArrayList.
     */
    public int size() {
        return numElements;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < numElements; i++)
                str += listOfObjects[i] + "  ";
        return str;
    }

    /*
     * Checks if the ArrayList is empty.
     */
    public boolean isEmpty() {
        if ((numElements == 0) || (listOfObjects[0] == null))
            return true;
        else
            return false;
    }
    
    /*
     * Checks if another object is equal to another instance of the ArrayList object.
     */
    public boolean equals(Object other) {
        if ((other == null) || !(other instanceof ArrayList))
            return false;

        ArrayList that = (ArrayList) other;
        if (this.size() != that.size()) 
            return false;

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).equals(that.get(i))) //checks if the items of the two objects are exact at the same index
                continue;
            else
                return false;
        }
        return true;
    }

    /*
     * Return the index of item the user is trying to find.
     */
    public int getIndexOf(Object o) {
        for (int i = 0; i < numElements; i++) {
            if (listOfObjects[i].equals(o))
                return i;
        }
        return -1;
    }

    /*
     * Return the actual object/item at the given index of the ArrayList.
     */
    public Object get(int index) {
        return listOfObjects[index];
    }
    
    /*
     * Shifts the array according to whether the ArrayList is removing or inserting an object.
     */
    public void shift(int index, char c) {
        if (c == 'r') {
            for (int i = numElements; i > index; i--)
                listOfObjects[i] = listOfObjects[i - 1];
        }
        if (c == 'l') {
            for (int j = index; j < numElements - 1; j++)
                listOfObjects[j] = listOfObjects[j + 1];
        }
    }
    
    /*
     * Expand the size of the ArrayList and then adding the elements to the newly sized Array.
     */
    private void expand() {
        Object[] box = new Object[listOfObjects.length * 2]; //Double the size of Old listOfObjects.
        for (int i = 0; i < numElements; i++)
            box[i] = listOfObjects[i];

        listOfObjects = box;
    }
}
