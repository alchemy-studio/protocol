package io.alchemystudio.protocol.test;

import io.alchemystudio.protocol.spi.Dispatcher;
import io.alchemystudio.protocol.Id;
import io.alchemystudio.protocol.Request;
import io.alchemystudio.protocol.Response;


public class MockDispatcher implements Dispatcher {

    private Id vendorIdForTest;

    private MockService mockService;

    public MockService getMockService() {
        return mockService;
    }

    public void setMockService(MockService mockService) {
        this.mockService = mockService;
    }

    public Id getVendorIdForTest() {
        return vendorIdForTest;
    }

    public void setVendorIdForTest(Id vendorIdForTest) {
        this.vendorIdForTest = vendorIdForTest;
    }

    @Override
    public void dispatch(Request request, Response response) {

        if (vendorIdForTest.getStringVal().equals(request.getContext().getVendorId().getStringVal())) {
            if (request.getContext().getMethod().equals("hello"))
                mockService.hello(request, response);
        }
    }
}
