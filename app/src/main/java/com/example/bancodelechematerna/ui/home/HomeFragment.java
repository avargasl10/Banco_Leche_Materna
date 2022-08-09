package com.example.bancodelechematerna.ui.home;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bancodelechematerna.R;
import com.example.bancodelechematerna.databinding.FragmentGalleryBinding;
import com.example.bancodelechematerna.databinding.FragmentHomeBinding;
import com.example.bancodelechematerna.entidades.IMaestro;
import com.example.bancodelechematerna.adaptadores.MaestroAdapter;
import com.example.bancodelechematerna.entidades.TipoDocumento;
import com.example.bancodelechematerna.repositorio.RepositorioMaestro;
import com.example.bancodelechematerna.ui.gallery.GalleryFragment;


import java.util.Calendar;
import java.util.List;

public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;
    private Button btnAgregar;
    private TextView lblFecha;
    private EditText txtDocumento;
    private EditText txtDireccion;
    private EditText txtCiudad;
    private EditText txtCelular;
    private EditText txtFecha;
    private EditText txtPeso;
    private EditText txtTalla;
    private EditText txtIMC;
    private EditText txtRegla;
    private EditText txtParto;
    private EditText txtAmenorrea;
    private EditText txtPatologia;
    private RadioButton rbtMedicamentosSi;
    private RadioButton rbtMedicamentosNo;
    private RadioButton rbtHabitosSi;
    private RadioButton rbtHabitosNo;
    private RadioButton rbtPatologiaSi;
    private RadioButton rbtPatologiaNo;
    private List<IMaestro> tiposDocumento;
    private IMaestro tipoDocumento;
    DatePickerDialog.OnDateSetListener setListener;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TextView lblFecha= binding.lblFecha;
        EditText txtFecha= binding.txtFecha;
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        binding.txtFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog= new DatePickerDialog(
                        HomeFragment.this.getContext(), setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                datePickerDialog.show();
            }
        });

        setListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                String date= day+"/"+month+"/"+year;
                binding.lblFecha.setText(date);
            }
        };
        txtFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        HomeFragment.this.getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int day) {
                                month=month+1;
                                String date= day+"/"+month+"/"+year;
                                binding.txtFecha.setText(date);
                            }
                        },year,month,day);
                datePickerDialog.show();
            }
        });

        EditText txtRegla= binding.txtRegla;
        Calendar calendar2 = Calendar.getInstance();
        final int year2 = calendar.get(Calendar.YEAR);
        final int month2 = calendar.get(Calendar.MONTH);
        final int day2 = calendar.get(Calendar.DAY_OF_MONTH);
        binding.txtRegla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog= new DatePickerDialog(
                        HomeFragment.this.getContext(), setListener,year2,month2,day2);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                datePickerDialog.show();
            }
        });

        setListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year2, int month2, int day2) {
                month2=month2+1;
                String date2= day2+"/"+month2+"/"+year2;
                binding.lblRegla.setText(date2);
            }
        };
        txtRegla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        HomeFragment.this.getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year2, int month2, int day2) {
                                month2=month2+1;
                                String date2= day2+"/"+month2+"/"+year2;
                                binding.txtRegla.setText(date2);
                            }
                        },year2,month2,day2);
                datePickerDialog.show();
            }
        });

        EditText txtParto= binding.txtParto;
        Calendar calendar3 = Calendar.getInstance();
        final int year3 = calendar.get(Calendar.YEAR);
        final int month3 = calendar.get(Calendar.MONTH);
        final int day3 = calendar.get(Calendar.DAY_OF_MONTH);
        binding.txtParto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog= new DatePickerDialog(
                        HomeFragment.this.getContext(), setListener,year3,month3,day3);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                datePickerDialog.show();
            }
        });

        setListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year3, int month3, int day3) {
                month3=month3+1;
                String date3= day3+"/"+month3+"/"+year3;
                binding.lblParto.setText(date3);
            }
        };
        txtParto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        HomeFragment.this.getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year3, int month3, int day3) {
                                month3=month3+1;
                                String date3= day3+"/"+month3+"/"+year3;
                                binding.txtParto.setText(date3);
                            }
                        },year,month,day);
                datePickerDialog.show();
            }
        });
        binding.btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos();
            }
        });
        Spinner spnTiposDocumento =binding.spnTiposDocumento;
        tiposDocumento = RepositorioMaestro.obtenerTiposDocumento();
        MaestroAdapter adapter = new MaestroAdapter(this.getContext(), tiposDocumento);
        spnTiposDocumento.setAdapter(adapter);
        spnTiposDocumento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tipoDocumento = null;
                if (adapterView.getItemAtPosition(i) instanceof TipoDocumento) {
                    tipoDocumento = (TipoDocumento) adapterView.getItemAtPosition(i);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        return root;

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void guardarDatos() {
        boolean error = false;
        binding.txtDocumento.setError(null);
        if(binding.txtDocumento.getText().toString().isEmpty())
        {
            binding.txtDocumento.setError("Debe ingresar el # de documento");
            error = true;
        }
        if(binding.txtDireccion.getText().toString().isEmpty())
        {
            binding.txtDireccion.setError("Debe ingresar la dirección");
            error = true;
        }
        if(tipoDocumento == null)
        {
            error = true;
        }
        if(binding.txtCiudad.getText().toString().isEmpty())
        {
            binding.txtCiudad.setError("Debe ingresar la ciudad");
            error = true;
        }
        if(binding.txtCelular.getText().toString().isEmpty())
        {
            binding.txtCelular.setError("Debe ingresar el # celular");
            error = true;
        }
        if(binding.txtFecha.getText().toString().isEmpty())
        {
            binding.txtFecha.setError("Debe ingresar la fecha de nacimiento");
            error = true;
        }
        if(binding.txtPeso.getText().toString().isEmpty())
        {
            binding.txtPeso.setError("Debe ingresar el peso");
            error = true;
        }
        if(binding.txtTalla.getText().toString().isEmpty())
        {
            binding.txtTalla.setError("Debe ingresar la talla");
            error = true;
        }
        if(binding.txtIMC.getText().toString().isEmpty())
        {
            binding.txtIMC.setError("Debe ingresar el IMC");
            error = true;
        }
        if(binding.txtRegla.getText().toString().isEmpty())
        {
            binding.txtRegla.setError("Debe ingresar la fecha de ultimia regla");
            error = true;
        }
        if(binding.txtParto.getText().toString().isEmpty())
        {
            binding.txtParto.setError("Debe ingresar la fecha de parto");
            error = true;
        }
        if(binding.txtAmenorrea.getText().toString().isEmpty())
        {
            binding.txtAmenorrea.setError("Debe ingresar la edad de amenorrea");
            error = true;
        }
        if(binding.txtPatologia.getText().toString().isEmpty() & binding.rbtPatologiaSi.isChecked())
        {
            binding.txtPatologia.setError("Debe ingresar la patología");
            error = true;
        }

        if(error)  {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
            builder.setMessage("Error al guardar los datos").
                    setPositiveButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });
            builder.show();
        }
    }

}
