/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

/**
 * Class Plays.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Plays implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _playList.
     */
    private java.util.Vector<Play> _playList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Plays() {
        super();
        this._playList = new java.util.Vector<Play>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vPlay
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPlay(
            final Play vPlay)
    throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this._playList.size() >= 7) {
            throw new IndexOutOfBoundsException("addPlay has a maximum of 7");
        }

        this._playList.addElement(vPlay);
    }

    /**
     * 
     * 
     * @param index
     * @param vPlay
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPlay(
            final int index,
            final Play vPlay)
    throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this._playList.size() >= 7) {
            throw new IndexOutOfBoundsException("addPlay has a maximum of 7");
        }

        this._playList.add(index, vPlay);
    }

    /**
     * Method enumeratePlay.
     * 
     * @return an Enumeration over all Play elements
     */
    public java.util.Enumeration<? extends Play> enumeratePlay(
    ) {
        return this._playList.elements();
    }

    /**
     * Method getPlay.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the Play at the given index
     */
    public Play getPlay(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._playList.size()) {
            throw new IndexOutOfBoundsException("getPlay: Index value '" + index + "' not in range [0.." + (this._playList.size() - 1) + "]");
        }

        return (Play) _playList.get(index);
    }

    /**
     * Method getPlay.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public Play[] getPlay(
    ) {
        Play[] array = new Play[0];
        return (Play[]) this._playList.toArray(array);
    }

    /**
     * Method getPlayCount.
     * 
     * @return the size of this collection
     */
    public int getPlayCount(
    ) {
        return this._playList.size();
    }

    /**
     */
    public void removeAllPlay(
    ) {
        this._playList.clear();
    }

    /**
     * Method removePlay.
     * 
     * @param vPlay
     * @return true if the object was removed from the collection.
     */
    public boolean removePlay(
            final Play vPlay) {
        boolean removed = _playList.remove(vPlay);
        return removed;
    }

    /**
     * Method removePlayAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public Play removePlayAt(
            final int index) {
        java.lang.Object obj = this._playList.remove(index);
        return (Play) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vPlay
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPlay(
            final int index,
            final Play vPlay)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._playList.size()) {
            throw new IndexOutOfBoundsException("setPlay: Index value '" + index + "' not in range [0.." + (this._playList.size() - 1) + "]");
        }

        this._playList.set(index, vPlay);
    }

    /**
     * 
     * 
     * @param vPlayArray
     */
    public void setPlay(
            final Play[] vPlayArray) {
        //-- copy array
        _playList.clear();

        for (int i = 0; i < vPlayArray.length; i++) {
                this._playList.add(vPlayArray[i]);
        }
    }

}
