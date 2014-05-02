/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

/**
 * Class Lottery_tickets_type.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Lottery_tickets_type implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _lottery_ticketList.
     */
    private java.util.Vector<Lottery_ticket> _lottery_ticketList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Lottery_tickets_type() {
        super();
        this._lottery_ticketList = new java.util.Vector<Lottery_ticket>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vLottery_ticket
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLottery_ticket(
            final Lottery_ticket vLottery_ticket)
    throws java.lang.IndexOutOfBoundsException {
        this._lottery_ticketList.addElement(vLottery_ticket);
    }

    /**
     * 
     * 
     * @param index
     * @param vLottery_ticket
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLottery_ticket(
            final int index,
            final Lottery_ticket vLottery_ticket)
    throws java.lang.IndexOutOfBoundsException {
        this._lottery_ticketList.add(index, vLottery_ticket);
    }

    /**
     * Method enumerateLottery_ticket.
     * 
     * @return an Enumeration over all Lottery_ticket elements
     */
    public java.util.Enumeration<? extends Lottery_ticket> enumerateLottery_ticket(
    ) {
        return this._lottery_ticketList.elements();
    }

    /**
     * Method getLottery_ticket.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the Lottery_ticket at the given index
     */
    public Lottery_ticket getLottery_ticket(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._lottery_ticketList.size()) {
            throw new IndexOutOfBoundsException("getLottery_ticket: Index value '" + index + "' not in range [0.." + (this._lottery_ticketList.size() - 1) + "]");
        }

        return (Lottery_ticket) _lottery_ticketList.get(index);
    }

    /**
     * Method getLottery_ticket.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public Lottery_ticket[] getLottery_ticket(
    ) {
        Lottery_ticket[] array = new Lottery_ticket[0];
        return (Lottery_ticket[]) this._lottery_ticketList.toArray(array);
    }

    /**
     * Method getLottery_ticketCount.
     * 
     * @return the size of this collection
     */
    public int getLottery_ticketCount(
    ) {
        return this._lottery_ticketList.size();
    }

    /**
     */
    public void removeAllLottery_ticket(
    ) {
        this._lottery_ticketList.clear();
    }

    /**
     * Method removeLottery_ticket.
     * 
     * @param vLottery_ticket
     * @return true if the object was removed from the collection.
     */
    public boolean removeLottery_ticket(
            final Lottery_ticket vLottery_ticket) {
        boolean removed = _lottery_ticketList.remove(vLottery_ticket);
        return removed;
    }

    /**
     * Method removeLottery_ticketAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public Lottery_ticket removeLottery_ticketAt(
            final int index) {
        java.lang.Object obj = this._lottery_ticketList.remove(index);
        return (Lottery_ticket) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vLottery_ticket
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setLottery_ticket(
            final int index,
            final Lottery_ticket vLottery_ticket)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._lottery_ticketList.size()) {
            throw new IndexOutOfBoundsException("setLottery_ticket: Index value '" + index + "' not in range [0.." + (this._lottery_ticketList.size() - 1) + "]");
        }

        this._lottery_ticketList.set(index, vLottery_ticket);
    }

    /**
     * 
     * 
     * @param vLottery_ticketArray
     */
    public void setLottery_ticket(
            final Lottery_ticket[] vLottery_ticketArray) {
        //-- copy array
        _lottery_ticketList.clear();

        for (int i = 0; i < vLottery_ticketArray.length; i++) {
                this._lottery_ticketList.add(vLottery_ticketArray[i]);
        }
    }

}
