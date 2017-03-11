
package test01.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>queryResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="queryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="studentById" type="{http://service.test01/}student" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryResponse", propOrder = {
    "studentById"
})
public class QueryResponse {

    protected Student studentById;

    /**
     * 获取studentById属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Student }
     *     
     */
    public Student getStudentById() {
        return studentById;
    }

    /**
     * 设置studentById属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Student }
     *     
     */
    public void setStudentById(Student value) {
        this.studentById = value;
    }

}
