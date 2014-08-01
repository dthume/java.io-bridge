package org.dthume.java.io_bridge;

import java.io.IOException;

public interface OutputStreamSink
{
    Object close() throws IOException;
    OutputStreamSink flush() throws IOException;
    OutputStreamSink write(byte[] b, int off, int len) throws IOException;
    OutputStreamSink write(int b) throws IOException;
}
