package com.example.fier;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 429285-2 on 04.10.2018.
 */
public class MainActivity extends AppCompatActivity {
    Button bp, bm, bx, bd, br;
    int cpos = 1;
    View pv = null;
    ListView listView;
    EditText editText;
    EditText input0, input1;
    TextView output0;
    ArrayList<String> listItems;// = new ArrayList<String>();
    private ArrayAdapter adapter;
    char sym='0';

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        listItems = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listView = (ListView) findViewById(R.id.listView);
        bp = (Button) findViewById(R.id.bp);
        bm = (Button) findViewById(R.id.bm);
        bx = (Button) findViewById(R.id.bx);
        bd = (Button) findViewById(R.id.bd);
        br = (Button) findViewById(R.id.bClear);
        input0 = (EditText) findViewById(R.id.et1);
        input1 = (EditText) findViewById(R.id.et2);
        bp_OnClickListener();
        bm_OnClickListener();
        bx_OnClickListener();
        bd_OnClickListener();
        br_OnClickListener();
    }

    private void bp_OnClickListener() {
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bp.setBackgroundColor(getResources().getColor(R.color.background_select));
                bm.setBackgroundColor(getResources().getColor(R.color.background));
                bx.setBackgroundColor(getResources().getColor(R.color.background));
                bd.setBackgroundColor(getResources().getColor(R.color.background));
                sym = '+';

            }
        });
    }

    private void bm_OnClickListener() {
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bm.setBackgroundColor(getResources().getColor(R.color.background_select));
                bp.setBackgroundColor(getResources().getColor(R.color.background));
                bx.setBackgroundColor(getResources().getColor(R.color.background));
                bd.setBackgroundColor(getResources().getColor(R.color.background));
                sym = '-';

            }
        });
    }

    private void bx_OnClickListener() {
        bx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bx.setBackgroundColor(getResources().getColor(R.color.background_select));
                bp.setBackgroundColor(getResources().getColor(R.color.background));
                bm.setBackgroundColor(getResources().getColor(R.color.background));
                bd.setBackgroundColor(getResources().getColor(R.color.background));
                sym = '*';

            }
        });
    }

    private void bd_OnClickListener() {
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.setBackgroundColor(getResources().getColor(R.color.background_select));
                bp.setBackgroundColor(getResources().getColor(R.color.background));
                bm.setBackgroundColor(getResources().getColor(R.color.background));
                bx.setBackgroundColor(getResources().getColor(R.color.background));
                sym = '/';

            }
        });
    }

    private void br_OnClickListener() {
        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bp.setBackgroundColor(getResources().getColor(R.color.background));
                bm.setBackgroundColor(getResources().getColor(R.color.background));
                bx.setBackgroundColor(getResources().getColor(R.color.background));
                bd.setBackgroundColor(getResources().getColor(R.color.background));
                //sym = '+';
                float i0 = Float.parseFloat(input0.getText().toString());
                float i1 = Float.parseFloat(input1.getText().toString());
                String result = "ERROR";
                try{
                    switch (sym){
                        case '+':
                            result = Float.toString(i0 + i1);
                            break;
                        case '-':
                            result = Float.toString(i0 - i1);
                            break;
                        case '*':
                            result = Float.toString(i0 * i1);
                            break;
                        case '/':
                            if (i1 != 0)
                                result = Float.toString(i0 / i1);
                            else
                                result = "ERROR";
                            break;
                        default:
                            result = "ERROR";
                            break;
                    }
                }catch (Exception e){result = "NULL EXCEPTION";}


            });

}

        );
    }
}

    protected void listView_onItemClickListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //listView.setBackgroundColor(getResources().getColor(R.color.pink));
                if (pv != null)
                    pv.setBackgroundColor(getResources().getColor(R.color.pink));

                view.setBackgroundColor(getResources().getColor(R.color.select));
                cpos = position;
                pv = view;

                String s = adapter.getItem(position).toString();
                editText.setText(s);

            }
        });
    };