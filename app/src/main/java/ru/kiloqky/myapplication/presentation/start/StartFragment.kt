package ru.kiloqky.myapplication.presentation.start

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.ktx.moxyPresenter
import ru.kiloqky.myapplication.R
import ru.kiloqky.myapplication.databinding.StartFragmentBinding
import ru.kiloqky.myapplication.helpers.click
import ru.kiloqky.myapplication.navigation.cicerone.navigationcontroller.NavigationController
import ru.kiloqky.myapplication.presentation.abs.AbsFragment
import javax.inject.Inject

private const val REQUEST_CODE_PERMISSIONS = 99
private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)

class StartFragment : AbsFragment(R.layout.start_fragment), StartView {

    @Inject
    lateinit var navigationController: NavigationController

    private val binding: StartFragmentBinding by viewBinding()

    private val presenter: StartPresenter by moxyPresenter {
        StartPresenter(navigationController)
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            REQUIRED_PERMISSIONS,
            REQUEST_CODE_PERMISSIONS
        )
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            requireContext(), it
        ) == PackageManager.PERMISSION_GRANTED
    }


    override fun requestPermissions() {
        requestPermission()
    }

    override fun initBtns() {
        binding.btnOpenMap.click { if (allPermissionsGranted()) presenter.openMap() else requestPermission() }
    }

    companion object {
        fun newInstance(): StartFragment = StartFragment()
    }
}