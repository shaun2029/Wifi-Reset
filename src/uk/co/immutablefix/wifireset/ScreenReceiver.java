package uk.co.immutablefix.wifireset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;


public class ScreenReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		if (wm != null) {
			if ((wm.isWifiEnabled()) && (!validHost("www.google.com"))) 
			{
				wm.setWifiEnabled(false);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				wm.setWifiEnabled(true);
			}
		}
	}
	
	private boolean validHost(String url){
        //InetAddress in;
        //in = null;
/*
        try {
        	InetAddress in = InetAddress.getByName("www.google.com");
        	in = InetAddress.getByName(address);
            if (in == null) return false;
        } catch (UnknownHostException e) {
            return false;	        
        }
*/
		
		try
		{
		   String netAddress = new NetTask().execute(url).get();
		   return netAddress != null;
		}
		catch (Exception e1)
		{
	        return false;
	    }
	};	
}