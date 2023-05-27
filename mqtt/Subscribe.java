package ufcitycore.mqtt;

import org.eclipse.paho.client.mqttv3.*;

import static java.time.LocalDateTime.now;
import static ufcitycore.mqtt.ConnectionData.PREFIX;
import static ufcitycore.mqtt.ConnectionData.SUB;

public class Subscribe extends ConnectionDefault {
//    ConnectionConfig conn;
    String clientId = PREFIX+SUB+now();

    public Subscribe(ConnectionConfig connectionConfig) {
        super(connectionConfig);
//        this.conn = connectionConfig;
    }

    public void subscribe(MessageObserver messageObserver) throws MqttException {
        try {
            System.out.println("SUB# ServerURI: " + connectionConfig.getServerURI());
            client = new MqttClient(connectionConfig.getServerURI(), clientId);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            client.connect(connOpts);
            client.setCallback(new MQTTCallBack(messageObserver));
//            int[] qos = new int[connectionConfig.getTopics().length];
//            for (int i = 0; i < connectionConfig.getTopics().length; i++) {
//                qos[i] = 0;
//            }
            client.subscribe(connectionConfig.getTopics());
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void setClientId(String clientId){
        this.clientId = PREFIX+SUB+clientId+now();
    }

}
