package ufcitycore.models;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Service {
    public String uuid_service;
    public ArrayList<Data> data = new ArrayList<Data>();

    public String getUuid_service() {
        return uuid_service;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setUuid_service(String uuid_service) {
        this.uuid_service = uuid_service;
    }

    public Data getDataByTag(String _tag){
        for(Data _service_data : this.data){
            if(Objects.equals(_service_data.getTag(), _tag))
                return _service_data;
        }
        return null;
    }

    public void addServiceData(Data data){
        this.data.add(data);
    }

}
