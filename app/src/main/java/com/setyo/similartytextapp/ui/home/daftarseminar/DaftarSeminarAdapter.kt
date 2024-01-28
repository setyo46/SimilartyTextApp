package com.setyo.similartytextapp.ui.home.daftarseminar

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.setyo.similartytextapp.R
import com.setyo.similartytextapp.data.remote.response.DetsemproDataItem
import com.setyo.similartytextapp.databinding.ItemRowDaftarSeminarBinding

class DaftarSeminarAdapter(private val detSempro: List<DetsemproDataItem>):RecyclerView.Adapter<DaftarSeminarAdapter.ListViewHolder>() {

    inner class ListViewHolder(private val binding: ItemRowDaftarSeminarBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(detSempro: DetsemproDataItem) {
            binding.apply {
                textViewNim.text = detSempro.nimDetsempro
                textViewName.text = detSempro.namaDetsempro
                when(detSempro.statusDafsempro) {
                    "1" -> {
                        textViewStatus.setText(R.string.initial_status_accept)
                        textViewStatus.setTextColor(Color.GREEN)
                    }
                    "2" -> {
                        textViewStatus.setBackgroundColor(R.string.initial_status_rejected)
                        textViewStatus.setTextColor(Color.RED)
                    }
                    else -> {
                        textViewStatus.setBackgroundColor(R.string.initial_status_waiting)
                        textViewStatus.setTextColor(Color.YELLOW)
                    }
                }
                textViewDate.text = detSempro.tanggalDafsempro
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowDaftarSeminarBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(detSempro[position])
    }

    override fun getItemCount(): Int = detSempro.size

}