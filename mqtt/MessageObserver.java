package com.ufcity.semantic.communication;

public interface MessageObserver {

    void receiveMessage(String topic, String message);

}
