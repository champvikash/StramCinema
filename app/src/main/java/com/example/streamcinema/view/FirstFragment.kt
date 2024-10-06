package com.example.streamcinema.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.stramcinema.databinding.FragmentFirstBinding
import com.example.streamcinema.adapter.MoviePagingAdapter
import com.example.streamcinema.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */


@AndroidEntryPoint
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    val viewModel: MovieViewModel by viewModels()
    val movieAdapter = MoviePagingAdapter()


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
//        getData()

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        getData()

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }



        setRecyclerView()

        binding.movieSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.setQuery(it)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
             return false
            }

        })


        viewModel.list.observe(viewLifecycleOwner) {
            movieAdapter.submitData(lifecycle, it)
        }

    }


//    private fun getData() {
//        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<responseDataClass?> {
//            override fun onResponse(
//                p0: Call<responseDataClass?>,
//                p1: Response<responseDataClass?>
//            ) {
//               val res =  p1.body()?.total_pages
//                println("VIKASH KUMAR ----->$res")
//                Toast.makeText(requireContext(), "Vikas${res}", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onFailure(p0: Call<responseDataClass?>, p1: Throwable) {
//                val s = "Failed"
//                println("VIKASH KUMAR ----->$s")
//
//                Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setRecyclerView() {
        _binding?.movieRecycler?.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }
}