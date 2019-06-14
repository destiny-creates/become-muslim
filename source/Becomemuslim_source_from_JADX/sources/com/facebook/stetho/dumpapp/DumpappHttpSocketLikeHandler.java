package com.facebook.stetho.dumpapp;

import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.SocketLikeHandler;
import com.facebook.stetho.server.http.ExactPathMatcher;
import com.facebook.stetho.server.http.HandlerRegistry;
import com.facebook.stetho.server.http.HttpHandler;
import com.facebook.stetho.server.http.HttpStatus;
import com.facebook.stetho.server.http.LightHttpBody;
import com.facebook.stetho.server.http.LightHttpRequest;
import com.facebook.stetho.server.http.LightHttpResponse;
import com.facebook.stetho.server.http.LightHttpServer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

@Deprecated
public class DumpappHttpSocketLikeHandler implements SocketLikeHandler {
    private final LightHttpServer mServer;

    private static class DumpappLegacyHttpHandler implements HttpHandler {
        private static final String CONTENT_TYPE = "application/octet-stream";
        private static final String QUERY_PARAM_ARGV = "argv";
        private static final String RESPONSE_HEADER_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
        private final Dumper mDumper;

        public DumpappLegacyHttpHandler(Dumper dumper) {
            this.mDumper = dumper;
        }

        public boolean handleRequest(SocketLike socketLike, LightHttpRequest lightHttpRequest, LightHttpResponse lightHttpResponse) {
            socketLike = "POST".equals(lightHttpRequest.method);
            Object obj = (socketLike == null && "GET".equals(lightHttpRequest.method)) ? 1 : null;
            if (obj == null) {
                if (socketLike == null) {
                    lightHttpResponse.code = HttpStatus.HTTP_NOT_IMPLEMENTED;
                    lightHttpResponse.reasonPhrase = "Not implemented";
                    socketLike = new StringBuilder();
                    socketLike.append(lightHttpRequest.method);
                    socketLike.append(" not implemented");
                    lightHttpResponse.body = LightHttpBody.create(socketLike.toString(), "text/plain");
                    return true;
                }
            }
            lightHttpRequest = lightHttpRequest.uri.getQueryParameters(QUERY_PARAM_ARGV);
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Framer framer = new Framer(new ByteArrayInputStream(new byte[0]), byteArrayOutputStream);
            socketLike = socketLike != null ? "ERROR" : "WARNING";
            PrintStream stderr = framer.getStderr();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("*** ");
            stringBuilder.append(socketLike);
            stringBuilder.append(": Using legacy HTTP protocol; update dumpapp script! ***");
            stderr.println(stringBuilder.toString());
            if (obj != null) {
                DumpappSocketLikeHandler.dump(this.mDumper, framer, (String[]) lightHttpRequest.toArray(new String[lightHttpRequest.size()]));
            } else {
                framer.writeExitCode(1);
            }
            lightHttpResponse.code = HttpStatus.HTTP_OK;
            lightHttpResponse.reasonPhrase = "OK";
            lightHttpResponse.addHeader(RESPONSE_HEADER_ALLOW_ORIGIN, "*");
            lightHttpResponse.body = LightHttpBody.create(byteArrayOutputStream.toByteArray(), CONTENT_TYPE);
            return true;
        }
    }

    public DumpappHttpSocketLikeHandler(Dumper dumper) {
        HandlerRegistry handlerRegistry = new HandlerRegistry();
        handlerRegistry.register(new ExactPathMatcher("/dumpapp"), new DumpappLegacyHttpHandler(dumper));
        this.mServer = new LightHttpServer(handlerRegistry);
    }

    public void onAccepted(SocketLike socketLike) {
        this.mServer.serve(socketLike);
    }
}
