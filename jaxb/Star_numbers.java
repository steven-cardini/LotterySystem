/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

/**
 * Class Star_numbers.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Star_numbers implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _star_numberList.
     */
    private java.util.Vector<java.lang.Integer> _star_numberList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Star_numbers() {
        super();
        this._star_numberList = new java.util.Vector<java.lang.Integer>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vStar_number
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addStar_number(
            final int vStar_number)
    throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this._star_numberList.size() >= 2) {
            throw new IndexOutOfBoundsException("addStar_number has a maximum of 2");
        }

        this._star_numberList.addElement(new java.lang.Integer(vStar_number));
    }

    /**
     * 
     * 
     * @param index
     * @param vStar_number
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addStar_number(
            final int index,
            final int vStar_number)
    throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this._star_numberList.size() >= 2) {
            throw new IndexOutOfBoundsException("addStar_number has a maximum of 2");
        }

        this._star_numberList.add(index, new java.lang.Integer(vStar_number));
    }

    /**
     * Method enumerateStar_number.
     * 
     * @return an Enumeration over all int elements
     */
    public java.util.Enumeration<java.lang.Integer> enumerateStar_number(
    ) {
        return this._star_numberList.elements();
    }

    /**
     * Method getStar_number.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getStar_number(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._star_numberList.size()) {
            throw new IndexOutOfBoundsException("getStar_number: Index value '" + index + "' not in range [0.." + (this._star_numberList.size() - 1) + "]");
        }

        return ((java.lang.Integer) _star_numberList.get(index)).intValue();
    }

    /**
     * Method getStar_number.Returns the contents of the collection
     * in an Array.  
     * 
     * @return this collection as an Array
     */
    public int[] getStar_number(
    ) {
        int size = this._star_numberList.size();
        int[] array = new int[size];
        java.util.Iterator iter = _star_numberList.iterator();
        for (int index = 0; index < size; index++) {
            array[index] = ((java.lang.Integer) iter.next()).intValue();
        }
        return array;
    }

    /**
     * Method getStar_numberCount.
     * 
     * @return the size of this collection
     */
    public int getStar_numberCount(
    ) {
        return this._star_numberList.size();
    }

    /**
     */
    public void removeAllStar_number(
    ) {
        this._star_numberList.clear();
    }

    /**
     * Method removeStar_number.
     * 
     * @param vStar_number
     * @return true if the object was removed from the collection.
     */
    public boolean removeStar_number(
            final int vStar_number) {
        boolean removed = _star_numberList.remove(new java.lang.Integer(vStar_number));
        return removed;
    }

    /**
     * Method removeStar_numberAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeStar_numberAt(
            final int index) {
        java.lang.Object obj = this._star_numberList.remove(index);
        return ((java.lang.Integer) obj).intValue();
    }

    /**
     * 
     * 
     * @param index
     * @param vStar_number
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setStar_number(
            final int index,
            final int vStar_number)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._star_numberList.size()) {
            throw new IndexOutOfBoundsException("setStar_number: Index value '" + index + "' not in range [0.." + (this._star_numberList.size() - 1) + "]");
        }

        this._star_numberList.set(index, new java.lang.Integer(vStar_number));
    }

    /**
     * 
     * 
     * @param vStar_numberArray
     */
    public void setStar_number(
            final int[] vStar_numberArray) {
        //-- copy array
        _star_numberList.clear();

        for (int i = 0; i < vStar_numberArray.length; i++) {
                this._star_numberList.add(new java.lang.Integer(vStar_numberArray[i]));
        }
    }

}
