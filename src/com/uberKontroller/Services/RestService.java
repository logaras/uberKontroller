package com.uberKontroller.Services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;
import com.uberKontroller.Activities.RoomsActivity;
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
        Log.d(RoomsActivity.TAG, "Service Running");
    }

    public RestService() {
        super("defaultService");
    }

    protected void onHandleIntent(Intent intent) {
        final ResultReceiver receiver = intent.getParcelableExtra("receiver");
        String restUrl = intent.getStringExtra("url");
        Bundle b = new Bundle();


        Log.d(RoomsActivity.TAG, "restful: " + restUrl);
        connect(restUrl);
        receiver.send(1, Bundle.EMPTY);


        this.stopSelf();
    }

    private void connect(final String restUrl) {
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

                  Log.d(RoomsActivity.TAG,"Response is" + reader.readLine());

            }


        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        // Examine the response status
                   //Log.i("Praeda",response.getStatusLine().toString());


    }
}

