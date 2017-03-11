
package com.cmr.client.wsimport;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "FirstServiceService", targetNamespace = "http://server.cmr.com/", wsdlLocation = "http://localhost:9876/hello?wsdl")
public class FirstServiceService
    extends Service
{

    private final static URL FIRSTSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException FIRSTSERVICESERVICE_EXCEPTION;
    private final static QName FIRSTSERVICESERVICE_QNAME = new QName("http://server.cmr.com/", "FirstServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9876/hello?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FIRSTSERVICESERVICE_WSDL_LOCATION = url;
        FIRSTSERVICESERVICE_EXCEPTION = e;
    }

    public FirstServiceService() {
        super(__getWsdlLocation(), FIRSTSERVICESERVICE_QNAME);
    }

    public FirstServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FIRSTSERVICESERVICE_QNAME);
    }

    public FirstServiceService(URL wsdlLocation) {
        super(wsdlLocation, FIRSTSERVICESERVICE_QNAME);
    }

    public FirstServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FIRSTSERVICESERVICE_QNAME);
    }

    public FirstServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FirstServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns FirstService
     */
    @WebEndpoint(name = "FirstServicePort")
    public FirstService getFirstServicePort() {
        return super.getPort(new QName("http://server.cmr.com/", "FirstServicePort"), FirstService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FirstService
     */
    @WebEndpoint(name = "FirstServicePort")
    public FirstService getFirstServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server.cmr.com/", "FirstServicePort"), FirstService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FIRSTSERVICESERVICE_EXCEPTION!= null) {
            throw FIRSTSERVICESERVICE_EXCEPTION;
        }
        return FIRSTSERVICESERVICE_WSDL_LOCATION;
    }

}
