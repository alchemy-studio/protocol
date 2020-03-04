package io.alchemystudio.protocol;

public class Request {

    private String id;
    private String timestamp;
    private String dataType;
    private Context data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Context getData() {
        return data;
    }

    public void setData(Context data) {
        this.data = data;
    }
}
