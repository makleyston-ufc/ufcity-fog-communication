## UFCity Core

This code is UFCity's Fog Computing core. It has the models and communication components needed for several architecture components.

Currently, this core is present in the following:
* [UFCity Handler](https://github.com/makleyston-ufc/ufcity-fog-handler)
* [UFCity CEP](https://github.com/makleyston-ufc/ufcity-fog-cep)
* [UFCity Semantic](https://github.com/makleyston-ufc/ufcity-fog-semantic)

See the example following for use this core:

Dependencies:
* [Gson](https://github.com/google/gson).
* [MQTT Paho](https://www.eclipse.org/paho/).

To import the dependencies in your project via Gradle: 
```
dependencies {
    ...
    implementation 'com.google.code.gson:gson:2.10.1'
    implementation "org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.2.1"
}
```

In the directory `java`, your Java project:
```
git clone https://github.com/makleyston-ufc/ufcitycore.git
```