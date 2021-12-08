package com.Abdul.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.Abdul.R
import com.Abdul.ViewModel.MainViewModel
import com.Abdul.data.RetrofitClient
import com.Abdul.database.UserDB
import com.Abdul.ui.adapters.UserListAdapter
import kotlinx.android.synthetic.main.fragment_short_opisanie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShortDescriptionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_short_opisanie, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val recyclerView = rcView
        recyclerView.layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)

        viewModel.liveData.observe(viewLifecycleOwner) {
            recyclerView.adapter = UserListAdapter(it) { position ->
                val bundle = Bundle()
                bundle.putInt("id", position)
                (activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment)
                        as NavHostFragment).navController.navigate(
                    R.id.action_shortOpisanieFragment2_to_opisanieFragment2,
                    bundle
                )
            }
        }

        viewModel.getFromServer()
    }
}