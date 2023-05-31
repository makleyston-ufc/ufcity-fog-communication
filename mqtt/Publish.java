package ufcitycore.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.logging.Logger;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.time.LocalDateTime.now;
import static ufcitycore.mqtt.ConnectionData.PREFIX;
import static ufcitycore.mqtt.ConnectionData.PUB;

public class Publish extends ConnectionDefault{

    public Publish(ConnectionConfig connectionConfig){
        super(connectionConfig);
    }

    public void publish(String message) {
        String clientId = PREFIX+PUB+now();
        try {
            System.out.println("PUB# Sending data to ServerURI: " + connectionConfig.getServerURI());
            client = new MqttClient(this.connectionConfig.getServerURI(), clientId);
            client.connect();
            for (String topic : connectionConfig.getTopics()) {
                System.out.println("Pub: " + topic + "  ##  " + message);
                client.publish(topic, message.getBytes(UTF_8),0, false);
            }
            client.disconnect();
            System.out.println(" ... OK");
        } catch (MqttException e) {
            System.err.println(" ... Fail");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
