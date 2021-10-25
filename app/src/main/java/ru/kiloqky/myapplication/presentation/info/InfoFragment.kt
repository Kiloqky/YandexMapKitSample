package ru.kiloqky.myapplication.presentation.info

import android.annotation.SuppressLint
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.ktx.moxyPresenter
import ru.kiloqky.myapplication.R
import ru.kiloqky.myapplication.databinding.InfoFragmentBinding
import ru.kiloqky.myapplication.presentation.abs.AbsFragment

const val LAT_KEY = "lat"
const val LONG_KEY = "long"
const val ADDRESS_KEY = "address"

class InfoFragment : AbsFragment(R.layout.info_fragment), InfoView {

    private val binding: InfoFragmentBinding by viewBinding()

    private val presenter: InfoPresenter by moxyPresenter {
        InfoPresenter()
    }

    private val lat: String by lazy {
        requireArguments().getString(LAT_KEY) ?: "null"
    }
    private val long: String by lazy {
        requireArguments().getString(LONG_KEY) ?: "null"
    }
    private val address: String by lazy {
        requireArguments().getString(ADDRESS_KEY) ?: "null"
    }


    companion object {
        fun newInstance(lat: String, long: String, address: String): InfoFragment =
            InfoFragment().apply {
                val args = Bundle()
                with(args) {
                    putString(LAT_KEY, lat)
                    putString(LONG_KEY, long)
                    putString(ADDRESS_KEY, address)
                }
                this.arguments = args
            }
    }

    @SuppressLint("SetTextI18n")
    override fun showInfo() {
        binding.txtAddress.text = "${getString(R.string.address)}: $address"
        binding.txtLat.text = "${getString(R.string.lat)}: $lat"
        binding.txtLong.text = "${getString(R.string.lon)}: $long"
    }
}