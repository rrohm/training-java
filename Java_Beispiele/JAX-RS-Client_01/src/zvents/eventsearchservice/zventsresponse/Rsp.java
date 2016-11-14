//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.05.06 um 07:36:47 AM CEST 
//


package zvents.eventsearchservice.zventsresponse;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="stream_count" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="event" type="{}eventType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="venue" type="{}venueType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="category" type="{}categoryType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="group" type="{}groupType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="user" type="{}userType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="tag" type="{}tagType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="search_info" type="{}searchInfoType" minOccurs="0"/>
 *         &lt;element name="venue_type" type="{}venueTypeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="msg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "streamCount",
    "event",
    "venue",
    "category",
    "group",
    "user",
    "tag",
    "searchInfo",
    "venueType",
    "msg"
})
@XmlRootElement(name = "rsp")
public class Rsp {

    @XmlElement(name = "stream_count")
    protected Integer streamCount;
    protected List<EventType> event;
    protected List<VenueType> venue;
    protected List<CategoryType> category;
    protected List<GroupType> group;
    protected List<UserType> user;
    protected List<TagType> tag;
    @XmlElement(name = "search_info")
    protected SearchInfoType searchInfo;
    @XmlElement(name = "venue_type")
    protected List<VenueTypeType> venueType;
    protected String msg;
    @XmlAttribute(name = "status")
    protected String status;

    /**
     * Ruft den Wert der streamCount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStreamCount() {
        return streamCount;
    }

    /**
     * Legt den Wert der streamCount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStreamCount(Integer value) {
        this.streamCount = value;
    }

    /**
     * Gets the value of the event property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the event property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventType }
     * 
     * 
     */
    public List<EventType> getEvent() {
        if (event == null) {
            event = new ArrayList<EventType>();
        }
        return this.event;
    }

    /**
     * Gets the value of the venue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the venue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVenue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VenueType }
     * 
     * 
     */
    public List<VenueType> getVenue() {
        if (venue == null) {
            venue = new ArrayList<VenueType>();
        }
        return this.venue;
    }

    /**
     * Gets the value of the category property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the category property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CategoryType }
     * 
     * 
     */
    public List<CategoryType> getCategory() {
        if (category == null) {
            category = new ArrayList<CategoryType>();
        }
        return this.category;
    }

    /**
     * Gets the value of the group property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the group property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GroupType }
     * 
     * 
     */
    public List<GroupType> getGroup() {
        if (group == null) {
            group = new ArrayList<GroupType>();
        }
        return this.group;
    }

    /**
     * Gets the value of the user property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the user property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUser().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserType }
     * 
     * 
     */
    public List<UserType> getUser() {
        if (user == null) {
            user = new ArrayList<UserType>();
        }
        return this.user;
    }

    /**
     * Gets the value of the tag property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tag property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTag().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TagType }
     * 
     * 
     */
    public List<TagType> getTag() {
        if (tag == null) {
            tag = new ArrayList<TagType>();
        }
        return this.tag;
    }

    /**
     * Ruft den Wert der searchInfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SearchInfoType }
     *     
     */
    public SearchInfoType getSearchInfo() {
        return searchInfo;
    }

    /**
     * Legt den Wert der searchInfo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchInfoType }
     *     
     */
    public void setSearchInfo(SearchInfoType value) {
        this.searchInfo = value;
    }

    /**
     * Gets the value of the venueType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the venueType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVenueType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VenueTypeType }
     * 
     * 
     */
    public List<VenueTypeType> getVenueType() {
        if (venueType == null) {
            venueType = new ArrayList<VenueTypeType>();
        }
        return this.venueType;
    }

    /**
     * Ruft den Wert der msg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Legt den Wert der msg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsg(String value) {
        this.msg = value;
    }

    /**
     * Ruft den Wert der status-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Legt den Wert der status-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
