package com.jk.luvcalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.jk.luvcalculator.databinding.FragmentCalculateBinding
import com.jk.luvcalculator.model.LoveModel
import com.jk.luvcalculator.retrofit.LoveService
import com.jk.luvcalculator.utils.Key
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalculateFragment : Fragment() {
    private lateinit var binding: FragmentCalculateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnCalculate.setOnClickListener {
                LoveService().getLoveApi().getLoveResult(
                    firstName = etName1.text.toString(),
                    secondName = etName2.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful) {
                            val stringResponse = LoveModel(
                                response.body()?.firstName.toString(),
                                response.body()?.secondName.toString(),
                                response.body()?.percentage.toString(),
                                response.body()?.result.toString(),
                            )
                            findNavController().navigate(
                                R.id.resultFragment,
                                bundleOf(Key.KEY_DATA to stringResponse)
                            )
                        } else {
                            Toast.makeText(context, "An error occurred", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.d("ololo", "onFailure:" + t.message)
                    }
                })
            }


        }
    }
}
