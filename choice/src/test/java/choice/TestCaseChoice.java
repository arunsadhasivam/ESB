package choice;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.mule.api.MuleMessage;
//import org.mule.api.client.MuleClient; # not for test case.
import org.mule.module.client.MuleClient;

import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.tck.junit4.rule.DynamicPort;
import org.mule.transport.NullPayload;


public class TestCaseChoice extends FunctionalTestCase
{
	@Rule
	public DynamicPort port = new DynamicPort("http.port");
    
    @Override
    protected String getConfigResources()
    {
        return "choice.xml";
    }
    
    
    @Test
    public void httpGetMethod() throws Exception
    {
        MuleClient client = new MuleClient(muleContext);
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("http.method", "GET");
        
        MuleMessage result = client.send("http://localhost:8081/hello" , "", props);
        assertNotNull(result);
        assertFalse(result.getPayload() instanceof NullPayload);
        assertEquals("Response Method : GET  called!!", result.getPayloadAsString());
        
       
 
    }
    
    
    @Test
    public void httpPUTMethod() throws Exception
    {
        MuleClient client = new MuleClient(muleContext);
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("http.method", "PUT");
        
        MuleMessage result = client.send("http://localhost:8081/hello" , "", props);
        assertEquals("Response Method : PUT  called!!", result.getPayloadAsString());

        
 
    }
    
    @Test
    public void httpNoMethodSet() throws Exception
    {
        MuleClient client = new MuleClient(muleContext);
        Map<String, Object> props = new HashMap<String, Object>();
        props = new HashMap<String, Object>();//default
        
        MuleMessage result = client.send("http://localhost:8081/hello" , "", props);
        result = client.send("http://localhost:8081/hello" , "", props);
        assertEquals("Response Method : POST  called!!", result.getPayloadAsString());
       
 
    }
    
}


