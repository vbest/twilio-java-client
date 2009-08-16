
package twilio.client;

public class GetRecordingTest extends AbstractTwilioTest
{

	
	public void testGetRecordings() throws Exception
	{
		TwilioClient c = getClient();
	
		Recordings recordings = c.getRecordings(); 
		
		assertNotNull(recordings);
		
		for (Recording r : recordings)
		{
			assertNotNull(r.getMp3Url());
			
			byte[] mp3 = c.getRecordingBytes(r, RecordingFormat.MP3);
			
			assertNotNull(mp3);
		
			assertTrue(mp3.length > 0);
			
			byte[] wav = c.getRecordingBytes(r, RecordingFormat.WAV);
			
			assertNotNull(wav);
			assertTrue(wav.length > 0);
			
		}

	}
	
}
