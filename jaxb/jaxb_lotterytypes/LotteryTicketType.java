//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.17 at 06:33:17 PM CEST 
//


package jaxb_lotterytypes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for lottery_ticket_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lottery_ticket_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.ti.bfh.ch/euromillions/}plays"/>
 *         &lt;element name="super_star_numbers" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="super_star_number" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="4"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="next_drawing_date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element ref="{http://www.ti.bfh.ch/euromillions/}validity_duration"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ticket_id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lottery_ticket_type", propOrder = {
    "plays",
    "superStarNumbers",
    "nextDrawingDate",
    "validityDuration"
})
public class LotteryTicketType {

    @XmlElement(namespace = "http://www.ti.bfh.ch/euromillions/", required = true)
    protected Plays plays;
    @XmlElement(name = "super_star_numbers")
    protected LotteryTicketType.SuperStarNumbers superStarNumbers;
    @XmlElement(name = "next_drawing_date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar nextDrawingDate;
    @XmlElement(name = "validity_duration", namespace = "http://www.ti.bfh.ch/euromillions/")
    protected int validityDuration;
    @XmlAttribute(name = "ticket_id", required = true)
    protected int ticketId;

    /**
     * Gets the value of the plays property.
     * 
     * @return
     *     possible object is
     *     {@link Plays }
     *     
     */
    public Plays getPlays() {
        return plays;
    }

    /**
     * Sets the value of the plays property.
     * 
     * @param value
     *     allowed object is
     *     {@link Plays }
     *     
     */
    public void setPlays(Plays value) {
        this.plays = value;
    }

    /**
     * Gets the value of the superStarNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link LotteryTicketType.SuperStarNumbers }
     *     
     */
    public LotteryTicketType.SuperStarNumbers getSuperStarNumbers() {
        return superStarNumbers;
    }

    /**
     * Sets the value of the superStarNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link LotteryTicketType.SuperStarNumbers }
     *     
     */
    public void setSuperStarNumbers(LotteryTicketType.SuperStarNumbers value) {
        this.superStarNumbers = value;
    }

    /**
     * Gets the value of the nextDrawingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNextDrawingDate() {
        return nextDrawingDate;
    }

    /**
     * Sets the value of the nextDrawingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNextDrawingDate(XMLGregorianCalendar value) {
        this.nextDrawingDate = value;
    }

    /**
     * Gets the value of the validityDuration property.
     * 
     */
    public int getValidityDuration() {
        return validityDuration;
    }

    /**
     * Sets the value of the validityDuration property.
     * 
     */
    public void setValidityDuration(int value) {
        this.validityDuration = value;
    }

    /**
     * Gets the value of the ticketId property.
     * 
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * Sets the value of the ticketId property.
     * 
     */
    public void setTicketId(int value) {
        this.ticketId = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="super_star_number" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="4"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "superStarNumber"
    })
    public static class SuperStarNumbers {

        @XmlElement(name = "super_star_number", required = true)
        protected List<String> superStarNumber;

        /**
         * Gets the value of the superStarNumber property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the superStarNumber property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSuperStarNumber().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getSuperStarNumber() {
            if (superStarNumber == null) {
                superStarNumber = new ArrayList<String>();
            }
            return this.superStarNumber;
        }

    }

}
