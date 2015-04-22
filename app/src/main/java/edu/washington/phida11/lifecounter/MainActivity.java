package edu.washington.phida11.lifecounter;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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

                TextView playerName = (TextView) playerLayout.findViewById(R.id.personTitle);
                String fullName = getResources().getString(R.string.player_name) + i + 1;

                //Sets the player name
                playerName.setText(fullName);

                lifeTracker.add(new Player(playerLayoutID, fullName));
            }
        }
    }

    public void clickFunction(View v) {
        RelativeLayout player = (RelativeLayout) v.getParent();
        String playerID = v.getResources().getResourceName(player.getId());

        TextView life = (TextView) player.findViewById(R.id.life);

        int index = Integer.parseInt(playerID.substring(playerID.length() -1)) - 1;
        Player current = lifeTracker.get(index);

        switch (v.getTag().toString()) {
            case "pos1": current.changeLife(1);
                break;
            case "pos5": current.changeLife(5);
                break;
            case "neg1": current.changeLife(-1);
                break;
            case "neg5": current.changeLife(-5);
                break;
        }

        if (current.getLife() <= 0) {
            Context context = getApplicationContext();
            CharSequence text = current.getName() + " LOSES!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            life.setText("0");
        } else {
            life.setText(current.getLife());
        }

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
