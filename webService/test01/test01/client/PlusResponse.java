
package test01.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>plusResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="plusResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="plusResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "plusResponse", propOrder = {
    "plusResult"
})
public class PlusResponse {

    protected int plusResult;

    /**
     * 获取plusResult属性的值。
     * 
     */
    public int getPlusResult() {
        return plusResult;
    }

    /**
     * 设置plusResult属性的值。
     * 
     */
    public void setPlusResult(int value) {
        this.plusResult = value;
    }

}
