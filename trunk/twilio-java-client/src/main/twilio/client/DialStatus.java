
package twilio.client;

public class DialStatus
{
	// todo
	
	/*
	 
DialStatus

Twilio sends a DialStatus parameter to your application, indicating the result of your new call. This parameter will be appended to the URL for a GET request, or added to the POST fields. Possible values are:
answered: The call has been answered and IfMachine was not specified. (See the answering machines section below for more info)
answered-human: The call has been answered by a human and IfMachine was Hangup or Continue. (See the answering machines section below for more info)
answered-machine: The call has been answered by a machine and IfMachine was Continue. (See the answering machines section below for more info)
hangup-machine: The call has been answered by a machine and IfMachine was Hangup. (See the answering machines section below for more info)
busy: The phone number was busy, and was not anwered. No retries will be made.
no-answer: The phone number was not picked up after ringing for Timeout seconds (defaults to 60 seconds). No retries will be made.
fail: An intermittent error has occurred, and Twilio was unable to complete the call. No retries will be made.	 
	 
	 */
}
