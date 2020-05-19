package com.example.orientationlistviewproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.muddzdev.styleabletoast.StyleableToast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Dialogs.dialoglisren{
ListView lightsabers;
ArrayList<lightsaber> lightsaberArrayList;
TextView appears;
TextView powerindex;
CustomAdapter customAdapter;
Button movie;
String key;
String key2;
String key3;
Boolean whicht;
String key4;
int kappastore;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout constraintLayout = findViewById(R.id.constrain);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        lightsabers = findViewById(R.id.list);
        appears = findViewById(R.id.appear);
        powerindex = findViewById(R.id.power);

        movie = findViewById(R.id.movie);
        button = findViewById(R.id.button2);
        key = "JoeM";
        key2 = "JoeMa";
        key3 = "JoeMam";
        whicht = false;
        key4 = "JoeMama";

        lightsaberArrayList = new ArrayList<>();
        if(savedInstanceState == null) {
            lightsaber jeff = new lightsaber("Dyn Jarren", R.drawable.darksaber, "The Mandalorian", 7, "An ancient and unique black lightsaber for the mandalorians. Extremely cool design and breaks conventional design");
            lightsaberArrayList.add(jeff);
            jeff = new lightsaber("Greivous", R.drawable.grevious, "Revenge of the sith", 10, "4 lightsabers are better than one. Known as the spirit sabers these lightsabers favor overwhelming strength over anything");
            lightsaberArrayList.add(jeff);
            jeff = new lightsaber("Darth Maul", R.drawable.maul, "The Phantom Menace", 5, "Dope lightsaber but is consistently over-powered by other smaller sabers");
            lightsaberArrayList.add(jeff);
            jeff = new lightsaber("The Guards", R.drawable.protosaber, "The comics", 4, "Original lightsaber which was used. Largely irrelevant now. The temple guards still use them");
            lightsaberArrayList.add(jeff);
            jeff = new lightsaber("Mace Windu", R.drawable.windu, "Phantom Menace", 4, "Mace Windu's purple lightsaber. Extremely stylish but is an overall basic lightsaber lacking ");
            lightsaberArrayList.add(jeff);
            jeff = new lightsaber("Lego Yoda", R.drawable.lyoda, "Lego Star Wars", 99, "Hmmm. Yoda it is. Why I put? Know I not. Cool it is. Stylish it is. Yoda it is.");
            lightsaberArrayList.add(jeff);
            jeff = new lightsaber("The Guard", R.drawable.shadowguard, "Force Unleased Comic", 3, "Spear mixed with a lightsaber at the end. But is prone to counter-attacks and seems weird to use a spear which limits motion");
            lightsaberArrayList.add(jeff);
            jeff = new lightsaber("Maris Brood", R.drawable.broodsaber, "The Old Republic", 5, "Extremely defensive sabers, however they lack power for hits. They are overall very meh.");
            lightsaberArrayList.add(jeff);
            jeff = new lightsaber("Lumiya", R.drawable.lightwhip, "The Comics", 7, " Very strong weapon which can dominate in fights but if you miss one attack you will get destroyed.");
            lightsaberArrayList.add(jeff);
            jeff = new lightsaber("Gonk Droid", R.drawable.gonk, "Ever since existance", 999, "Besides the fact it blows itself up... easily the best character in the franchise. LITERALLY!");
            lightsaberArrayList.add(jeff);
        }else {
            lightsaberArrayList = savedInstanceState.getParcelableArrayList(key);
            System.out.println(lightsaberArrayList);
            powerindex.setText(savedInstanceState.getString(key2));
            appears.setText(savedInstanceState.getString(key3));
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                TextView descrip = findViewById(R.id.desc);
                int x = savedInstanceState.getInt(key4);
                if(x==-1) {
                    descrip.setText("Personal Opinion: not clicked");
                }else {
                    descrip.setText("Personal Opinion: " + lightsaberArrayList.get(x).getDescription());
                }
            }
        }
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.adapter_custom ,lightsaberArrayList);
        lightsabers.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();
    }

    public class CustomAdapter extends ArrayAdapter<lightsaber> {
        Context parentConetext;
        List<lightsaber> list;
        int xmlResources;


        public CustomAdapter(@NonNull Context context, int resource, @NonNull List objects) {
            super(context, resource, objects);
            parentConetext = context;
            xmlResources = resource;
            list = objects;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) parentConetext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View adapterView = layoutInflater.inflate(xmlResources, null);
            ConstraintLayout constraintLayout = findViewById(R.id.constrain);
            AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
            animationDrawable.setEnterFadeDuration(2000);
            animationDrawable.setExitFadeDuration(4000);
            animationDrawable.start();
            final TextView appearz = findViewById(R.id.appear);
            final TextView powerinde = findViewById(R.id.power);
            final TextView descr = findViewById(R.id.desc);
            TextView name = adapterView.findViewById(R.id.chara);
            final Button remove = adapterView.findViewById(R.id.remove);
            final Button clone = adapterView.findViewById(R.id.clone);
            ImageView images = adapterView.findViewById(R.id.saber);
            name.setText("Name of User: " + list.get(position).getName());
            int hold = (list.get(position).getID());
            System.out.println(hold);
            images.setImageResource(hold);
            //insert onclick listener
            if (remove != null)
                remove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                            descr.setText("Deleted! Click New Element!");
                        powerinde.setText("Click Value");
                        appearz.setText("Please Click Appearance"+" ");
                        System.out.println("Yeetivus");
                        lightsaberArrayList.remove(position);
                        lightsabers.invalidateViews();
                        showRemoveText();
                    }
                });
            lightsabers.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    System.out.println(list.get(position).getPower());
                    kappastore = position;
                    powerinde.setText("Power: " + list.get(position).getPower());
                    appearz.setText("First Appearance: " + list.get(position).getAppearances() + "  ");
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                        descr.setText("Personal Opinion: " + list.get(position).getDescription());
                }
            });
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                clone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lightsaberArrayList.add(list.get(position));
                        lightsabers.invalidateViews();
                        showAddText();
                    }
                });
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                movie.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showChangeText();
                        openActivity2();
                    }
                });

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openDialog();
                    }
                });

            }


            return adapterView;
        }
    }
    protected void onSaveInstanceState(Bundle outState) {
        appears = findViewById(R.id.appear);
        powerindex = findViewById(R.id.power);
        outState.putParcelableArrayList(key, lightsaberArrayList);
        String rtemp = (String)appears.getText();
        outState.putString(key2, rtemp);
        String temp = (String)powerindex.getText();
        outState.putString(key3, temp);
        int temzp = 0;
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        System.out.println(lightsaberArrayList);
        Boolean wavecheck = false;
        int x = -1;
            for(lightsaber l : lightsaberArrayList){
                x++;
                if(("First Appearance: "+l.getAppearances()+"  ").equals(rtemp)){
                wavecheck = true;
                System.out.println("Yeet");
                System.out.println("KEY"+x);
                outState.putInt(key4, x);
                break;
            }
            System.out.println("YEETED");
        }
            if(wavecheck == false)
                outState.putInt(key4, -1);
        super.onSaveInstanceState(outState);
    }


    public void showRemoveText(){
        StyleableToast.makeText(this, "Successfully Removed", R.style.mytoast).show();
    }
    public void showAddText(){
        StyleableToast.makeText(this, "Successfully Added", R.style.myaddtoast).show();
    }
    public void showChangeText(){
        StyleableToast.makeText(this, "Transferring to Movie", R.style.entertoast).show();
    }
    @Override
    public void applyTexts(String u, int i, String ap, int po, String desc){
        String name = u;
        String appears = ap;
        int power = po;
        String des = desc;
        Boolean hold = false;
        int imageid = (i);
        if(i == 700130) {
            imageid = R.drawable.broodsaber;
            hold = true;
        }else if(i ==700051){
            imageid = R.drawable.darksaber;
            hold = true;
        }else if(i == 700073){
            imageid = R.drawable.gonk;
            hold = true;
        }else if(i == 700002){
            imageid = R.drawable.grevious;
            hold = true;
        }else if(i == 700011){
            imageid = R.drawable.lightwhip;
            hold = true;
        }else if(i == 700040){
            imageid = R.drawable.lyoda;
            hold = true;
        }else if(i == 700006){
            imageid = R.drawable.maul;
            hold = true;
        }else if(i == 700102){
            imageid = R.drawable.windu;
            hold = true;
        }else if(i == 700088){
            imageid = R.drawable.shadowguard;
            hold = true;
        }else if(i == 700075){
            imageid = R.drawable.ren;
            hold = true;
        }else if(i == 700119) {
            imageid = R.drawable.protosaber;
            hold = true;
        }
              //  -700130
        if(hold) {
            try {
                lightsaber sud = new lightsaber(name, imageid, appears, power, desc);
                lightsaberArrayList.add(sud);
                lightsabers.invalidateViews();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            StyleableToast.makeText(this, "Wrong Information", R.style.mytoast).show();
        }
    }
    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
        whicht = true;
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void openDialog(){
        Dialogs dialog = new Dialogs();
        dialog.show(getSupportFragmentManager(), "Dialog");
    }
    public void finish(){
        super.finish();
        if(whicht) {
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else{
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }
}


