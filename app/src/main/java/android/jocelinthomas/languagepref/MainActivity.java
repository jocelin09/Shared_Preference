package android.jocelinthomas.languagepref;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SharedPreferences sharedPreferences;

    private void setLanguage(String language) {

        sharedPreferences.edit().putString("language",language).apply();
        Log.i("language",language);
        textView.setText(language);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        sharedPreferences = this.getSharedPreferences("android.jocelinthomas.languagepref", MODE_PRIVATE);

        String language = sharedPreferences.getString("language", "");
        if (language == "")
        {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Choose a language")
                .setMessage("Which language would you like ?")
                .setPositiveButton("English", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        setLanguage("English");
                    }
                }).setNegativeButton("Hindi", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                setLanguage("Hindi");
            }
        }).show();

        }
        else
        {
            textView.setText(language);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);

         if (item.getItemId() == R.id.english)
         {
             setLanguage("English");
         }
         else if (item.getItemId() == R.id.hindi)
         {
             setLanguage("Hindi");
         }

         return true;

    }
}
