package io.alchemystudio.protocol;

/**
 * context是request里面必须要封装的信息，dispatcher要靠context来定位所需服务和所需call的方法。
 */
public class Context {
    private Id vendorId;

    private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Id getVendorId() {
        return vendorId;
    }

    public void setVendorId(Id vendorId) {
        this.vendorId = vendorId;
    }
}
