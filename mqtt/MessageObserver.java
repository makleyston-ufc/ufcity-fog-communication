package ufcitycore.mqtt;

public interface MessageObserver {

    void receiveMessage(String topic, String message);

}
