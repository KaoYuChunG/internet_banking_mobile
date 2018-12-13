package com.example.xxx.internetbanking.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xxx.internetbanking.Models.DebitoAutomatico;
import com.example.xxx.internetbanking.R;

import java.util.List;

public class DebitoAutomaticoAdapter extends RecyclerView.Adapter<DebitoAutomaticoAdapter.MyViewHolder> {

    private Context mContext;
    private AdapterPositionOnClickListener mAadapterPositionOnClickListener;
    public List<DebitoAutomatico> mList;

    public DebitoAutomaticoAdapter(Context context, List<DebitoAutomatico> list){
        this.mContext = context;
        this.mList = list;
    }

    //Inserir uma função de contato entre a activity e o Adapter
    public void setAdapterPositionOnClickListener(AdapterPositionOnClickListener click){
        mAadapterPositionOnClickListener = click;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View holder = inflater.inflate(R.layout.item_debito_automatico, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(holder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DebitoAutomatico debitoAutomatico = mList.get(position);

        holder.mId.setText(String.valueOf(debitoAutomatico.id));
        holder.mDescricao.setText(debitoAutomatico.descricao);
        holder.mCodigo.setText(String.valueOf(debitoAutomatico.codigo));
    }

    public DebitoAutomatico getDebitoAutomatico(int position)
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

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mId;
        public TextView mDescricao;
        public TextView mCodigo;

        public MyViewHolder(View itemView) {
            super(itemView);

            mId = itemView.findViewById(R.id.lb_debito_id);
            mDescricao = itemView.findViewById(R.id.lb_debito_descricao);
            mCodigo = itemView.findViewById(R.id.lb_debito_codigo);

//            Aplica a função do click na view toda
            itemView.setOnClickListener(this);

            // Aplica a função de click somente na foto
            // mFotoBtn.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            //Verificar se a ponte de contato entre o activity e o adapter foi passado
            if(mAadapterPositionOnClickListener != null){

                mAadapterPositionOnClickListener.setAdapterPositionOnClickListener(view, getPosition());
            }
        }
    }
}