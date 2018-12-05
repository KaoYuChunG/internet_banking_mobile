package com.example.xxx.internetbanking.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xxx.internetbanking.Models.Transacao;
import com.example.xxx.internetbanking.R;

import java.util.List;

public class TransacoesAdapter extends RecyclerView.Adapter<TransacoesAdapter.viewHolder> {
    private Context mContext;

    public List<Transacao> mList;


    public TransacoesAdapter(Context context, List<Transacao> list){
        this.mContext = context;
        this.mList = list;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View holder = inflater.inflate(R.layout.item_transacao, parent, false);
        viewHolder ViewHolder = new viewHolder(holder);

        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Transacao transacao = mList.get(position);

        String data = String.valueOf(transacao.data);
        String hora = String.valueOf(transacao.hora);
        String t = String.valueOf(transacao.id_tipo_transacao == 1 ? "débito" : "Crédito");
        String valor = String.valueOf(transacao.valor);



        holder.lbl_data.setText(data);
        holder.lbl_hora.setText(hora);
        holder.lbl_transacao.setText(t);
        holder.lbl_valor.setText(valor);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class viewHolder extends RecyclerView.ViewHolder  {

        public TextView lbl_data;
        public TextView lbl_hora;
        public TextView lbl_transacao;
        public TextView lbl_valor;

//        public ImageButton btn_lixeira;

        public viewHolder(View itemView) {
            super(itemView);

            lbl_data = itemView.findViewById(R.id.lblData);
            lbl_data = itemView.findViewById(R.id.lblhora);
            lbl_transacao = itemView.findViewById(R.id.lbltransacao);
            lbl_valor = itemView.findViewById(R.id.lblValor);

//            itemView.setOnClickListener(this);
        }
    }
}
