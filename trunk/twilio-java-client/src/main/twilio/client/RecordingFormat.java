
package twilio.client;

public enum RecordingFormat
{
	
	WAV("audio/x-wav", ".wav"), 
	MP3("audio/mpeg", ".mp3");

	public static final RecordingFormat DEFAULT = WAV;
	
	private String mime;
	private String fileExtension;
	
	RecordingFormat(String mimeType, String fileExt)
	{
		this.mime = mimeType;
		this.fileExtension = fileExt;
	}
	
	public String getMimeType()
	{
		return this.mime;
	}
	
	public String getFileExtension()
	{
		return this.fileExtension;
	}
	
	
}
