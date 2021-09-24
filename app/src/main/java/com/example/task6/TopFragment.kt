package com.example.task6

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.task6.RxDataBus.subjectPublisher
import com.example.task6.databinding.TopFragmentBinding
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

class TopFragment : Fragment() {

    private lateinit var binding : TopFragmentBinding
    //private lateinit var publisherSubject:PublishSubject<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = TopFragmentBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    binding.theEditText.doOnTextChanged { text, _ , _ , _ ->
        subjectPublisher.onNext(text.toString())
            }
        }
    }






