package com.commdel.carservicewale.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.commdel.carservicewale.R
import com.commdel.carservicewale.base.BaseActivity
import com.commdel.carservicewale.databinding.ActivityProfileBinding
import com.commdel.carservicewale.ui.fragments.profile.ProfileMainFragment

class ProfileActivity : BaseActivity() {
    private lateinit var binding:ActivityProfileBinding
    private val target = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activity = ProfileActivity()
        super.init()
        bindView()
    }
    private fun bindView() {
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            mToolbar!!.title = getString(R.string.edit_profile)
            getSupportActionBar()?.setHomeAsUpIndicator(R.drawable.ic_cancel_black_)
        }
        setView()
    }
    private fun gotoPrevious(tag: String) {
        val fm = supportFragmentManager
        fm.popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
    private fun setView() {
        var fragment: ProfileMainFragment? = ProfileMainFragment.getInstance()
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        var tag: String? = null
        when (target) {
            1 -> {
                fragment = ProfileMainFragment.getInstance()
                tag = ProfileMainFragment::class.java.getSimpleName()
            }
        }
        if (fragment != null) {
            ft.add(R.id.fragment_container, fragment, "tag")
        }
        ft.commit()
    }
}