package ru.nikita.linegraph.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.nikita.linegraph.R
import ru.nikita.linegraph.databinding.FragmentGraphBinding



class GraphFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGraphBinding.inflate(inflater, container, false)


        binding.backButton.setOnClickListener {
            findNavController().popBackStack(R.id.startFragment, false)
        }

        return binding.root
    }

}