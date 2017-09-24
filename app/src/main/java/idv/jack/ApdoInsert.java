package idv.jack;

import android.content.SharedPreferences;
import android.net.wifi.WifiConfiguration;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.java.iPet.R;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.security.acl.Group;

import idv.randy.me.MembersVO;
import idv.randy.ut.Me;

import static android.content.Context.MODE_PRIVATE;
import static com.example.java.iPet.R.id.petAge;
import static com.example.java.iPet.R.id.petSex;
import static com.example.java.iPet.R.id.rdman;



public class ApdoInsert extends Fragment {
    String TAG ="ApdoInsert";
    private EditText edpetname , edpetage ,edpetcloor;
    private Button btFinishInsert;
    private RadioGroup rdsex , rdsize ,rdpetic ,rdtnr;
    private Case cs = new Case();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_apdo_insert, container, false);
        findViews(rootView);
        return rootView;
    }

    private void findViews(View rootView) {
        btFinishInsert = (Button) rootView.findViewById(R.id.btFinishInsert);
        edpetname =(EditText)rootView.findViewById(R.id.edpetname);
        edpetage = (EditText)rootView.findViewById(R.id.edpetage);
        edpetcloor = (EditText)rootView.findViewById(R.id.edpetcolor);
        rdsex = (RadioGroup)rootView.findViewById(R.id.rdsex);
        rdsize = (RadioGroup)rootView.findViewById(R.id.rdsize);
        rdpetic = (RadioGroup)rootView.findViewById(R.id.rdpetic);
        rdtnr = (RadioGroup) rootView.findViewById(R.id.rdtnr);
    }

    private void insert(Case cs){
        SharedPreferences pref = getActivity().getSharedPreferences("UserData" ,MODE_PRIVATE);//抓偏好設定黨
        Integer memNo = pref.getInt("memNo", 0);
        if (Common.networkConnected(getActivity())) {
            String url = Common.URL ;
            cs.setMemNo(memNo);
//                    String imageBase64 = Base64.encodeToString(image, Base64.DEFAULT);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("param", "spotInsert");
            jsonObject.addProperty("petInformationVO", new Gson().toJson(cs));
//                    jsonObject.addProperty("imageBase64", imageBase64);
            int count = 0;
            try {
                String result = new MyTask(url, jsonObject.toString()).execute().get();
                count = Integer.valueOf(result);
            } catch (Exception e) {
                        Log.e(TAG, e.toString());
            }
            if (count == 0) {
                Common.showToast(getActivity(), R.string.msg_InsertFail);
            } else {
                Common.showToast(getActivity(), R.string.msg_InsertSuccess);
            }
            } else {
            Common.showToast(getActivity(), R.string.msg_NoNetwork);
        }
    }
    public void  onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        rdsex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton radiobutton = (RadioButton) radioGroup.findViewById(i);
                String petSex = radiobutton.getText().toString();
                cs.setPetSex(petSex);

            }
        });
        rdsize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton radiobutton = (RadioButton) radioGroup.findViewById(i);
                String petSize = radiobutton.getText().toString();
                cs.setPetSize(petSize);
            }
        });
        rdpetic.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton radiobutton = (RadioButton) radioGroup.findViewById(i);
                String petIc = radiobutton.getText().toString();
                cs.setPetIc(petIc);
            }
        });
        rdtnr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton radiobutton = (RadioButton) radioGroup.findViewById(i);
                String TNR = radiobutton.getText().toString();
                cs.setTNR(TNR);
                if(TNR.length()<=0 || TNR==null){
                    Common.showToast(getActivity(),"請選擇");
                }
            }
        });
        btFinishInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String petName = edpetname.getText().toString().trim();
                String petAge = edpetage.getText().toString().trim();
                String petColor = edpetcloor.getText().toString().trim();
                cs.setPetName(petName);
                cs.setPetAge(petAge);
                cs.setPetColor(petColor);
                if (petName.length() <= 0 || petName ==null) {
                    Common.showToast(getActivity(), "請輸入");
                }if(petAge.length()==0 ||petAge==null){
                    Common.showToast(getActivity(),"請輸入成or幼");
                    return;
                }if(petColor.length()==0 |petColor==null){
                    Common.showToast(getActivity(),"請輸入寵物顏色");
                    return;
                }
                insert(cs);
            }
        });
    }
}
