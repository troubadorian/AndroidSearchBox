package com.troubadorian.mobile.android.androidsearchbox;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class AndroidSearchBoxActivity extends Activity
{
    private ListView listView;

    private EditText editText;

    private String mArray[] =
    { "Android", "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "ICS" };
    
    private ArrayList<String> mArrayList = new ArrayList<String>();

    private ArrayList<String> mArrayListSort = new ArrayList<String>();

    int textlength = 0;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mArrayList.add("Android");
        mArrayList.add("Cupcake");
        mArrayList.add("Donut");
        mArrayList.add("Eclair");
        mArrayList.add("Froyo");
        mArrayList.add("Gingerbread");
        mArrayList.add("ICS");
        mArrayList.add("JellyBean");
        
        listView = (ListView) findViewById(R.id.ListView01);
        editText = (EditText) findViewById(R.id.EditText01);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mArrayList));
        editText.addTextChangedListener(new TextWatcher()
        {

            public void afterTextChanged(Editable s)
            {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

                textlength = editText.getText().length();
                mArrayListSort.clear();
                for (int i = 0; i < mArrayList.size(); i++)
                {
                    if (textlength ==0)
                    {
                        mArrayListSort.clear();
                    }
                    
                    if (textlength <= mArrayList.get(i).length())
                    {
                        if (editText.getText().toString().equalsIgnoreCase((String) mArrayList.get(i).subSequence(0, textlength)))
                        {
                            mArrayListSort.add(mArrayList.get(i));
                        }
                    }
                    
                }

                listView.setAdapter(new ArrayAdapter<String>(AndroidSearchBoxActivity.this, android.R.layout.simple_list_item_1, mArrayListSort));

            }
        });

    }
}