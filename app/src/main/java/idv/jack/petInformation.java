package idv.jack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.java.iPet.R;

public class petInformation extends Fragment {
    private TextView petName, petColor, petAge, petSize, petTnr, petIc, petPosition, petSex;
    private Case cs;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_petinformation, container, false);
        cs = (Case) getArguments().getSerializable("cs");

        petName = (TextView) view.findViewById(R.id.petName);
        petColor = (TextView) view.findViewById(R.id.petColor);
        petAge = (TextView) view.findViewById(R.id.petAge);
        petSize = (TextView) view.findViewById(R.id.petSize);
        petTnr = (TextView) view.findViewById(R.id.petTnr);
        petIc = (TextView) view.findViewById(R.id.petIc);
        petPosition = (TextView) view.findViewById(R.id.petposition);
        petSex = (TextView) view.findViewById(R.id.petSex);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        petName.setText(cs.getPetName());
        petColor.setText(cs.getPetColor());
        petAge.setText(cs.getPetAge());
        petSize.setText(cs.getPetSize());
        petTnr.setText(cs.getTNR());
        petIc.setText(cs.getPetIc());
        petPosition.setText(cs.getPetPosition());
        petSex.setText(cs.getPetSex(petSex));


    }
}