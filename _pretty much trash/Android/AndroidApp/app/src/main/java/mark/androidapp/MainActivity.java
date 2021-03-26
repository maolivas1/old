package mark.androidapp;

import android.content.Intent;
import android.hardware.Camera;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "mark.myapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                TextView textcount = (TextView)findViewById(R.id.textCount);
                textcount.setText(String.valueOf(seekBar.getProgress()));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        switch (item.getItemId()) {
            case R.id.action_search:
                intent.putExtra(EXTRA_MESSAGE, "case1");
                startActivity(intent);
                return true;
            case R.id.action_settings:
                intent.putExtra(EXTRA_MESSAGE, "case2");
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    boolean camera = false;
     Camera cam = Camera.open();
    Camera.Parameters p = cam.getParameters();

    @Override
    protected void onStop() {
        super.onStop();
        if (cam != null) {
            cam.release();
            toast("Light Turned Off");
        }
    }

    public void sendMessage(View view) {
        EditText editText = (EditText)findViewById(R.id.edit_message);
        String msg = editText.getText().toString();
        String[] args = msg.split(" ");

        if (msg.equals("light")) {
            if (camera == false) {
                p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                cam.setParameters(p);
                cam.startPreview();
                toast("Light Turned On");
                camera = true;
            } else {
                p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                cam.setParameters(p);
                cam.stopPreview();
                toast("Light Turned Off");
                camera = false;
            }
        } else editText.setText("");
    }

    public void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_LONG).show();
    }

}
