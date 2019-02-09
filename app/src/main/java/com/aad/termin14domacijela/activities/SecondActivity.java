package com.aad.termin14domacijela.activities;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.aad.termin14domacijela.R;
import com.aad.termin14domacijela.model.Category;
import com.aad.termin14domacijela.model.Jelo;
import com.aad.termin14domacijela.provider.CategoryProvider;
import com.aad.termin14domacijela.provider.JeloProvider;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SecondActivity extends Activity {

    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constrain_layout);

        if(savedInstanceState != null ){
            this.position = savedInstanceState.getInt("position");

        }
        position = getIntent().getIntExtra("position", 0);

        ImageView iv = findViewById(R.id.imageView);

            InputStream is = null;
        try{
             is = getAssets().open(JeloProvider.getJeloById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            iv.setImageDrawable(drawable);

        }catch (IOException e){
            e.printStackTrace();
        }
        TextView tvName = findViewById(R.id.textView_naziv);
        tvName.setText(JeloProvider.getJeloById(position).getNaziv());

        TextView tvDescription = findViewById(R.id.textView_opis);
        tvDescription.setText(JeloProvider.getJeloById(position).getOpis());

        TextView tvSastojci = findViewById(R.id.textView_sastojci);
        tvSastojci.setText(JeloProvider.getJeloById(position).getSastojci());

        TextView tvKalVrednost = findViewById(R.id.textView_kal_vrednost);
        tvKalVrednost.setText(Integer.toString(JeloProvider.getJeloById(position).getKalorijskaVrednost()));

        TextView tvCena = findViewById(R.id.textView_cena);
        tvCena.setText(Double.toString(JeloProvider.getJeloById(position).getCena()));

        RatingBar rb = findViewById(R.id.ratingBar);
        rb.setRating(JeloProvider.getJeloById(position).getRating());

        Spinner sp = findViewById(R.id.spinner_category);
        List<Category> categories = CategoryProvider.getCategories();
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);
        sp.setAdapter(adapter);


    }
    public void onClick(View v){
        Toast.makeText(this, "You just buy "+ JeloProvider.getJeloById(position).getNaziv() + " Thank you!", Toast.LENGTH_SHORT).show();
    }
}
