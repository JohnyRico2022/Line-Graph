package ru.nikita.linegraph.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.nikita.linegraph.R
import ru.nikita.linegraph.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentStartBinding.inflate(inflater, container, false)


        binding.buttonGoToList.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_listFragment)
        }

        binding.buttonGoToGraph.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_graphFragment)
        }

        return binding.root
    }
}