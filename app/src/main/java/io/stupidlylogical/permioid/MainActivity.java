package io.stupidlylogical.permioid;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Permioid";
    private Button requestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] permissions = {
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
        };

        final Permioid permioid = new Permioid();
        permioid.setContext(this);
        permioid.setPermissions(permissions);
        requestButton = findViewById(R.id.request_button);
        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!permioid.checkAllPermissions()) {
                    Log.d(TAG, "Not given");
                    permioid.requestAllPermissions();
                }
            }
        });
    }
}
