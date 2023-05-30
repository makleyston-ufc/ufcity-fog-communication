package ufcitycore.config;

public interface ConfigInterface {

    public void configDataBase(String host, String port);
    public void configFogMqttBroker(String host, String port);
    public void configCloudMqttBroker(String host, String port);
    public void configSemantic(String host, String port, String username, String password);
    public void configGroupData(char method, long time, long size);
    public void configAggregateData(char method);
    public void configMissingData(char method);
    public void configRemoveOutlier(char method, double threshold, double lowerPercentile, double upperPercentile);

}
