
package test01.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IMyService", targetNamespace = "http://service.test01/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IMyService {


    /**
     * 
     * @param id
     * @return
     *     returns test01.client.Student
     */
    @WebMethod
    @WebResult(name = "studentById", targetNamespace = "")
    @RequestWrapper(localName = "query", targetNamespace = "http://service.test01/", className = "test01.client.Query")
    @ResponseWrapper(localName = "queryResponse", targetNamespace = "http://service.test01/", className = "test01.client.QueryResponse")
    public Student query(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "plusResult", targetNamespace = "")
    @RequestWrapper(localName = "plus", targetNamespace = "http://service.test01/", className = "test01.client.Plus")
    @ResponseWrapper(localName = "plusResponse", targetNamespace = "http://service.test01/", className = "test01.client.PlusResponse")
    public int plus(
        @WebParam(name = "a", targetNamespace = "")
        int a,
        @WebParam(name = "b", targetNamespace = "")
        int b);

    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "minusResult", targetNamespace = "")
    @RequestWrapper(localName = "minus", targetNamespace = "http://service.test01/", className = "test01.client.Minus")
    @ResponseWrapper(localName = "minusResponse", targetNamespace = "http://service.test01/", className = "test01.client.MinusResponse")
    public int minus(
        @WebParam(name = "a", targetNamespace = "")
        int a,
        @WebParam(name = "b", targetNamespace = "")
        int b);

}
