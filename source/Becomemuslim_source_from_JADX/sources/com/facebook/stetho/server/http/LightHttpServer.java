package com.facebook.stetho.server.http;

import android.net.Uri;
import com.facebook.stetho.server.LeakyBufferedInputStream;
import com.facebook.stetho.server.SocketLike;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LightHttpServer {
    private static final String TAG = "LightHttpServer";
    private final HandlerRegistry mHandlerRegistry;

    private static class HttpMessageReader {
        private final StringBuilder mBuffer = new StringBuilder();
        private final BufferedInputStream mIn;
        private final NewLineDetector mNewLineDetector = new NewLineDetector();

        private static class NewLineDetector {
            private static final int STATE_ON_CR = 2;
            private static final int STATE_ON_CRLF = 3;
            private static final int STATE_ON_OTHER = 1;
            private int state;

            private NewLineDetector() {
                this.state = 1;
            }

            public void accept(char c) {
                switch (this.state) {
                    case 1:
                        if (c == '\r') {
                            this.state = 2;
                            return;
                        }
                        return;
                    case 2:
                        if (c == '\n') {
                            this.state = '\u0003';
                            return;
                        } else {
                            this.state = 1;
                            return;
                        }
                    case 3:
                        if (c == '\r') {
                            this.state = 2;
                            return;
                        } else {
                            this.state = 1;
                            return;
                        }
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown state: ");
                        stringBuilder.append(this.state);
                        throw new IllegalArgumentException(stringBuilder.toString());
                }
            }

            public int state() {
                return this.state;
            }
        }

        public HttpMessageReader(BufferedInputStream bufferedInputStream) {
            this.mIn = bufferedInputStream;
        }

        public String readLine() {
            while (true) {
                int read = this.mIn.read();
                if (read >= 0) {
                    char c = (char) read;
                    this.mNewLineDetector.accept(c);
                    switch (this.mNewLineDetector.state()) {
                        case 1:
                            this.mBuffer.append(c);
                            break;
                        case 2:
                            break;
                        case 3:
                            String stringBuilder = this.mBuffer.toString();
                            this.mBuffer.setLength(0);
                            return stringBuilder;
                        default:
                            break;
                    }
                }
                return null;
            }
        }
    }

    public static class HttpMessageWriter {
        private static final byte[] CRLF = "\r\n".getBytes();
        private final BufferedOutputStream mOut;

        public HttpMessageWriter(BufferedOutputStream bufferedOutputStream) {
            this.mOut = bufferedOutputStream;
        }

        public void writeLine(String str) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                this.mOut.write(str.charAt(i));
            }
            this.mOut.write(CRLF);
        }

        public void writeLine() {
            this.mOut.write(CRLF);
        }

        public void flush() {
            this.mOut.flush();
        }
    }

    public LightHttpServer(HandlerRegistry handlerRegistry) {
        this.mHandlerRegistry = handlerRegistry;
    }

    public void serve(SocketLike socketLike) {
        LeakyBufferedInputStream leakyBufferedInputStream = new LeakyBufferedInputStream(socketLike.getInput(), 1024);
        OutputStream output = socketLike.getOutput();
        HttpMessageReader httpMessageReader = new HttpMessageReader(leakyBufferedInputStream);
        HttpMessageWriter httpMessageWriter = new HttpMessageWriter(new BufferedOutputStream(output));
        SocketLike socketLike2 = new SocketLike(socketLike, leakyBufferedInputStream);
        socketLike = new LightHttpRequest();
        LightHttpResponse lightHttpResponse = new LightHttpResponse();
        while (true) {
            LightHttpRequest readRequestMessage = readRequestMessage(socketLike, httpMessageReader);
            if (readRequestMessage != null) {
                lightHttpResponse.reset();
                if (dispatchToHandler(socketLike2, readRequestMessage, lightHttpResponse)) {
                    writeFullResponse(lightHttpResponse, httpMessageWriter, output);
                } else {
                    return;
                }
            }
            return;
        }
    }

    private boolean dispatchToHandler(SocketLike socketLike, LightHttpRequest lightHttpRequest, LightHttpResponse lightHttpResponse) {
        PrintWriter printWriter;
        HttpHandler lookup = this.mHandlerRegistry.lookup(lightHttpRequest.uri.getPath());
        if (lookup == null) {
            lightHttpResponse.code = HttpStatus.HTTP_NOT_FOUND;
            lightHttpResponse.reasonPhrase = "Not found";
            lightHttpResponse.body = LightHttpBody.create("No handler found\n", "text/plain");
            return true;
        }
        try {
            return lookup.handleRequest(socketLike, lightHttpRequest, lightHttpResponse);
        } catch (SocketLike socketLike2) {
            lightHttpResponse.code = HttpStatus.HTTP_INTERNAL_SERVER_ERROR;
            lightHttpResponse.reasonPhrase = "Internal Server Error";
            lightHttpRequest = new StringWriter();
            printWriter = new PrintWriter(lightHttpRequest);
            socketLike2.printStackTrace(printWriter);
            lightHttpResponse.body = LightHttpBody.create(lightHttpRequest.toString(), "text/plain");
            return true;
        } finally {
            printWriter.close();
        }
    }

    private static LightHttpRequest readRequestMessage(LightHttpRequest lightHttpRequest, HttpMessageReader httpMessageReader) {
        lightHttpRequest.reset();
        String readLine = httpMessageReader.readLine();
        if (readLine == null) {
            return null;
        }
        String[] split = readLine.split(" ", 3);
        if (split.length == 3) {
            lightHttpRequest.method = split[0];
            lightHttpRequest.uri = Uri.parse(split[1]);
            lightHttpRequest.protocol = split[2];
            readHeaders(lightHttpRequest, httpMessageReader);
            return lightHttpRequest;
        }
        httpMessageReader = new StringBuilder();
        httpMessageReader.append("Invalid request line: ");
        httpMessageReader.append(readLine);
        throw new IOException(httpMessageReader.toString());
    }

    private static void readHeaders(LightHttpMessage lightHttpMessage, HttpMessageReader httpMessageReader) {
        while (true) {
            String readLine = httpMessageReader.readLine();
            if (readLine == null) {
                throw new EOFException();
            } else if (!"".equals(readLine)) {
                String[] split = readLine.split(": ", 2);
                if (split.length == 2) {
                    Object obj = split[0];
                    Object obj2 = split[1];
                    lightHttpMessage.headerNames.add(obj);
                    lightHttpMessage.headerValues.add(obj2);
                } else {
                    httpMessageReader = new StringBuilder();
                    httpMessageReader.append("Malformed header: ");
                    httpMessageReader.append(readLine);
                    throw new IOException(httpMessageReader.toString());
                }
            } else {
                return;
            }
        }
    }

    private static void writeFullResponse(LightHttpResponse lightHttpResponse, HttpMessageWriter httpMessageWriter, OutputStream outputStream) {
        lightHttpResponse.prepare();
        writeResponseMessage(lightHttpResponse, httpMessageWriter);
        if (lightHttpResponse.body != null) {
            lightHttpResponse.body.writeTo(outputStream);
        }
    }

    public static void writeResponseMessage(LightHttpResponse lightHttpResponse, HttpMessageWriter httpMessageWriter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP/1.1 ");
        stringBuilder.append(lightHttpResponse.code);
        stringBuilder.append(" ");
        stringBuilder.append(lightHttpResponse.reasonPhrase);
        httpMessageWriter.writeLine(stringBuilder.toString());
        int size = lightHttpResponse.headerNames.size();
        for (int i = 0; i < size; i++) {
            String str = (String) lightHttpResponse.headerNames.get(i);
            String str2 = (String) lightHttpResponse.headerValues.get(i);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(": ");
            stringBuilder2.append(str2);
            httpMessageWriter.writeLine(stringBuilder2.toString());
        }
        httpMessageWriter.writeLine();
        httpMessageWriter.flush();
    }
}
