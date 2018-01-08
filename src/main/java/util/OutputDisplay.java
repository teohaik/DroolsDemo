package util;

import com.sun.jmx.snmp.Timestamp;

public class OutputDisplay {
	
	public void showText(String someText) {
		long time = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(time);
		System.out.println("[" + timestamp.getDate() + "] " + someText);
	}
	

}
