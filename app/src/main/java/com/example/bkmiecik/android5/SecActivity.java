package com.example.bkmiecik.android5;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import android.widget.Toast;

public class SecActivity extends AppCompatActivity{

    TextView t1;
    TextView t2;

    int suma =0;

    private ActionMode mojActionMode;

    private ActionMode.Callback myInterface = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            menu.add(1,10,1,"Szare").setIcon(android.R.drawable.ic_dialog_map);
            menu.add(1,11,1,"Białe").setIcon(android.R.drawable.ic_dialog_dialer);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            mode.setTitle("Zmień tło");
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item)
        {
            switch (item.getItemId()) {
                case 10:
                    t1.setBackgroundColor(getResources().getColor(R.color.grey));
                    t1.setTextColor(getResources().getColor(R.color.white));
                    mode.finish(); // Action picked, so close the CAB
                    return true;
                case 11:
                    t1.setBackgroundColor(getResources().getColor(R.color.white));
                    t1.setTextColor(getResources().getColor(R.color.grey));
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

        registerForContextMenu(t2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,1,0,"Pogrubienie");
        menu.add(0,2,0,"Kursywa");
        menu.setHeaderTitle("Ustaw styl");
        menu.setHeaderIcon(android.R.drawable.ic_menu_edit);
        menu.setGroupCheckable(0,true,false);
        if(suma==1){
            menu.getItem(0).setChecked(true);
            menu.getItem(1).setChecked(false);
        }
        else if(suma==2){
            menu.getItem(1).setChecked(true);
            menu.getItem(0).setChecked(false);
        }
        else if(suma==3){
            menu.getItem(0).setChecked(true);
            menu.getItem(1).setChecked(true);
        }
        else{
            menu.getItem(0).setChecked(false);
            menu.getItem(1).setChecked(false);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                if(!item.isChecked())
                suma++;
                else suma--;
                t2.setTypeface(null, suma);
                break;
            case 2:
                if(!item.isChecked())
                suma+=2;
                else suma-=2;
                t2.setTypeface(null, suma);
            default: super.onOptionsItemSelected(item);
        }
        return true;
    }

}
