package io.alchemystudio.protocol;

public interface Rpc {
    Response call(Request req);
}
