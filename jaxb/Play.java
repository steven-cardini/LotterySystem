/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

/**
 * Class Play.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Play implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _numbers.
     */
    private Numbers _numbers;

    /**
     * Field _star_numbers.
     */
    private Star_numbers _star_numbers;


      //----------------/
     //- Constructors -/
    //----------------/

    public Play() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'numbers'.
     * 
     * @return the value of field 'Numbers'.
     */
    public Numbers getNumbers(
    ) {
        return this._numbers;
    }

    /**
     * Returns the value of field 'star_numbers'.
     * 
     * @return the value of field 'Star_numbers'.
     */
    public Star_numbers getStar_numbers(
    ) {
        return this._star_numbers;
    }

    /**
     * Sets the value of field 'numbers'.
     * 
     * @param numbers the value of field 'numbers'.
     */
    public void setNumbers(
            final Numbers numbers) {
        this._numbers = numbers;
    }

    /**
     * Sets the value of field 'star_numbers'.
     * 
     * @param star_numbers the value of field 'star_numbers'.
     */
    public void setStar_numbers(
            final Star_numbers star_numbers) {
        this._star_numbers = star_numbers;
    }

}
