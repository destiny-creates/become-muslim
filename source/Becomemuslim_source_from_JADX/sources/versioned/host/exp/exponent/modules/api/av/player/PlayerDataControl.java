package versioned.host.exp.exponent.modules.api.av.player;

import android.widget.MediaController.MediaPlayerControl;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;

public class PlayerDataControl implements MediaPlayerControl {
    private final PlayerData mPlayerData;

    public boolean canPause() {
        return true;
    }

    public boolean canSeekBackward() {
        return true;
    }

    public boolean canSeekForward() {
        return true;
    }

    public PlayerDataControl(PlayerData playerData) {
        this.mPlayerData = playerData;
    }

    public void start() {
        ReadableMap createMap = Arguments.createMap();
        createMap.putBoolean("shouldPlay", true);
        this.mPlayerData.setStatus(createMap, null);
    }

    public void pause() {
        ReadableMap createMap = Arguments.createMap();
        createMap.putBoolean("shouldPlay", false);
        this.mPlayerData.setStatus(createMap, null);
    }

    public int getDuration() {
        ReadableMap status = this.mPlayerData.getStatus();
        return (status.getBoolean("isLoaded") && status.hasKey("durationMillis")) ? status.getInt("durationMillis") : 0;
    }

    public int getCurrentPosition() {
        ReadableMap status = this.mPlayerData.getStatus();
        return status.getBoolean("isLoaded") ? status.getInt("positionMillis") : 0;
    }

    public void seekTo(int i) {
        ReadableMap createMap = Arguments.createMap();
        createMap.putDouble("positionMillis", (double) i);
        this.mPlayerData.setStatus(createMap, null);
    }

    public boolean isPlaying() {
        ReadableMap status = this.mPlayerData.getStatus();
        return status.getBoolean("isLoaded") && status.getBoolean(PlayerData.STATUS_IS_PLAYING_KEY_PATH);
    }

    public int getBufferPercentage() {
        ReadableMap status = this.mPlayerData.getStatus();
        if (!status.getBoolean("isLoaded") || !status.hasKey("durationMillis") || !status.hasKey("playableDurationMillis")) {
            return 0;
        }
        return (int) ((((double) status.getInt("playableDurationMillis")) / ((double) status.getInt("durationMillis"))) * 100.0d);
    }

    public int getAudioSessionId() {
        return this.mPlayerData.getAudioSessionId();
    }

    public boolean isFullscreen() {
        return this.mPlayerData.isPresentedFullscreen();
    }

    public void toggleFullscreen() {
        this.mPlayerData.toggleFullscreen();
    }
}
