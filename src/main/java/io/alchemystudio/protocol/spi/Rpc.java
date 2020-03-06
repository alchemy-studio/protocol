package io.alchemystudio.protocol.spi;

import io.alchemystudio.protocol.Request;
import io.alchemystudio.protocol.Response;

public interface Rpc {
    Response call(Request req);
}
