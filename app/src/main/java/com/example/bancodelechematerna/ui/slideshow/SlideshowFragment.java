package com.example.bancodelechematerna.ui.slideshow;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bancodelechematerna.R;
import com.example.bancodelechematerna.adaptadores.MaestroAdapter;
import com.example.bancodelechematerna.databinding.FragmentSlideshowBinding;
import com.example.bancodelechematerna.entidades.IMaestro;
import com.example.bancodelechematerna.entidades.TipoDocumento;
import com.example.bancodelechematerna.repositorio.RepositorioMaestro;

import java.util.List;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button btnAgregar = binding.btnAgregar;
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos();
            }
        });
        Spinner spnTiposDocumento =binding.spnTiposDocumento;
        tiposDocumento = RepositorioMaestro.obtenerTiposDocumento();
        MaestroAdapter adapter = new MaestroAdapter(this, tiposDocumento);
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
        txtDocumento.setError(null);
        if(txtDocumento.getText().toString().isEmpty())
        {
            txtDocumento.setError("Debe ingresar el # de documento");
            error = true;
        }
        if(txtDireccion.getText().toString().isEmpty())
        {
            txtDireccion.setError("Debe ingresar la dirección");
            error = true;
        }
        if(tipoDocumento == null)
        {
            error = true;
        }
        if(txtCiudad.getText().toString().isEmpty())
        {
            txtCiudad.setError("Debe ingresar la ciudad");
            error = true;
        }
        if(txtCelular.getText().toString().isEmpty())
        {
            txtCelular.setError("Debe ingresar el # celular");
            error = true;
        }
        if(txtFecha.getText().toString().isEmpty())
        {
            txtFecha.setError("Debe ingresar la fecha de nacimiento");
            error = true;
        }
        if(txtPeso.getText().toString().isEmpty())
        {
            txtPeso.setError("Debe ingresar el peso");
            error = true;
        }
        if(txtTalla.getText().toString().isEmpty())
        {
            txtTalla.setError("Debe ingresar la talla");
            error = true;
        }
        if(txtIMC.getText().toString().isEmpty())
        {
            txtIMC.setError("Debe ingresar el IMC");
            error = true;
        }
        if(txtRegla.getText().toString().isEmpty())
        {
            txtRegla.setError("Debe ingresar la fecha de ultimia regla");
            error = true;
        }
        if(txtParto.getText().toString().isEmpty())
        {
            txtParto.setError("Debe ingresar la fecha de parto");
            error = true;
        }
        if(txtAmenorrea.getText().toString().isEmpty())
        {
            txtAmenorrea.setError("Debe ingresar la edad de amenorrea");
            error = true;
        }
        if(txtPatologia.getText().toString().isEmpty() & rbtPatologiaSi.isChecked())
        {
            txtPatologia.setError("Debe ingresar la patología");
            error = true;
        }

        if(error)  {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
