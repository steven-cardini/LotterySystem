//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2014.05.28 um 10:14:53 PM CEST 
//


package jaxb_lotterytypes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="main_numbers">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="main_number" maxOccurs="5" minOccurs="5">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                         &lt;minInclusive value="1"/>
 *                         &lt;maxInclusive value="50"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="star_numbers">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="star_number" maxOccurs="2" minOccurs="2">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                         &lt;minInclusive value="1"/>
 *                         &lt;maxInclusive value="11"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "mainNumbers",
    "starNumbers"
})
@XmlRootElement(name = "play")
public class Play {

    @XmlElement(name = "main_numbers", required = true)
    protected Play.MainNumbers mainNumbers;
    @XmlElement(name = "star_numbers", required = true)
    protected Play.StarNumbers starNumbers;

    /**
     * Ruft den Wert der mainNumbers-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Play.MainNumbers }
     *     
     */
    public Play.MainNumbers getMainNumbers() {
        return mainNumbers;
    }

    /**
     * Legt den Wert der mainNumbers-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Play.MainNumbers }
     *     
     */
    public void setMainNumbers(Play.MainNumbers value) {
        this.mainNumbers = value;
    }

    /**
     * Ruft den Wert der starNumbers-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Play.StarNumbers }
     *     
     */
    public Play.StarNumbers getStarNumbers() {
        return starNumbers;
    }

    /**
     * Legt den Wert der starNumbers-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Play.StarNumbers }
     *     
     */
    public void setStarNumbers(Play.StarNumbers value) {
        this.starNumbers = value;
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
     *         &lt;element name="main_number" maxOccurs="5" minOccurs="5">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *               &lt;minInclusive value="1"/>
     *               &lt;maxInclusive value="50"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
        "mainNumber"
    })
    public static class MainNumbers {

        @XmlElement(name = "main_number", type = Integer.class)
        protected List<Integer> mainNumber;

        /**
         * Gets the value of the mainNumber property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mainNumber property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMainNumber().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Integer }
         * 
         * 
         */
        public List<Integer> getMainNumber() {
            if (mainNumber == null) {
                mainNumber = new ArrayList<Integer>();
            }
            return this.mainNumber;
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
     *         &lt;element name="star_number" maxOccurs="2" minOccurs="2">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *               &lt;minInclusive value="1"/>
     *               &lt;maxInclusive value="11"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
        "starNumber"
    })
    public static class StarNumbers {

        @XmlElement(name = "star_number", type = Integer.class)
        protected List<Integer> starNumber;

        /**
         * Gets the value of the starNumber property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the starNumber property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStarNumber().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Integer }
         * 
         * 
         */
        public List<Integer> getStarNumber() {
            if (starNumber == null) {
                starNumber = new ArrayList<Integer>();
            }
            return this.starNumber;
        }

    }

}
