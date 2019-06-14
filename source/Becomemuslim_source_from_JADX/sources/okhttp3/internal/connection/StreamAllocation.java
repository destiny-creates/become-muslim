package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector.Selection;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

public final class StreamAllocation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Address address;
    public final Call call;
    private final Object callStackTrace;
    private boolean canceled;
    private HttpCodec codec;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    public final EventListener eventListener;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private Route route;
    private Selection routeSelection;
    private final RouteSelector routeSelector;

    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.callStackTrace = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool, Address address, Call call, EventListener eventListener, Object obj) {
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
        this.routeSelector = new RouteSelector(address, routeDatabase(), call, eventListener);
        this.callStackTrace = obj;
    }

    public HttpCodec newStream(OkHttpClient okHttpClient, Chain chain, boolean z) {
        try {
            okHttpClient = findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).newCodec(okHttpClient, chain, this);
            synchronized (this.connectionPool) {
                this.codec = okHttpClient;
            }
            return okHttpClient;
        } catch (OkHttpClient okHttpClient2) {
            throw new RouteException(okHttpClient2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.connection.RealConnection findHealthyConnection(int r4, int r5, int r6, int r7, boolean r8, boolean r9) {
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.findConnection(r4, r5, r6, r7, r8);
        r1 = r3.connectionPool;
        monitor-enter(r1);
        r2 = r0.successCount;	 Catch:{ all -> 0x0019 }
        if (r2 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        return r0;
    L_0x000d:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        r1 = r0.isHealthy(r9);
        if (r1 != 0) goto L_0x0018;
    L_0x0014:
        r3.noNewStreams();
        goto L_0x0000;
    L_0x0018:
        return r0;
    L_0x0019:
        r4 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.findHealthyConnection(int, int, int, int, boolean, boolean):okhttp3.internal.connection.RealConnection");
    }

    private RealConnection findConnection(int i, int i2, int i3, int i4, boolean z) {
        Socket releaseIfNoNewStreams;
        Connection connection;
        Object obj;
        Route route;
        Object obj2;
        synchronized (this.connectionPool) {
            if (r1.released) {
                throw new IllegalStateException("released");
            } else if (r1.codec != null) {
                throw new IllegalStateException("codec != null");
            } else if (r1.canceled) {
                throw new IOException("Canceled");
            } else {
                RealConnection realConnection = r1.connection;
                releaseIfNoNewStreams = releaseIfNoNewStreams();
                Socket socket = null;
                if (r1.connection != null) {
                    realConnection = r1.connection;
                    connection = null;
                } else {
                    connection = realConnection;
                    realConnection = null;
                }
                if (!r1.reportedAcquired) {
                    connection = null;
                }
                if (realConnection == null) {
                    Internal.instance.get(r1.connectionPool, r1.address, r1, null);
                    if (r1.connection != null) {
                        obj = r1.connection;
                        route = null;
                        obj2 = 1;
                    } else {
                        route = r1.route;
                        obj = realConnection;
                    }
                } else {
                    obj = realConnection;
                    route = null;
                }
                obj2 = null;
            }
        }
        Util.closeQuietly(releaseIfNoNewStreams);
        if (connection != null) {
            r1.eventListener.connectionReleased(r1.call, connection);
        }
        if (obj2 != null) {
            r1.eventListener.connectionAcquired(r1.call, obj);
        }
        if (obj != null) {
            return obj;
        }
        Object obj3;
        if (route != null || (r1.routeSelection != null && r1.routeSelection.hasNext())) {
            obj3 = null;
        } else {
            r1.routeSelection = r1.routeSelector.next();
            obj3 = 1;
        }
        synchronized (r1.connectionPool) {
            if (r1.canceled) {
                throw new IOException("Canceled");
            }
            if (obj3 != null) {
                List all = r1.routeSelection.getAll();
                int size = all.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Route route2 = (Route) all.get(i5);
                    Internal.instance.get(r1.connectionPool, r1.address, r1, route2);
                    if (r1.connection != null) {
                        obj = r1.connection;
                        r1.route = route2;
                        obj2 = 1;
                        break;
                    }
                }
            }
            if (obj2 == null) {
                if (route == null) {
                    route = r1.routeSelection.next();
                }
                r1.route = route;
                r1.refusedStreamCount = 0;
                obj = new RealConnection(r1.connectionPool, route);
                acquire(obj, false);
            }
        }
        if (obj2 != null) {
            r1.eventListener.connectionAcquired(r1.call, obj);
            return obj;
        }
        obj.connect(i, i2, i3, i4, z, r1.call, r1.eventListener);
        routeDatabase().connected(obj.route());
        synchronized (r1.connectionPool) {
            r1.reportedAcquired = true;
            Internal.instance.put(r1.connectionPool, obj);
            if (obj.isMultiplexed()) {
                socket = Internal.instance.deduplicate(r1.connectionPool, r1.address, r1);
                obj = r1.connection;
            }
        }
        Util.closeQuietly(socket);
        r1.eventListener.connectionAcquired(r1.call, obj);
        return obj;
    }

    private Socket releaseIfNoNewStreams() {
        RealConnection realConnection = this.connection;
        return (realConnection == null || !realConnection.noNewStreams) ? null : deallocate(false, false, true);
    }

    public void streamFinished(boolean z, HttpCodec httpCodec, long j, IOException iOException) {
        Socket deallocate;
        this.eventListener.responseBodyEnd(this.call, j);
        synchronized (this.connectionPool) {
            if (httpCodec != null) {
                if (httpCodec == this.codec) {
                    if (!z) {
                        RealConnection realConnection = this.connection;
                        realConnection.successCount++;
                    }
                    Connection connection = this.connection;
                    deallocate = deallocate(z, false, true);
                    if (this.connection != null) {
                        connection = null;
                    }
                    httpCodec = this.released;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected ");
            stringBuilder.append(this.codec);
            stringBuilder.append(" but was ");
            stringBuilder.append(httpCodec);
            throw new IllegalStateException(stringBuilder.toString());
        }
        Util.closeQuietly(deallocate);
        if (connection != null) {
            this.eventListener.connectionReleased(this.call, connection);
        }
        if (iOException != null) {
            this.eventListener.callFailed(this.call, iOException);
        } else if (httpCodec != null) {
            this.eventListener.callEnd(this.call);
        }
    }

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.connectionPool) {
            httpCodec = this.codec;
        }
        return httpCodec;
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public Route route() {
        return this.route;
    }

    public synchronized RealConnection connection() {
        return this.connection;
    }

    public void release() {
        Socket deallocate;
        synchronized (this.connectionPool) {
            Connection connection = this.connection;
            deallocate = deallocate(false, true, false);
            if (this.connection != null) {
                connection = null;
            }
        }
        Util.closeQuietly(deallocate);
        if (connection != null) {
            this.eventListener.connectionReleased(this.call, connection);
        }
    }

    public void noNewStreams() {
        Socket deallocate;
        synchronized (this.connectionPool) {
            Connection connection = this.connection;
            deallocate = deallocate(true, false, false);
            if (this.connection != null) {
                connection = null;
            }
        }
        Util.closeQuietly(deallocate);
        if (connection != null) {
            this.eventListener.connectionReleased(this.call, connection);
        }
    }

    private Socket deallocate(boolean z, boolean z2, boolean z3) {
        if (z3) {
            this.codec = null;
        }
        if (z2) {
            this.released = true;
        }
        if (this.connection) {
            if (z) {
                this.connection.noNewStreams = true;
            }
            if (!this.codec && (this.released || this.connection.noNewStreams)) {
                release(this.connection);
                if (this.connection.allocations.isEmpty()) {
                    this.connection.idleAtNanos = System.nanoTime();
                    if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection)) {
                        z = this.connection.socket();
                        this.connection = null;
                        return z;
                    }
                }
                z = false;
                this.connection = null;
                return z;
            }
        }
        return false;
    }

    public void cancel() {
        synchronized (this.connectionPool) {
            this.canceled = true;
            HttpCodec httpCodec = this.codec;
            RealConnection realConnection = this.connection;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public void streamFailed(IOException iOException) {
        Connection connection;
        Socket deallocate;
        synchronized (this.connectionPool) {
            if (iOException instanceof StreamResetException) {
                StreamResetException streamResetException = (StreamResetException) iOException;
                if (streamResetException.errorCode == ErrorCode.REFUSED_STREAM) {
                    this.refusedStreamCount++;
                }
                if (streamResetException.errorCode != ErrorCode.REFUSED_STREAM || this.refusedStreamCount > 1) {
                    this.route = null;
                }
                iOException = null;
                connection = this.connection;
                deallocate = deallocate(iOException, false, true);
                if (!(this.connection == null && this.reportedAcquired)) {
                    connection = null;
                }
            } else {
                if (this.connection != null && (!this.connection.isMultiplexed() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.connection.successCount == 0) {
                        if (!(this.route == null || iOException == null)) {
                            this.routeSelector.connectFailed(this.route, iOException);
                        }
                        this.route = null;
                    }
                }
                iOException = null;
                connection = this.connection;
                deallocate = deallocate(iOException, false, true);
                connection = null;
            }
            iOException = true;
            connection = this.connection;
            deallocate = deallocate(iOException, false, true);
            connection = null;
        }
        Util.closeQuietly(deallocate);
        if (connection != null) {
            this.eventListener.connectionReleased(this.call, connection);
        }
    }

    public void acquire(RealConnection realConnection, boolean z) {
        if (this.connection == null) {
            this.connection = realConnection;
            this.reportedAcquired = z;
            realConnection.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
            return;
        }
        throw new IllegalStateException();
    }

    private void release(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i = 0; i < size; i++) {
            if (((Reference) realConnection.allocations.get(i)).get() == this) {
                realConnection.allocations.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket releaseAndAcquire(RealConnection realConnection) {
        if (this.codec == null && this.connection.allocations.size() == 1) {
            Reference reference = (Reference) this.connection.allocations.get(0);
            Socket deallocate = deallocate(true, false, false);
            this.connection = realConnection;
            realConnection.allocations.add(reference);
            return deallocate;
        }
        throw new IllegalStateException();
    }

    public boolean hasMoreRoutes() {
        if (this.route == null && (this.routeSelection == null || !this.routeSelection.hasNext())) {
            if (!this.routeSelector.hasNext()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        RealConnection connection = connection();
        return connection != null ? connection.toString() : this.address.toString();
    }
}
