package io.alchemystudio.protocol.spi;

import io.alchemystudio.protocol.Request;
import io.alchemystudio.protocol.Response;

/**
 * Dispatcher接口，用来接收Rpc接口收进来的Request，并进行解析和内部分发。
 * 分发给内部的具体的处理逻辑。
 */
public interface Dispatcher {

    /**
     * dispatch方法
     * @param request Rpc.call()方法传进来的request。
     * @param response 要处理的Response
     *
     */
    void dispatch(Request request, Response response);
}
