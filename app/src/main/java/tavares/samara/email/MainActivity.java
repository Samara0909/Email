package tavares.samara.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //obtemos o botao atraves do metodo findViewByld
        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);
         // Definicao da acao do click do botao
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etEmail = (EditText) findViewById(R.id.etEmail);
                String email = etEmail.getText().toString();

                EditText etAssunto = (EditText) findViewById(R.id.etAssunto);
                String assunto = etAssunto.getText().toString();

                EditText etTexto = (EditText) findViewById(R.id.etTexto);
                String texto = etTexto.getText().toString();

                 //criacao do intent sem uma tabela definida
                 Intent i = new Intent(Intent.ACTION_SENDTO);
                    //Definimos que so estamos interessados em app que resolvem o URI "mailto"
                    i.setData(Uri.parse("mailto:"));
                //preenchimento do intent com os dados que queremos enviar para a app externa que vai enviar ao email
                    String[] emails = new String[]{email};
                    i.putExtra(Intent.EXTRA_EMAIL, emails);
                    i.putExtra(Intent.EXTRA_SUBJECT, assunto);
                    i.putExtra(Intent.EXTRA_TEXT, texto);
                    try {
                  //execucao do intent
                    startActivity(Intent.createChooser(i, "Escolha o APP"));
                     }
                    catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, "Não há nenhum app que posso realizar essa operação",
                            Toast.LENGTH_LONG).show();

         }
     }
          });


    }
}