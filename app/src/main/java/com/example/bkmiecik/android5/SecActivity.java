package com.example.bkmiecik.android5;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecActivity extends AppCompatActivity{

    TextView t1;
    TextView t2;

    private ActionMode mojActionMode;

    private ActionMode.Callback myInterface = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            menu.add(1,10,1,"DUPA");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            mode.setTitle("Action");
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item)
        {
            switch (item.getItemId()) {
                case 10:
                    Toast.makeText(SecActivity.this,"Działa",Toast.LENGTH_SHORT).show();
                    mode.finish(); // Action picked, so close the CAB
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mojActionMode = null;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);



        t1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if(mojActionMode!=null) return false;
                else{
                    mojActionMode = startActionMode(myInterface);
                    v.setSelected(true);
                    return true;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"Pogrubienie");
        menu.add(0,2,0,"Kursywa");
        menu.add(0,3,0,"Pogrubienie i kursywa");
        menu.add(0,4,0,"Podstawowy").setChecked(true);
        menu.setGroupCheckable(0,true,true);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case 1:
                if(!item.isChecked()){
                    item.setChecked(true);
                    t1.setTypeface(null, Typeface.BOLD);
                    t2.setTypeface(null, Typeface.BOLD);
                }
                break;
            case 2:
                if(!item.isChecked()){
                    item.setChecked(true);
                    t1.setTypeface(null, Typeface.ITALIC);
                    t2.setTypeface(null, Typeface.ITALIC);
                }
                break;
            case 3:
                if(!item.isChecked()){
                    item.setChecked(true);
                    t1.setTypeface(null, Typeface.BOLD_ITALIC);
                    t2.setTypeface(null, Typeface.BOLD_ITALIC);
                }
                break;
            case 4:
                if(!item.isChecked()){
                    item.setChecked(true);
                    t1.setTypeface(null, 0);
                    t2.setTypeface(null, 0);
                }
                break;
            default: super.onOptionsItemSelected(item);
        }
        return true;
    }

}
