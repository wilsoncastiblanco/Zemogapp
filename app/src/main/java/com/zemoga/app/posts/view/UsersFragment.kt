package com.zemoga.app.posts.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zemoga.app.R

/**
 * Created by wilsoncastiblanco on 5/30/18.
 */
const val USER_ID = "user_id"

class UsersFragment : Fragment() {

    companion object {
        fun newInstance(userId: Int): UsersFragment {
            val bundle = Bundle()
            bundle.putInt(USER_ID, userId)
            val usersFragment = UsersFragment()
            usersFragment.arguments = bundle
            return usersFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}