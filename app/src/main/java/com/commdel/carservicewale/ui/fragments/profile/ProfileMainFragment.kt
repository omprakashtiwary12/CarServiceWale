package com.commdel.carservicewale.ui.fragments.profile

import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.commdel.carservicewale.R
import com.commdel.carservicewale.databinding.FragmentProfileMainBinding
import com.commdel.carservicewale.ui.fragments.BaseFragment
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

class ProfileMainFragment : BaseFragment() {
    private lateinit var binding: FragmentProfileMainBinding
    private var btn: Button? = null
    private var imageview: ImageView? = null
    private val GALLERY = 1
    private val CAMERA = 2
   companion object{
       private val IMAGE_DIRECTORY = "/demonuts"

       fun getInstance():ProfileMainFragment? {
           return ProfileMainFragment()
       }
       private const val MAX_PROFILE_PIC_SIZE = 256
       private const val MAX_ID_PIC_SIZE = 512
   }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentProfileMainBinding.inflate(layoutInflater)
       binding.mainFragment = this
       binding.imgEdit.setOnClickListener { changeFragment(EditProfileBasic()) }
       binding.profileCameraButton.setOnClickListener { showPictureDialog()  }
       binding.operatrImage.setOnClickListener { showPictureDialog() }
       return binding.root
    }

        private fun showPictureDialog() {
            val pictureDialog = activity?.let { AlertDialog.Builder(it) }
            pictureDialog?.setTitle("Select Action")
            val pictureDialogItems = arrayOf("Take Photo", "Choose from Gallery", "Cancel")
            pictureDialog?.setItems(pictureDialogItems
            ) { dialog, which ->
                when (which) {
                    0 -> choosePhotoFromGallary()
                    1 -> takePhotoFromCamera()
                }
            }
            pictureDialog?.show()
        }
    fun choosePhotoFromGallary() {
        val galleryIntent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, GALLERY)
    }
    private fun takePhotoFromCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA)
    }
    public override fun onActivityResult(requestCode:Int, resultCode:Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        /* if (resultCode == this.RESULT_CANCELED)
         {
         return
         }*/
        if (requestCode == GALLERY)
        {
            if (data != null)
            {
                val contentURI = data!!.data
                try
                {
                    val bitmap = MediaStore.Images.Media.getBitmap(activity?.contentResolver, contentURI)
                    val path = saveImage(bitmap)
                    Toast.makeText(requireContext(), "Image Saved!", Toast.LENGTH_SHORT).show()
                    imageview!!.setImageBitmap(bitmap)

                }
                catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(requireContext(), "Failed!", Toast.LENGTH_SHORT).show()
                }

            }

        }
        else if (requestCode == CAMERA)
        {
            val thumbnail = data!!.extras!!.get("data") as Bitmap
            imageview!!.setImageBitmap(thumbnail)
            saveImage(thumbnail)
            Toast.makeText(requireContext(), "Image Saved!", Toast.LENGTH_SHORT).show()
        }
    }
    fun saveImage(myBitmap: Bitmap):String {
        val bytes = ByteArrayOutputStream()
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes)
        val wallpaperDirectory = File(
            (Environment.getExternalStorageDirectory()).toString() + IMAGE_DIRECTORY)
        // have the object build the directory structure, if needed.
        Log.d("fee",wallpaperDirectory.toString())
        if (!wallpaperDirectory.exists())
        {

            wallpaperDirectory.mkdirs()
        }

        try
        {
            Log.d("heel",wallpaperDirectory.toString())
            val f = File(wallpaperDirectory, ((Calendar.getInstance()
                .getTimeInMillis()).toString() + ".jpg"))
            f.createNewFile()
            val fo = FileOutputStream(f)
            fo.write(bytes.toByteArray())
            MediaScannerConnection.scanFile(activity,
                arrayOf(f.getPath()),
                arrayOf("image/jpeg"), null)
            fo.close()
            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath())

            return f.getAbsolutePath()
        }
        catch (e1: IOException) {
            e1.printStackTrace()
        }

        return ""
    }


    private fun changeFragment(baseFragment: BaseFragment) {
        val fragmentTransaction = activity?.getSupportFragmentManager()?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragment_container, baseFragment)
            ?.addToBackStack(BaseFragment::class.simpleName)?.commit()
    }


}