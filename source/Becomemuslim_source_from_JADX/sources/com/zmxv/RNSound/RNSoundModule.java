package com.zmxv.RNSound;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import versioned.host.exp.exponent.modules.api.av.player.PlayerData;

public class RNSoundModule extends ReactContextBaseJavaModule implements OnAudioFocusChangeListener {
    static final Object NULL = null;
    String category;
    ReactApplicationContext context;
    Double focusedPlayerKey;
    Boolean mixWithOthers = Boolean.valueOf(true);
    Map<Double, MediaPlayer> playerPool = new HashMap();
    Boolean wasPlayingBeforeFocusChange = Boolean.valueOf(false);

    @ReactMethod
    public void enable(Boolean bool) {
    }

    public String getName() {
        return "RNSound";
    }

    public RNSoundModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.context = reactApplicationContext;
        this.category = null;
    }

    private void setOnPlay(boolean z, Double d) {
        ReactContext reactContext = this.context;
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean(PlayerData.STATUS_IS_PLAYING_KEY_PATH, z);
        createMap.putDouble("playerKey", d.doubleValue());
        ((RCTDeviceEventEmitter) reactContext.getJSModule(RCTDeviceEventEmitter.class)).emit("onPlayChange", createMap);
    }

    @ReactMethod
    public void prepare(String str, Double d, ReadableMap readableMap, final Callback callback) {
        str = createMediaPlayer(str);
        int i = -1;
        if (str == null) {
            str = Arguments.createMap();
            str.putInt("code", -1);
            str.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "resource not found");
            callback.invoke(new Object[]{str, NULL});
            return;
        }
        this.playerPool.put(d, str);
        if (this.category != null) {
            d = null;
            String str2 = this.category;
            switch (str2.hashCode()) {
                case -1803461041:
                    if (str2.equals("System")) {
                        i = 2;
                        break;
                    }
                    break;
                case 2547280:
                    if (str2.equals("Ring")) {
                        i = 4;
                        break;
                    }
                    break;
                case 82833682:
                    if (str2.equals("Voice")) {
                        i = 3;
                        break;
                    }
                    break;
                case 772508280:
                    if (str2.equals("Ambient")) {
                        i = 1;
                        break;
                    }
                    break;
                case 1943812667:
                    if (str2.equals("Playback")) {
                        i = 0;
                        break;
                    }
                    break;
                default:
                    break;
            }
            switch (i) {
                case 0:
                    d = Integer.valueOf(3);
                    break;
                case 1:
                    d = Integer.valueOf(5);
                    break;
                case 2:
                    d = Integer.valueOf(1);
                    break;
                case 3:
                    d = Integer.valueOf(0);
                    break;
                case 4:
                    d = Integer.valueOf(2);
                    break;
                default:
                    Log.e("RNSoundModule", String.format("Unrecognised category %s", new Object[]{this.category}));
                    break;
            }
            if (d != null) {
                str.setAudioStreamType(d.intValue());
            }
        }
        str.setOnPreparedListener(new OnPreparedListener(this) {
            /* renamed from: a */
            boolean f19502a = null;
            /* renamed from: c */
            final /* synthetic */ RNSoundModule f19504c;

            public synchronized void onPrepared(MediaPlayer mediaPlayer) {
                if (!this.f19502a) {
                    this.f19502a = true;
                    Arguments.createMap().putDouble("duration", ((double) mediaPlayer.getDuration()) * 0.001d);
                    try {
                        callback.invoke(new Object[]{RNSoundModule.NULL, r1});
                    } catch (MediaPlayer mediaPlayer2) {
                        Log.e("RNSoundModule", "Exception", mediaPlayer2);
                    }
                } else {
                    return;
                }
                return;
            }
        });
        str.setOnErrorListener(new OnErrorListener(this) {
            /* renamed from: a */
            boolean f19505a = null;
            /* renamed from: c */
            final /* synthetic */ RNSoundModule f19507c;

            public synchronized boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (this.f19505a != null) {
                    return true;
                }
                this.f19505a = true;
                try {
                    mediaPlayer = Arguments.createMap();
                    mediaPlayer.putInt("what", i);
                    mediaPlayer.putInt("extra", i2);
                    callback.invoke(new Object[]{mediaPlayer, RNSoundModule.NULL});
                } catch (MediaPlayer mediaPlayer2) {
                    Log.e("RNSoundModule", "Exception", mediaPlayer2);
                }
                return true;
            }
        });
        try {
            if (readableMap.hasKey("loadSync") == null || readableMap.getBoolean("loadSync") == null) {
                str.prepareAsync();
            } else {
                str.prepare();
            }
        } catch (String str3) {
            Log.e("RNSoundModule", "Exception", str3);
        }
    }

    protected MediaPlayer createMediaPlayer(String str) {
        int identifier = this.context.getResources().getIdentifier(str, "raw", this.context.getPackageName());
        MediaPlayer mediaPlayer = new MediaPlayer();
        if (identifier != 0) {
            try {
                str = this.context.getResources().openRawResourceFd(identifier);
                mediaPlayer.setDataSource(str.getFileDescriptor(), str.getStartOffset(), str.getLength());
                str.close();
                return mediaPlayer;
            } catch (String str2) {
                Log.e("RNSoundModule", "Exception", str2);
                return null;
            }
        }
        if (!str2.startsWith("http://")) {
            if (!str2.startsWith("https://")) {
                if (str2.startsWith("asset:/")) {
                    try {
                        str2 = this.context.getAssets().openFd(str2.replace("asset:/", ""));
                        mediaPlayer.setDataSource(str2.getFileDescriptor(), str2.getStartOffset(), str2.getLength());
                        str2.close();
                        return mediaPlayer;
                    } catch (String str22) {
                        Log.e("RNSoundModule", "Exception", str22);
                        return null;
                    }
                } else if (!new File(str22).exists()) {
                    return null;
                } else {
                    mediaPlayer.setAudioStreamType(3);
                    Log.i("RNSoundModule", str22);
                    try {
                        mediaPlayer.setDataSource(str22);
                        return mediaPlayer;
                    } catch (String str222) {
                        Log.e("RNSoundModule", "Exception", str222);
                        return null;
                    }
                }
            }
        }
        mediaPlayer.setAudioStreamType(3);
        Log.i("RNSoundModule", str222);
        try {
            mediaPlayer.setDataSource(str222);
            return mediaPlayer;
        } catch (String str2222) {
            Log.e("RNSoundModule", "Exception", str2222);
            return null;
        }
    }

    @ReactMethod
    public void play(final Double d, final Callback callback) {
        MediaPlayer mediaPlayer = (MediaPlayer) this.playerPool.get(d);
        if (mediaPlayer == null) {
            setOnPlay(false, d);
            if (callback != null) {
                callback.invoke(new Object[]{Boolean.valueOf(false)});
            }
        } else if (!mediaPlayer.isPlaying()) {
            if (!this.mixWithOthers.booleanValue()) {
                ((AudioManager) this.context.getSystemService("audio")).requestAudioFocus(this, 3, 1);
                this.focusedPlayerKey = d;
            }
            mediaPlayer.setOnCompletionListener(new OnCompletionListener(this) {
                /* renamed from: a */
                boolean f19508a = null;
                /* renamed from: d */
                final /* synthetic */ RNSoundModule f19511d;

                public synchronized void onCompletion(android.media.MediaPlayer r4) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r3 = this;
                    monitor-enter(r3);
                    r4 = r4.isLooping();	 Catch:{ all -> 0x0027 }
                    if (r4 != 0) goto L_0x0025;	 Catch:{ all -> 0x0027 }
                L_0x0007:
                    r4 = r3.f19511d;	 Catch:{ all -> 0x0027 }
                    r0 = r5;	 Catch:{ all -> 0x0027 }
                    r1 = 0;	 Catch:{ all -> 0x0027 }
                    r4.setOnPlay(r1, r0);	 Catch:{ all -> 0x0027 }
                    r4 = r3.f19508a;	 Catch:{ all -> 0x0027 }
                    if (r4 == 0) goto L_0x0015;
                L_0x0013:
                    monitor-exit(r3);
                    return;
                L_0x0015:
                    r4 = 1;
                    r3.f19508a = r4;	 Catch:{ all -> 0x0027 }
                    r0 = r6;	 Catch:{ Exception -> 0x0025 }
                    r2 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0025 }
                    r4 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0025 }
                    r2[r1] = r4;	 Catch:{ Exception -> 0x0025 }
                    r0.invoke(r2);	 Catch:{ Exception -> 0x0025 }
                L_0x0025:
                    monitor-exit(r3);
                    return;
                L_0x0027:
                    r4 = move-exception;
                    monitor-exit(r3);
                    throw r4;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.zmxv.RNSound.RNSoundModule.3.onCompletion(android.media.MediaPlayer):void");
                }
            });
            mediaPlayer.setOnErrorListener(new OnErrorListener(this) {
                /* renamed from: a */
                boolean f19512a = null;
                /* renamed from: d */
                final /* synthetic */ RNSoundModule f19515d;

                public synchronized boolean onError(android.media.MediaPlayer r3, int r4, int r5) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r2 = this;
                    monitor-enter(r2);
                    r3 = r2.f19515d;	 Catch:{ all -> 0x0021 }
                    r4 = r5;	 Catch:{ all -> 0x0021 }
                    r5 = 0;	 Catch:{ all -> 0x0021 }
                    r3.setOnPlay(r5, r4);	 Catch:{ all -> 0x0021 }
                    r3 = r2.f19512a;	 Catch:{ all -> 0x0021 }
                    r4 = 1;
                    if (r3 == 0) goto L_0x0010;
                L_0x000e:
                    monitor-exit(r2);
                    return r4;
                L_0x0010:
                    r2.f19512a = r4;	 Catch:{ all -> 0x0021 }
                    r3 = r6;	 Catch:{ Exception -> 0x001f }
                    r0 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x001f }
                    r1 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x001f }
                    r0[r5] = r1;	 Catch:{ Exception -> 0x001f }
                    r3.invoke(r0);	 Catch:{ Exception -> 0x001f }
                L_0x001f:
                    monitor-exit(r2);
                    return r4;
                L_0x0021:
                    r3 = move-exception;
                    monitor-exit(r2);
                    throw r3;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.zmxv.RNSound.RNSoundModule.4.onError(android.media.MediaPlayer, int, int):boolean");
                }
            });
            mediaPlayer.start();
            setOnPlay(true, d);
        }
    }

    @ReactMethod
    public void pause(Double d, Callback callback) {
        MediaPlayer mediaPlayer = (MediaPlayer) this.playerPool.get(d);
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
        if (callback != null) {
            callback.invoke(new Object[null]);
        }
    }

    @ReactMethod
    public void stop(Double d, Callback callback) {
        MediaPlayer mediaPlayer = (MediaPlayer) this.playerPool.get(d);
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
        }
        if (!this.mixWithOthers.booleanValue() && d == this.focusedPlayerKey) {
            ((AudioManager) this.context.getSystemService("audio")).abandonAudioFocus(this);
        }
        callback.invoke(new Object[0]);
    }

    @ReactMethod
    public void reset(Double d) {
        MediaPlayer mediaPlayer = (MediaPlayer) this.playerPool.get(d);
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
    }

    @ReactMethod
    public void release(Double d) {
        MediaPlayer mediaPlayer = (MediaPlayer) this.playerPool.get(d);
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer.release();
            this.playerPool.remove(d);
            if (!this.mixWithOthers.booleanValue() && d == this.focusedPlayerKey) {
                ((AudioManager) this.context.getSystemService("audio")).abandonAudioFocus(this);
            }
        }
    }

    public void onCatalystInstanceDestroy() {
        Iterator it = this.playerPool.entrySet().iterator();
        while (it.hasNext()) {
            MediaPlayer mediaPlayer = (MediaPlayer) ((Entry) it.next()).getValue();
            if (mediaPlayer != null) {
                mediaPlayer.reset();
                mediaPlayer.release();
            }
            it.remove();
        }
    }

    @ReactMethod
    public void setVolume(Double d, Float f, Float f2) {
        MediaPlayer mediaPlayer = (MediaPlayer) this.playerPool.get(d);
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f.floatValue(), f2.floatValue());
        }
    }

    @ReactMethod
    public void getSystemVolume(Callback callback) {
        try {
            AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
            callback.invoke(new Object[]{NULL, Float.valueOf(((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3)))});
        } catch (Exception e) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("code", -1);
            createMap.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, e.getMessage());
            callback.invoke(new Object[]{createMap});
        }
    }

    @ReactMethod
    public void setSystemVolume(Float f) {
        AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
        audioManager.setStreamVolume(3, Math.round(((float) audioManager.getStreamMaxVolume(3)) * f.floatValue()), 0);
    }

    @ReactMethod
    public void setLooping(Double d, Boolean bool) {
        MediaPlayer mediaPlayer = (MediaPlayer) this.playerPool.get(d);
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(bool.booleanValue());
        }
    }

    @ReactMethod
    public void setSpeed(Double d, Float f) {
        if (VERSION.SDK_INT < 23) {
            Log.w("RNSoundModule", "setSpeed ignored due to sdk limit");
            return;
        }
        MediaPlayer mediaPlayer = (MediaPlayer) this.playerPool.get(d);
        if (mediaPlayer != null) {
            mediaPlayer.setPlaybackParams(mediaPlayer.getPlaybackParams().setSpeed(f.floatValue()));
        }
    }

    @ReactMethod
    public void setCurrentTime(Double d, Float f) {
        MediaPlayer mediaPlayer = (MediaPlayer) this.playerPool.get(d);
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(Math.round(f.floatValue() * 1000.0f));
        }
    }

    @ReactMethod
    public void getCurrentTime(Double d, Callback callback) {
        if (((MediaPlayer) this.playerPool.get(d)) == null) {
            callback.invoke(new Object[]{Integer.valueOf(-1), Boolean.valueOf(false)});
            return;
        }
        callback.invoke(new Object[]{Double.valueOf(((double) ((MediaPlayer) this.playerPool.get(d)).getCurrentPosition()) * 0.001d), Boolean.valueOf(((MediaPlayer) this.playerPool.get(d)).isPlaying())});
    }

    @ReactMethod
    public void setSpeakerphoneOn(Double d, Boolean bool) {
        MediaPlayer mediaPlayer = (MediaPlayer) this.playerPool.get(d);
        if (mediaPlayer != null) {
            mediaPlayer.setAudioStreamType(3);
            d = this.context;
            ReactApplicationContext reactApplicationContext = this.context;
            AudioManager audioManager = (AudioManager) d.getSystemService("audio");
            if (bool.booleanValue()) {
                audioManager.setMode(3);
            } else {
                audioManager.setMode(0);
            }
            audioManager.setSpeakerphoneOn(bool.booleanValue());
        }
    }

    @ReactMethod
    public void setCategory(String str, Boolean bool) {
        this.category = str;
        this.mixWithOthers = bool;
    }

    public void onAudioFocusChange(int i) {
        if (!this.mixWithOthers.booleanValue()) {
            MediaPlayer mediaPlayer = (MediaPlayer) this.playerPool.get(this.focusedPlayerKey);
            if (mediaPlayer == null) {
                return;
            }
            if (i <= 0) {
                this.wasPlayingBeforeFocusChange = Boolean.valueOf(mediaPlayer.isPlaying());
                if (this.wasPlayingBeforeFocusChange.booleanValue() != 0) {
                    pause(this.focusedPlayerKey, null);
                }
            } else if (this.wasPlayingBeforeFocusChange.booleanValue() != 0) {
                play(this.focusedPlayerKey, null);
                this.wasPlayingBeforeFocusChange = Boolean.valueOf(0);
            }
        }
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("IsAndroid", Boolean.valueOf(true));
        return hashMap;
    }
}
