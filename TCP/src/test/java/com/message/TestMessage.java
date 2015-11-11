package com.message;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

import com.mulesoft.mmc.agent.v3.dto.NullPayload;

public class TestMessage  extends FunctionalTestCase{

	
	protected String getConfigResources()
    {
        return "http.xml";
    }

    @Test
    public void tcpTest() throws Exception
    {
        MuleClient client = muleContext.getClient();
        String result = "mule";
       // MuleMessage message = client.send("tcp://localhost:4444", result, null);
        MuleMessage message = client.send("TCPEndPoint", result, null);

        assertNotNull(message);
        assertNull(message.getExceptionPayload());
        assertFalse(message.getPayload() instanceof NullPayload);

        // Assert that the expected payload has been received.
        assertTrue(message.getPayload() instanceof Message);

        Message finalResult = (Message) message.getPayload();

        // Assert id returned as expected (note: Echo increments id by 1)
        assertEquals("hello:"+result, finalResult.getResult());
    }
}
