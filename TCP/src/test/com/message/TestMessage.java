package muleproject;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

import com.mulesoft.mmc.agent.v3.dto.NullPayload;

public class TestMessage  extends FunctionalTestCase{

	
	protected String getConfigResources()
    {
        return "mule-config.xml";
    }

    @Test
    public void tcpTest() throws Exception
    {
        MuleClient client = muleContext.getClient();
        MuleMessage result = client.send("tcpendpoint", new DataObject(1234), null);

        assertNotNull(result);
        assertNull(result.getExceptionPayload());
        assertFalse(result.getPayload() instanceof NullPayload);

        // Assert that the expected payload has been received.
        assertTrue(result.getPayload() instanceof DataObject);

        DataObject dataObject = (DataObject) result.getPayload();

        // Assert id returned as expected (note: Echo increments id by 1)
        assertEquals(1235, (int)dataObject.getId());
    }
}
