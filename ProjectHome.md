Java library for [Twilio](http://www.twilio.com)'s REST API

## Example: make a call ##


```

   import twilio.client.*;

   TwilioClient c = new TwilioClient("account123", "foo");
		
   Call call = c.call("503-111-2222", "503-222-3333");

   System.out.println(call);

```


## Example: send text message (SMS) ##


```

   import twilio.client.*;

   TwilioClient c = new TwilioClient("account123", "foo");
		
   c.sendSMSMessage("503-111-2222", "503-222-3333", "Hello world");


```


## Example: list calls ##


```

   import twilio.client.*;

   TwilioClient c = new TwilioClient("account123", "foo");
		
   Calls calls = c.getCalls();

   for (Call call : calls)
   {
       System.out.println(call);
   }

```


## Example: get incoming phone numbers ##

```

   import twilio.client.*;

   TwilioClient c = new TwilioClient("account123", "foo");
		
   IncomingPhoneNumbers phoneNumbers = c.getIncomingPhoneNumbers(); 

   for (IncomingPhoneNumber phoneNum : phoneNumbers)
   {
       System.out.println(phoneNum);
   }

```

## Example: get outgoing caller ids ##

```

   import twilio.client.*;

   TwilioClient c = new TwilioClient("account123", "foo");
		
   OutgoingCallerIds callerIds = c.getOutgoingCallerIds(); 

   for (OutgoingCallerIds callerId : callerIds)
   {
       System.out.println(callerId);
   }

```


## Example: get account information ##

```

   import twilio.client.*;

   TwilioClient c = new TwilioClient("account123", "foo");
		
   Account account = c.getAccount(); 

   System.out.println(account);

```


## Example: get recordings ##

```

   import twilio.client.*;

   TwilioClient c = new TwilioClient("account123", "foo");
		
   Recordings recordings = c.getRecordings(); 

   for (Recording r : recordings)
   {
      System.out.println(r);
   }

```


## Example: get recording audio ##

```

   import twilio.client.*;

   TwilioClient c = new TwilioClient("account123", "foo");
		
   Recordings recordings = c.getRecordings(); 

   for (Recording r : recordings)
   {
      byte[] audio = c.getRecordingBytes(r, RecordingFormat.MP3);
   }

```

## Example:   Twilio markup ##

```

   import twilio.markup.*;

   Say say = new Say("What is your name?");

   Record record = new Record();
   record.setTimeout(10);
   record.setFinishOnKey('#');
   record.setMaxLength(60);

   Response response = new Response();

   response.add(say);
   response.add(record);

   String xml = response.toXml();

```


## Example:   Twilio servlet ##

```

   import twilio.servlet.*;

   public class MyTwilioServlet extends TwilioServlet
   {
        @Override
	protected void onInboundCall(TwilioRequest req, String caller, String called)
	{
		pause(1);
		say("Hello world");
		pause(1);
		hangup();
	}
   }

```
