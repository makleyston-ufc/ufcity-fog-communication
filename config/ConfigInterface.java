package ufcitycore.config;

public interface ConfigInterface {

    public void configDataBase(String host, String port, String username, String password);
    public void configFogMqttBroker(String host, String port);
    public void configCloudMqttBroker(String host, String port);
    public void configSemantic(String host, String port, String username, String password);
    public void configGroupData(String method, long time, long size);
    public void configAggregateData(String method);
    public void configMissingData(String method);
    public void configRemoveOutlier(String method, double threshold, double lowerPercentile, double upperPercentile);

}
