package com.uberKontroller.services.websockets;

//import eu.uberdust.communication.rest.RestClient;
//import eu.uberdust.communication.websocket.tasks.PingTask;

import android.util.Log;
import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketClient;
import org.eclipse.jetty.websocket.WebSocketClientFactory;

import java.io.IOException;
import java.net.URI;
import java.util.Timer;

/**
 * Created by IntelliJ IDEA.
 * User: logaras
 * Date: 12/12/11
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class WsClient {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static WsClient ourInstance = null;

    /**
     * Static WebSocket URI.
     */
    private URI WS_URI;

    /**
     * The WebSocketClientFactory.
     */
    private WebSocketClientFactory factory;

    /**
     * The WebSocketClient.
     */
    private WebSocketClient client;

    /**
     * The WebSocket.Connection.
     */
    private WebSocket.Connection connection = null;

    /**
     * The protocol.
     */
    private static final String PROTOCOL = "urn:wisebed:ctitestbed:0x1ccd@urn:wisebed:node:capability:pir";


    private final WebSocketImpl webSocketIMPL = new WebSocketImpl();
    /**
     * The timer.
     */
    private final Timer timer;

    /**
     * WSocketClient is loaded on the first execution of WSocketClient.getInstance()
     * or the first access to WSocketClient.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static WsClient getInstance() {
        synchronized (WsClient.class) {
            if (ourInstance == null) {
                ourInstance = new WsClient();
            }
        }
        return ourInstance;
    }

    /**
     * Private constructor suppresses generation of a (public) default constructor.
     */
    private WsClient() {
        //PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
        Log.i("WS","WSocketClient initialized");
        timer = new Timer();
        connect();
        //timer.scheduleAtFixedRate(new PingTask(timer), PingTask.DELAY, PingTask.DELAY);

    }

    /**
     * Connects to the WebSocket.
     */
    public void connect() {
        try {
            WS_URI = new URI("ws://uberdust.cti.gr:80/lastreading.ws");
            factory = new WebSocketClientFactory();
            factory.setBufferSize(4096);
            factory.start();

            client = factory.newWebSocketClient();
            client.setMaxIdleTime(-1);
            client.setProtocol(PROTOCOL);
            connection = client.open(WS_URI, webSocketIMPL).get();

        } catch (final Exception e) {
           Log.e("WS", e.toString());
            try {
                Thread.sleep(2000);
            } catch (final InterruptedException e1) {
                Log.e("WS", e1.toString());
            }
            connect();
        }
    }

    public void ping() {
        if (!connection.isOpen())
            return;

        try {
            connection.sendMessage("ping");
        } catch (final IOException e) {
            Log.e("WS", e.toString());
        }
    }

    public void disconnect() {
        try {
            connection.disconnect();
            if (factory.isRunning()) {
                factory.destroy();
            }
            factory.stop();
        } catch (final Exception e) {
            Log.e("WS", e.toString());
        }
    }


    public void restPing() {
        Log.i("WS","ping");
        //RestClient.getInstance().callRestfulWebService("http://uberdust.cti.gr/lastreading.ws");
    }
}
