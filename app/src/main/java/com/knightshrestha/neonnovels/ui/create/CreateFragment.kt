package com.knightshrestha.neonnovels.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.knightshrestha.neonnovels.databinding.FragmentCreateBinding
import com.knightshrestha.neonnovels.datasources.local.database.LocalViewModel
import com.knightshrestha.neonnovels.datasources.local.dataclass.LocalSeriesItem

class CreateFragment : Fragment() {

    private var _binding: FragmentCreateBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel = ViewModelProvider(this)[LocalViewModel::class.java]


        _binding = FragmentCreateBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.buttonSubmitCreate.setOnClickListener {
            viewModel.insertLocalItem(
                LocalSeriesItem(
                    title = binding.etTitleCreate.text.toString(),
                    synopsis = binding.etSynopsisCreate.text.toString(),
                    thumbnail = binding.etThumbnailCreate.text.toString(),
                    author = binding.etAuthorCreate.text.toString()
                )
            )
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}