package com.example.vongdoiactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtTen, edtMSSV, edtTuoi;
    RadioGroup rdoGroup;
    CheckBox chkDaBong, chkGame;
    Button btnLuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTen = findViewById(R.id.edtTen);
        edtMSSV = findViewById(R.id.edtMSSV);
        edtTuoi = findViewById(R.id.edtTuoi);

        rdoGroup = findViewById(R.id.rdoGroup);
        btnLuu = findViewById(R.id.btnLuu);
        chkDaBong = findViewById(R.id.chkDaBong);
        chkGame = findViewById(R.id.chkGame);

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lay thong tin ho ten
                String ten = edtTen.getText().toString();
                if (ten.length() < 3) {
                    Toast.makeText(MainActivity.this, "Họ tên phải >= 3 ký tự", Toast.LENGTH_LONG).show();
                    edtTen.requestFocus();
                    edtTen.selectAll();
                    return;
                }
                //Lay thong tin MSSV
                String MSSV = edtMSSV.getText().toString();
                if (MSSV.length() != 10) {
                    Toast.makeText(MainActivity.this, "MSSV phải đủ 10 số", Toast.LENGTH_LONG).show();
                    edtMSSV.requestFocus();
                    edtMSSV.selectAll();
                    return;
                }

                //Lay thong tin toi
                String tuoi = edtTuoi.getText().toString();

                //Lay thong tin gioi tinh
                int idChon = rdoGroup.getCheckedRadioButtonId(); //tra ve id cua button duoc chon trong radiogroup
                RadioButton rdoChon = findViewById(idChon); //anh xa id den doi tuong duoc chon
                String gioitinh = rdoChon.getText().toString();

                //Lay thong tin so thich
                String sothich = "";
                if (chkDaBong.isChecked())
                    sothich += chkDaBong.getText().toString() + "-";
                if (chkGame.isChecked())
                    sothich += chkGame.getText().toString();

                String hienthi = "Tôi tên: " + ten + "\n" + "MSSV: " + MSSV + "\n" + "Tuổi: " + tuoi + "\n" + "Giới tính: " + gioitinh + "\n" + "Sở thích: " + sothich + "\n";

                //Tao Dialog va hien thi thong tin da nhap
                AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("THÔNG TIN CÁ NHÂN");
                mydialog.setMessage(hienthi);
                mydialog.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                mydialog.create().show();
            }
        });

    }
}