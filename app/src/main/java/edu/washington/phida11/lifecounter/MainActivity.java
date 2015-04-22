package edu.washington.phida11.lifecounter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private ArrayList<Player> lifeTracker = new ArrayList<Player>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            for (int i = 0; i < 4; i++) {

                int playerLayoutID = getResources().getIdentifier(("player"+i+1), "id", getPackageName());
                RelativeLayout playerLayout = (RelativeLayout) findViewById(playerLayoutID);

                lifeTracker.add(new Player(playerLayoutID));

                TextView playerName = (TextView) playerLayout.findViewById(R.id.personTitle);

                //Sets the player name
                playerName.setText(getResources().getString(R.string.player_name) + i + 1);
            }
        }
    }

    public void clickFunction(View v) {
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
