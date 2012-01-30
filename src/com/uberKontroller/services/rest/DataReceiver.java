package com.uberKontroller.services.rest;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * Created by IntelliJ IDEA.
 * User: logaras
 * Date: 11/28/11
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataReceiver extends ResultReceiver {
    private Receiver mReceiver;

    public DataReceiver(Handler handler) {
        super(handler);
    }

    public void setReceiver(Receiver receiver) {
        mReceiver = receiver;
    }

    public interface Receiver {
        public void onReceiveResult(int resultCode, Bundle resultData);
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if (mReceiver != null) {
            mReceiver.onReceiveResult(resultCode, resultData);
        }
    }
}
