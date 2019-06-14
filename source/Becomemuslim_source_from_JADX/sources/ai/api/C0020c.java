package ai.api;

import ai.api.p007c.C0012a;
import ai.api.p007c.C0013c;

/* compiled from: AIListener */
/* renamed from: ai.api.c */
public interface C0020c {
    void onAudioLevel(float f);

    void onError(C0012a c0012a);

    void onListeningCanceled();

    void onListeningFinished();

    void onListeningStarted();

    void onResult(C0013c c0013c);
}
