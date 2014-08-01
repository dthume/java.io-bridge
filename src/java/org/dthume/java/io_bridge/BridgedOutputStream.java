package org.dthume.java.io_bridge;

import java.io.OutputStream;
import clojure.lang.IFn;

public class BridgedOutputStream extends OutputStream
{
    private volatile IFn f;

    public BridgedOutputStream(IFn f)
    {
        if (null == f)
            throw new IllegalArgumentException("fn cannot be null");
        this.f = f;
    }

    public IFn getFn() { return f; }

    public void close()
    {
        f = (IFn)f.invoke(true);
    }

    public void flush()
    {
        f = (IFn)f.invoke(false);
    }

    public void write(byte[] b)
    {
        write(b, 0, b.length);
    }

    public void write(byte[] b, int off, int len)
    {
        f = (IFn)f.invoke(b, off, len);
    }

    public void write(int b)
    {
        f = (IFn)f.invoke(false, b);
    }
}
