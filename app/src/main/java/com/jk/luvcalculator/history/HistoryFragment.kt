package com.jk.luvcalculator.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jk.luvcalculator.App
import com.jk.luvcalculator.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val it = App.appDataBase.getDao().getAllByAlphabet()

       it.forEach{
            binding.historyTv.append("\n${it.firstName}\n${it.secondName}\n${it.percentage}\n${it.result}")}

    }


}
