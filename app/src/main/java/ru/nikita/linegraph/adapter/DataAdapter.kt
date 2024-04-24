package ru.nikita.linegraph.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.nikita.linegraph.databinding.ItemsBinding
import ru.nikita.linegraph.dto.DataModel

class DataAdapter : ListAdapter<DataModel, DataViewHolder>(DataDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val marks = getItem(position)
        holder.bind(marks)
    }
}

class DataViewHolder(
    private val binding: ItemsBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: DataModel) {
        binding.valueValue.text = data.value.toString()
        binding.typeValue.text = data.type.toString()
        binding.timeValue.text = data.time
    }
}


class DataDiffCallback : DiffUtil.ItemCallback<DataModel>() {
    override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
        return oldItem == newItem
    }
}