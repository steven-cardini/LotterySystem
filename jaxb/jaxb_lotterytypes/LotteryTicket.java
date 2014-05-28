//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2014.05.28 um 08:33:07 PM CEST 
//


package jaxb_lotterytypes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="plays">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.ti.bfh.ch/euromillions/}play" maxOccurs="7"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
 *         &lt;element name="ticket_date" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
@XmlType(name = "", propOrder = {
    "plays",
    "superStarNumbers",
    "ticketDate",
    "validityDuration"
})
@XmlRootElement(name = "lottery_ticket")
public class LotteryTicket {

    @XmlElement(required = true)
    protected LotteryTicket.Plays plays;
    @XmlElement(name = "super_star_numbers")
    protected LotteryTicket.SuperStarNumbers superStarNumbers;
    @XmlElement(name = "ticket_date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar ticketDate;
    @XmlElement(name = "validity_duration", namespace = "http://www.ti.bfh.ch/euromillions/")
    protected int validityDuration;
    @XmlAttribute(name = "ticket_id", required = true)
    protected int ticketId;

    /**
     * Ruft den Wert der plays-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LotteryTicket.Plays }
     *     
     */
    public LotteryTicket.Plays getPlays() {
        return plays;
    }

    /**
     * Legt den Wert der plays-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LotteryTicket.Plays }
     *     
     */
    public void setPlays(LotteryTicket.Plays value) {
        this.plays = value;
    }

    /**
     * Ruft den Wert der superStarNumbers-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LotteryTicket.SuperStarNumbers }
     *     
     */
    public LotteryTicket.SuperStarNumbers getSuperStarNumbers() {
        return superStarNumbers;
    }

    /**
     * Legt den Wert der superStarNumbers-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LotteryTicket.SuperStarNumbers }
     *     
     */
    public void setSuperStarNumbers(LotteryTicket.SuperStarNumbers value) {
        this.superStarNumbers = value;
    }

    /**
     * Ruft den Wert der ticketDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTicketDate() {
        return ticketDate;
    }

    /**
     * Legt den Wert der ticketDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTicketDate(XMLGregorianCalendar value) {
        this.ticketDate = value;
    }

    /**
     * Ruft den Wert der validityDuration-Eigenschaft ab.
     * 
     */
    public int getValidityDuration() {
        return validityDuration;
    }

    /**
     * Legt den Wert der validityDuration-Eigenschaft fest.
     * 
     */
    public void setValidityDuration(int value) {
        this.validityDuration = value;
    }

    /**
     * Ruft den Wert der ticketId-Eigenschaft ab.
     * 
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * Legt den Wert der ticketId-Eigenschaft fest.
     * 
     */
    public void setTicketId(int value) {
        this.ticketId = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{http://www.ti.bfh.ch/euromillions/}play" maxOccurs="7"/>
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
        "play"
    })
    public static class Plays {

        @XmlElement(namespace = "http://www.ti.bfh.ch/euromillions/", required = true)
        protected List<Play> play;

        /**
         * Gets the value of the play property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the play property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPlay().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Play }
         * 
         * 
         */
        public List<Play> getPlay() {
            if (play == null) {
                play = new ArrayList<Play>();
            }
            return this.play;
        }

    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
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
