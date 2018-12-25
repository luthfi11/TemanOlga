package com.wysiwyg.temanolga.activities

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.wysiwyg.temanolga.R
import com.wysiwyg.temanolga.presenters.LoginPresenter
import com.wysiwyg.temanolga.utils.ValidateUtil.emailValidate
import com.wysiwyg.temanolga.utils.ValidateUtil.etToString
import com.wysiwyg.temanolga.utils.ValidateUtil.etValidate
import com.wysiwyg.temanolga.utils.ValidateUtil.setError
import com.wysiwyg.temanolga.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity(), LoginView {

    private var presenter = LoginPresenter(this)
    private lateinit var mProgressDialog: ProgressDialog

    override fun showLoading() {
        mProgressDialog
    }

    override fun hideLoading() {
        mProgressDialog.dismiss()
    }

    override fun startActivity() {
        startActivity<MainActivity>()
        finish()
    }

    override fun showWrong() {
        tv_Wrong.text = getString(R.string.login_fail)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_signup.setOnClickListener {
            startActivity<SignUpActivity>()
            finish()
        }

        btn_signin.setOnClickListener {
            login()
        }
    }

    private fun initProgressBar() {
        mProgressDialog = indeterminateProgressDialog("Signing In ...", null){
            this.setCancelable(false)
            this.setCanceledOnTouchOutside(false)
            this.show()
        }
    }

    private fun login() {
        if (emailValidate(et_email)) {
            if (etValidate(et_password)) {

                initProgressBar()
                presenter.login(etToString(et_email), etToString(et_password))

            } else {
                setError(et_password, getString(R.string.empty_password))
            }
        } else {
            setError(et_email, getString(R.string.email_invalid))
        }
    }
}
