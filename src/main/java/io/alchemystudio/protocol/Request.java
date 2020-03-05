package io.alchemystudio.protocol;

public class Request {

    private Id id;
    private Time t;
    private Context context;

    public Time getT() {
        return t;
    }

    public void setT(Time t) {
        this.t = t;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
