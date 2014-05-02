/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

/**
 * Class Lottery_ticket_type.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Lottery_ticket_type implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ticket_id.
     */
    private int _ticket_id;

    /**
     * keeps track of state for field: _ticket_id
     */
    private boolean _has_ticket_id;

    /**
     * Field _plays.
     */
    private Plays _plays;

    /**
     * Field _super_star_numbers.
     */
    private Super_star_numbers _super_star_numbers;

    /**
     * Field _next_draw_date.
     */
    private org.exolab.castor.types.Date _next_draw_date;

    /**
     * Field _validity.
     */
    private types.ValidityType _validity;


      //----------------/
     //- Constructors -/
    //----------------/

    public Lottery_ticket_type() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteTicket_id(
    ) {
        this._has_ticket_id= false;
    }

    /**
     * Returns the value of field 'next_draw_date'.
     * 
     * @return the value of field 'Next_draw_date'.
     */
    public org.exolab.castor.types.Date getNext_draw_date(
    ) {
        return this._next_draw_date;
    }

    /**
     * Returns the value of field 'plays'.
     * 
     * @return the value of field 'Plays'.
     */
    public Plays getPlays(
    ) {
        return this._plays;
    }

    /**
     * Returns the value of field 'super_star_numbers'.
     * 
     * @return the value of field 'Super_star_numbers'.
     */
    public Super_star_numbers getSuper_star_numbers(
    ) {
        return this._super_star_numbers;
    }

    /**
     * Returns the value of field 'ticket_id'.
     * 
     * @return the value of field 'Ticket_id'.
     */
    public int getTicket_id(
    ) {
        return this._ticket_id;
    }

    /**
     * Returns the value of field 'validity'.
     * 
     * @return the value of field 'Validity'.
     */
    public types.ValidityType getValidity(
    ) {
        return this._validity;
    }

    /**
     * Method hasTicket_id.
     * 
     * @return true if at least one Ticket_id has been added
     */
    public boolean hasTicket_id(
    ) {
        return this._has_ticket_id;
    }

    /**
     * Sets the value of field 'next_draw_date'.
     * 
     * @param next_draw_date the value of field 'next_draw_date'.
     */
    public void setNext_draw_date(
            final org.exolab.castor.types.Date next_draw_date) {
        this._next_draw_date = next_draw_date;
    }

    /**
     * Sets the value of field 'plays'.
     * 
     * @param plays the value of field 'plays'.
     */
    public void setPlays(
            final Plays plays) {
        this._plays = plays;
    }

    /**
     * Sets the value of field 'super_star_numbers'.
     * 
     * @param super_star_numbers the value of field
     * 'super_star_numbers'.
     */
    public void setSuper_star_numbers(
            final Super_star_numbers super_star_numbers) {
        this._super_star_numbers = super_star_numbers;
    }

    /**
     * Sets the value of field 'ticket_id'.
     * 
     * @param ticket_id the value of field 'ticket_id'.
     */
    public void setTicket_id(
            final int ticket_id) {
        this._ticket_id = ticket_id;
        this._has_ticket_id = true;
    }

    /**
     * Sets the value of field 'validity'.
     * 
     * @param validity the value of field 'validity'.
     */
    public void setValidity(
            final types.ValidityType validity) {
        this._validity = validity;
    }

}
