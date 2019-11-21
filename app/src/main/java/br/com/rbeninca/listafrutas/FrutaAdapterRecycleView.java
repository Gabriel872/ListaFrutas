package br.com.rbeninca.listafrutas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

class FrutaAdapterRecyclerView extends RecyclerView.Adapter<FrutaAdapterRecyclerView.MyViewHolder> {

    Context mContext;
    int mResource;
    Fruta[] mDatabaset;

    public FrutaAdapterRecyclerView(Context mContext, int mResource, Fruta[] mDatabaset) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.mDatabaset = mDatabaset;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View convertView = layoutInflater.inflate(mResource,parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(convertView);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Fruta f = mDatabaset[position];

        DecimalFormat df = new DecimalFormat( "#,###.00");

        //------------------Populando as views do layout inflado------------------

        holder.tvCodigo.setText(Integer.toString(f.getCodigo()));
        holder.tvNome.setText(f.getNome());
        holder.imageView.setImageResource(f.getImagem());
        holder.tvPrecoVenda.setText(df.format(f.getPreco_venda()));
        holder.tvPreco.setText(df.format(f.getPreco()));

    }

    @Override
    public int getItemCount() {
        return mDatabaset.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvCodigo, tvPreco, tvNome, tvPrecoVenda;

        ImageView imageView;

        public MyViewHolder(@NonNull View convertView) {
            super(convertView);

          tvCodigo = (TextView) convertView.findViewById(R.id.tvCodigo);
          tvNome = (TextView) convertView.findViewById(R.id.tvNome);
          tvPreco = (TextView) convertView.findViewById(R.id.tvPreco);
          tvPrecoVenda = (TextView) convertView.findViewById(R.id.tvPrecoVenda);
          imageView = (ImageView) convertView.findViewById(R.id.imageView);

        }
    }

}
