package com.soluts.filiperibeiro.solutis;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.solutis.filiperibeiro.solutis.Model.Capsula;

import java.util.ArrayList;
import java.util.List;

public class CapsulaAdapter extends ArrayAdapter<Capsula> {

    private final Context contexto;
    private final ArrayList<Capsula> capsulas;

    public CapsulaAdapter( Context contexto, ArrayList<Capsula> capsulas) {
        super(contexto, R.layout.row, capsulas);
        this.contexto = contexto;
        this.capsulas = capsulas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){


        LayoutInflater layoutInflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = layoutInflater.inflate(R.layout.row,parent, false);

        TextView nomecapsula = (TextView) row.findViewById(R.id.nomeCapsula);
        TextView saborCapsula = (TextView) row.findViewById(R.id.saborCapsula);
        ImageView imagem = (ImageView) row.findViewById(R.id.imageview);

        nomecapsula.setText(capsulas.get(position).getNomeCapsula());
        saborCapsula.setText(capsulas.get(position).getSaborCapsula());
        imagem.setImageResource(R.drawable.coffee);

        return row;
    }
}
