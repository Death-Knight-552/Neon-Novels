package com.knightshrestha.neonnovels.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.knightshrestha.neonnovels.databinding.FragmentHomeBinding
import com.knightshrestha.neonnovels.datasources.local.database.LocalViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var homeLocalListAdapter: HomeLocalListAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val viewModel = ViewModelProvider(this)[LocalViewModel::class.java]

        val listView = binding.rvLocalListHome

        viewModel.allBooks.observe(viewLifecycleOwner) {
            listView.apply {
                adapter = HomeLocalListAdapter(it)
                layoutManager = LinearLayoutManager(context)
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}