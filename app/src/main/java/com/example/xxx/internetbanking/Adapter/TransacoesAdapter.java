package com.example.xxx.internetbanking.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xxx.internetbanking.Models.DebitoAutomatico;
import com.example.xxx.internetbanking.Models.Transacao;
import com.example.xxx.internetbanking.R;
import com.example.xxx.internetbanking.conta.corrente.ExtratoActivity;

import java.util.List;

public class TransacoesAdapter extends RecyclerView.Adapter<TransacoesAdapter.viewHolder> {
    private Context mContext;
    private AdapterPositionOnClickListener mAadapterPositionOnClickListener;
    public List<Transacao> mList;


    public TransacoesAdapter(Context context, List<Transacao> list){
        this.mContext = context;
        this.mList = list;
    }

    public void setAdapterPositionOnClickListener(AdapterPositionOnClickListener click){
        mAadapterPositionOnClickListener = click;
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

        holder.lbl_data.setText(transacao.data);
        holder.lbl_hora.setText(transacao.hora);
        holder.lbl_transacao.setText(transacao.tipo_transacao);
        holder.lbl_valor.setText(String.valueOf(transacao.valor));
    }
    public Transacao getTransacao(int position)
    {
        return mList.get(position);
    }

    public void deleteItem(int positon){
        mList.remove(positon);
        notifyItemRemoved(positon);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }



    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mAadapterPositionOnClickListener != null){

                mAadapterPositionOnClickListener.setAdapterPositionOnClickListener(v, getPosition());
            }
        }
    }
}
