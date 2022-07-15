#Author: maslachahawwaliyah@gmail.com
Feature: Request Staff

  @cekFilterDate
  Scenario Outline: Pending MNGR cek fungsi filter
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    And User cek filter data input tanggal from <date1>
    And User input tanggal to <date2>
    Then Data tidak berhasil tampil
    And User validasi fitur filter <date1> date <date2>

    Examples: 
      | date1      | date2      |
      | 09-07-2022 | 11-07-2022 |
      | 09-07-2022 | 09-07-2022 |
      | 11-07-2022 | 09-06-2022 |
      |            |            |

  @searchNtest
  Scenario Outline: Request Staff pending MNGR search data negatif test
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    And User menjalankan search berdasarkan data di sub menu pending <search>
    Then Data tidak berhasil tampil

    Examples: 
      | search              |
      | Supervisor          |
      | 006/PM/HRD/VII/2022 |
      |                  50 |
      | Juara Coding Tebet  |

  #=======================================
  #FORM DETAIL
  @tujuanTidakDipilih
  Scenario Outline: Pending MNGR input data select tujuan tidak dilakukan
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data select tujuan

    Examples: 
      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #ada
  @NIKkarakter
  Scenario Outline: Pending MNGR input data Nik dengan spesial karakter
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, spesial karakter dan kosong NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan
    And User validasi data NIK

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | !!..%$^! |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #tadi jadi 1 sama atas
  @NIKkosong
  Scenario Outline: Pending MNGR input data Nik kosong
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, spesial karakter dan kosong NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan
    And User validasi data NIK kosong

    Examples: 
      | nik | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      |     |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @posisiTidakDipilih
  Scenario Outline: Pending MNGR input data select tidak dilakukan
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User melakukan input tujuan, NIK <nik>, select posisi tidak dilakukan, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data select posisi

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @jumlahOrang0
  Scenario Outline: Pending MNGR input data jumlah orang dengan 0
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, input jumlah orang dengan angka 0 <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    Then User klik tombol kirim

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           0 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @jumlahOrangNegatifTest
  Scenario Outline: Pending MNGR input data jumlah orang dengan huruf
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, melakukan input jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data jumlah orang

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 | abc         | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 | !!..^..!!   | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |             | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @mulaiKerjaInputHuruf
  Scenario Outline: Pending MNGR input data mulai kerja input manual
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, input huruf difield mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @LokasiKerjaTidakDipilih
  Scenario Outline: Pending MNGR input data lokasi kerja tidak dipilih
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja tidak dipilih, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data lokasi kerja

    Examples: 
      | nik      | jumlahOrang | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @kotaLokasiKerjaTidakDipilih
  Scenario Outline: Pending MNGR input data kota lokasi krja tidak dipilih
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data lokasi kerja

    Examples: 
      | nik      | jumlahOrang | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @detailLokasiKerjaKosong
  Scenario Outline: Pending MNGR input data detail lokasi kerja kosong
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, field detail lokasi tidak dilakukan pengisian <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data lokasi kerja

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 |              | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @deskripsiPekerjaanKosong
  Scenario Outline: Pending MNGR input data deskripsi pekerjaan kosong
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, detail lokasi <detailLokasi>, tidak melakukan input deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data deskripsi pekerjaan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua |      |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #===============================
  #FORM KUALIFIKASI
  @selectJKTidakDilakukan
  Scenario Outline: Pending MNGR input data select jenis kelamin tidak dilakukan
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin dan tidak melakukan select data, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data select jenis kelamin

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #edit
  @inputUmurInvalid
  Scenario Outline: Pending MNGR input data umur tidak dilakukan
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, input umur kosong, spesial karakter dan huruf <umur1><umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data input umur

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |       |       | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test | !.^.! | !.^.! | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test | abc   | def   | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #hasilfail
  @inputBatasUmurLebihKecil
  Scenario Outline: Pending MNGR input data start umur > batas umur
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1> lebih besar dibanding batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    26 |    20 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #ada
  @selectPendidikanTidakDilakukan
  Scenario Outline: Pending MNGR input data select pendidikan tidak dilakukan
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, select pendidikan tidak dilakukan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data select pendidikan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @selectStatusPerkawinanTidakDilakukan
  Scenario Outline: Pending MNGR input data select status perkawinan tidak dilakukan
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, select status perkawinan tidak dilakukan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data select status perkawinan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @inputKualifikasiLainnyaKosong
  Scenario Outline: Pending MNGR input data kualifikasi lainnya tidak dilakukan
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, tidak melakukan input kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data input kualifikasi lainnya

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 |    |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #===========================================
  #FORM STATUS KARYAWAN
  #hasil memang fail
  @StatusKaryawanPKWTinputBulan
  Scenario Outline: Pending MNGR input data memilih status karyawan PKWT input bulan > 12, bulan > 2 digit angka
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, memilih status karyawan PKWT, input bulan > 12, bulan > 2 digit angka <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan
    And User validasi bulan PKWT

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |  13 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill | 134 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @KaryawanPKWTBulanInvalid
  Scenario Outline: Pending MNGR input data memilih status karyawan PKWT check bulan invalid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, memilih status karyawan PKWT, input bulan dengan huruf spesial karakter dan kosong <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data input bulan PKWT

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln   | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill | abc   |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill | !.^.! |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |       |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @KaryawanPKWTCheckTahunInvalid
  Scenario Outline: Pending MNGR input data memilih status karyawan PKWT check tahun
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, memilih status karyawan PKWT, bulan <bln>, input tahun dengan huruf spesial karakter dan kosong <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data input tahun PKWT

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn   | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   5 | abc   |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   5 | !.^.! |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   5 |       |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #MAGANG
  #hasil memang fail
  @StatusKaryawanMaganginputBulan
  Scenario Outline: Pending MNGR input data memilih status karyawan Magang input bulan > 12, bulan > 2 digit angka
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, pilih karyawan Magang, input bulan > 12, bulan > 2 digit angka <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan
    And User validasi bulan magang

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |  13 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill | 134 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @KaryawanMagangBulanInvalid
  Scenario Outline: Pending MNGR input data memilih status karyawan Magang check bulan invalid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, pilih karyawan Magang, input bulan dengan huruf spesial karakter dan kosong <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data input bulan Magang

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln   | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill | abc   |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill | !.^.! |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |       |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @KaryawanMagangCheckTahunInvalid
  Scenario Outline: Pending MNGR input data memilih status karyawan Magang check tahun
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, pilih karyawan Magang, bulan <bln>, input tahun dengan huruf spesial karakter dan kosong <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data input tahun Magang

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn   | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   5 | abc   |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   5 | !.^.! |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   5 |       |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #MAGANG HARIAN
  #hasil memang fail
  @KaryawanMagangHarianinputBulan
  Scenario Outline: Pending MNGR input data memilih status karyawan Magang Harian input bulan > 12, bulan > 2 digit angka
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, memilih status karyawan Magang Harian, input bulan > 12, bulan > 2 digit angka <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan
    And User validasi bulan magang harian

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |  13 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill | 134 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @KaryawanMagangHarianBulanInvalid
  Scenario Outline: Pending MNGR input data memilih status karyawan Magang Harian check bulan invalid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, memilih status karyawan Magang Harian, input bulan dengan huruf spesial karakter dan kosong <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data input bulan Magang Harian

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln   | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill | abc   |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill | !.^.! |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |       |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @KaryawanMagangHarianCekTahunInvalid
  Scenario Outline: Pending MNGR input data memilih status karyawan Magang Harian check tahun
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, memilih status karyawan Magang Harian, bulan <bln>, input tahun dengan huruf spesial karakter dan kosong <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data input tahun Magang Harian

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn   | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   5 | abc   |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   5 | !.^.! |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   5 |       |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #MITRA
  #hasil memang fail
  @KaryawanMitrainputBulan
  Scenario Outline: Pending MNGR input data memilih status karyawan Mitra input bulan > 12, bulan > 2 digit angka
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, pilih karyawan Mitra, input bulan > 12, bulan > 2 digit angka <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan
    And User validasi bulan mitra

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |  13 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill | 134 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @KaryawanMitraBulanInvalid
  Scenario Outline: Pending MNGR input data memilih status karyawan Mitra check bulan invalid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, pilih karyawan Mitra, input bulan dengan huruf spesial karakter dan kosong <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data input bulan Mitra

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln   | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill | abc   |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill | !.^.! |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |       |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @KaryawanMitraCekTahunInvalid
  Scenario Outline: Pending MNGR input data memilih status karyawan Mitra check tahun
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, pilih karyawan Mitra, bulan <bln>, input tahun dengan huruf spesial karakter dan kosong <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data input tahun Mitra

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn   | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   5 | abc   |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   5 | !.^.! |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   5 |       |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #MASA PERCOBAAN
  #memang hasil fail
  @cekMasaPercobaanInputBulan
  Scenario Outline: Pending MNGR input data memilih status masa percobaan input bulan > 12, bulan > 2 digit angka
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melakukan input status karyawan, masa percobaan input bulan lebih dari 12, bulan lebih dari 2 digit angka <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then User validasi data input non mandatory

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   14 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |  124 | 1000 | 500 |       300 | 200 | satu dua |

  @cekMasaPercobaanInputBulanInvalid
  Scenario Outline: Pending MNGR input data check masa percobaan bulan invalid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    Then User validasi field masa percobaan <masa>

    Examples: 
      | masa  |
      | abc   |
      | !.^.! |
      |       |

  #GOLONGAN/JABATAN
  @cekGolonganJabatanInvalid
  Scenario Outline: Pending MNGR select golongan jabatan tidak dilakukan
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, masa percobaan <masa>, select golongan jabatan tidak dilakukan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data input Golongan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #GAJI
  @cekGajiInvalid
  Scenario Outline: Pending MNGR input data cek field gaji
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    Then User validasi field gaji <gaji>

    Examples: 
      | gaji  |
      | abc   |
      | !.^.! |
      |       |

  #ASURANSI
  @checkboxAsuransiTidakDipilih
  Scenario Outline: Pending MNGR input data checkbox asuransi dipilih
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, masa percobaan <masa>, golongan, gaji <gaji>, tidak melakukan pilih checkbox asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then User validasi data input non mandatory

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #TUNJANGAN JABATAN
  @tunjanganJabatanInvalid
  Scenario Outline: Pending MNGR input data cek tunjangan jabatan dengan data invalid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    Then User validasi field tunjangan jabatan <jabatan>

    Examples: 
      | jabatan |
      | abc     |
      | !.^.!   |
      |         |

  #TUNJANGAN TRANSPORTASI
  @tunjanganTransportasiInvalid
  Scenario Outline: Pending MNGR input data cek tunjangan transportasi dengan data invalid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    Then User validasi field tunjangan transportasi <transportasi>

    Examples: 
      | transportasi |
      | abc          |
      | !.^.!        |
      |              |

  #TUNJANGAN KOMUNIKASI
  @tunjanganKomunikasiInvalid
  Scenario Outline: Pending MNGR input data cek tunjangan komunikasi dengan data invalid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    Then User validasi field tunjangan komunikasi <komunikasi>

    Examples: 
      | komunikasi |
      | abc        |
      | !.^.!      |
      |            |

  #NOTE, pass
  @noteDataInvalid
  Scenario Outline: Pending MNGR input data cek note dengan data invalid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    Then User validasi field note <note>

    Examples: 
      | note |
      |      |

  #BTN KIRIM INVALID DATA, pass
  @erorBtnKirim
  Scenario Outline: Pending MNGR select golongan jabatan tidak dilakukan
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, masa percobaan <masa>, select golongan jabatan tidak dilakukan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tidak dapat tersimpan dan muncul eror dihalaman input data
    And User validasi data input Golongan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
  #========================================================
