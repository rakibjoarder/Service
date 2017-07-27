//http://www.vogella.com/tutorials/AndroidNotifications/article.html
package com.aust.rakib.intentservice;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {

    private static String TAG="IntentService";
   /* private Handler handler;*/
    private String msg;
    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"onCreate");

      /*  handler=new Handler(Looper.getMainLooper());*/

    }

    @Override
    protected void onHandleIntent(Intent intent) {                       //Background Thread a kaj kore

        Log.e(TAG,"Start");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {                             // it will show the notification After 2 sec
            e.printStackTrace();
        }
        msg=intent.getStringExtra("msg");

        ShowNotification(msg);
        /*handler.post(new Runnable() {                                    //To show the toast in MainThread from Background Thread/
            @Override
            public void run() {
                Toast.makeText(MyIntentService.this,msg, Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    private void ShowNotification(String msg) {
        Intent intent=new Intent(this,IntentServiceActivity.class);
        TaskStackBuilder taskStackBuilder=TaskStackBuilder.create(this);
        taskStackBuilder.addParentStack(IntentServiceActivity.class);
        taskStackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent=taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);  //To Return Back to the Activity



      //
        Notification notification=new Notification.Builder(this)
                .setContentTitle(msg)
                .setSmallIcon(R.drawable.icon)
                .setContentText(msg)
                .setAutoCancel(false)
                .setColor(Color.BLACK)
                .setPriority(Notification.PRIORITY_HIGH)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setContentIntent(pendingIntent)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);
                                                    //to Show the Notification
    }


    @Override
    public void onDestroy() {
        Log.e(TAG,"onDestroy");
        super.onDestroy();
    }
}
