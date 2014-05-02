/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

/**
 * Class Numbers.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Numbers implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _numberList.
     */
    private java.util.Vector<java.lang.Integer> _numberList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Numbers() {
        super();
        this._numberList = new java.util.Vector<java.lang.Integer>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vNumber
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addNumber(
            final int vNumber)
    throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this._numberList.size() >= 5) {
            throw new IndexOutOfBoundsException("addNumber has a maximum of 5");
        }

        this._numberList.addElement(new java.lang.Integer(vNumber));
    }

    /**
     * 
     * 
     * @param index
     * @param vNumber
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addNumber(
            final int index,
            final int vNumber)
    throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this._numberList.size() >= 5) {
            throw new IndexOutOfBoundsException("addNumber has a maximum of 5");
        }

        this._numberList.add(index, new java.lang.Integer(vNumber));
    }

    /**
     * Method enumerateNumber.
     * 
     * @return an Enumeration over all int elements
     */
    public java.util.Enumeration<java.lang.Integer> enumerateNumber(
    ) {
        return this._numberList.elements();
    }

    /**
     * Method getNumber.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getNumber(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._numberList.size()) {
            throw new IndexOutOfBoundsException("getNumber: Index value '" + index + "' not in range [0.." + (this._numberList.size() - 1) + "]");
        }

        return ((java.lang.Integer) _numberList.get(index)).intValue();
    }

    /**
     * Method getNumber.Returns the contents of the collection in
     * an Array.  
     * 
     * @return this collection as an Array
     */
    public int[] getNumber(
    ) {
        int size = this._numberList.size();
        int[] array = new int[size];
        java.util.Iterator iter = _numberList.iterator();
        for (int index = 0; index < size; index++) {
            array[index] = ((java.lang.Integer) iter.next()).intValue();
        }
        return array;
    }

    /**
     * Method getNumberCount.
     * 
     * @return the size of this collection
     */
    public int getNumberCount(
    ) {
        return this._numberList.size();
    }

    /**
     */
    public void removeAllNumber(
    ) {
        this._numberList.clear();
    }

    /**
     * Method removeNumber.
     * 
     * @param vNumber
     * @return true if the object was removed from the collection.
     */
    public boolean removeNumber(
            final int vNumber) {
        boolean removed = _numberList.remove(new java.lang.Integer(vNumber));
        return removed;
    }

    /**
     * Method removeNumberAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeNumberAt(
            final int index) {
        java.lang.Object obj = this._numberList.remove(index);
        return ((java.lang.Integer) obj).intValue();
    }

    /**
     * 
     * 
     * @param index
     * @param vNumber
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setNumber(
            final int index,
            final int vNumber)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._numberList.size()) {
            throw new IndexOutOfBoundsException("setNumber: Index value '" + index + "' not in range [0.." + (this._numberList.size() - 1) + "]");
        }

        this._numberList.set(index, new java.lang.Integer(vNumber));
    }

    /**
     * 
     * 
     * @param vNumberArray
     */
    public void setNumber(
            final int[] vNumberArray) {
        //-- copy array
        _numberList.clear();

        for (int i = 0; i < vNumberArray.length; i++) {
                this._numberList.add(new java.lang.Integer(vNumberArray[i]));
        }
    }

}
