package com.example.task6

import android.text.TextWatcher
import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject

object RxDataBus {

     val subjectPublisher: PublishSubject<String> = PublishSubject.create<String>()

}