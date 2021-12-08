package com.Abdul.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.Abdul.ViewModel.MainViewModel
import com.Abdul.database.UserDB
import com.Abdul.database.UserDatabase
import com.Abdul.databinding.FragmentDescriptionBinding
import com.bumptech.glide.Glide
import kotlinx.coroutines.*
import java.lang.RuntimeException

class DescriptionFragment : Fragment() {

    private var _binding: FragmentDescriptionBinding? = null
    private val binding: FragmentDescriptionBinding
        get() = _binding ?: throw RuntimeException("FragmentDescriptionBinding is null")

    private var scope: CoroutineScope? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scope = CoroutineScope(Dispatchers.IO)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val id = requireArguments().getInt("id")

        viewModel.userLiveData.observe(viewLifecycleOwner) {
            binding.TVname.text = it.FIO
            binding.navik2.text = it.spesialnost
            binding.info.text = it.opisanie
        }

        viewModel.getUserById(id)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}