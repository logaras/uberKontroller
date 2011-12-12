package com.uberKontroller.services.websockets;

import android.util.Log;
import org.eclipse.jetty.websocket.WebSocket;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: logaras
 * Date: 12/12/11
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class WebSocketImpl implements WebSocket.OnTextMessage {

    /**
     * Called with a complete text message when all fragments have been received.
     * The maximum size of text message that may be aggregated from multiple
     * frames is set with {@link org.eclipse.jetty.websocket.WebSocket.Connection#setMaxTextMessageSize(int)}.
     *
     * @param data The message
     */

    public final void onMessage(final String data) {
        if (data.isEmpty()) {
            return;
        }
        //UberLogger.getInstance().log(Long.valueOf(data.split("\t")[0]), "T6");
        //System.out.println(Long.valueOf(data.split("\t")[0]));
        Log.i("WS", new StringBuilder().append("-- onMessage: ").append(data).append(new Date()).toString());
        //LightController.getInstance().setLastReading(System.currentTimeMillis());
        //LightController.getInstance().setLastReading(Long.valueOf(data.split("\t")[0]));
        Log.i("WS", new StringBuilder().append("-- finished : ").append(new Date()).toString());
    }

    /**
     * Called when a new websocket connection is accepted.
     *
     * @param connection The Connection object to use to send messages.
     */

    public final void onOpen(final Connection connection) {
        Log.i("WS", "onOpen");
    }

    /**
     * Called when an established websocket connection closes.
     *
     * @param closeCode the Close Code
     * @param message   the Message
     */

    public final void onClose(final int closeCode, final String message) {
        Log.i("WS", "onClose");
        WsClient.getInstance().disconnect();
        WsClient.getInstance().restPing();
        WsClient.getInstance().connect();
    }
}
