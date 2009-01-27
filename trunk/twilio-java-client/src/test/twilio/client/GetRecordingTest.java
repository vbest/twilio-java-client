
package twilio.client;

public class GetRecordingTest extends AbstractTwilioTest
{

	
	public void testGetRecordings() throws Exception
	{
		TwilioClient c = getClient();
	
		Recordings recordings = c.getRecordings(getAccountSid()); 
		
		assertNotNull(recordings);
		
		for (Recording r : recordings)
		{
			byte[] mp3 = c.getRecordingBytes(r, RecordingFormat.MP3);
			
			assertNotNull(mp3);
			
			byte[] wav = c.getRecordingBytes(r, RecordingFormat.WAV);
			
			assertNotNull(wav);
			
		}

	}
	
}
