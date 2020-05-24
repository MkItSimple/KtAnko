package com.example.ktanko

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.design.snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            //shareContentsViaEmail("choanania1@gmail.com", "My Friend", "Hi cho, how are you?")
            //showSnackBar(it)
            showSelector()
        }
    }

    private fun openProductActivity(){
        //val intent = Intent(this, ProductActivity::class.java)
        //startActivity(intent)

        startActivity<ProductActivity>()
    }

    private fun openProductActivityWithTwoParams(){
        //val intent = Intent(this, ProductActivity::class.java)
        //intent.putExtra("id", 7)
        //intent.putExtra("name", "android")
        //startActivity(intent)

        startActivity<ProductActivity>(
            "id" to 7,
            "name" to "anroid"
        )
    }

    private fun openProductActivityWithFrag() {
        //val intent = Intent(this, ProductActivity::class.java)
        //intent.putExtra("id", 7)
        //intent.putExtra("name", "android")
        //intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        //startActivity(intent)

        startActivity(intentFor<ProductActivity>(
            "id" to 7,
            "name" to "anroid"
        ).singleTop())
    }

    private fun openLink() {
        //val intent = Intent(Intent.ACTION_VIEW)
        //intent.data = Uri.parse("http://www.google.com")
        //startActivity(intent)
        browse("http://www.google.com")
    }

    private fun shareContents() {
        //var shareIntent = Intent(Intent.ACTION_SEND)
        //shareIntent.type = "text/plain"
        //shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Sample Subject")
        //startActivity(Intent.createChooser(shareIntent, null))

        share("Sample Contents", "Sample Subject")
    }

    private fun shareContentsViaEmail(address: String, subject: String, text: String) {
//        val intent = Intent(Intent.ACTION_SENDTO)
//        intent.data = Uri.parse("mailto:")
//        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(address))
//        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
//        intent.putExtra(Intent.EXTRA_TEXT, text)
//        startActivity(intent)

        email(address, subject, text)
    }

    private fun showToast() {
        //Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
        //toast("hello cho")
        //longToast("hello cho")
        longToast(R.string.app_name)
    }

    private fun showAlert() {
//        val alert = AlertDialog.Builder(this)
//        alert.setTitle("Title")
//        alert.setMessage("Message")
//
//        alert.setPositiveButton("Yes") { _, _ ->
//            Toast.makeText(this, "Yes clicked", Toast.LENGTH_SHORT).show()
//        }
//
//        alert.setNegativeButton("No") { _, _ ->
//            Toast.makeText(this, "No clicked", Toast.LENGTH_SHORT).show()
//        }
//
//        alert.create().show()

        // anko sample 1
//        alert("Message",  "Title"){
//
//            positiveButton("Yes"){
//                toast("Yes clicked")
//            }
//
//            negativeButton("No"){
//                toast("No clicked")
//            }
//        }.show()

        // anko sample 2
        alert("Message",  "Title"){

            yesButton {
                toast("Yes clicked")
            }
            noButton {
                toast("No clicked")
            }
        }.show()
    }

    private fun showSnackBar(view: View) {
        //Snackbar.make(view, "Welcome my friend", Snackbar.LENGTH_SHORT).show()
        //view.snackbar("Welcome my friend")
        //view.longSnackbar("Welcome my friend")
        view.snackbar("Welcome my friend", "Click me"){
            toast("Hi there!")
        }
    }

    private fun showSelector() {
//        val builder = AlertDialog.Builder(this)
//        builder.setTitle("Choose an animal")
//
//        val animals = arrayOf("horse", "camel", "sheep", "goat")
//        builder.setItems(animals){ dialog, which ->
//            when (which) {
//                0 -> toast("horse")
//                1 -> toast("cow")
//                2 -> toast("camel")
//                3 -> toast("sheep")
//                4 -> toast("goast")
//            }
//        }
//        val dialog = builder.create()
//        dialog.show()

        val animals = listOf("horse", "camel", "sheep", "goat")
        selector("Choose an animal", animals, {
            dialogInterface, i ->  toast("${animals[i]}")
        })
    }
}
