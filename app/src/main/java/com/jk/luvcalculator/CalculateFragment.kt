package com.jk.luvcalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.jk.luvcalculator.databinding.FragmentCalculateBinding
import com.jk.luvcalculator.pref.Pref
import com.jk.luvcalculator.utils.Key
import com.jk.luvcalculator.viewmodel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CalculateFragment : Fragment() {
    @Inject
    lateinit var pref: Pref
    private lateinit var binding: FragmentCalculateBinding

    private val viewModel: LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCalculateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        pref.onPref(requireContext())
        if (!pref.isOnBoardingShown()) {
            findNavController().navigate(R.id.onBoardingFragment)
        }
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
            with(binding) {
                btnCalculate.setOnClickListener {
                    viewModel.getLiveLove(
                        firstName = etName1.text.toString(),
                        secondName = etName2.text.toString()
                    ).observe(viewLifecycleOwner, Observer {
                        val data = it
                        App.appDataBase.getDao().insertLove(data)
                        findNavController().navigate(
                            R.id.resultFragment, bundleOf(Key.KEY_DATA to data)
                        )
                    })
                }


            }
        }
    }
}
