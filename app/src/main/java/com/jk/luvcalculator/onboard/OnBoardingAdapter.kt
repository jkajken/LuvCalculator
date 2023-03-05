package com.jk.luvcalculator.onboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.jk.luvcalculator.R
import com.jk.luvcalculator.databinding.ItemOnBoardingBinding
import com.jk.luvcalculator.model.OnBoard

class OnBoardingAdapter (private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val loveList = arrayListOf(
        OnBoard(R.raw.vitrual, "Love Calculator", "Creative space to find your love"),
        OnBoard(R.raw.valenti, "Have a Good Time", "You should take the time to help those who need you"),
        OnBoard(R.raw.romatictext, "Have a breakup?", " \nDon`t worry \nMaybe there is someone new in your Life"),
        OnBoard(R.raw.her, "Love Calculator", "Find Love in one Count "))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(loveList[position])
    }

    override fun getItemCount(): Int = loveList.size


    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            with(binding) {
                btnGetStarted.isVisible = adapterPosition == loveList.lastIndex
                onBoard.image?.let { onBoardLottie.setAnimation(it) }
                tvTitle.text = onBoard.title
                tvDescription.text = onBoard.description
                binding.btnGetStarted.setOnClickListener{
                    this@OnBoardingAdapter.onClick()
                }
            }

        }

    }

}