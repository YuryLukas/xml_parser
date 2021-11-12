package jl.narva.xml_parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class GetXmlData {
    String path;
    String data;

    public GetXmlData(String path) throws IOException {
        this.path = path;
        this.download();
    }

    public void download() throws IOException {
        StringBuilder xmlResult = new StringBuilder();
        BufferedReader reader = null;
        InputStream stream = null;
        HttpsURLConnection connection = null;
        URL url = new URL(this.path);
        connection = (HttpsURLConnection) url.openConnection();
        stream = connection.getInputStream();
        reader = new BufferedReader(new InputStreamReader(stream));
        String line;
        while ((line = reader.readLine()) != null) {
            xmlResult.append(line);
        }
        this.setData(xmlResult.toString());

        if (reader != null) {
            reader.close();
        }
        if (stream != null) {
            stream.close();
        }
        if (connection != null) {
            connection.disconnect();
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
