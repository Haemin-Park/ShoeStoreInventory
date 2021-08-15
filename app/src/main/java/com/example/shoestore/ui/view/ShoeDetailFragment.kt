package com.example.shoestore.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeDetailBinding
import com.example.shoestore.model.Shoe
import com.example.shoestore.ui.viewmodel.ShoeStoreViewModel

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeStoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
            val name =
                if (binding.etShoeName.length() != 0) binding.etShoeName.text.toString() else "Default Name"
            val company =
                if (binding.etShoeCompany.length() != 0) binding.etShoeCompany.text.toString() else "Default Company"
            val size =
                if (binding.etShoeSize.length() != 0) binding.etShoeSize.text.toString() else "Default Size"
            val description =
                if (binding.etShoeDescription.length() != 0) binding.etShoeDescription.text.toString() else "Default description"
            viewModel.addShoe(Shoe(name, company, size, description))
        }
        binding.btnCancel.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }
    }
}