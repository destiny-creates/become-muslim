package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.connection.StreamAllocation.StreamAllocationReference;
import okhttp3.internal.platform.Platform;

public final class ConnectionPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Executor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    private final Runnable cleanupRunnable;
    boolean cleanupRunning;
    private final Deque<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    final RouteDatabase routeDatabase;

    /* renamed from: okhttp3.ConnectionPool$1 */
    class C66141 implements Runnable {
        C66141() {
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r6 = this;
        L_0x0000:
            r0 = okhttp3.ConnectionPool.this;
            r1 = java.lang.System.nanoTime();
            r0 = r0.cleanup(r1);
            r2 = -1;
            r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r2 != 0) goto L_0x0011;
        L_0x0010:
            return;
        L_0x0011:
            r2 = 0;
            r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r2 <= 0) goto L_0x0000;
        L_0x0017:
            r2 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
            r4 = r0 / r2;
            r2 = r2 * r4;
            r0 = r0 - r2;
            r2 = okhttp3.ConnectionPool.this;
            monitor-enter(r2);
            r3 = okhttp3.ConnectionPool.this;	 Catch:{ InterruptedException -> 0x002b }
            r0 = (int) r0;	 Catch:{ InterruptedException -> 0x002b }
            r3.wait(r4, r0);	 Catch:{ InterruptedException -> 0x002b }
            goto L_0x002b;
        L_0x0029:
            r0 = move-exception;
            goto L_0x002d;
        L_0x002b:
            monitor-exit(r2);	 Catch:{ all -> 0x0029 }
            goto L_0x0000;	 Catch:{ all -> 0x0029 }
        L_0x002d:
            monitor-exit(r2);	 Catch:{ all -> 0x0029 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.ConnectionPool.1.run():void");
        }
    }

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.cleanupRunnable = new C66141();
        this.connections = new ArrayDeque();
        this.routeDatabase = new RouteDatabase();
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = timeUnit.toNanos(j);
        if (j <= 0) {
            timeUnit = new StringBuilder();
            timeUnit.append("keepAliveDuration <= 0: ");
            timeUnit.append(j);
            throw new IllegalArgumentException(timeUnit.toString());
        }
    }

    public synchronized int idleConnectionCount() {
        int i;
        i = 0;
        for (RealConnection realConnection : this.connections) {
            if (realConnection.allocations.isEmpty()) {
                i++;
            }
        }
        return i;
    }

    public synchronized int connectionCount() {
        return this.connections.size();
    }

    RealConnection get(Address address, StreamAllocation streamAllocation, Route route) {
        for (RealConnection realConnection : this.connections) {
            if (realConnection.isEligible(address, route)) {
                streamAllocation.acquire(realConnection, true);
                return realConnection;
            }
        }
        return null;
    }

    Socket deduplicate(Address address, StreamAllocation streamAllocation) {
        for (RealConnection realConnection : this.connections) {
            if (realConnection.isEligible(address, null) && realConnection.isMultiplexed() && realConnection != streamAllocation.connection()) {
                return streamAllocation.releaseAndAcquire(realConnection);
            }
        }
        return null;
    }

    void put(RealConnection realConnection) {
        if (!this.cleanupRunning) {
            this.cleanupRunning = true;
            executor.execute(this.cleanupRunnable);
        }
        this.connections.add(realConnection);
    }

    boolean connectionBecameIdle(RealConnection realConnection) {
        if (!realConnection.noNewStreams) {
            if (this.maxIdleConnections != 0) {
                notifyAll();
                return null;
            }
        }
        this.connections.remove(realConnection);
        return true;
    }

    public void evictAll() {
        List<RealConnection> arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.connections.iterator();
            while (it.hasNext()) {
                RealConnection realConnection = (RealConnection) it.next();
                if (realConnection.allocations.isEmpty()) {
                    realConnection.noNewStreams = true;
                    arrayList.add(realConnection);
                    it.remove();
                }
            }
        }
        for (RealConnection socket : arrayList) {
            Util.closeQuietly(socket.socket());
        }
    }

    long cleanup(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            RealConnection realConnection = null;
            int i = 0;
            int i2 = 0;
            for (RealConnection realConnection2 : this.connections) {
                if (pruneAndGetAllocationCount(realConnection2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - realConnection2.idleAtNanos;
                    if (j3 > j2) {
                        realConnection = realConnection2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.keepAliveDurationNs) {
                if (i <= this.maxIdleConnections) {
                    if (i > 0) {
                        j = this.keepAliveDurationNs - j2;
                        return j;
                    } else if (i2 > 0) {
                        j = this.keepAliveDurationNs;
                        return j;
                    } else {
                        this.cleanupRunning = false;
                        return -1;
                    }
                }
            }
            this.connections.remove(realConnection);
            Util.closeQuietly(realConnection.socket());
            return 0;
        }
    }

    private int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        List list = realConnection.allocations;
        int i = 0;
        while (i < list.size()) {
            Reference reference = (Reference) list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                StreamAllocationReference streamAllocationReference = (StreamAllocationReference) reference;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("A connection to ");
                stringBuilder.append(realConnection.route().address().url());
                stringBuilder.append(" was leaked. Did you forget to close a response body?");
                Platform.get().logCloseableLeak(stringBuilder.toString(), streamAllocationReference.callStackTrace);
                list.remove(i);
                realConnection.noNewStreams = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
