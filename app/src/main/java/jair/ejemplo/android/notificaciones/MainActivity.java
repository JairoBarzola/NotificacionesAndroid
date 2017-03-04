package jair.ejemplo.android.notificaciones;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    Button button;
    private final static int ID = 10;
    public long[] pattern = new long[]{1000,500,1000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.notificacion);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = "Texto de la notificacion";
                String titulo = "Titulo de la notificacion";
                Intent intent = new Intent(MainActivity.this,notifiacionActivity.class);
                intent.setAction("Notify");
                intent.putExtra("title",titulo);
                intent.putExtra("texto",texto);
                NotificationCompat.Builder builder = basicBuilder(titulo, texto, intent);//llenamos sus parametros
                Notification notification = builder.build(); // creamos la notificacion
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE); // creamos el adminsitrador de notificacion
                // las notificaciones tienen que tener un id
                notificationManager.notify(ID, notification);

            }
        });

    }

    private NotificationCompat.Builder basicBuilder(String title, String text, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this); // creamos la notificacion
        builder.setContentText(text);
        builder.setContentTitle(title);
        builder.setSmallIcon(R.drawable.ic_launcher)
                .setContentInfo("INFO")
                .setVibrate(pattern)
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND);

        if(intent != null){
            PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
            builder.setContentIntent(pendingIntent);
        }
        return builder;
    }


}