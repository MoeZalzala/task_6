package com.example.task6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.task6.RxDataBus.subjectPublisher
import com.example.task6.databinding.BottomFragmentBinding
import com.example.task6.databinding.TopFragmentBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class BottomFragment : Fragment() {
    lateinit var binding : BottomFragmentBinding
    val topFragment = TopFragment()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomFragmentBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        subjectPublisher.debounce(1500,TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t ->
            binding.textBubble.text = t
            },
            { e ->
                Log.v("The Info","${e.message}")
            }
        )
    }
}