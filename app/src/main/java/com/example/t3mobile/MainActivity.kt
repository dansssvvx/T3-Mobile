package com.example.t3mobile

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Deklarasi widget
    private lateinit var etNama: EditText
    private lateinit var rgJenisKelamin: RadioGroup
    private lateinit var rbLakiLaki: RadioButton
    private lateinit var rbPerempuan: RadioButton
    private lateinit var cbMembaca: CheckBox
    private lateinit var cbCoding: CheckBox
    private lateinit var cbOlahraga: CheckBox
    private lateinit var btnTampilkan: Button
    private lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi widget
        etNama        = findViewById(R.id.etNama)
        rgJenisKelamin = findViewById(R.id.rgJenisKelamin)
        rbLakiLaki    = findViewById(R.id.rbLakiLaki)
        rbPerempuan   = findViewById(R.id.rbPerempuan)
        cbMembaca     = findViewById(R.id.cbMembaca)
        cbCoding      = findViewById(R.id.cbCoding)
        cbOlahraga    = findViewById(R.id.cbOlahraga)
        btnTampilkan  = findViewById(R.id.btnTampilkan)
        tvHasil       = findViewById(R.id.tvHasil)

        // Listener tombol Tampilkan
        btnTampilkan.setOnClickListener {
            tampilkanHasil()
        }
    }

    private fun tampilkanHasil() {
        // 1. Ambil nilai nama
        val nama = etNama.text.toString().trim()

        // 2. Validasi nama tidak boleh kosong
        if (nama.isEmpty()) {
            etNama.error = "Nama tidak boleh kosong!"
            etNama.requestFocus()
            return
        }

        // 3. Ambil jenis kelamin
        val selectedGenderId = rgJenisKelamin.checkedRadioButtonId

        // 4. Validasi jenis kelamin harus dipilih
        if (selectedGenderId == -1) {
            Toast.makeText(this, "Jenis kelamin harus dipilih!", Toast.LENGTH_SHORT).show()
            return
        }

        val jenisKelamin = if (selectedGenderId == R.id.rbLakiLaki) "Laki-laki" else "Perempuan"

        // 5. Ambil hobi yang dicentang
        val hobiList = mutableListOf<String>()
        if (cbMembaca.isChecked)  hobiList.add("Membaca")
        if (cbCoding.isChecked)   hobiList.add("Coding")
        if (cbOlahraga.isChecked) hobiList.add("Olahraga")

        val hobi = if (hobiList.isEmpty()) "Tidak ada" else hobiList.joinToString(", ")

        // 6. Tampilkan hasil ke TextView
        val hasil = """
            Nama     : $nama
            Kelamin  : $jenisKelamin
            Hobi     : $hobi
        """.trimIndent()

        tvHasil.text = hasil
    }
}
