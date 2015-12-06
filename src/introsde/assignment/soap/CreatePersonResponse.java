
package introsde.assignment.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createPersonResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createPersonResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="newPerson" type="{http://soap.assignment.introsde/}Person" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createPersonResponse", propOrder = {
    "newPerson"
})
public class CreatePersonResponse {

    protected Person newPerson;

    /**
     * Gets the value of the newPerson property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getNewPerson() {
        return newPerson;
    }

    /**
     * Sets the value of the newPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setNewPerson(Person value) {
        this.newPerson = value;
    }

}
