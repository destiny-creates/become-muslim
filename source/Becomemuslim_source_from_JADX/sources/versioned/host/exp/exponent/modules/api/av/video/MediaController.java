package versioned.host.exp.exponent.modules.api.av.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import host.exp.p333a.C6279c.C6273b;
import host.exp.p333a.C6279c.C6274c;
import host.exp.p333a.C6279c.C6275d;
import java.lang.ref.WeakReference;
import java.util.Formatter;
import java.util.Locale;
import versioned.host.exp.exponent.modules.api.av.player.PlayerDataControl;

public class MediaController extends FrameLayout {
    private static final int FADE_OUT = 1;
    private static final int SHOW_PROGRESS = 2;
    private static final int sDefaultTimeout = 3000;
    private ViewGroup mAnchor;
    private Context mContext;
    private TextView mCurrentTime;
    private boolean mDragging;
    private TextView mEndTime;
    private ImageButton mFastForwardButton;
    private OnClickListener mFfwdListener;
    private StringBuilder mFormatBuilder;
    private Formatter mFormatter;
    private boolean mFromXml;
    private ImageButton mFullscreenButton;
    private OnClickListener mFullscreenListener;
    private Handler mHandler;
    private boolean mListenersSet;
    private ImageButton mNextButton;
    private OnClickListener mNextListener;
    private ImageButton mPauseButton;
    private OnClickListener mPauseListener;
    private PlayerDataControl mPlayer;
    private ImageButton mPrevButton;
    private OnClickListener mPrevListener;
    private ProgressBar mProgress;
    private OnClickListener mRewListener;
    private ImageButton mRewindButton;
    private View mRoot;
    private OnSeekBarChangeListener mSeekListener;
    private boolean mShowing;
    private boolean mUseFastForward;

    /* renamed from: versioned.host.exp.exponent.modules.api.av.video.MediaController$1 */
    class C67241 implements OnClickListener {
        C67241() {
        }

