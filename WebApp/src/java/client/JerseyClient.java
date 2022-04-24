/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        JerseyClient client = new JerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Vishal
 */
public class JerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/WebApp/webresources";

    public JerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

    public <T> T getallemp(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getallemp");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String addemp(String empname, String deptid, String gender, String email) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addemp/{0}/{1}/{2}/{3}", new Object[]{empname, deptid, gender, email})).request().post(null, String.class);
    }

    public String deleteemp(String empid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteemp/{0}", new Object[]{empid})).request().post(null, String.class);
    }

    public <T> T getalldept(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getalldept");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String updateemp(String empid, String empname, String deptid, String gender, String email) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateemp/{0}/{1}/{2}/{3}/{4}", new Object[]{empid, empname, deptid, gender, email})).request().post(null, String.class);
    }

    public void close() {
        client.close();
    }
    
}
