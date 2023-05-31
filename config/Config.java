package ufcitycore.config;

import org.yaml.snakeyaml.Yaml;
import java.io.*;
import java.util.List;
import java.util.Map;

public class Config {

    public static void ReaderYAMLConfig(ConfigInterface config) throws FileNotFoundException {
        try {
            // Carrega o arquivo YAML
            FileInputStream inputStream = new FileInputStream("config.yaml");
            Yaml yaml = new Yaml();
            Map<String, Object> data = (Map) yaml.load(inputStream);
//            System.out.println(data.toString());

            if (data.containsKey("fog-computing")) {
                List<Map<String, Object>> fogComputingList = (List<Map<String, Object>>) data.get("fog-computing");

                String fogComputingAddress = null;
                String fogComputingPort = null;

                for (Map<String, Object> map : fogComputingList) {
                    if (map.containsKey("address")) {
                        fogComputingAddress = (String) map.get("address");
                    }
                    if (map.containsKey("port")) {
                        fogComputingPort = String.valueOf(map.get("port"));
                    }
                }

                config.configFogMqttBroker(fogComputingAddress, fogComputingPort);
            }

            if (data.containsKey("cloud-computing")) {
                List<Map<String, Object>> cloudComputingList = (List<Map<String, Object>>) data.get("cloud-computing");

                String cloudComputingAddress = null;
                String cloudComputingPort = null;

                for (Map<String, Object> map : cloudComputingList) {
                    if (map.containsKey("address")) {
                        cloudComputingAddress = (String) map.get("address");
                    }
                    if (map.containsKey("port")) {
                        cloudComputingPort = String.valueOf(map.get("port"));
                    }
                }

                config.configCloudMqttBroker(cloudComputingAddress, cloudComputingPort);
            }

            if (data.containsKey("database")) {
                List<Map<String, Object>> databaseList = (List<Map<String, Object>>) data.get("database");

                String dbAddress = null;
                String dbPort = null;
                String username = null;
                String password = null;

                for (Map<String, Object> map : databaseList) {
                    if (map.containsKey("address")) {
                        dbAddress = (String) map.get("address");
                    }
                    if (map.containsKey("port")) {
                        dbPort = String.valueOf(map.get("port"));
                    }
                    if (map.containsKey("username")) {
                        username = (String) map.get("username");
                    }
                    if (map.containsKey("password")) {
                        password = (String) map.get("password");
                    }
                }

                config.configDataBase(dbAddress, dbPort, username, password);
            }

            if (data.containsKey("data-grouping")) {
                List<Map<String, Object>> dataGroupingList = (List<Map<String, Object>>) data.get("data-grouping");

                String method = null;
                int groupingSize = 0, groupingTime = 0;

                for (Map<String, Object> map : dataGroupingList) {
                    if(map.containsKey("method")) {
                        method = (String) map.get("method");
                    }
                    if (map.containsKey("size")) {
                        groupingSize = (int) map.get("size");
                    }
                    if (map.containsKey("time")) {
                        groupingTime = (int) map.get("time");
                    }
                }

                config.configGroupData(method, groupingTime, groupingSize);
            }

            if (data.containsKey("missing-data")) {
                List<Map<String, Object>> missingDataList = (List<Map<String, Object>>) data.get("missing-data");
                Map<String, Object> missingData = missingDataList.get(0);
                String method = null;
                if(missingData.containsKey("method")) {
                    method = (String) missingData.get("method");
                }
                config.configMissingData(method);
            }

            if (data.containsKey("removing-outliers")) {
                List<Map<String, Object>> removingOutliersList = (List<Map<String, Object>>) data.get("removing-outliers");

                String method = null;
                double outliersThreshold = 0, outliersUpper = 0, outliersLower = 0;

                for (Map<String, Object> map : removingOutliersList) {
                    if(map.containsKey("method")) {
                        method = (String) map.get("method");
                    }
                    if (map.containsKey("threshold")) {
                        outliersThreshold = (double) map.get("threshold");
                    }
                    if (map.containsKey("upper-percentile")) {
                        outliersUpper = (double) map.get("upper-percentile");
                    }
                    if (map.containsKey("lower-percentile")) {
                        outliersLower = (double) map.get("lower-percentile");
                    }
                }
                config.configRemoveOutlier(method, outliersThreshold, outliersLower, outliersUpper);
            }

            if (data.containsKey("aggregating-data")) {
                List<Map<String, Object>> aggregatingDataList = (List<Map<String, Object>>) data.get("aggregating-data");
                Map<String, Object> aggregatingData = aggregatingDataList.get(0);
                String aggregationMethod = null;
                if(aggregatingData.containsKey("method")) {
                    aggregationMethod = (String) aggregatingData.get("method");
                }
                config.configAggregateData(aggregationMethod);
            }

            if (data.containsKey("semantic")) {
                List<Map<String, Object>> semanticList = (List<Map<String, Object>>) data.get("semantic");
                String address = null;
                String port = null;
                String username = null;
                String password = null;

                for (Map<String, Object> map : semanticList) {
                    if (map.containsKey("address")) {
                        address = (String) map.get("address");
                    }
                    if (map.containsKey("port")) {
                        port = String.valueOf(map.get("port"));
                    }
                    if (map.containsKey("username")) {
                        username = (String) map.get("username");
                    }
                    if (map.containsKey("password")) {
                        password = (String) map.get("password");
                    }
                }

                config.configSemantic(address, port, username, password);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
