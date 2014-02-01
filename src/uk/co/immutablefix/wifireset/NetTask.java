// Copyright 2013 Shaun Simpson shauns2029@gmail.com

package uk.co.immutablefix.wifireset;

import java.net.InetAddress;
import java.net.UnknownHostException;

import android.os.AsyncTask;

public class NetTask extends AsyncTask<String, Integer, String>
{
    @Override
    protected String doInBackground(String... params)
    {
        InetAddress addr = null;
        
        try
        {
            addr = InetAddress.getByName(params[0]);
        }

        catch (UnknownHostException e)
        {
        }

        if (addr != null)
          return addr.getHostAddress();
        else
          return null;
    }
}