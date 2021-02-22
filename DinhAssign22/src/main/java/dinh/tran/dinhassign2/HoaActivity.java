package dinh.tran.dinhassign2;
//DinhHoaTran - n01354661

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class HoaActivity<spinner> extends AppCompatActivity {
    Spinner spinner;
    Intent inte;
    Bundle piz;
    private EditText nameoncard;
    private EditText cardnumber;
    private EditText expirationdate;
    private EditText cvv;
    private EditText phone;
    Button button3;
    ArrayList<String> addtopping = new ArrayList<>();
    String size,type,topping="";
    TextView printsize,printtype,printtopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa);
        printtype = (TextView)findViewById(R.id.printtype);
        printsize = (TextView)findViewById(R.id.printsize);
        printtopping = (TextView)findViewById(R.id.printtopping);
        inte = getIntent();
        piz = inte.getExtras();
        if(piz != null)
        {
            size = piz.getString("Size:","");
            type = piz.getString("Type:","");
            addtopping = piz.getStringArrayList("Topping:");
        }
        printtype.setText(String.format("Type:%s",type));
        printsize.setText(String.format("Size:%s",size));
        for( int i=0; i < addtopping.size() ; i++)
        {
            topping += addtopping.get(i) + "\n";
        }
        printtopping.setText(String.format("Topping:%s",topping));



        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayList<String> arrayProvince = new ArrayList<String>();
        arrayProvince.add("Ontario");
        arrayProvince.add("Quebec");
        arrayProvince.add("Nova Scotia");
        arrayProvince.add("New Brunswick");
        arrayProvince.add("Manitoba");
        arrayProvince.add("British Columbia");
        arrayProvince.add("Prince Edward Island");
        arrayProvince.add("Saskatchewan");
        arrayProvince.add("Alberta");
        arrayProvince.add("Newfoundland and Labrador");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayProvince);

        spinner.setAdapter(arrayAdapter);

        EditText editText;

        nameoncard = findViewById(R.id.editTextTextPersonName);
        cardnumber = findViewById(R.id.editTextNumber);
        expirationdate = findViewById(R.id.editTextDate);
        cvv = findViewById(R.id.editTextNumberPassword);
        phone = findViewById(R.id.editTextPhone);
        button3 = findViewById(R.id.button3);
        nameoncard.addTextChangedListener(loginTextWatcher);
        cardnumber.addTextChangedListener(loginTextWatcher);
        expirationdate.addTextChangedListener(loginTextWatcher);
        cvv.addTextChangedListener(loginTextWatcher);
        phone.addTextChangedListener(loginTextWatcher);
    }
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String name = nameoncard.getText().toString().trim();
            String dnumber = cardnumber.getText().toString().trim();
            String date = expirationdate.getText().toString().trim();
            String cv = cvv.getText().toString().trim();
            String phonenumber = phone.getText().toString().trim();
            button3.setEnabled(!name.isEmpty()&& !dnumber.isEmpty()&&!date.isEmpty()&&!cv.isEmpty()&&!phonenumber.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}

