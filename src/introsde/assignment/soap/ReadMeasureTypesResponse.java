
package introsde.assignment.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for readMeasureTypesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readMeasureTypesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="measuretypes" type="{http://soap.assignment.introsde/}measureType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readMeasureTypesResponse", propOrder = {
    "measuretypes"
})
public class ReadMeasureTypesResponse {

    protected List<MeasureType> measuretypes;

    /**
     * Gets the value of the measuretypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the measuretypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeasuretypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeasureType }
     * 
     * 
     */
    public List<MeasureType> getMeasuretypes() {
        if (measuretypes == null) {
            measuretypes = new ArrayList<MeasureType>();
        }
        return this.measuretypes;
    }

}
