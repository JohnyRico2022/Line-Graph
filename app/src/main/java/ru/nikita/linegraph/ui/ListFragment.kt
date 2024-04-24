package ru.nikita.linegraph.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.nikita.linegraph.data.DataSource
import ru.nikita.linegraph.R
import ru.nikita.linegraph.adapter.DataAdapter
import ru.nikita.linegraph.databinding.FragmentListBinding


class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentListBinding.inflate(inflater, container, false)

        val list = DataSource().listWithData()

        val adapter = DataAdapter()
        binding.recyclerView.adapter = adapter
        adapter.submitList(list)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack(R.id.startFragment, false)
        }

        return binding.root
    }
}