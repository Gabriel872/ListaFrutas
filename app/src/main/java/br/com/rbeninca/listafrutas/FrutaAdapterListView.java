package br.com.rbeninca.listafrutas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;


class FrutaAdapterListView extends ArrayAdapter<Fruta>{

    Context mContext;
    int mResource;
    Fruta[] frutas;

    public FrutaAdapterListView(@NonNull Context context, int resource, @NonNull Fruta[] objects) {
        super(context, resource, objects);
        mContext=context;
        mResource = resource;
        frutas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource,parent, false);

        //Associando objetos da interface a identificadores locais

        TextView tvCodigo = convertView.findViewById(R.id.tvCodigo);
        TextView tvPreco = convertView.findViewById(R.id.tvPreco);

        ImageView imageView = convertView.findViewById(R.id.imageView);

        //Recuperando um objeto do data set, na posição position

        Fruta f = getItem(position);

        DecimalFormat df = new DecimalFormat( "#,###.00");

        //Populando as views do layout inflado

        tvCodigo.setText(Integer.toString(f.getCodigo()));

        imageView.setImageResource(f.getImagem());

        tvPreco.setText(df.format(f.getPreco()));

        return convertView;
    }


}
