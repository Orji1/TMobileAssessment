package com.example.tmobileassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmobileassessment.databinding.ActivityMainBinding
import com.example.tmobileassessment.model.ResponseData
import com.example.tmobileassessment.model.repository.IRepository
import com.example.tmobileassessment.model.repository.Repository
import com.example.tmobileassessment.view.adapter.TMobileAdapter
import com.example.tmobileassessment.viewmodel.TMobileViewModel
import com.example.tmobileassessment.viewmodel.TMobileViewModelProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var repository: IRepository

    @Inject
    lateinit var viewModelProvider: TMobileViewModelProvider

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: TMobileAdapter

    private val viewModel: TMobileViewModel by lazy {
        viewModelProvider.create(TMobileViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        TMobileApplication.component.inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)

        initViews()

        viewModel.liveData.observe(this, {
            when (it) {
                is Repository.DataState.Data -> udpateDataSet(it.data)
                is Repository.DataState.Error -> showError(it.errMsg)
                is Repository.DataState.Loading -> isLoading(true)
            }
        })

        setContentView(binding.root)
    }

    private fun initViews() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TMobileAdapter(null)
        binding.recyclerView.adapter = adapter
    }

    private fun isLoading(loading: Boolean) {
        if (loading) binding.loading.visibility = View.VISIBLE
        else binding.loading.visibility = View.GONE
    }

    private fun showError(errMsg: String) {
        isLoading(false)
        Toast.makeText(this, errMsg, Toast.LENGTH_SHORT).show()
    }

    private fun udpateDataSet(data: ResponseData?) {
        isLoading(false)
        adapter.updateDataSet(data)
    }
}