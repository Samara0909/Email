package tavares.samara.email;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button btnEnviar = (Button) findViewById(R.id.btnEnviar); // Definicao da acao do click do botao
      btnEnviar.setOnClickListener(new View.OnClickListener() {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            public void onClick(View v) {

            });

        }
}