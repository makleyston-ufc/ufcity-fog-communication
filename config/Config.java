package ufcitycore.config;

import com.ufcity.handler.procedures.*;
import org.yaml.snakeyaml.Yaml;
import java.io.*;
import java.util.Map;

public class Config {

    public static void ReaderYAMLConfig(ConfigInterface config) throws FileNotFoundException {
        try {
            // Carrega o arquivo YAML
            FileInputStream inputStream = new FileInputStream("config.yaml");

            // Faz o parsing do arquivo YAML
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(inputStream);

            if (data.containsKey("fog-computing")) {
                Map<String, Object> fogComputing = (Map<String, Object>) data.get("fog-computing");
                String fogComputingAddress = (String) fogComputing.get("address");
                String fogComputingPort = (String) fogComputing.get("port");
                config.configFogMqttBroker(fogComputingAddress, fogComputingPort);
            }

            if (data.containsKey("cloud-computing")) {
                Map<String, Object> cloudComputing = (Map<String, Object>) data.get("cloud-computing");
                String cloudComputingAddress = (String) cloudComputing.get("address");
                String cloudComputingPort = (String) cloudComputing.get("port");
                config.configCloudMqttBroker(cloudComputingAddress, cloudComputingPort);
            }

            if (data.containsKey("database")) {
                Map<String, Object> database = (Map<String, Object>) data.get("database");
                String dbAddress = (String) database.get("address");
                String dbPort = (String) database.get("port");
                config.configDataBase(dbAddress, dbPort);
            }

            if (data.containsKey("data-groupin")) {
                Map<String, Object> dataGrouping = (Map<String, Object>) data.get("data-grouping");
                String groupingDataMethod = (String) dataGrouping.get("method");
                DataGroupingHandling.getInstance().setMethod(METHODS.methodMap.get(groupingDataMethod));
                int groupingSize = 0, groupingTime = 0;
                if (dataGrouping.containsKey("size")) {
                    groupingSize = (int) dataGrouping.get("size");
                }
                if (dataGrouping.containsKey("time")) {
                    groupingTime = (int) dataGrouping.get("time");
                }
                config.configGroupData(METHODS.methodMap.get(groupingDataMethod), groupingTime, groupingSize);
            }

            if (data.containsKey("missing-data")) {
                Map<String, Object> missingData = (Map<String, Object>) data.get("missing-data");
                String missingDataMethod = (String) missingData.get("method");
                config.configMissingData(METHODS.methodMap.get(missingDataMethod));
            }

            if (data.containsKey("removing-outliers")) {
                Map<String, Object> removingOutliers = (Map<String, Object>) data.get("removing-outliers");
                String outliersMethod = (String) removingOutliers.get("method");
                OutliersHandling.getInstance().setMethod(METHODS.methodMap.get(outliersMethod));
                double outliersThreshold = 0, outliersUpper = 0, outliersLower = 0;
                if (removingOutliers.containsKey("threshold")) {
                    outliersThreshold = (double) removingOutliers.get("threshold");
                }
                if (removingOutliers.containsKey("upper-percentile")) {
                    outliersUpper = (double) removingOutliers.get("upper-percentile");
                }
                if (removingOutliers.containsKey("lower-percentile")) {
                    outliersLower = (double) removingOutliers.get("lower-percentile");
                }
                config.configRemoveOutlier(METHODS.methodMap.get(outliersMethod), outliersThreshold, outliersLower, outliersUpper);
            }

            if (data.containsKey("aggregating-data")) {
                Map<String, Object> aggregatingData = (Map<String, Object>) data.get("aggregating-data");
                String aggregationMethod = (String) aggregatingData.get("method");
                config.configAggregateData(METHODS.methodMap.get(aggregationMethod));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