        public void onClick(View view) {
            MediaController.this.show(MediaController.sDefaultTimeout);
            MediaController.this.doPauseResume();
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.av.video.MediaController$2 */
    class C67252 implements OnClickListener {
        C67252() {
        }

        public void onClick(View view) {
            MediaController.this.show(MediaController.sDefaultTimeout);
            MediaController.this.doToggleFullscreen();
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.av.video.MediaController$3 */
    class C67263 implements OnSeekBarChangeListener {
        C67263() {
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            MediaController.this.show(3600000);
            MediaController.this.mDragging = true;
            MediaController.this.mHandler.removeMessages(2);
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (MediaController.this.mPlayer != null && z) {
                i = (int) ((((long) MediaController.this.mPlayer.getDuration()) * ((long) i)) / 1000);
                MediaController.this.mPlayer.seekTo(i);
                if (MediaController.this.mCurrentTime != null) {
                    MediaController.this.mCurrentTime.setText(MediaController.this.stringForTime(i));
                }
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            MediaController.this.mDragging = false;
            MediaController.this.setProgress();
            MediaController.this.updatePausePlay();
            MediaController.this.show(MediaController.sDefaultTimeout);
            MediaController.this.mHandler.sendEmptyMessage(2);
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.av.video.MediaController$4 */
    class C67274 implements OnClickListener {
        C67274() {
        }

        public void onClick(View view) {
            if (MediaController.this.mPlayer != null) {
                MediaController.this.mPlayer.seekTo(MediaController.this.mPlayer.getCurrentPosition() - 5000);
                MediaController.this.setProgress();
                MediaController.this.show(MediaController.sDefaultTimeout);
            }
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.av.video.MediaController$5 */
    class C67285 implements OnClickListener {
        C67285() {
        }

        public void onClick(View view) {
            if (MediaController.this.mPlayer != null) {
                MediaController.this.mPlayer.seekTo(MediaController.this.mPlayer.getCurrentPosition() + 15000);
                MediaController.this.setProgress();
                MediaController.this.show(MediaController.sDefaultTimeout);
            }
        }
    }

    private static class MessageHandler extends Handler {
        private final WeakReference<MediaController> mView;

        MessageHandler(MediaController mediaController) {
            this.mView = new WeakReference(mediaController);
        }

        public void handleMessage(Message message) {
            MediaController mediaController = (MediaController) this.mView.get();
            if (mediaController != null) {
                if (mediaController.mPlayer != null) {
                    switch (message.what) {
                        case 1:
                            mediaController.hide();
                            break;
                        case 2:
                            message = mediaController.setProgress();
                            if (!mediaController.mDragging && mediaController.mShowing && mediaController.mPlayer.isPlaying()) {
                                sendMessageDelayed(obtainMessage(2), (long) (1000 - (message % 1000)));
                                break;
                            }
                        default:
                            break;
                    }
                }
            }
        }
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new MessageHandler(this);
        this.mPauseListener = new C67241();
        this.mFullscreenListener = new C67252();
        this.mSeekListener = new C67263();
        this.mRewListener = new C67274();
        this.mFfwdListener = new C67285();
        this.mRoot = null;
        this.mContext = context;
        this.mUseFastForward = true;
        this.mFromXml = true;
    }

    public MediaController(Context context, boolean z) {
        super(context);
        this.mHandler = new MessageHandler(this);
        this.mPauseListener = new C67241();
        this.mFullscreenListener = new C67252();
        this.mSeekListener = new C67263();
        this.mRewListener = new C67274();
        this.mFfwdListener = new C67285();
        this.mContext = context;
        this.mUseFastForward = z;
    }

    public MediaController(Context context) {
        this(context, true);
    }

    public void onFinishInflate() {
        if (this.mRoot != null) {
            initControllerView(this.mRoot);
        }
        super.onFinishInflate();
    }

    public void setMediaPlayer(PlayerDataControl playerDataControl) {
        this.mPlayer = playerDataControl;
        updateControls();
    }

    public void updateControls() {
        setProgress();
        updatePausePlay();
        updateFullScreen();
    }

    public void setAnchorView(ViewGroup viewGroup) {
        this.mAnchor = viewGroup;
        if (this.mRoot == null) {
            viewGroup = new LayoutParams(-1, -2, 80);
            removeAllViews();
            addView(makeControllerView(), viewGroup);
        }
    }

    protected View makeControllerView() {
        this.mRoot = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(C6275d.expo_media_controller, null);
        initControllerView(this.mRoot);
        return this.mRoot;
    }

    private void initControllerView(View view) {
        this.mPauseButton = (ImageButton) view.findViewById(C6274c.play_button);
        if (this.mPauseButton != null) {
            this.mPauseButton.requestFocus();
            this.mPauseButton.setOnClickListener(this.mPauseListener);
        }
        this.mFullscreenButton = (ImageButton) view.findViewById(C6274c.fullscreen_mode_button);
        if (this.mFullscreenButton != null) {
            this.mFullscreenButton.requestFocus();
            this.mFullscreenButton.setOnClickListener(this.mFullscreenListener);
        }
        this.mFastForwardButton = (ImageButton) view.findViewById(C6274c.fast_forward_button);
        int i = 0;
        if (this.mFastForwardButton != null) {
            this.mFastForwardButton.setOnClickListener(this.mFfwdListener);
            if (!this.mFromXml) {
                this.mFastForwardButton.setVisibility(this.mUseFastForward ? 0 : 8);
            }
        }
        this.mRewindButton = (ImageButton) view.findViewById(C6274c.rewind_button);
        if (this.mRewindButton != null) {
            this.mRewindButton.setOnClickListener(this.mRewListener);
            if (!this.mFromXml) {
                ImageButton imageButton = this.mRewindButton;
                if (!this.mUseFastForward) {
                    i = 8;
                }
                imageButton.setVisibility(i);
            }
        }
        this.mNextButton = (ImageButton) view.findViewById(C6274c.skip_next_button);
        if (!(this.mNextButton == null || this.mFromXml || this.mListenersSet)) {
            this.mNextButton.setVisibility(8);
        }
        this.mPrevButton = (ImageButton) view.findViewById(C6274c.skip_previous_button);
        if (!(this.mPrevButton == null || this.mFromXml || this.mListenersSet)) {
            this.mPrevButton.setVisibility(8);
        }
        this.mProgress = (ProgressBar) view.findViewById(C6274c.seek_bar);
        if (this.mProgress != null) {
            if (this.mProgress instanceof SeekBar) {
                ((SeekBar) this.mProgress).setOnSeekBarChangeListener(this.mSeekListener);
            }
            this.mProgress.setMax(1000);
        }
        this.mEndTime = (TextView) view.findViewById(C6274c.end_time_text);
        this.mCurrentTime = (TextView) view.findViewById(C6274c.current_time_text);
        this.mFormatBuilder = new StringBuilder();
        this.mFormatter = new Formatter(this.mFormatBuilder, Locale.getDefault());
        installPrevNextListeners();
    }

    public void show() {
        show(sDefaultTimeout);
    }

    private void disableUnsupportedButtons() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mPlayer;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r2.mPauseButton;	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
        r1 = 0;	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
        if (r0 == 0) goto L_0x0017;	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
    L_0x000a:
        r0 = r2.mPlayer;	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
        r0 = r0.canPause();	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
        if (r0 != 0) goto L_0x0017;	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
    L_0x0012:
        r0 = r2.mPauseButton;	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
        r0.setEnabled(r1);	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
    L_0x0017:
        r0 = r2.mRewindButton;	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
        if (r0 == 0) goto L_0x0028;	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
    L_0x001b:
        r0 = r2.mPlayer;	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
        r0 = r0.canSeekBackward();	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
        if (r0 != 0) goto L_0x0028;	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
    L_0x0023:
        r0 = r2.mRewindButton;	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
        r0.setEnabled(r1);	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
    L_0x0028:
        r0 = r2.mFastForwardButton;	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
        if (r0 == 0) goto L_0x0039;	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
    L_0x002c:
        r0 = r2.mPlayer;	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
        r0 = r0.canSeekForward();	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
        if (r0 != 0) goto L_0x0039;	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
    L_0x0034:
        r0 = r2.mFastForwardButton;	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
        r0.setEnabled(r1);	 Catch:{ IncompatibleClassChangeError -> 0x0039 }
    L_0x0039:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.av.video.MediaController.disableUnsupportedButtons():void");
    }

    public void show(int i) {
        if (!(this.mShowing || this.mAnchor == null)) {
            setProgress();
            if (this.mPauseButton != null) {
                this.mPauseButton.requestFocus();
            }
            disableUnsupportedButtons();
            this.mAnchor.addView(this, new LayoutParams(-1, -1));
            this.mShowing = true;
        }
        updateControls();
        this.mHandler.sendEmptyMessage(2);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        if (i != 0) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(obtainMessage, (long) i);
        }
    }

    public boolean isShowing() {
        return this.mShowing;
    }

    public void hide() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mAnchor;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r2.mAnchor;	 Catch:{ IllegalArgumentException -> 0x0011 }
        r0.removeView(r2);	 Catch:{ IllegalArgumentException -> 0x0011 }
        r0 = r2.mHandler;	 Catch:{ IllegalArgumentException -> 0x0011 }
        r1 = 2;	 Catch:{ IllegalArgumentException -> 0x0011 }
        r0.removeMessages(r1);	 Catch:{ IllegalArgumentException -> 0x0011 }
        goto L_0x0018;
    L_0x0011:
        r0 = "MediaController";
        r1 = "already removed";
        android.util.Log.w(r0, r1);
    L_0x0018:
        r0 = 0;
        r2.mShowing = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.av.video.MediaController.hide():void");
    }

    private String stringForTime(int i) {
        i /= 1000;
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        i /= 3600;
        this.mFormatBuilder.setLength(0);
        if (i > 0) {
            return this.mFormatter.format("%d:%02d:%02d", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2)}).toString();
        }
        return this.mFormatter.format("%02d:%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)}).toString();
    }

    private int setProgress() {
        if (this.mPlayer != null) {
            if (!this.mDragging) {
                int currentPosition = this.mPlayer.getCurrentPosition();
                int duration = this.mPlayer.getDuration();
                if (this.mProgress != null) {
                    if (duration > 0) {
                        this.mProgress.setProgress((int) ((((long) currentPosition) * 1000) / ((long) duration)));
                    }
                    this.mProgress.setSecondaryProgress(this.mPlayer.getBufferPercentage() * 10);
                }
                if (this.mEndTime != null) {
                    this.mEndTime.setText(stringForTime(duration));
                }
                if (this.mCurrentTime != null) {
                    this.mCurrentTime.setText(stringForTime(currentPosition));
                }
                return currentPosition;
            }
        }
        return 0;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() != null) {
            show(sDefaultTimeout);
        }
        return true;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (isEnabled() != null) {
            show(sDefaultTimeout);
        }
        return null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mPlayer != null) {
            if (isEnabled()) {
                int keyCode = keyEvent.getKeyCode();
                Object obj = (keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0) ? 1 : null;
                if (!(keyCode == 79 || keyCode == 85)) {
                    if (keyCode != 62) {
                        if (keyCode == 126) {
                            if (obj != null && this.mPlayer.isPlaying() == null) {
                                this.mPlayer.start();
                                updatePausePlay();
                                show(sDefaultTimeout);
                            }
                            return true;
                        }
                        if (keyCode != 86) {
                            if (keyCode != 127) {
                                if (!(keyCode == 25 || keyCode == 24)) {
                                    if (keyCode != 164) {
                                        if (keyCode != 4) {
                                            if (keyCode != 82) {
                                                show(sDefaultTimeout);
                                                return super.dispatchKeyEvent(keyEvent);
                                            }
                                        }
                                        if (obj != null) {
                                            hide();
                                        }
                                        return true;
                                    }
                                }
                                return super.dispatchKeyEvent(keyEvent);
                            }
                        }
                        if (!(obj == null || this.mPlayer.isPlaying() == null)) {
                            this.mPlayer.pause();
                            updatePausePlay();
                            show(sDefaultTimeout);
                        }
                        return true;
                    }
                }
                if (obj != null) {
                    doPauseResume();
                    show(sDefaultTimeout);
                    if (this.mPauseButton != null) {
                        this.mPauseButton.requestFocus();
                    }
                }
                return true;
            }
        }
        return true;
    }

    public void updatePausePlay() {
        if (!(this.mRoot == null || this.mPauseButton == null)) {
            if (this.mPlayer != null) {
                if (this.mPlayer.isPlaying()) {
                    this.mPauseButton.setImageResource(C6273b.exo_controls_pause);
                } else {
                    this.mPauseButton.setImageResource(C6273b.exo_controls_play);
                }
            }
        }
    }

    public void updateFullScreen() {
        if (!(this.mRoot == null || this.mFullscreenButton == null)) {
            if (this.mPlayer != null) {
                if (this.mPlayer.isFullscreen()) {
                    this.mFullscreenButton.setImageResource(C6273b.ic_fullscreen_exit_32dp);
                } else {
                    this.mFullscreenButton.setImageResource(C6273b.ic_fullscreen_32dp);
                }
            }
        }
    }

    private void doPauseResume() {
        if (this.mPlayer != null) {
            if (this.mPlayer.isPlaying()) {
                this.mPlayer.pause();
            } else {
                this.mPlayer.start();
            }
            updatePausePlay();
        }
    }

    private void doToggleFullscreen() {
        if (this.mPlayer != null) {
            this.mPlayer.toggleFullscreen();
        }
    }

    public void setEnabled(boolean z) {
        if (this.mPauseButton != null) {
            this.mPauseButton.setEnabled(z);
        }
        if (this.mFastForwardButton != null) {
            this.mFastForwardButton.setEnabled(z);
        }
        if (this.mRewindButton != null) {
            this.mRewindButton.setEnabled(z);
        }
        boolean z2 = true;
        if (this.mNextButton != null) {
            ImageButton imageButton = this.mNextButton;
            boolean z3 = z && this.mNextListener != null;
            imageButton.setEnabled(z3);
        }
        if (this.mPrevButton != null) {
            imageButton = this.mPrevButton;
            if (!z || this.mPrevListener == null) {
                z2 = false;
            }
            imageButton.setEnabled(z2);
        }
        if (this.mProgress != null) {
            this.mProgress.setEnabled(z);
        }
        disableUnsupportedButtons();
        super.setEnabled(z);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(MediaController.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(MediaController.class.getName());
    }

    private void installPrevNextListeners() {
        boolean z = false;
        if (this.mNextButton != null) {
            this.mNextButton.setOnClickListener(this.mNextListener);
            this.mNextButton.setEnabled(this.mNextListener != null);
        }
        if (this.mPrevButton != null) {
            this.mPrevButton.setOnClickListener(this.mPrevListener);
            ImageButton imageButton = this.mPrevButton;
            if (this.mPrevListener != null) {
                z = true;
            }
            imageButton.setEnabled(z);
        }
    }

    public void setPrevNextListeners(OnClickListener onClickListener, OnClickListener onClickListener2) {
        this.mNextListener = onClickListener;
        this.mPrevListener = onClickListener2;
        this.mListenersSet = true;
        if (this.mRoot != null) {
            installPrevNextListeners();
            if (this.mNextButton != null && this.mFromXml == null) {
                this.mNextButton.setVisibility(0);
            }
            if (this.mPrevButton != null && this.mFromXml == null) {
                this.mPrevButton.setVisibility(0);
            }
        }
    }
}
