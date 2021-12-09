package com.mintic.meetingbogota.ui.preference

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.preference.PreferenceFragmentCompat
import com.mintic.meetingbogota.R
//import com.mintic.meetingbogota.ui.main.MainActivity

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        //     (activity as MainActivity?)?.showIcon()  No se usa en Drawer Activity por eso se comenta                                                                                                                                            //        (activity as MainActivity?)?.showIcon()  No se usa en Drawer Activity por eso se comenta
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }
}