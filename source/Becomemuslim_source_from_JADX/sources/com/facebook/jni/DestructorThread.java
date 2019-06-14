package com.facebook.jni;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicReference;

public class DestructorThread {
    private static DestructorList sDestructorList = new DestructorList();
    private static DestructorStack sDestructorStack = new DestructorStack();
    private static ReferenceQueue sReferenceQueue = new ReferenceQueue();
    private static Thread sThread = new Thread("HybridData DestructorThread") {
        public void run() {
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
            r2 = this;
        L_0x0000:
            r0 = com.facebook.jni.DestructorThread.sReferenceQueue;	 Catch:{ InterruptedException -> 0x0000 }
            r0 = r0.remove();	 Catch:{ InterruptedException -> 0x0000 }
            r0 = (com.facebook.jni.DestructorThread.Destructor) r0;	 Catch:{ InterruptedException -> 0x0000 }
            r0.destruct();	 Catch:{ InterruptedException -> 0x0000 }
            r1 = r0.previous;	 Catch:{ InterruptedException -> 0x0000 }
            if (r1 != 0) goto L_0x001a;	 Catch:{ InterruptedException -> 0x0000 }
        L_0x0013:
            r1 = com.facebook.jni.DestructorThread.sDestructorStack;	 Catch:{ InterruptedException -> 0x0000 }
            r1.transferAllToList();	 Catch:{ InterruptedException -> 0x0000 }
        L_0x001a:
            com.facebook.jni.DestructorThread.DestructorList.drop(r0);	 Catch:{ InterruptedException -> 0x0000 }
            goto L_0x0000;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.jni.DestructorThread.1.run():void");
        }
    };

    public static abstract class Destructor extends PhantomReference<Object> {
        private Destructor next;
        private Destructor previous;

        abstract void destruct();

        Destructor(Object obj) {
            super(obj, DestructorThread.sReferenceQueue);
            DestructorThread.sDestructorStack.push(this);
        }

        private Destructor() {
            super(null, DestructorThread.sReferenceQueue);
        }
    }

    private static class DestructorList {
        private Destructor mHead = new Terminus();

        public DestructorList() {
            this.mHead.next = new Terminus();
            this.mHead.next.previous = this.mHead;
        }

        public void enqueue(Destructor destructor) {
            destructor.next = this.mHead.next;
            this.mHead.next = destructor;
            destructor.next.previous = destructor;
            destructor.previous = this.mHead;
        }

        private static void drop(Destructor destructor) {
            destructor.next.previous = destructor.previous;
            destructor.previous.next = destructor.next;
        }
    }

    private static class DestructorStack {
        private AtomicReference<Destructor> mHead;

        private DestructorStack() {
            this.mHead = new AtomicReference();
        }

        public void push(Destructor destructor) {
            Destructor destructor2;
            do {
                destructor2 = (Destructor) this.mHead.get();
                destructor.next = destructor2;
            } while (!this.mHead.compareAndSet(destructor2, destructor));
        }

        public void transferAllToList() {
            Destructor destructor = (Destructor) this.mHead.getAndSet(null);
            while (destructor != null) {
                Destructor access$600 = destructor.next;
                DestructorThread.sDestructorList.enqueue(destructor);
                destructor = access$600;
            }
        }
    }

    private static class Terminus extends Destructor {
        private Terminus() {
            super();
        }

        void destruct() {
            throw new IllegalStateException("Cannot destroy Terminus Destructor.");
        }
    }

    static {
        sThread.start();
    }
}
