//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2014.05.28 um 10:14:53 PM CEST 
//


package jaxb_lotterytypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jaxb_lotterytypes package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ValidityDuration_QNAME = new QName("http://www.ti.bfh.ch/euromillions/", "validity_duration");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jaxb_lotterytypes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Play }
     * 
     */
    public Play createPlay() {
        return new Play();
    }

    /**
     * Create an instance of {@link LotteryTicket }
     * 
     */
    public LotteryTicket createLotteryTicket() {
        return new LotteryTicket();
    }

    /**
     * Create an instance of {@link Play.MainNumbers }
     * 
     */
    public Play.MainNumbers createPlayMainNumbers() {
        return new Play.MainNumbers();
    }

    /**
     * Create an instance of {@link Play.StarNumbers }
     * 
     */
    public Play.StarNumbers createPlayStarNumbers() {
        return new Play.StarNumbers();
    }

    /**
     * Create an instance of {@link LotteryTickets }
     * 
     */
    public LotteryTickets createLotteryTickets() {
        return new LotteryTickets();
    }

    /**
     * Create an instance of {@link LotteryTicket.Plays }
     * 
     */
    public LotteryTicket.Plays createLotteryTicketPlays() {
        return new LotteryTicket.Plays();
    }

    /**
     * Create an instance of {@link LotteryTicket.SuperStarNumbers }
     * 
     */
    public LotteryTicket.SuperStarNumbers createLotteryTicketSuperStarNumbers() {
        return new LotteryTicket.SuperStarNumbers();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ti.bfh.ch/euromillions/", name = "validity_duration")
    public JAXBElement<Integer> createValidityDuration(Integer value) {
        return new JAXBElement<Integer>(_ValidityDuration_QNAME, Integer.class, null, value);
    }

}
