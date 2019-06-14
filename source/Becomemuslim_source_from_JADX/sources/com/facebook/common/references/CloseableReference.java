package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.PropagatesNullable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class CloseableReference<T> implements Closeable, Cloneable {
    private static final ResourceReleaser<Closeable> DEFAULT_CLOSEABLE_RELEASER = new C37201();
    private static Class<CloseableReference> TAG = CloseableReference.class;
    private boolean mIsClosed = false;
    private final SharedReference<T> mSharedReference;

    /* renamed from: com.facebook.common.references.CloseableReference$1 */
    static class C37201 implements ResourceReleaser<Closeable> {
        C37201() {
        }

        public void release(java.io.Closeable r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r1 = this;
            r0 = 1;
            com.facebook.common.internal.Closeables.close(r2, r0);	 Catch:{ IOException -> 0x0004 }
        L_0x0004:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.references.CloseableReference.1.release(java.io.Closeable):void");
        }
    }

    private CloseableReference(SharedReference<T> sharedReference) {
        this.mSharedReference = (SharedReference) Preconditions.checkNotNull(sharedReference);
        sharedReference.addReference();
    }

    private CloseableReference(T t, ResourceReleaser<T> resourceReleaser) {
        this.mSharedReference = new SharedReference(t, resourceReleaser);
    }

    public static <T extends Closeable> CloseableReference<T> of(@PropagatesNullable T t) {
        return t == null ? null : new CloseableReference(t, DEFAULT_CLOSEABLE_RELEASER);
    }

    public static <T> CloseableReference<T> of(@PropagatesNullable T t, ResourceReleaser<T> resourceReleaser) {
        return t == null ? null : new CloseableReference(t, resourceReleaser);
    }

    public synchronized T get() {
        Preconditions.checkState(this.mIsClosed ^ 1);
        return this.mSharedReference.get();
    }

    public synchronized CloseableReference<T> clone() {
        Preconditions.checkState(isValid());
        return new CloseableReference(this.mSharedReference);
    }

    public synchronized CloseableReference<T> cloneOrNull() {
        if (!isValid()) {
            return null;
        }
        return clone();
    }

    public synchronized boolean isValid() {
        return this.mIsClosed ^ 1;
    }

    @VisibleForTesting
    public synchronized SharedReference<T> getUnderlyingReferenceTestOnly() {
        return this.mSharedReference;
    }

    public int getValueHash() {
        return isValid() ? System.identityHashCode(this.mSharedReference.get()) : 0;
    }

    public void close() {
        synchronized (this) {
            if (this.mIsClosed) {
                return;
            }
            this.mIsClosed = true;
            this.mSharedReference.deleteReference();
        }
    }

    public static boolean isValid(CloseableReference<?> closeableReference) {
        return (closeableReference == null || closeableReference.isValid() == null) ? null : true;
    }

    public static <T> CloseableReference<T> cloneOrNull(CloseableReference<T> closeableReference) {
        return closeableReference != null ? closeableReference.cloneOrNull() : null;
    }

    public static <T> List<CloseableReference<T>> cloneOrNull(@PropagatesNullable Collection<CloseableReference<T>> collection) {
        if (collection == null) {
            return null;
        }
        List<CloseableReference<T>> arrayList = new ArrayList(collection.size());
        for (CloseableReference cloneOrNull : collection) {
            arrayList.add(cloneOrNull(cloneOrNull));
        }
        return arrayList;
    }

    public static void closeSafely(CloseableReference<?> closeableReference) {
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    public static void closeSafely(Iterable<? extends CloseableReference<?>> iterable) {
        if (iterable != null) {
            for (CloseableReference closeSafely : iterable) {
                closeSafely(closeSafely);
            }
        }
    }

    protected void finalize() {
        try {
            synchronized (this) {
                if (this.mIsClosed) {
                    super.finalize();
                    return;
                }
                FLog.m5712w(TAG, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mSharedReference)), this.mSharedReference.get().getClass().getName());
                close();
                super.finalize();
            }
        } catch (Throwable th) {
            super.finalize();
        }
    }
}
