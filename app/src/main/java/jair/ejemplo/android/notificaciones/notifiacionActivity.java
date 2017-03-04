package jair.ejemplo.android.notificaciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class notifiacionActivity extends AppCompatActivity {
   // String texto;
  //  String title;
   TextView textView;
    public static final  String TITLE= "titulo";
    public static final String TEXT="texto";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifiacion);
        textView = (TextView) findViewById(R.id.texto);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String texto = intent.getStringExtra("texto");
         if(title != null)
             setTitle(title);
         if(texto != null)
             textView.setText(title+"    "+texto);
        textView.setTextSize(20);
    }
}
