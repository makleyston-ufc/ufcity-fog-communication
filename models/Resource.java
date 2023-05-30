package ufcitycore.models;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Objects;

public class Resource {

    private Location location;
    private String uuid_resource;
    ArrayList < Service > services = new ArrayList< Service >();

    public ArrayList< Service > getServices(){
        return this.services;
    }

    public Service getServiceByUUID(String uuidService){
        for(Service _service : this.services){
            if(Objects.equals(_service.getUuid_service(), uuidService))
                return _service;
        }
        return null;
    }

    public Location getLocation() {
        return location;
    }

    public String getUuid_resource() {
        return uuid_resource;
    }

    public void setLocation(Location locationObject) {
        this.location = locationObject;
    }

    public void setUuid_resource(String uuid_resource) {
        this.uuid_resource = uuid_resource;
    }

    public void addService(Service service){
        this.services.add(service);
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
