
package twilio.client;

public class DeleteRecordingTest extends AbstractTwilioTest
{

	
	public void testDeleteRecording() throws Exception
	{
		TwilioClient c = getClient();
	
		Recordings recordings = c.getRecordings(); 
		
		assertNotNull(recordings);
		
		for (Recording r : recordings)
		{
			c.deleteRecording(r);
		}

	}
	
}
