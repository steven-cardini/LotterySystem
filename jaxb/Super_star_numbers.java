/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

/**
 * Class Super_star_numbers.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Super_star_numbers implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _super_star_numberList.
     */
    private java.util.Vector<java.lang.String> _super_star_numberList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Super_star_numbers() {
        super();
        this._super_star_numberList = new java.util.Vector<java.lang.String>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSuper_star_number
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSuper_star_number(
            final java.lang.String vSuper_star_number)
    throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this._super_star_numberList.size() >= 4) {
            throw new IndexOutOfBoundsException("addSuper_star_number has a maximum of 4");
        }

        this._super_star_numberList.addElement(vSuper_star_number);
    }

    /**
     * 
     * 
     * @param index
     * @param vSuper_star_number
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSuper_star_number(
            final int index,
            final java.lang.String vSuper_star_number)
    throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this._super_star_numberList.size() >= 4) {
            throw new IndexOutOfBoundsException("addSuper_star_number has a maximum of 4");
        }

        this._super_star_numberList.add(index, vSuper_star_number);
    }

    /**
     * Method enumerateSuper_star_number.
     * 
     * @return an Enumeration over all java.lang.String elements
     */
    public java.util.Enumeration<? extends java.lang.String> enumerateSuper_star_number(
    ) {
        return this._super_star_numberList.elements();
    }

    /**
     * Method getSuper_star_number.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSuper_star_number(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._super_star_numberList.size()) {
            throw new IndexOutOfBoundsException("getSuper_star_number: Index value '" + index + "' not in range [0.." + (this._super_star_numberList.size() - 1) + "]");
        }

        return (java.lang.String) _super_star_numberList.get(index);
    }

    /**
     * Method getSuper_star_number.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSuper_star_number(
    ) {
        java.lang.String[] array = new java.lang.String[0];
        return (java.lang.String[]) this._super_star_numberList.toArray(array);
    }

    /**
     * Method getSuper_star_numberCount.
     * 
     * @return the size of this collection
     */
    public int getSuper_star_numberCount(
    ) {
        return this._super_star_numberList.size();
    }

    /**
     */
    public void removeAllSuper_star_number(
    ) {
        this._super_star_numberList.clear();
    }

    /**
     * Method removeSuper_star_number.
     * 
     * @param vSuper_star_number
     * @return true if the object was removed from the collection.
     */
    public boolean removeSuper_star_number(
            final java.lang.String vSuper_star_number) {
        boolean removed = _super_star_numberList.remove(vSuper_star_number);
        return removed;
    }

    /**
     * Method removeSuper_star_numberAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSuper_star_numberAt(
            final int index) {
        java.lang.Object obj = this._super_star_numberList.remove(index);
        return (java.lang.String) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vSuper_star_number
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSuper_star_number(
            final int index,
            final java.lang.String vSuper_star_number)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._super_star_numberList.size()) {
            throw new IndexOutOfBoundsException("setSuper_star_number: Index value '" + index + "' not in range [0.." + (this._super_star_numberList.size() - 1) + "]");
        }

        this._super_star_numberList.set(index, vSuper_star_number);
    }

    /**
     * 
     * 
     * @param vSuper_star_numberArray
     */
    public void setSuper_star_number(
            final java.lang.String[] vSuper_star_numberArray) {
        //-- copy array
        _super_star_numberList.clear();

        for (int i = 0; i < vSuper_star_numberArray.length; i++) {
                this._super_star_numberList.add(vSuper_star_numberArray[i]);
        }
    }

}
