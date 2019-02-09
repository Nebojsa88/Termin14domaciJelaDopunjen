package com.aad.termin14domacijela.activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.aad.termin14domacijela.R;
import com.aad.termin14domacijela.model.Jelo;
import com.aad.termin14domacijela.provider.JeloProvider;

import java.util.List;

public class FirstActivity extends Activity  {

    ListView listView1;
    private static ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        listView1 = findViewById(R.id.list_view);


        loadData();
        // for(final Jelo jelo: Jelo.JELA) {
        //    Button button = new Button(this);
        //    button.setText(jelo.getNaziv());
        //    button.setOnClickListener(new View.OnClickListener() {
        //        @Override
         //       public void onClick(View v) {
         //           Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
          //          intent.putExtra("id", jelo.getId());
          //          startActivity(intent);
          //      }
         //   });
          //
          //  LinearLayout layout = findViewById(R.id.linear_layout);
           // layout.addView(button);


       // }

   }

   private void loadData(){
        GetDataAsyncTask getDataAsyncTask = new GetDataAsyncTask();
        getDataAsyncTask.execute();
   }

   private void showData(List<String> naziviJela){
       ArrayAdapter dataAdapter = new ArrayAdapter(FirstActivity.this, android.R.layout.simple_list_item_1, naziviJela);
       ListView listView =  findViewById(R.id.list_view);
       listView.setAdapter(dataAdapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
               intent.putExtra("position", position);
               startActivity(intent);

           }
       });
   }

    public void showProgressDialog(){
        if (dialog == null){
            dialog = new ProgressDialog(this);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setIndeterminate(true);
            dialog.setMessage("Loading data...");
        }
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    public void hideDialog(){
        if (dialog != null && dialog.isShowing()){
            dialog.dismiss();
        }
    }

    private class GetDataAsyncTask extends AsyncTask<Void, Void, List<String>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgressDialog();
        }

        @Override
        protected List<String> doInBackground(Void... voids) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return JeloProvider.getJalaNames();
        }

        @Override
        protected void onPostExecute(List<String> strings) {
            super.onPostExecute(strings);
            hideDialog();
            showData(strings);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            hideDialog();
        }
    }
}
