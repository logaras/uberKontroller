package com.uberKontroller.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;
import com.uberKontroller.UberApp;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: logaras
 * Date: 11/28/11
 * Time: 4:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class RestService extends IntentService {

    private ArrayList results;

    public RestService(String name) {
        super(name);
        Log.d(UberApp.TAG, "Service Running");
    }

    public RestService() {
        super("defaultService");
    }

    protected void onHandleIntent(Intent intent) {
        final ResultReceiver receiver = intent.getParcelableExtra("receiver");
        final String restUrl = intent.getExtras().getString("restUrl");

        Log.d(UberApp.TAG, "resturl: " + restUrl);

        final String rawResponse = callRest(restUrl);

        if (rawResponse != null) {
            final Bundle replyBundle = new Bundle();

            replyBundle.putString("rawResponse", callRest(restUrl));
            receiver.send(1, replyBundle);
        } else {
            receiver.send(2, Bundle.EMPTY);
        }
        this.stopSelf();
    }

    private String callRest(final String restUrl) {
        String stringResponse = "";
        Log.d(UberApp.TAG, "URL is " + restUrl);
        HttpClient httpclient = new DefaultHttpClient();

        // Prepare a request object
        HttpGet httpget = new HttpGet(restUrl);

        // Execute the request
        org.apache.http.HttpResponse response;


        try {
            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                InputStream instream = entity.getContent();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(instream));

                stringResponse = reader.readLine();
                Log.d(UberApp.TAG, "Response is" + stringResponse);

            }


        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }
        // Examine the response status
        //Log.i("Praeda",response.getStatusLine().toString());

        return stringResponse;
    }

}

