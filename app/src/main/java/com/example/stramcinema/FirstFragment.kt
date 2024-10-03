package com.example.stramcinema

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.stramcinema.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null



    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        getData()

        return binding.root





    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        getData()

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
    }


    private fun getData() {
        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<responseDataClass?> {
            override fun onResponse(
                p0: Call<responseDataClass?>,
                p1: Response<responseDataClass?>
            ) {
               val res =  p1.body()?.total_pages
                println("VIKASH KUMAR ----->$res")
                Toast.makeText(requireContext(), "Vikas${res}", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(p0: Call<responseDataClass?>, p1: Throwable) {
                val s = "Failed"
                println("VIKASH KUMAR ----->$s")

                Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}