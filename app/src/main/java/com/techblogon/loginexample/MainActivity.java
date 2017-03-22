//package com.techblogon.loginexample;
//
//import android.app.ActionBar;
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//
//import com.techblogon.loginexample.instance_recorders.Audio;
//import com.techblogon.loginexample.instance_recorders.Camera;
//import com.techblogon.loginexample.instance_recorders.Video;
//
//public class MainActivity extends Activity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.mainactivity);
//        getActionBar().setDisplayShowTitleEnabled(false);
//        View mActionBarView = getLayoutInflater().inflate(R.layout.my_action_bar, null);
//        getActionBar().setCustomView(mActionBarView);
//        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_mainactivity, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
////        This switch statement switches between the diffrent menu items
////        There is an error that was very persistent whereby the app was crashing on starting a new activity. The reason was
////        that the parent class extends Activity while I was trying to open a child class that extends AppCompatActivity
////        AppCompatActivity activity does not work with material theme. It only works whith appcompat themes
//        switch (item.getItemId()){
//            case R.id.take_picture:
//            Intent startCameraActivity = new Intent(this, Camera.class);
//            startActivity(startCameraActivity);
//            return true;
//
//            case R.id.record_audio:
//            Intent startAudioActivity = new Intent(this, Audio.class);
//            startActivity(startAudioActivity);
//            return true;
//
//            case R.id.record_video:
//                Intent startVideoActivity = new Intent(this, Video.class);
//                startActivity(startVideoActivity);
//                return true;
//
////            case R.id.take_note:
////                Intent startNoteActivity = new Intent(this, Note.class);
////                startActivity(startNoteActivity);
////                return true;
//
//        }
//        return super.onOptionsItemSelected(item);
//    }
//}
package com.techblogon.loginexample;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;

import com.techblogon.loginexample.instance_recorders.Audio;
import com.techblogon.loginexample.instance_recorders.Camera;
import com.techblogon.loginexample.instance_recorders.Note.TakeNote;
import com.techblogon.loginexample.instance_recorders.Video;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;

    FloatingActionButton fab_plus,fab_twitter,fab_fb;
    Animation fab_open,fab_close,fabR_clockwise,fabR_anticlockwise;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 


        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();


        nvDrawer= (NavigationView)findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);

        drawerToggle.syncState();;


    }



    private ActionBarDrawerToggle setupDrawerToggle(){
        return new ActionBarDrawerToggle(this, mDrawer,toolbar,R.string.drawer_open,R.string.drawer_close);

    }




    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                }
        );

    }

    public void selectDrawerItem(MenuItem menuItem){
//        //create a new fragmennt and specify the fragment to show based on nav item clicked
//        Fragment fragment = null;
//        Class fragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.nav_camera:
                Intent i = new Intent(this, Camera.class);
                startActivity(i);
                break;
            case R.id.nav_video:
                Intent video= new Intent(this, Video.class);
                startActivity(video);
                break;



            case R.id.nav_audio:
                Intent audio= new Intent(this,Audio.class);
                startActivity(audio);
                break;

            case R.id.nav_take_note:
                Intent note = new Intent(this, TakeNote.class);
                startActivity(note);
                break;







            default:
                Intent x = new Intent(this, Audio.class);
                startActivity(x);




        }
//        try {
//            fragment=(Fragment) fragmentClass.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();

//        }
////insert the fragment by replacing any existing fragment
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.flContent,fragment).commit();
//
//        //Highlight the selected item has been done by the Navigation View
//        menuItem.setChecked(true);
//        //set action bar title
//        setTitle(menuItem.getTitle());
//        mDrawer.closeDrawers();

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;

        }

        return super.onOptionsItemSelected(item);
    }


}

