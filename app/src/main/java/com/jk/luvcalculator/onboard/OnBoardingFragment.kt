package com.jk.luvcalculator.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jk.luvcalculator.databinding.FragmentOnBoardingBinding
import com.jk.luvcalculator.pref.Pref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding
    @Inject
    lateinit var pref: Pref
    lateinit var adapter: OnBoardingAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref.onPref(requireContext())
        adapter = OnBoardingAdapter {
            pref.saveShowBoarding(true)
            findNavController().navigateUp()}

            with(binding) {
                viewPager.adapter = adapter
                indicator.setViewPager(viewPager)
            }
        }
    }
