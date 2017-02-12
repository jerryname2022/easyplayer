package cn.jx.easyplayerlib;

import android.os.Handler;
import android.util.Log;
import android.view.Surface;

import cn.jx.easyplayerlib.events.VideoEventListener;


/**
 *
 */

public class EasyPlayer {

    static final String TAG = EasyPlayer.class.getSimpleName();

    private VideoEventListener videoEventListener;
    private Handler mainHandler = new Handler();


    static {
         System.loadLibrary("avutil-55");
         System.loadLibrary("swresample-2");
         System.loadLibrary("avcodec-57");
         System.loadLibrary("avformat-57");
         System.loadLibrary("swscale-4");
         System.loadLibrary("postproc-54");
         System.loadLibrary("avfilter-6");
         System.loadLibrary("avdevice-57");

        System.loadLibrary("player-lib");
    }


    public native void play(String url, Surface surface);

//    public native void pause()

    private void onResolutionChange(final int width,final int height){
        Log.d(TAG, "height: "+height+" width:"+width);
        if (videoEventListener != null) {
            videoEventListener.onResolutionChange(width, height);
        }


    }

    public void setVideoEventListener(VideoEventListener videoEventListener) {
        this.videoEventListener = videoEventListener;
    }
}
