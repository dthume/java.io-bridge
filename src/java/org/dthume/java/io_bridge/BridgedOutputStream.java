package org.dthume.java.io_bridge;

import java.io.IOException;
import java.io.OutputStream;
import clojure.lang.IFn;

public class BridgedOutputStream extends OutputStream
{
    private volatile Object result;
    private volatile OutputStreamSink f;

    public BridgedOutputStream(OutputStreamSink f)
    {
        if (null == f)
            throw new IllegalArgumentException("outputStreamSink cannot be null");
        this.f = f;
    }

    public Object getResult() { return result; }

    public void close() throws IOException
    {
        result = f.close();
        f = null;
    }

    public void flush() throws IOException
    {
        f = f.flush();
    }

    public void write(byte[] b) throws IOException
    {
        write(b, 0, b.length);
    }

    public void write(byte[] b, int off, int len) throws IOException
    {
        f = f.write(b, off, len);
    }

    public void write(int b) throws IOException
    {
        f = f.write(b);
    }
}
