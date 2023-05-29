package com.knightshrestha.neonnovels.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.knightshrestha.neonnovels.databinding.FragmentDetailsBinding
import java.text.SimpleDateFormat
import java.util.Locale

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val args: DetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        val root = binding.root

        val data = args.seriesItem



        binding.textTitleDetail.text = data.title
        binding.textUpdatedAtDetail.text = "Updated at " + SimpleDateFormat(
            "dd MMMM, yyyy 'at' hh:mm aa",
            Locale("en", "NP")
        ).format(data.updatedAt)
        binding.textAuthorDetail.text = data.author
        binding.textGenresDetail.text = data.genres.toString()
        Glide.with(requireContext()).load(data.thumbnail).into(binding.imageThumbnailDetail)

        binding.textSynopsisDetail.text = data.synopsis
        binding.textAliasDetail.text = data.alias.toString()



        return root
    }


}