package info.sayederfanarefin.chat.ui.authentication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.commons.Constants;
import info.sayederfanarefin.chat.core.CoreFirebaseFragment;
import info.sayederfanarefin.chat.core.CoreFragment;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

import static android.app.Activity.RESULT_OK;
import static info.sayederfanarefin.chat.commons.Commons.dateToString;

/**
 * Created by Sayed Erfan Arefin on 10/5/18.
 */

@EFragment(R.layout.content_authentication_input_name)
public class SignUpAddNameProfilePictureFragment extends CoreFirebaseFragment implements CalendarDatePickerDialogFragment.OnDateSetListener {


    private static final String FRAG_TAG_DATE_PICKER = "fragment_date_picker_name";
    private static final int REQUEST_IMAGE = 100;
    private File destination;
    private String imagePath;


    @ViewById
    TextView liveName;

    @ViewById
    ImageView profilePictureUpload;

    @ViewById
    EditText createProfileName;

    @ViewById
    Button buttonSelectBirthdate;

    @ViewById
    LinearLayout buttonMale;

    @ViewById
    LinearLayout buttonFemale;

    String birthDate = null;
    String gender = null;

    public SignUpAddNameProfilePictureFragment() {
        //Mandatory default constructor
    }

    @AfterViews
    void afterViews() {
        createProfileName.setBackgroundResource(R.drawable.edittexrroundedcorner_gray);
        createProfileName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    view.setBackgroundResource(R.drawable.edittexrroundedcorner_focused);
                } else {
                    view.setBackgroundResource(R.drawable.edittexrroundedcorner_gray);
                }
            }
        });
        selectMale();

        createProfileName.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0)
                    liveName.setText("");
            }
        });
    }

    @Click
    void buttonSelectBirthdate(){

        CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                .setOnDateSetListener(SignUpAddNameProfilePictureFragment.this)
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setDoneText("Select")
                .setCancelText("Cancel");

        cdp.show(getActivity().getSupportFragmentManager(), FRAG_TAG_DATE_PICKER);
    }


    @Click
    void buttonTakeSnap(){
        getView().showContextMenu();
    }

    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
        //mResultTextView.setText(getString(R.string.calendar_date_picker_result_values, year, monthOfYear, dayOfMonth));
        birthDate = String.valueOf(dayOfMonth) + "/" + String.valueOf(monthOfYear)+"/" + String.valueOf(year);
        buttonSelectBirthdate.setText(birthDate);
    }

    @Click
    void buttonFemale(){
        selectFemale();
    }

    @Click
    void buttonMale(){
        selectMale();
    }

    @Click
    void buttonGetStarted(){
        if(birthDate == null){
            showSnachBar("Please select Birthdate");
        }else{
            if (gender == null){
                showSnachBar("Please select Gender");
            }else{
                if (TextUtils.isEmpty(createProfileName.getText().toString())){
                    showSnachBar("Please enter your name");
                }else{
                    // save
                }
            }
        }
    }

    private void selectMale(){
        gender = "male";
        buttonFemale.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        buttonMale.setBackgroundColor(getResources().getColor(R.color.colorAccentPrimary));
    }

    private void selectFemale(){
        gender = "female";
        buttonMale.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        buttonFemale.setBackgroundColor(getResources().getColor(R.color.colorAccentPrimary));
    }


    //from previous project

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, final Intent data) {
//        super.onActivityResult(requestCode, requestCode, data);
//        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK) {
//            showSnachBar("Uploading Image...");
//            Uri uri = data.getData();
//
//            StorageReference photos = storageRef.child(Constants.storagePhotoLocation+ uri.getLastPathSegment()); //.child(uniqueId + "/profile_pic");//mStorage.child(imageLocationId);
//            UploadTask uploadTask = photos.putFile(uri);
//            uploadTask.addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception exception) {
//                    // Handle unsuccessful uploads
//                    showSnachBar("Something went wrong. Please try again later.");
//                }
//            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                        @Override
//                        public void onSuccess(Uri uri) {
//                            Uri downloadUrl = uri;
//                            addImageToProfile(downloadUrl.toString());
//                        }
//                    });
//                }
//            });
//
//        }
//
//        if( requestCode == REQUEST_IMAGE && resultCode == RESULT_OK ){
//            try {
//                showSnachBar("Uploading Image...");
//                Uri uri = Uri.parse(imagePath);
//                InputStream stream = new FileInputStream(imagePath);
//
//                StorageReference riversRef = storageRef.child("Photos/"+ uri.getLastPathSegment()); //.child(uniqueId + "/profile_pic");//mStorage.child(imageLocationId);
//                UploadTask  uploadTask = riversRef.putStream(stream);
//                uploadTask.addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        showSnachBar("Upload failed");
//                    }
//                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                            @Override
//                            public void onSuccess(Uri uri) {
//                                Uri downloadUrl = uri;
//                                addImageToProfile(downloadUrl.toString());
//                            }
//                        });
//
//                    }
//                });
//
////                tvPath.setText(imagePath);
//                // Bitmap bmp = BitmapFactory.decodeStream(in, null, options);
//
//
////                picture.setImageBitmap(bmp);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//    }

    public void addImageToProfile(final String imageLocation) {
        usersRef.child(Constants.dbUserUserPhoto).setValue(imageLocation).addOnCompleteListener(
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        Glide.with(profilePictureUpload.getContext())
                                .load(imageLocation)
                                .bitmapTransform(new CropCircleTransformation(getContext()))
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                .into(profilePictureUpload);
                    }
                }
        );

    }


//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        MenuInflater inflater = getActivity().getMenuInflater();
//
//        inflater.inflate(R.menu.choose_photo_source_context_menu_input_name, menu);
//    }
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.upload:
//                // your first action code
//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setType("image/*");
//                startActivityForResult(intent, GALLERY_INTENT);
//                return true;
//
//            case R.id.take_a_new_photo:
//
//
//                Intent intent2 = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//
//
//                File imagePath = new File(getContext().getFilesDir(), "public");
//                if (!imagePath.exists()) imagePath.mkdirs();
//                String name =   dateToString(new Date(),"yyyy-MM-dd-hh-mm-ss");
//                destination = new File(imagePath, name+"tmp.jpg");
//
//                this.imagePath = destination.getAbsolutePath();
//
//                Uri imageUri = FileProvider.getUriForFile(getContext(), "us.poptalks.provider", destination);
//                intent2.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
//                startActivityForResult(intent2, REQUEST_IMAGE);
//
//
//                return true;
//
//            case R.id.view_profile_photo:
//
//
//            default:
//                return super.onContextItemSelected(item);
//        }
//    }

}
