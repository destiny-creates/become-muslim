package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.List;

public abstract class BaseListBitmapDataSubscriber extends BaseDataSubscriber<List<CloseableReference<CloseableImage>>> {
    public void onNewResultImpl(com.facebook.datasource.DataSource<java.util.List<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> r6) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Incorrect nodes count for selectOther: B:30:0x0076 in [B:23:0x006c, B:30:0x0076, B:29:0x0060]
	at jadx.core.utils.BlockUtils.selectOther(BlockUtils.java:53)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:64)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r5 = this;
        r0 = r6.isFinished();
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r6 = r6.getResult();
        r6 = (java.util.List) r6;
        r0 = 0;
        if (r6 != 0) goto L_0x0014;
    L_0x0010:
        r5.onNewResultListImpl(r0);
        return;
    L_0x0014:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x0061 }
        r2 = r6.size();	 Catch:{ all -> 0x0061 }
        r1.<init>(r2);	 Catch:{ all -> 0x0061 }
        r2 = r6.iterator();	 Catch:{ all -> 0x0061 }
    L_0x0021:
        r3 = r2.hasNext();	 Catch:{ all -> 0x0061 }
        if (r3 == 0) goto L_0x0049;	 Catch:{ all -> 0x0061 }
    L_0x0027:
        r3 = r2.next();	 Catch:{ all -> 0x0061 }
        r3 = (com.facebook.common.references.CloseableReference) r3;	 Catch:{ all -> 0x0061 }
        if (r3 == 0) goto L_0x0045;	 Catch:{ all -> 0x0061 }
    L_0x002f:
        r4 = r3.get();	 Catch:{ all -> 0x0061 }
        r4 = r4 instanceof com.facebook.imagepipeline.image.CloseableBitmap;	 Catch:{ all -> 0x0061 }
        if (r4 == 0) goto L_0x0045;	 Catch:{ all -> 0x0061 }
    L_0x0037:
        r3 = r3.get();	 Catch:{ all -> 0x0061 }
        r3 = (com.facebook.imagepipeline.image.CloseableBitmap) r3;	 Catch:{ all -> 0x0061 }
        r3 = r3.getUnderlyingBitmap();	 Catch:{ all -> 0x0061 }
        r1.add(r3);	 Catch:{ all -> 0x0061 }
        goto L_0x0021;	 Catch:{ all -> 0x0061 }
    L_0x0045:
        r1.add(r0);	 Catch:{ all -> 0x0061 }
        goto L_0x0021;	 Catch:{ all -> 0x0061 }
    L_0x0049:
        r5.onNewResultListImpl(r1);	 Catch:{ all -> 0x0061 }
        r6 = r6.iterator();
    L_0x0050:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0060;
    L_0x0056:
        r0 = r6.next();
        r0 = (com.facebook.common.references.CloseableReference) r0;
        com.facebook.common.references.CloseableReference.closeSafely(r0);
        goto L_0x0050;
    L_0x0060:
        return;
    L_0x0061:
        r0 = move-exception;
        r6 = r6.iterator();
    L_0x0066:
        r1 = r6.hasNext();
        if (r1 == 0) goto L_0x0076;
    L_0x006c:
        r1 = r6.next();
        r1 = (com.facebook.common.references.CloseableReference) r1;
        com.facebook.common.references.CloseableReference.closeSafely(r1);
        goto L_0x0066;
    L_0x0076:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.datasource.BaseListBitmapDataSubscriber.onNewResultImpl(com.facebook.datasource.DataSource):void");
    }

    protected abstract void onNewResultListImpl(List<Bitmap> list);
}
