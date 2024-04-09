package ufcitycore.mqtt;

import java.util.ArrayList;
import java.util.List;

public class ConnectionData {
    final public static String PREFIX = "";
    final public static String PUB = "pub_";
    final public static String SUB = "sub_";
//    public static String EDGE_PORT = "1883";
    public static String FOG_PORT = "1883";
    public static String CLOUD_PORT = "1883";
//    public static String EDGE_HOST;
    public static String FOG_HOST;
    public static String CLOUD_HOST;
    final public static String EDGE_RESOURCES_DATA_SUBSCRIBE = "resource_data";
    final public static String EDGE_DEVICE_SUBSCRIBE = "device";
    final public static String EDGE_REMOVED_RESOURCES_SUBSCRIBE = "removed_resource";
    final public static String EDGE_REGISTERED_RESOURCES_SUBSCRIBE = "registered_resource";
    final public static String EDGE_RESOURCE_COMMANDS_PUBLISH = "commands_fog_to_edge";
    final public static String EDGE_RESEND_RESOURCE_DATA_PUBLISH = "resend";
    final public static String INNER_CEP_RESOURCE_DATA_PUBLISH = "cep";
    final public static String INNER_COMBINED_SERVICES_PUBLISH = "combined_services";
    public static final String ADD_EPL = "add_epl";
    public static final String REMOVE_EPL = "remove_epl";
    public static final String COMMANDS_TO_EDGE = "commands_fog_to_edge";

    public static List<String> getCEPSubscribeTopics(String uuidFog){
        List<String> topics = new ArrayList<>();
        topics.add(ADD_EPL + "/" + uuidFog);
        topics.add(REMOVE_EPL + "/" + uuidFog);
        return topics;
    }

    public static List<String> getCommandsToEdge(String uuid_device){
        List<String> topics = new ArrayList<>();
        topics.add(COMMANDS_TO_EDGE + "/" + uuid_device);
        return topics;
    }

    public static List<String> getEdgeSubscribeTopics(){
        List<String> topics = new ArrayList<String>();
        topics.add(EDGE_DEVICE_SUBSCRIBE+"/+");
        topics.add(EDGE_RESOURCES_DATA_SUBSCRIBE+"/+/+");
        topics.add(EDGE_REMOVED_RESOURCES_SUBSCRIBE+"/+");
        topics.add(EDGE_REGISTERED_RESOURCES_SUBSCRIBE+"/+");
        return topics;
    }

    public static List<String> getResourceDataSubscribeTopic(){
        List<String> topics = new ArrayList<String>();
        topics.add(EDGE_RESOURCES_DATA_SUBSCRIBE +"/+");
        return topics;
    }

    public static String getFogPort() {
        return FOG_PORT;
    }

    public static void setFogPort(String innerPort) {
        FOG_PORT = innerPort;
    }

    public static String getFogHost() {
        return FOG_HOST;
    }

    public static void setFogHost(String innerHost) {
        FOG_HOST = innerHost;
    }

    public static String getCloudPort() {
        return CLOUD_PORT;
    }

    public static void setCloudPort(String portCloud) {
        CLOUD_PORT = portCloud;
    }

    public static String getCloudHost() {
        return CLOUD_HOST;
    }

    public static void setCloudHost(String hostCloud) {
        CLOUD_HOST = hostCloud;
    }

    /* resource_data/uuid_device/uuid_resource     -> Message is resource data */
    public static String getInnerCEPResourcesDataPublishTopic(String uuidDevice, String uuidResource){
        return INNER_CEP_RESOURCE_DATA_PUBLISH +"/"+uuidDevice+"/"+uuidResource;
    }

    /* combined_services/uuid_resource */
    public static String getInnerCombinedServicesTopic(String uuidDevice, String uuidResource){
        return INNER_COMBINED_SERVICES_PUBLISH + "/" + uuidDevice + "/" + uuidResource;
    }

    public static String getResendDeviceTopic(String uuidDevice){
        return EDGE_RESEND_RESOURCE_DATA_PUBLISH+"/"+uuidDevice;
    }

    public static String getResendResourceTopic(String uuidDevice, String uuidResource){
        return EDGE_RESEND_RESOURCE_DATA_PUBLISH+"/"+uuidDevice+"/"+uuidResource;
    }

    /* resource_data/uuid_fog/uuid_device/uuid_resource	-> resource_json */
    public static String getCloudResourceDataTopic(String uuidItself, String uuidDevice, String uuiResource){
        return "resource_data/"+uuidItself+"/"+uuidDevice+"/"+uuiResource;
    }

}
